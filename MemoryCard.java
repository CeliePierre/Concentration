/*
    NAME: Célie Pierre
    COS 161, Spring 2022, Prof. Andrew Amorelli
    Project 03
    File Name: MemoryCard.java
*/

/*
 * This class must have the following:
 * Private fields, String shapeType, Color color, boolean isUncovered with 
 * Getters and Setters.
 * Public toString() method that returns a formatted display of shapeType, 
 * color, and isUncovered
 */

import java.awt.Color;

public class MemoryCard {

	private String shapeType;
	private Color color;
	private boolean isUncovered;
	
	// Constructor
	public MemoryCard(String shapeType, Color color) {
		setShapeType(shapeType);
		setColor(color);
		setUncovered(false);
	}
	
	
	public String toString() {
		String colorName = "";
		if (this.color.equals(new Color(209, 34, 41))) {
			colorName = "Red";
		} else if (this.color.equals(new Color(246, 138, 30))) {
			colorName = "Orange";
		} else if (this.color.equals(new Color(253, 224, 26))) {
			colorName = "Yellow";
		} else if (this.color.equals(new Color(0, 121, 64))) {
			colorName = "Green";
		} else if (this.color.equals(new Color(36, 64, 142))) {
			colorName = "Blue";
		} else if (this.color.equals(new Color(115, 41, 130))) {
			colorName = "Purple";
		}
		return colorName + " " + this.shapeType;
	}
	
	// Getters and setters
	public String getShapeType() {
		return shapeType;
	}
	public void setShapeType(String shapeType) {
		this.shapeType = shapeType;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public String getColorName() {
		String colorName = "";
		Color 
			red = new Color(209, 34, 41), 
			orange = new Color(246, 138, 30), 
			yellow = new Color(253, 224, 26), 
			green = new Color(0, 121, 64), 
			blue = new Color(36, 64, 142), 
			purple = new Color(115, 41, 130);
		if (this.color.equals(red)) {
			colorName = "Red";
		} else if (this.color.equals(orange)) {
			colorName = "Orange";
		} else if (this.color.equals(yellow)) {
			colorName = "Yellow";
		} else if (this.color.equals(green)) {
			colorName = "Green";
		} else if (this.color.equals(blue)) {
			colorName = "Blue";
		} else if (this.color.equals(purple)) {
			colorName = "Purple";
		}
		return colorName;
	}

	public boolean getIsUncovered() {
		return isUncovered;
	}
	public void setUncovered(boolean isUncovered) {
		this.isUncovered = isUncovered;
	}
	
}
