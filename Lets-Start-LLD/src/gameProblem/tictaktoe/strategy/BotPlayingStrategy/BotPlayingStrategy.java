package gameProblem.tictaktoe.strategy.BotPlayingStrategy;


import gameProblem.tictaktoe.model.Board;
import gameProblem.tictaktoe.model.Move;

public interface BotPlayingStrategy {
    public Move makeMove(Board board);
}
