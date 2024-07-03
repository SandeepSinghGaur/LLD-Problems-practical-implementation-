package gameProblem.snakeAndLadder.model;

import java.util.List;
import java.util.Map;

public class Board {
    private List<List<Cell>> board;
    int size;
    private Snake snakeMappings;
    private Ladder ladderMappings;



    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }




}
