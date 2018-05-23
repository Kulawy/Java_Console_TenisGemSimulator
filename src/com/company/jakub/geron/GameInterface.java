package com.company.jakub.geron;

import java.io.*;
import java.util.Scanner;

public class GameInterface {

    private SingleGem actualGame;
    private Scanner scanner;


    public GameInterface(){
        scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    }

    public boolean initGem() {
        Player one = new Player("Server");
        Player two = new Player("Receiver");
        actualGame = new SingleGem( one, two);
        return true;
    }

    public boolean displayRules() {
        System.out.println("RULES:");
        System.out.println("Type ");
        System.out.println("Server = 1");
        System.out.println("Receiver = 2");
        System.out.println("Please enter the player that wins the poin");
        return true;
    }


    public boolean displayWinner() {

        switch ( actualGame.setWinnerOfGem()){
            case 1:
                System.out.println("Server wins");
                return true;
            case 2:
                System.out.println("Receiver wins");
                return true;
            default:
                return false;
        }
    }

    public void startGame() {
        initGem();
        displayRules();

        while ( !actualGame.isOver() ){
            System.out.println(actualGame.displayScore());
            System.out.print("#");
            actualGame.setBallWinner(scanner.nextInt());
        }
        displayWinner();
        System.out.println("Press any key to end");
        scanner.next();
    }

}
