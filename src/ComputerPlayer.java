public class ComputerPlayer extends Player{

    Strategy strategy;

    public ComputerPlayer(Strategy strategy, Symbol symbol) {
        super(strategy.getName(), symbol);
        this.strategy = strategy;
    }
    public ComputerPlayer(Symbol symbol) {
        this(new NaiveStrategy(), symbol);
    }

    @Override
    public int determineMove(Board board) {
        return strategy.determineMove(board, getSymbol());
    }
}
