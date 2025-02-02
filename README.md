# Concentration

![Java](https://img.shields.io/badge/Java-8%2B-orange)

![Concentration](cat-memory.jpeg)

# Concentration - Java Implementation

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)

## Overview
This project is a Java-based implementation of the classic memory card game **Concentration**, developed as part of the "Algorithms in Programming" course. The game uses Java collections such as Maps and Sets to manage card placement, tracking, and gameplay mechanics.

## Features
- **Graphical Board Rendering** using `DrawingPanel` and Java's `Graphics` library.
- **Object-Oriented Design** with a `MemoryCard` class representing individual cards.
- **Game Mechanics** including card flipping, matching, and player turns.
- **Turn-Based Two-Player Mode** where players take turns selecting and matching cards.
- **Automatic Winner Detection** based on the number of matched pairs.

## Usage
- The game initializes with a **6x6 grid** of shuffled memory cards.
- Players take turns selecting two cards.
- If the selected cards match, they remain revealed, and the player earns another turn.
- If they do not match, they are flipped back over, and the next player takes a turn.
- The game continues until all cards are matched.
- The player with the most matches at the end **wins the game**.

## Installation
1. Ensure you have **Java 8 or higher** installed.
2. Clone this repository:
   ```sh
   git clone https://github.com/CeliePierre/Concentration.git
   cd Concentration
   ```
3. Compile the Java files:
   ```sh
   javac Concentration.java MemoryCard.java
   ```
4. Run the program:
   ```sh
   java Concentration
   ```

## License
This project is for educational purposes and does not require a license.
