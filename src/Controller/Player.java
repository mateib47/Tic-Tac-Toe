package Controller;

import Model.Board;
import Model.Symbol;

public abstract class Player {
    private String name;
    private Symbol symbol;

    public Player(String name, Symbol symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public abstract int determineMove(Board board);

    public void makeMove(Board board){
        int choice = determineMove(board);
        board.setField(choice, getSymbol());
    }
}
