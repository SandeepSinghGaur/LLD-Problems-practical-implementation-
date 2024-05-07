package gameProblem.tictaktoe.strategy.WinningStrategy;

import gameProblem.tictaktoe.model.Board;
import gameProblem.tictaktoe.model.Move;
import gameProblem.tictaktoe.model.Player;

public interface WinningStrategy {
    public boolean checkWinner(Board board, Move move);
}
