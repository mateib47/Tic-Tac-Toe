package View;

import Controller.*;
import Model.Symbol;


import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args){
        System.out.println("Welcome to Tic-Tac-Toe game implementation!");
        Player player1 = getPlayer(1);
        Player player2 = getPlayer(2);
        Game game= new Game(player1, player2);
        game.start();
    }

    public static Player getPlayer(int nr){
        Symbol symbol = nr == 1 ? Symbol.X : Symbol.O;
        Scanner s = new Scanner(System.in);
        String prompt = "Select the type of player "+ nr +". (0 - human, 1 - computer)";
        System.out.println(prompt);
        while(true){
            int response = s.nextInt();
            if(response == 0){
                System.out.println("What is your name?");
                while (true) {
                    String name = s.nextLine().trim();
                    if(name != ""){
                        return new HumanPlayer(name, symbol);
                    }else{
                        System.out.println("Enter a valid name");
                    }
                }
            }else if (response == 1){
                System.out.println("Select difficulty (1-easy, 2-medium, 3-hard)");
                while (true) {
                    int difficulty = s.nextInt();
                    if(difficulty == 1){
                        return new ComputerPlayer(symbol);
                    }else if(difficulty == 2){
                        return new ComputerPlayer(new SmartStrategy(), symbol);
                    } else if(difficulty == 3){
                        return new ComputerPlayer(new VerySmartStrategy(), symbol);
                    }
                    else{
                        System.out.println("Enter a valid difficulty level");
                    }
                }
            }else{
                System.out.println(prompt);
            }
        }

    }
}
