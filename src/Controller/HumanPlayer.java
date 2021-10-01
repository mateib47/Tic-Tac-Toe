package Controller;

import Model.Board;
import Model.Symbol;

import java.util.Scanner;

public class HumanPlayer extends Player {
    public HumanPlayer(String name, Symbol symbol) {
        super(name, symbol);
    }

    @Override
    public int determineMove(Board board) {
        System.out.println(getName() + " (" + getSymbol().toString() + ")" + " ,what is your move? (0-9)");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        boolean valid = board.isField(choice) && board.isEmpty(choice);
        while(!valid){
            System.out.println("Error, field "+choice+" is not valid");
            choice = scanner.nextInt();
            valid = board.isField(choice) && board.isEmpty(choice);
        }
        return choice;
    }
}
