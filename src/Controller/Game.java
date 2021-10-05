package Controller;

import Model.Board;
import View.GameView;

import java.util.Scanner;

public class Game {
    private Board board;
    private Player[] players;
    private int current;
    private GameView view;

    public Game(Player p0, Player p1, GameView view){
        this.board = new Board();
        players = new Player[2];
        this.view = view;
        players[0] = p0;
        players[1] = p1;
        current = 0;
    }

    public void start() {
        boolean continueGame = true;
        while(continueGame){
            reset();
            play();
            result();
            continueGame = again();

        }
    }
    private void result(){
        String result = "Game finished!\n";
        if(players[0].getSymbol().equals(board.getWinnerSymbol())){
            result += "Player " + players[0].getName() + " won!";
        }else if(players[1].getSymbol().equals(board.getWinnerSymbol())){
            result += "Player " + players[1].getName() + " won!";
        }else{
            result += "There was a draw!";
        }
        view.print(result);
    }

    private  boolean again(){
        Scanner scanner = new Scanner(System.in);
        view.print("Play again? (y/n)");
        while(true){
            String resp = scanner.nextLine();
            if(resp.equals("y")){
                return true;
            }else if(resp.equals("n")){
                return false;
            }else{
                view.print("Play again? Type 'y' for yes or 'n' for no");
            }
        }
    }

    private void reset() {
        current = 0;
        board.reset();
    }

    public void play() {
        while (!board.checkGameOver()){
            printGameStatus(board);
            players[current].makeMove(board);
            current = (current == 0) ? 1 : 0;
        }
        printGameStatus(board);
    }
    public void printGameStatus(Board board){
        view.print(board.toString());
        view.print();
        view.print("===========     ===========");
        view.print();
    }
}
