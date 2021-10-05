package Controller;

import Model.Board;
import Model.Symbol;
import View.GameView;

import java.util.Scanner;

public class HumanPlayer extends Player {
    private GameView view;
    public HumanPlayer(String name, Symbol symbol, GameView view) {
        super(name, symbol);
        this.view = view;
    }

    @Override
    public int determineMove(Board board) {
        view.print(getName() + " (" + getSymbol().toString() + ")" + " ,what is your move? (0-9)");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        boolean valid = board.isField(choice) && board.isEmpty(choice);
        while(!valid){
            view.print("Error, field "+choice+" is not valid");
            choice = scanner.nextInt();
            valid = board.isField(choice) && board.isEmpty(choice);
        }
        return choice;
    }
}
