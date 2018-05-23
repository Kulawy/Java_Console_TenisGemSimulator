package com.company.jakub.geron;

public class SingleGem {

    private Player playerOne;
    private Player playerTwo;
    private int advantage; //if server have Advantage set to 1, if receiver set to 2


    public SingleGem(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        advantage = 0;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public boolean setBallWinner(int winner) {

        boolean flag;
        if ( playerTwo.getScore() >= 3 && playerOne.getScore() >= 3)
            flag = true;
        else
            flag = false;

        switch ( winner ){
            case 1:
                if ( (setWinnerOfGem() == 0) && advantage != 2 && flag)
                    advantage = 1;
                else
                    advantage = 0;
                playerOne.winBall();
                return true;
            case 2:
                if ( (setWinnerOfGem() == 0) && advantage != 1 && flag)
                    advantage = 2;
                else
                    advantage = 0;
                playerTwo.winBall();
                return true;

            default:
                return false;
        }
    }

    public boolean isOver() {

        return ((playerOne.getScore() >= 4) || (playerTwo.getScore() >= 4)) && (Math.abs(playerOne.getScore() - playerTwo.getScore()) > 1);
        /*
        if ( ((playerOne.getScore() >= 4) || ( playerTwo.getScore() >= 4) ) && ( Math.abs(playerOne.getScore() - playerTwo.getScore()) <= 2) )
            return true;
        else
            return false;
         */
    }

    public int setWinnerOfGem(){

        if (playerOne.getScore() == playerTwo.getScore())
            return 0;
        else{
            if (playerOne.getScore() > playerTwo.getScore())
                return 1;
            else
                return 2;
        }

    }

    // I am sure that advantage only can have value 0 or 1 or 2, because test are passing but it is simple program and some guards just in case someone want to provide some changes to code.
    public String displayScore() {
        if ( (advantage <= 2) && (advantage >= 0)) {
            switch ( advantage){
                case 1:
                    return "A" + ":" + getPlayerTwo().generateScoreDescritpion();
                case 2:
                    return playerOne.generateScoreDescritpion() + ":" + "A";

                default:
                    return playerOne.generateScoreDescritpion() + ":" + getPlayerTwo().generateScoreDescritpion();
            }
        } else
            return "SUPRICE";
    }

}
