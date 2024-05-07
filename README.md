# Game Problem

## Tic Tac Toe Game

### Overview
The system should allow one human player to play against one bot in a game of Tic Tac Toe.

### Features
- One human player and one bot can play the game.
- The bot has adjustable difficulty levels.
- The human player can undo their last move.
- The game follows the standard rules of Tic Tac Toe.
- The human player starts the game.
- Players take turns making moves.
- The bot's move is determined based on its difficulty level:
    - Easy: Randomly selects an available spot.
    - Medium: Makes moves based on basic strategy (e.g., prioritizing winning moves or blocking the opponent).
    - Hard: Makes moves using advanced algorithms (e.g., minimax with alpha-beta pruning).
- Players can't make moves on occupied spots.
- The game ends when:
    - One player achieves a winning combination (3 in a row/column/diagonal).
    - The board is filled (draw).
- After the game ends, players can choose to:
    - Start a new game.
    - Quit the game.

### Implementation
- Backend: [Insert backend language/framework]
- Frontend: [Insert frontend language/framework]
- Bot Difficulty Levels: Easy, Medium, Hard
- Undo Mechanism: Human player can undo their last move.

### Additional Notes
- The bot's difficulty level should be configurable by the human player.
- The undo feature should be limited to one move per turn.
- Consider implementing a graphical interface for a better user experience.

## Snake and Ladder Game

### Overview
The system should allow multiple players to play the classic game of Snake and Ladder on a virtual board.

### Features
- Supports multiple players (2 or more) to play the game.
- The game follows the standard rules of Snake and Ladder.
- Players take turns rolling a dice and moving their tokens on the board.
- Each player's token starts at position 1 on the board.
- The board consists of cells numbered from 1 to N (N is configurable).
- Special cells include:
    - Snake: If a player lands on a cell with the head of a snake, they move down to the tail of the snake.
    - Ladder: If a player lands on a cell with the bottom of a ladder, they move up to the top of the ladder.
- Players win the game by reaching or surpassing the final cell (N).
- Players can't roll the dice or move their tokens until it's their turn.
- The game ends when one player wins or chooses to quit.
- The system should maintain a log of each player's moves and game events.

### Implementation
- Backend: [Insert backend language/framework]
- Frontend: [Insert frontend language/framework]
- Board Configuration: Configurable number of cells, snakes, and ladders.
- Dice Mechanism: Random number generation for dice rolls.
- Player Tokens: Tokens representing each player's position on the board.

### Additional Notes
- Consider implementing a graphical interface for a better user experience.
- Allow players to customize board settings (e.g., number of cells, positions of snakes and ladders).
- Implement error handling for invalid moves or configurations.
- Provide options for single-player mode against computer-controlled opponents.

## Chess Game

### Overview
The system should support two online players to play a game of chess following all rules of international chess.

### Features
- Two online players can play the game.
- All rules of international chess will be followed.
- Each player will be randomly assigned a side, black or white.
- Players take turns making moves, starting with the white side.
- Moves cannot be canceled or rolled back.
- The system should maintain a log of all moves made by both players.
- Each side starts with:
    - 8 pawns
    - 2 rooks
    - 2 bishops
    - 2 knights
    - 1 queen
    - 1 king
- The game can finish due to:
    - Checkmate from one side
    - Forfeit
    - Stalemate (a draw)
    - Resignation

### Implementation
- Backend: [Insert backend language/framework]
- Frontend: [Insert frontend language/framework]

### Additional Notes
- Consider implementing a graphical interface for a better user experience.
