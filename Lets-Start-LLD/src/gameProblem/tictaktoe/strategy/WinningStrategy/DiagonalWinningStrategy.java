package gameProblem.tictaktoe.strategy.WinningStrategy;

import gameProblem.tictaktoe.model.Board;
import gameProblem.tictaktoe.model.Move;

public class DiagonalWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move move) {
        return false;
    }
}