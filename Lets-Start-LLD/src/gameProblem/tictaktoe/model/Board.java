package gameProblem.tictaktoe.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> board;
    public Board(int size){
        this.size = size;
        this.board = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            board.add(new ArrayList<>());
            for (int j = 0; j < size; j++) {
                this.board.get(i).add(new Cell(i,j));
            }
        }

    }

    public Board() {
    }

    public  void printBoard(){
        for(List<Cell> row : this.board){
            for(Cell cell:row){
                if(cell.getPlayer()==null){
                    System.out.printf("| -  |");
                }else{
                    System.out.printf(STR."| \{cell.getPlayer().getSymbol().getaChar()} |");
                }
            }
            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }
}
