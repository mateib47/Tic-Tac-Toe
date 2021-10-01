package Controller;

import Model.Board;
import Model.Symbol;

import java.util.List;
import java.util.Random;

public class VerySmartStrategy implements Strategy{
    @Override
    public String getName() {
        return "VerySmart";
    }

    @Override
    public int determineMove(Board board, Symbol symbol) {
        List<Integer> emptyFields = board.getEmptyFields();
        for(int field : emptyFields) {
            Board copyBoard = board.deepCopy();
            copyBoard.setField(field, symbol.other());
            if (copyBoard.checkGameOver()) {
                return field;
            }
            copyBoard.setField(field, symbol);
            if (copyBoard.checkGameOver()) {
                return field;
            }
        }
        int middle = (board.SIZE * board.SIZE) / 2;
        if(emptyFields.contains(middle)){
            return middle;
        }else{
            Random r = new Random();
            int random = r.nextInt(emptyFields.size());
            return emptyFields.get(random);
        }
    }
}
