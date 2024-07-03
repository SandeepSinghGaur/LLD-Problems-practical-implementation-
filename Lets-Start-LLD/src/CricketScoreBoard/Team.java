package CricketScoreBoard;

import java.util.List;

public class Team {
    private int id;
    private String name;
    private List<Player> players;
    private List<Player> battingOrder;
    private int overs;
    private int runs = 0;
    private  Player currentPlayer;

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Team(int id, String name, List<Player> players, List<Player> battingOrder, int overs, int runs) {
        this.id = id;
        this.name = name;
        this.players = players;
        this.battingOrder = battingOrder;
        this.overs = overs;
        this.runs = runs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Player> getBattingOrder() {
        return battingOrder;
    }

    public void setBattingOrder(List<Player> battingOrder) {
        this.battingOrder = battingOrder;
    }

    public int getOvers() {
        return overs;
    }

    public void setOvers(int overs) {
        this.overs = overs;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }
}
