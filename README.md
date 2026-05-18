# Minesweeper-Project

## Overview
This project simulates and analyzes matches using custom data structures and game logic implemented in Java.

The project includes:
- board and cell management,
- player and move handling,
- match simulation,
- dataset analysis,
- and custom queue/linked list implementations.

---

# File Structure

## Core Game Classes

### `Board.java`
Represents the game board and handles board-related operations.

### `Cell.java`
Defines a single cell on the board.

### `CellState.java`
Enum or state definition for possible cell values/states.

### `Move.java`
Represents a move made during a game.

### `NodeMove.java`
Stores move-related node data, likely used in linked structures.

### `Player.java`
Represents a player and player-specific behavior.

### `GameOutcome.java`
Defines possible outcomes of a match/game.

---

# Match Simulation

### `MatchFactory.java`
Creates or initializes match instances.

### `GamesSimulator.java`
Runs match simulations and processes gameplay logic.

### `MatchSummary.java`
Stores summarized information about completed matches.

### `MatchDataset.java`
Handles collections of match data for analysis or testing.

### `TestMatchesAnalysis.java`
Testing and analysis class used for validating simulations and match statistics.

---

# Custom Data Structures

### `CoordinateQueue.java`
Custom queue implementation used for coordinate processing.

### `MyLinkedList.java`
Custom linked list implementation used within the project.

---

# Features

- Custom board/game logic
- Match simulation system
- Dataset analysis
- Queue and linked list implementations
- Modular Java class structure

---

# Notes

- The project is written entirely in Java.
- Several custom data structures were implemented manually instead of using Java Collections.
- Testing and simulation analysis are included for validation purposes.

---

# Author

Created as part of a programming/project assignment.
