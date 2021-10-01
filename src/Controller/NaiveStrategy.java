package Controller;

import Model.Board;
import Model.Symbol;

import java.util.List;
import java.util.Random;

public class NaiveStrategy implements Strategy{
    @Override
    public String getName() {
        return "Naive";
    }

    @Override
    public int determineMove(Board board, Symbol symbol) {
        Random r = new Random();
        List<Integer> emptyFields = board.getEmptyFields();
        int random = r.nextInt(emptyFields.size());
        return emptyFields.get(random);
    }
}
