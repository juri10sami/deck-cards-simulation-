# Card Game Simulation - Java Project

This repository contains a Java-based card game simulation. It showcases various object-oriented programming concepts such as encapsulation, collections, and custom methods for simulating gameplay mechanics.

## Features
- A `Cards` class that represents individual cards with a suit and point value.
- A `DeckCards` class that handles operations such as:
  - Generating a full deck of cards.
  - Shuffling the deck using both selection shuffle and perfect shuffle algorithms.
  - Dealing cards to players.
  - Simulating a card game with up to 4 players and a "bank."
- Game logic that determines winners based on card values, supporting additional card draws when necessary.
- Use of collections like `ArrayList` to manage cards and gameplay.

## How to Run
1. Clone this repository:
   ```bash
   git clone https://github.com/juri10sami/Card-Game-Simulation.git
Open the project in your preferred Java IDE (e.g., IntelliJ, Eclipse, or VS Code).
Run the DeckCards class to start the game.

##Project Structure:

Cards Class:
Represents a playing card with methods for setting and getting the suit and point value.
Includes utility methods to check if two cards have matching suits or point values.

DeckCards Class:
Handles deck creation, shuffling, dealing cards, and gameplay logic.
Includes methods like deal, perfectShuffle, and selectionShuffle to manage cards.

Example Gameplay:
The program creates a standard deck of 52 cards.
Shuffles the deck and deals cards to up to 4 players and a bank.
Players compete to achieve the highest score, with logic to draw additional cards based on specific conditions.
Outputs the results of each round, including card suits, values, and the winner.

Technologies Used:
Java 8+: The programming language used for this project.
ArrayList: For managing the card deck and discarded cards.
Math.random: To implement random shuffling.

Future Improvements:
Add more game rules for additional gameplay variations.
Implement a GUI for a more interactive user experience.
Include unit tests for the card dealing and shuffle methods.

Acknowledgments:
This project was developed as part of a foundational Java programming course to explore object-oriented concepts and algorithm implementation.







