package CricketScoreBoard;

public class Player {
    private int id;
    private String name;
    private PlayerType playerType;
    private int run = 0;
    private int over;

    public Player(int id, String name, PlayerType playerType, int run, int over) {
        this.id = id;
        this.name = name;
        this.playerType = playerType;
        this.run = run;
        this.over = over;
    }

    public int getRun() {
        return run;
    }

    public void setRun(int run) {
        this.run = run;
    }

    public int getOver() {
        return over;
    }

    public void setOver(int over) {
        this.over = over;
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

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }
}
