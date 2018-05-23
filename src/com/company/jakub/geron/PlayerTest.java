package com.company.jakub.geron;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class PlayerTest {

    Player server;
    Player receiver;

    @BeforeEach
    public void setUp() {
        server = new Player("Server");
        receiver = new Player("Receiver");

    }

    @Test
    public void checkPlayerServerName(){
        assertEquals("Server", server.getName());
    }
    @Test
    public void checkPlayerReceiverName(){
        assertEquals("Receiver", receiver.getName());
    }

    @Test
    public void checkObjectHasScorePropertyinitializedTo0(){
        assertEquals(0, server.getScore());
    }

    @Test
    public void checkPointsOneAfterWin(){
        server.winBall();
        assertEquals(1, server.getScore());
    }

    @Test
    public void checkPointsTwoAfterWin(){
        receiver.winBall();
        assertEquals(1, receiver.getScore());
    }

    @Test
    public void checkScoreDescriptionFor1(){
        receiver.winBall();
        assertEquals("15", receiver.generateScoreDescritpion());
    }

    @Test
    public void addingMorePointsOne(){

        for ( int i=0; i < 4; i++){
            server.winBall();
        }
        assertEquals(4, server.getScore());
    }

    @Test
    public void addingMorePointsTwo(){

        for ( int i=0; i < 3; i++){
            server.winBall();
        }
        assertEquals("40", server.generateScoreDescritpion());
    }

    @Test
    public void addingMorePoint(){

        for ( int i=0; i < 6; i++){
            server.winBall();
        }
        Assertions.assertEquals( "40", server.generateScoreDescritpion());
    }

    @Ignore
    public void addingMorePointsFail(){

        for ( int i=0; i < 6; i++){
            server.winBall();
        }
        Assertions.assertThrows(IndexOutOfBoundsException.class, ()-> server.generateScoreDescritpion());
    }

    @AfterEach
    public void tearDown() {

    }

}