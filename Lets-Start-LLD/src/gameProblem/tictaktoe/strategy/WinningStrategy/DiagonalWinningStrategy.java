package gameProblem.tictaktoe.strategy.WinningStrategy;

import gameProblem.tictaktoe.model.*;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategy{
    private Map<Symbol ,Integer> leftDiogonalCount = new HashMap<>();
    private Map<Symbol ,Integer> rightDiogonalCount = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();
        if (row == col) {
            if (!leftDiogonalCount.containsKey(symbol)) {
                leftDiogonalCount.put(symbol, 0);
            }
            leftDiogonalCount.put(symbol, leftDiogonalCount.get(symbol) + 1);
            if (leftDiogonalCount.get(symbol) == (board.getSize())) {
                return true;
            }
        }

        if (row + col == board.getSize() - 1) {
            if (!rightDiogonalCount.containsKey(symbol)) {
                rightDiogonalCount.put(symbol, 0);
            }
            rightDiogonalCount.put(symbol, rightDiogonalCount.get(symbol) + 1);
            if (rightDiogonalCount.get(symbol) == (board.getSize())) {
                return true;
            }
        }

        return false;
    }
}
