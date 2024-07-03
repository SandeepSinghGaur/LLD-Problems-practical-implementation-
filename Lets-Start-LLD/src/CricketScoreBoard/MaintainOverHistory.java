package CricketScoreBoard;

public class MaintainOverHistory {
    private int id;
    private Player bowlerName;
    private int runs;
    private int dotBalls;
    private int noBalls;
    private int wideBalls;
    private int totalBalls;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Player getBowlerName() {
        return bowlerName;
    }

    public void setBowlerName(Player bowlerName) {
        this.bowlerName = bowlerName;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getDotBalls() {
        return dotBalls;
    }

    public void setDotBalls(int dotBalls) {
        this.dotBalls = dotBalls;
    }

    public int getNoBalls() {
        return noBalls;
    }

    public void setNoBalls(int noBalls) {
        this.noBalls = noBalls;
    }

    public int getWideBalls() {
        return wideBalls;
    }

    public void setWideBalls(int wideBalls) {
        this.wideBalls = wideBalls;
    }

    public int getTotalBalls() {
        return totalBalls;
    }

    public void setTotalBalls(int totalBalls) {
        this.totalBalls = totalBalls;
    }
}
