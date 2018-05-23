package com.company.jakub.geron;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingleGemTest {

    SingleGem game;
    Player server;
    Player receiver;


    @BeforeEach
    public void setUp(){
        server = new Player("Server");
        receiver = new Player("Receiver");
        game = new SingleGem(server, receiver);
    }

    @Test
    public void checkThatSingleGameHasPlayerOne(){
        Assert.assertNotNull(game.getPlayerOne());
    }
    @Test
    public void checkThatSingleGameHasPlayerTwo(){
        Assert.assertNotNull(game.getPlayerTwo());
    }

    @Test
    public void checkPointsAdditionWhenPlayerWon10(){
        game.setBallWinner(1);
        Assert.assertEquals( "15", game.getPlayerOne().generateScoreDescritpion() );
    }

    @Test
    public void checkPointsAdditionWhenPlayerWon01(){
        game.setBallWinner(2);
        Assert.assertEquals( "15", game.getPlayerTwo().generateScoreDescritpion() );
    }

    @Test
    public void checkIsItOver(){
        for( int i = 0; i < 5; i++){
            game.setBallWinner(1);
        }
        game.isOver();
    }

    @Test
    public void checkTheWinner10(){
        game.setBallWinner(1);
        assertEquals( 1, game.getPlayerOne().getScore());
    }

    @Test
    public void checkWinnerOfGem(){
        for( int i = 0; i < 4; i++){
            game.setBallWinner(2);
        }
        assertEquals(2, game.setWinnerOfGem());
    }

    @Test
    public void checkDisplayScore00(){
        assertEquals("0:0", game.displayScore());
    }

    @Test
    public void checkDisplayScoreFor66(){
        for( int i = 0; i <= 10; i++){
            game.setBallWinner(1);
            game.setBallWinner(2);
        }
        assertEquals("40:40", game.displayScore());
    }

}
