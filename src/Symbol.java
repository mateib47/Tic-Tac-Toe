/**
 * Represents the types of symbols that are
 * used in this TicTacToe implementation
 * Symbol.X, Symbol.O,Symbol.EMPTY
 */


public enum Symbol {

    E, X, O;

    /**
     * @ensures O returned if symbol is X, X returned if symbol is O,
     * @return the other symbol (if different than empty)
     */
    public Symbol other(){
        if (this == Symbol.O){
            return Symbol.X;
        }else if (this == Symbol.X){
            return Symbol.O;
        }else{
            return Symbol.E;
        }
    }
}
