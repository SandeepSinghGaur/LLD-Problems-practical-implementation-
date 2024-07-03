package CricketScoreBoard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Let's start the match");
        System.out.println("Toss started");

        // Initialize teams and players
        List<Team> teamList = new ArrayList<>();
        List<Player> team1Player = new ArrayList<>();
        team1Player.add(new Player(1, "Virat", PlayerType.BATTER, 0, 0));
        team1Player.add(new Player(2, "Rohit", PlayerType.BATTER, 0, 0));
        team1Player.add(new Player(3, "Hardik", PlayerType.BATTER, 0, 0));
        team1Player.add(new Player(4, "Pant", PlayerType.BATTER, 0, 0));
        team1Player.add(new Player(5, "KL", PlayerType.BATTER, 0, 0));

        List<Player> team2Player = new ArrayList<>();
        team2Player.add(new Player(1, "Sachin", PlayerType.BATTER, 0, 0));
        team2Player.add(new Player(2, "Laxman", PlayerType.BATTER, 0, 0));
        team2Player.add(new Player(3, "Kumble", PlayerType.BATTER, 0, 0));
        team2Player.add(new Player(4, "Saurav", PlayerType.BATTER, 0, 0));
        team2Player.add(new Player(5, "Rahul", PlayerType.BATTER, 0, 0));

        List<Player> battingOrder1 = new ArrayList<>(team1Player);
        List<Player> battingOrder2 = new ArrayList<>(team2Player);

        Team team1 = new Team(1, "CSK", team1Player, battingOrder1, 2, 0);
        Team team2 = new Team(2, "RCB", team2Player, battingOrder2, 2, 0);
        teamList.add(team1);
        teamList.add(team2);

        Match match = new Match(1, "IPL", "Bengaluru", teamList);
        System.out.println("Team 1 won the toss");

        // Start match for team1
        int team1Overs = team1.getOvers();
        List<Player> battingOrder = team1.getBattingOrder();
        Player[] playingPlayers = new Player[2];
        int pos = 0;
        playingPlayers[0] = battingOrder.get(pos++);
        playingPlayers[1] = battingOrder.get(pos);

        for (int i = 0; i < team1Overs; i++) {
            MaintainOverHistory maintainOverHistory = new MaintainOverHistory();

            int legalBallsCount = 0;
            List<Integer> runOver = new ArrayList<>();
            int[] countAndCurrentPlayer = new int[3];

            while (legalBallsCount < 6) {
                countAndCurrentPlayer = playTheBall(team1, legalBallsCount, countAndCurrentPlayer[1], playingPlayers, maintainOverHistory, runOver, pos, battingOrder);
                legalBallsCount += countAndCurrentPlayer[0];
                System.out.println("Legal Balls Count: " + legalBallsCount);
            }

            System.out.println("Run in this over:");
            for (int run : runOver) {
                if(run==-1){
                    System.out.printf(" W "+" ");
                }else{
                    System.out.printf(" %d ", run);
                }

            }
            System.out.println();
        }

        System.out.println("Total Run by Team1 " + team1.getRuns());
        System.out.println("===============================");
        System.out.println("Run score by Individual player");
        System.out.println("===============================");
        for (Player player : team1.getPlayers()) {
            System.out.println(player.getName() + ", Runs: " + player.getRun());
        }
    }

    private static int[] playTheBall(Team team, int count, int ind, Player[] playingPlayers, MaintainOverHistory maintainOverHistory, List<Integer> runOver, int pos, List<Player> battingOrder) throws Exception {
        Player currentPlayer = playingPlayers[ind];
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose ball (wide, noball, 1, 2, 3, 4, 6, out):");
        String ball = sc.nextLine();

        boolean legalDelivery = true;
        boolean isWicket = true;

        switch (ball.toLowerCase()) {
            case "wide":
                runOver.add(1);
                team.setRuns(team.getRuns() + 1);
                legalDelivery = false;
                break;
            case "noball":
                runOver.add(1);
                team.setRuns(team.getRuns() + 1);
                legalDelivery = false;
                break;
            case "1":
                runOver.add(1);
                team.setRuns(team.getRuns() + 1);
                currentPlayer.setRun(currentPlayer.getRun() + 1);
                if (count != 5) {
                    ind = (ind + 1) % 2;
                }
                break;
            case "2":
                runOver.add(2);
                team.setRuns(team.getRuns() + 2);
                currentPlayer.setRun(currentPlayer.getRun() + 2);
                break;
            case "3":
                runOver.add(3);
                team.setRuns(team.getRuns() + 3);
                currentPlayer.setRun(currentPlayer.getRun() + 3);
                if (count != 5) {
                    ind = (ind + 1) % 2;
                }
                break;
            case "4":
                runOver.add(4);
                team.setRuns(team.getRuns() + 4);
                currentPlayer.setRun(currentPlayer.getRun() + 4);
                break;
            case "6":
                runOver.add(6);
                team.setRuns(team.getRuns() + 6);
                currentPlayer.setRun(currentPlayer.getRun() + 6);
                break;
            case "out":
                playingPlayers[ind] = battingOrder.get(++pos);
                runOver.add(-1);
                isWicket = false;
                break;
            default:
                System.out.println("Please Enter the Valid Input");
                legalDelivery = false;
                break;
        }

        return new int[]{legalDelivery ? 1 : 0, ind, isWicket ? 0 : 1};
    }
}
