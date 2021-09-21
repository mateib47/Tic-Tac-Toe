import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args){
        Player player1 = new HumanPlayer("Matei", Symbol.X);
        Player player2 = new HumanPlayer("Bucur", Symbol.O);
        Game game= new Game(player1, player2);
        game.start();
    }
}
