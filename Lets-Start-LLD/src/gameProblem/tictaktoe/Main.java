package gameProblem.tictaktoe;

import gameProblem.tictaktoe.controller.GameController;
import gameProblem.tictaktoe.model.*;
import gameProblem.tictaktoe.strategy.WinningStrategy.ColumnWinningStrategy;
import gameProblem.tictaktoe.strategy.WinningStrategy.DiagonalWinningStrategy;
import gameProblem.tictaktoe.strategy.WinningStrategy.RowWinningStrategy;
import gameProblem.tictaktoe.strategy.WinningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        try {
            int dimension = 3;
            List<Player> players = new ArrayList<>();
            players.add(new Player(new Symbol('X'),"Sandeep",1L, PlayerType.HUMAN));
            players.add(new Bot(new Symbol('O'),"AI",2L, BotDifficultyLevel.EASY));
            List<WinningStrategy> winningStrategies = List.of(
                    new ColumnWinningStrategy(),
                    new RowWinningStrategy(),
                    new DiagonalWinningStrategy()
            );
            Game game = gameController.startGame(dimension,players,winningStrategies);
            while(gameController.checkState(game).equals(GameState.IN_PROGRESS)){
                // 1- print the board
                // 2- make a move
                gameController.printBoard(game);
                gameController.makeMove(game);

            }
            if(game.getGameState().equals(GameState.DRAW)){
                gameController.printBoard(game);
                System.out.println("Game is Draw");
            }
            if(game.getGameState().equals(GameState.WIN)){
                gameController.printBoard(game);
                System.out.println("Game is Completed");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
