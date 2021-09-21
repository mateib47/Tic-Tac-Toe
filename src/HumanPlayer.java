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
        //check if it is valid
        return choice;
    }
}
