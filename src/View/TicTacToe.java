package View;

import Controller.*;
import Model.Symbol;


import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args){
        GameView view = new GameView(System.out);
        view.print("Welcome to Tic-Tac-Toe game implementation!");
        Player player1 = getPlayer(1, view);
        Player player2 = getPlayer(2, view);
        Game game= new Game(player1, player2, view);
        game.start();
    }

    public static Player getPlayer(int nr, GameView view){
        Symbol symbol = nr == 1 ? Symbol.X : Symbol.O;
        Scanner s = new Scanner(System.in);
        String prompt = "Select the type of player "+ nr +". (0 - human, 1 - computer)";
        view.print(prompt);
        while(true){
            int response = s.nextInt();
            if(response == 0){
                view.print("What is your name?");
                while (true) {
                    String name = s.nextLine().trim();
                    if(name != ""){
                        return new HumanPlayer(name, symbol, view);
                    }else{
                        view.print("Enter a valid name");
                    }
                }
            }else if (response == 1){
                view.print("Select difficulty (1-easy, 2-medium, 3-hard)");
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
                        view.print("Enter a valid difficulty level");
                    }
                }
            }else{
                view.print(prompt);
            }
        }

    }
}
