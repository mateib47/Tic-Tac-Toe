import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args){
        System.out.println("Welcome to Tic-Tac-Toe game implementation!");

        Player player1 = getPlayer(1);
        Player player2 = getPlayer(2);
        Game game= new Game(player1, player2);
        game.start();
    }

    public static Player getPlayer(int nr){
        Symbol symbol = nr == 1 ? Symbol.X : Symbol.O;
        Scanner s = new Scanner(System.in);
        String prompt = "Select the type of player "+ nr +". (0 - human, 1 - computer)";
        System.out.println(prompt);
        while(true){
            int response = s.nextInt();
            if(response == 0){
                System.out.println("What is your name?");
                while (true) {
                    String name = s.nextLine();
                    if(name != ""){
                        return new HumanPlayer(name, symbol);
                    }else{
                        System.out.println("Enter a valid name");
                    }
                }
            }else if (response == 1){
                System.out.println("Select difficulty (0-easy)");
                while (true) {
                    int difficulty = s.nextInt();
                    if(difficulty == 0){
                        return new ComputerPlayer(symbol);
                    }else{
                        System.out.println("Enter a valid difficulty level");
                    }
                }
            }else{
                System.out.println(prompt);
            }
        }

    }
}
