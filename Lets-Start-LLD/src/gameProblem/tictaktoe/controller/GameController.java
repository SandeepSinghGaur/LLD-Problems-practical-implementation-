package gameProblem.tictaktoe.controller;



import gameProblem.tictaktoe.exception.DuplicateSymbolException;
import gameProblem.tictaktoe.exception.MoreThanOneBotPlayerException;
import gameProblem.tictaktoe.exception.PlayerCountDimensionMisMatchException;
import gameProblem.tictaktoe.model.Game;
import gameProblem.tictaktoe.model.GameState;
import gameProblem.tictaktoe.model.Player;
import gameProblem.tictaktoe.strategy.WinningStrategy.WinningStrategy;

import java.util.List;

public class GameController {

    public Game startGame(int boardDimension, List<Player> players, List<WinningStrategy> winningStrategies) throws PlayerCountDimensionMisMatchException, DuplicateSymbolException, MoreThanOneBotPlayerException {
        return Game.getBuilder()
                .setDimension(boardDimension)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();

    }

    public void makeMove(Game game) {
        game.makeMove();

    }

    public GameState checkState(Game game) {
        return game.getGameState();

    }

    public void undoTheLastMove() {

    }

    public void getWinner() {

    }

    public void printBoard(Game game) {
        game.printBoard();

    }
}
