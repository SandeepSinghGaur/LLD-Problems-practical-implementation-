package gameProblem.tictaktoe.model;



import gameProblem.tictaktoe.exception.DuplicateSymbolException;
import gameProblem.tictaktoe.exception.MoreThanOneBotPlayerException;
import gameProblem.tictaktoe.exception.PlayerCountDimensionMisMatchException;
import gameProblem.tictaktoe.strategy.WinningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {

    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private Player winner;
    private GameState gameState;
    private int nextMovePlayerIndex;
    private List<WinningStrategy> winningStrategies;

    private Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.gameState = GameState.IN_PROGRESS;
        this.nextMovePlayerIndex = 0;
        this.board = new Board(dimension);
        this.moves = new ArrayList<>();
        this.winningStrategies = winningStrategies;
        this.players = players;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public void printBoard() {
        this.board.printBoard();
    }

    private boolean validateMove(Move move) {
        //cell is empty
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        if (row >= board.getSize()) return false;
        if (col >= board.getSize()) return false;
        if (board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY)) {
            return true;
        }

        return false;
    }

    private boolean checkWinner(Board board, Move move){
        for(WinningStrategy winningStrategy:winningStrategies){
            if(winningStrategy.checkWinner(board,move)){
                return  true;
            }

        }
        return false;
    }

    public void  makeMove() {
        Player currentMovePlayer = players.get(nextMovePlayerIndex);
        System.out.printf(STR."It is \{currentMovePlayer.getName()}\'s turn please make your move \ncurrent player type: \{currentMovePlayer.getPlayerType()}\n");
        Move move = currentMovePlayer.makeMove(board);
        if(!validateMove(move)) return;
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Cell cellToChange = board.getBoard().get(row).get(col);
        cellToChange.setCellState(CellState.FILLED);
        cellToChange.setPlayer(currentMovePlayer);
        Move finalMove = new Move(cellToChange,currentMovePlayer);
        moves.add(finalMove);
        nextMovePlayerIndex += 1;
        nextMovePlayerIndex %= players.size();
        if (checkWinner(board, finalMove)) {
            gameState = GameState.WIN;
            winner = currentMovePlayer;
            System.out.println(STR."Player \{winner.getName()} Won the match");
            return;
        }else{
            if (moves.size() == this.board.getSize() * this.board.getSize()) {
                gameState = GameState.DRAW;
            }
        }


    }

    public static class Builder {
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;
        private int dimension;

        private Builder() {
            this.players = new ArrayList<>();
            this.winningStrategies = new ArrayList<>();
            this.dimension = 0;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public List<WinningStrategy> getWinningStrategies() {
            return winningStrategies;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public int getDimension() {
            return dimension;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        private boolean validateBotCount() throws MoreThanOneBotPlayerException {
            int botCount = 0;
            for (Player player : players) {
                if (player.getPlayerType().equals(PlayerType.BOT)) {
                    botCount++;
                }
                if (botCount > 1) {
                    throw new MoreThanOneBotPlayerException();
                }
            }
            return true;
        }

        private boolean validateDimensionAndPlayerCount() throws PlayerCountDimensionMisMatchException {
            if (players.size() != dimension - 1) {
                throw new PlayerCountDimensionMisMatchException();
            }
            return true;
        }

        private boolean validateUniqueSymbol() throws DuplicateSymbolException {
            for (Player player : players) {
                Map<Character, Integer> symbolCount = new HashMap<>();
                if (symbolCount.containsKey(player.getSymbol().getaChar())) {
                    symbolCount.put(player.getSymbol().getaChar(), symbolCount.get(player.getSymbol().getaChar()) + 1);
                } else {
                    symbolCount.put(player.getSymbol().getaChar(), 1);
                }
                if (symbolCount.get(player.getSymbol().getaChar()) > 1) {
                    throw new DuplicateSymbolException();
                }
            }
            return true;
        }

        private boolean validate() throws PlayerCountDimensionMisMatchException, DuplicateSymbolException, MoreThanOneBotPlayerException {
            try {
                validateBotCount();
                validateDimensionAndPlayerCount();
                validateUniqueSymbol();

            } catch (Exception exception) {
                throw exception;

            }
            return true;
        }
        public Game build() throws PlayerCountDimensionMisMatchException, DuplicateSymbolException, MoreThanOneBotPlayerException {
            try {
                validate();
            }catch (Exception e){
                throw e;
            }
            return new Game(this.dimension,this.players,this.winningStrategies);
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getNextMovePlayerIndex() {
        return nextMovePlayerIndex;
    }

    public void setNextMovePlayerIndex(int nextMovePlayerIndex) {
        this.nextMovePlayerIndex = nextMovePlayerIndex;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }
}
