package com.company.jakub.geron;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameInterfaceTest {

    GameInterface actualInterface;

    @BeforeEach
    void setUp() {
        actualInterface = new GameInterface();
        actualInterface.initGem();
    }

    @Test
    public void chceckGemCreation(){
        assertTrue(actualInterface.initGem());
    }

    @Test
    public void checkDisplayRules(){
        assertTrue(actualInterface.displayRules());
    }

    @Test
    public void checkDisplayWinner(){

        //score is 0:0 so no one is the winner
        assertFalse(actualInterface.displayWinner());
    }


    @Ignore
    public void chcekStartGame(){
        actualInterface.startGame();
    }



}