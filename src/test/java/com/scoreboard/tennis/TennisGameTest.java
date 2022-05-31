package com.scoreboard.tennis;

import com.scoreboard.tennis.model.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TennisGameTest {
    private TennisGame tennisGameScore;

    private Player player1;

    private Player player2;

    @Before
    public void setup() {
        player1 = new Player();
        player1.setPlayerName("Player1");
        player2 = new Player();
        player2.setPlayerName("Player2");

        tennisGameScore = new TennisGame(player1,player2);
        
    }

    @Test
    public void testNewGameShouldReturn0All() {
        String score = tennisGameScore.getScore();

        assertEquals("0 | 0", score);
    }

    @Test
    public void testPlayer1WinsFirstBall() {
        tennisGameScore.playerOneScores();

        String score = tennisGameScore.getScore();
        assertEquals("15 | 0", score);
    }

    @Test
    public void test15All() {
        tennisGameScore.playerOneScores();
        tennisGameScore.playerTwoScores();

        String score = tennisGameScore.getScore();
        assertEquals("15 | 15", score);
    }

    @Test
    public void testPlayer2WinsFirst2Balls() {
        createScore(0, 2);

        String score = tennisGameScore.getScore();
        assertEquals("0 | 30", score);
    }

    @Test
    public void testPlayer1WinsFirst3Balls() {
        createScore(3, 0);
        String score = tennisGameScore.getScore();
        assertEquals("40 | 0", score);
    }

    @Test
    public void testPlayersAreDeuce() {
        createScore(3, 3);

        String score = tennisGameScore.getScore();
        assertEquals("Deuce", score);
    }

    @Test
    public void testPlayer1WinsGame() {
        createScore(4, 0);

        String score = tennisGameScore.getScore();
        assertEquals("Player1 wins", score);
    }

    @Test
    public void testPlayer2WinsGame() {
        createScore(1, 4);

        String score = tennisGameScore.getScore();
        assertEquals("Player2 wins", score);
    }

    @Test
    public void testPlayersAreDuce4() {
        createScore(4, 4);
        String score = tennisGameScore.getScore();
        assertEquals("Deuce", score);
    }

    @Test
    public void testPlayer2Advantage() {
        createScore(4, 5);

        String score = tennisGameScore.getScore();
        assertEquals("Advantage Player2", score);
    }

    @Test
    public void testPlayer1Advantage() {
        createScore(5, 4);

        String score = tennisGameScore.getScore();
        assertEquals("Advantage Player1", score);
    }

    @Test
    public void testPlayer2Wins() {
        createScore(2, 4);
        String score = tennisGameScore.getScore();
        assertEquals("Player2 wins", score);
    }

    @Test
    public void testPlayer2WinsAfterAdvantage() {
        createScore(6, 8);
        String score = tennisGameScore.getScore();
        assertEquals("Player2 wins", score);
    }

    @Test
    public void testPlayer1WinsAfterAdvantage() {
        createScore(8, 6);
        String score = tennisGameScore.getScore();
        assertEquals("Player1 wins", score);
    }

    @Test
    public void testScoreInputtedInvalid() {
        createScore(9, 6);
        String score = tennisGameScore.getScore();
        assertEquals("Illegal score...", score);
    }

    private void createScore(int player1Balls, int player2Balls) {

        for (int i = 0; i < player1Balls; i++) {
            tennisGameScore.playerOneScores();
        }
        for (int i = 0; i < player2Balls; i++) {
            tennisGameScore.playerTwoScores();
        }
    }
}
