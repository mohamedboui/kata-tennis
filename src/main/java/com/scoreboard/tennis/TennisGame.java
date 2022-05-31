package com.scoreboard.tennis;

import com.scoreboard.tennis.model.Player;

public class TennisGame {


    private static final String ILLEGAL_SCORE = "-1";
    private static final String FORTY_SCORE = "40";
    private static final String THIRTY_SCORE = "30";
    private static final String FIFTEEN_SCORE = "15";
    private static final String LOVE_SCORE = "0";
    private static final String DEUCE = "Deuce";
    private static final String ADVANTAGE = "Advantage ";
    private static final String ILLEGAL_SCORE_RESULT = "Illegal score...";

    private final Player player1;

    private final Player player2;

    public TennisGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getScore() {

        if (hasWinner()) {
            return getWinnerName() + " wins";
        }

        if (hasAdvantage()) {
            return ADVANTAGE + getWinnerName();
        }

        if (isDeuce())
            return DEUCE;

        if (player1.getPlayerScore() == player2.getPlayerScore()) {
            return getMappedScore(player1.getPlayerScore()) + " | " + getMappedScore(player2.getPlayerScore());
        }

        String score1 = getMappedScore(player1.getPlayerScore());
        String score2 = getMappedScore(player2.getPlayerScore());

        if (ILLEGAL_SCORE.equals(score1) && ILLEGAL_SCORE.equals(score2)) {
            return ILLEGAL_SCORE_RESULT;
        }

        return score1 + " | " + score2;
    }

    private boolean isDeuce() {
        return player1.getPlayerScore() >= 3 && player2.getPlayerScore() == player1.getPlayerScore();
    }

    private String getWinnerName() {
        if (player1.getPlayerScore() > player2.getPlayerScore()) {
            return player1.getPlayerName();
        } else {
            return player2.getPlayerName();
        }
    }

    private boolean hasWinner() {
        if (player2.getPlayerScore() == 4 && player2.getPlayerScore() >= player1.getPlayerScore() + 2)
            return true;
        if (player1.getPlayerScore() == 4 && player1.getPlayerScore() >= player2.getPlayerScore() + 2)
            return true;
        if (player2.getPlayerScore() > 4 && player2.getPlayerScore() == player1.getPlayerScore() + 2)
            return true;
        if (player1.getPlayerScore() > 4 && player1.getPlayerScore() == player2.getPlayerScore() + 2)
            return true;
        return false;
    }

    private boolean hasAdvantage() {
        if (player2.getPlayerScore() >= 4 && player2.getPlayerScore() == player1.getPlayerScore() + 1)
            return true;
        if (player1.getPlayerScore() >= 4 && player1.getPlayerScore() == player2.getPlayerScore() + 1)
            return true;

        return false;
    }

    public void playerOneScores() {
        int score = player1.getPlayerScore() + 1;
        player1.setPlayerScore(score);
    }

    public void playerTwoScores() {
        int score = player2.getPlayerScore() + 1;
        player2.setPlayerScore(score);
    }

    private String getMappedScore(int score) {
        switch (score) {
            case 3:
                return FORTY_SCORE;
            case 2:
                return THIRTY_SCORE;
            case 1:
                return FIFTEEN_SCORE;
            case 0:
                return LOVE_SCORE;
        }
        return ILLEGAL_SCORE;
    }

}
