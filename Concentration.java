/*
    NAME: Célie Pierre
    COS 161, Spring 2022, Prof. Andrew Amorelli
    Project 03
    File Name: Concentration.java
*/

import java.util.*;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Concentration {

	static DrawingPanel panel = new DrawingPanel(600, 800);
	static Graphics g = panel.getGraphics();
	static Graphics2D g2 = (Graphics2D) g;

	public static void main(String[] args) {

		// Sets that correspond to the cards that each player has uncovered
		Set<MemoryCard> p1set = new HashSet<MemoryCard>(); // Player 1
		Set<MemoryCard> p2set = new HashSet<MemoryCard>(); // Player 2
		
		// Map that stores the cards in play 
		Map<Integer, MemoryCard> gameBoard = new TreeMap<Integer, MemoryCard>();
		
		// ArrayList of type MemoryCard called cardDeck
		ArrayList<MemoryCard> cardDeck = new ArrayList<MemoryCard>();
		
		// Fill the deck
		fillBoard(cardDeck);
		// Shuffle the deck
		Collections.shuffle(cardDeck);
		
		// Fill the gameBoard Map with the Integers 0 – 35 mapped to 
		// the MemoryCards stored in cardDeck
		for (int i = 0; i <= 35; i++) {
			gameBoard.put(i, cardDeck.get(i));
		}
		
		drawBoard(gameBoard);
		while (!winner(cardDeck, p1set, p2set)) {
			System.out.println("PLAYER 1");
			takeTurn(gameBoard, p1set);
			System.out.println("PLAYER 2");
			takeTurn(gameBoard, p2set);
		}
		
	}
	
	public static void fillBoard(ArrayList<MemoryCard> cardDeck) {
		/*
		 * Fills cardDeck with 36 pairs of new MemoryCards (18 unique MemoryCards 
		 * each added twice). For colors, you can choose any 6, for shapes you must 
		 * have 6 each (one of each color you picked) of the following 3 shapes: 
		 * Circle, Square, Triangle. That should give you the 18 unique pairs you 
		 * need. Each should have an initial isUncovered value of false. Make sure 
		 * one you are done filling the List, you Shuffle it.
		 */
		
		// Colors: Red, Orange, Yellow, Green, Blue, Purple
		// Shapes: Circle, Square, Triangle
		Color 
			red = new Color(209, 34, 41), 
			orange = new Color(246, 138, 30), 
			yellow = new Color(253, 224, 26), 
			green = new Color(0, 121, 64), 
			blue = new Color(36, 64, 142), 
			purple = new Color(115, 41, 130);
		
		Color[] colors = {red, orange, yellow, green, blue, purple};
		String[] shapes = {"Circle", "Square", "Triangle"};
		
		for (int s = 0; s < shapes.length; s++) {
			for (int c = 0; c < colors.length; c++) {
				cardDeck.add(new MemoryCard(shapes[s], colors[c]));
				cardDeck.add(new MemoryCard(shapes[s], colors[c]));
			}
		}

	}
	
	public static void drawBoard(Map gameBoard) {
		/*
		 * Create a method called drawBoard() that will draw a 6 by 6 grid of 
		 * rectangles. This method must use an Iterator to look at every element 
		 * of gameBoard. Every time this method is called, it should first blank 
		 * the entire board.
		 * 
		 * This should give you an initial output of 6 rows and 6 columns of 
		 * rectangles with 0 – 35 printed inside them. Once you think you have 
		 * this right, edit the gameBoard Map temporarily to set all MemeryCard 
		 * isUncovered values to true. The board should now display 36 shapes of 
		 * various colors (18 unique pairs) inside the 36 card rectangles.
		 */
		
		//clear board
		g.setColor(Color.WHITE);   
		g.fillRect(0, 0, 600, 800);
		g.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(1));
		for (int x = 1; x <= 6; x++) {
			for (int y = 1; y <= 6; y++) {
				g.drawRect(75*x, 100*y, 75, 100);
			}
		}

		Iterator<Integer> itr = gameBoard.keySet().iterator();
		int x = 75;
		int y = 100;
		int count = 1;
		int row = 1;
		int boardWidth = 6;

		while (itr.hasNext()) {
		/*
		 * For each element it should do the following: Check if isUncovered is 
		 * true, if so, draw the correct shape inside the rectangle corresponding 
		 * to that card. If it is false, print the number inside the rectangle 
		 * instead.
		 */
			int cardNum = itr.next();
			MemoryCard card = (MemoryCard) gameBoard.get(cardNum);
			if (count > 6 && count <= 12) {
				y = 200;
			} else if (count > 12 && count <= 18) {
				y = 300;
			} else if (count > 18 && count <= 24) {
				y = 400;
			} else if (count > 24 && count <= 30) {
				y = 500;
			} else if (count > 30 && count <= 36) {
				y = 600;
			}
			if (count == 7 || count == 13 || count == 19 || count == 25 || count == 31) {
				row = 1;
			}

			if (card.getIsUncovered()) {
				// Set colors
				g.setColor(card.getColor());
				g2.setStroke(new BasicStroke(10));
				// Print shapes
				if (card.getShapeType() == "Circle") {
					g.drawOval(x*row+15, y+29, 45, 45);
				} else if (card.getShapeType() == "Square") {
					g.drawRect(x*row+15, y+29, 45, 45);
				} else if (card.getShapeType() == "Triangle") {
					g.drawLine(x*row+37, y+29, x*row+15, y+70);
					g.drawLine(x*row+37, y+29, x*row+60, y+70);
					g.drawLine(x*row+20, y+70, x*row+55, y+70);
				}
			} else {
				// print the number inside the rectangle
				g.setColor(Color.BLACK);
				g.drawString("" + cardNum, x*row+30, y+45);
			}
			count += 1;
			row += 1;
		}
		
	}
	
	public static boolean takeTurn(Map gameBoard, Set<MemoryCard> playerSet) {
		boolean turnOver = false;
		Scanner scanner = new Scanner(System.in);
		MemoryCard card1, card2;
		int c1, c2;

		while (!turnOver) {
			System.out.println("Please select your cards.");
			System.out.print("Card 1: ");
			c1 = scanner.nextInt();
			card1 = (MemoryCard) gameBoard.get(c1);
			card1.setUncovered(true);
			drawBoard(gameBoard);
			System.out.print("Card 2: ");
			c2 = scanner.nextInt();
			card2 = (MemoryCard) gameBoard.get(c2);
			card2.setUncovered(true);
			drawBoard(gameBoard);
			
			if (card1.getShapeType() == card2.getShapeType() && 
					card1.getColor() == card2.getColor()) {
				System.out.println("Match! Select again.");
				playerSet.add(card1);
				playerSet.add(card2);
			} else {
				System.out.println("No match. Next player's turn.");
				card1.setUncovered(false);
				card2.setUncovered(false);
				turnOver = true;
			}
		}

		return turnOver;
	}
	
	public static boolean winner(ArrayList cardDeck, Set p1set, Set p2set) {
		boolean winner = false;
		if (p1set.size() + p2set.size() == cardDeck.size()) {
			winner = true;
			if (p1set.size() > p2set.size()) {
				System.out.println("WINNER! Player 1");
				p1set.toString();
			} else if (p1set.size() < p2set.size()) {
				System.out.println("WINNER! Player 2");
				p2set.toString();
			}
		}
		return winner;
	}

}
