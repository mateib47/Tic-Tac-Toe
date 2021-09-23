public class NaiveStrategy implements Strategy{
    @Override
    public String getName() {
        return "Naive";
    }

    @Override
    public int determineMove(Board board, Symbol symbol) {
        //todo get all empty fields and choose one randomly
        return 0;
    }
}
