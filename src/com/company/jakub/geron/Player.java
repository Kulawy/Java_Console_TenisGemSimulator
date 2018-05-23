package com.company.jakub.geron;

import org.junit.jupiter.api.Test;

public class Player {

    private static final String[] description = {"0", "15", "30", "40"};
    private String name;
    private int score;


    public Player(String name) {
        this.name = name;
        score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void winBall() {
        score ++;
    }

    public String generateScoreDescritpion() {
        if ( score > 3 ){
            return description[3];
        }
        else
            return description[score];
    }


}
