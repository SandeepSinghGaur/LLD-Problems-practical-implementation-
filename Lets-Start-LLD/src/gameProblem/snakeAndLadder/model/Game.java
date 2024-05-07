package gameProblem.snakeAndLadder.model;

import gameProblem.tictaktoe.model.GameState;

import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private GameState gameState;
    private int nextMovePlayerIndex;
    private Move move;
    private Player winner;

    public Game(Board board, List<Player> players, GameState gameState, int nextMovePlayerIndex, Move move, Player winner) {
        this.board = board;
        this.players = players;
        this.gameState = gameState;
        this.nextMovePlayerIndex = nextMovePlayerIndex;
        this.move = move;
        this.winner = winner;
    }
    // How we start the game.?

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
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

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
}
