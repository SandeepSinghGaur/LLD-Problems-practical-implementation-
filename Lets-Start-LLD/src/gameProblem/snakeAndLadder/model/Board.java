package gameProblem.snakeAndLadder.model;

import java.util.List;
import java.util.Map;

public class Board {
    private List<List<Cell>> board;
    int size;
    private Map<Cell, Cell> snakeMappings;
    private Map<Cell, Cell> ladderMappings;

    public Board(List<List<Cell>> board, int size, Map<Cell, Cell> snakeMappings, Map<Cell, Cell> ladderMappings) {
        this.board = board;
        this.size = size;
        this.snakeMappings = snakeMappings;
        this.ladderMappings = ladderMappings;
    }

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

    public Map<Cell, Cell> getSnakeMappings() {
        return snakeMappings;
    }

    public void setSnakeMappings(Map<Cell, Cell> snakeMappings) {
        this.snakeMappings = snakeMappings;
    }

    public Map<Cell, Cell> getLadderMappings() {
        return ladderMappings;
    }

    public void setLadderMappings(Map<Cell, Cell> ladderMappings) {
        this.ladderMappings = ladderMappings;
    }
}
