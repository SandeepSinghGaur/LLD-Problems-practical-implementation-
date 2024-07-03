package CricketScoreBoard;

import java.util.List;

public class Match {
    private int id;
    private String name;
    private String place;
    List<Team> teamList;

    public Match(int id, String name, String place, List<Team> teamList) {
        this.id = id;
        this.name = name;
        this.place = place;
        this.teamList = teamList;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }
}
