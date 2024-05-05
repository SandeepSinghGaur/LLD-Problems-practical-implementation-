package gameProblem.tictaktoe.strategy.BotPlayingStrategy;


import gameProblem.tictaktoe.model.Board;
import gameProblem.tictaktoe.model.Cell;
import gameProblem.tictaktoe.model.CellState;
import gameProblem.tictaktoe.model.Move;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move makeMove(Board board) {
        for(List<Cell> row: board.getBoard()){
            for(Cell cell: row){
                if(cell.getCellState()== CellState.EMPTY){
                    return new Move(cell,null);

                }
            }

        }
        return null;
    }
}
