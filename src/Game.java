import java.util.Scanner;

public class Game {
    private Board board;
    private Player[] players;
    private int current;

    public Game(Player p0, Player p1){
        this.board = new Board();
        players = new Player[2];
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
        System.out.println("Game finished!");
        if(players[0].getSymbol().equals(board.getWinnerSymbol())){
            System.out.println("Player " + players[0].getName() + " won!");
        }else if(players[1].getSymbol().equals(board.getWinnerSymbol())){
                System.out.println("Player " + players[1].getName() + " won!");
        }else{
            System.out.println("There was a draw!");
        }
    }

    private  boolean again(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Play again? (y/n)");
        while(true){
            String resp = scanner.nextLine();
            if(resp.equals("y")){
                return true;
            }else if(resp.equals("n")){
                return false;
            }else{
                System.out.println("Play again? Type 'y' for yes or 'n' for no");
            }
        }
    }

    private void reset() {
        current = 0;
        board.reset();
    }

    public void play() {
        while (!board.checkGameOver()){
            System.out.println(board.toString());
            players[current].makeMove(board);
            current = (current == 0) ? 1 : 0;
        }
    }
}
