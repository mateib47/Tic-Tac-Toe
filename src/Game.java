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
        play();
    }
    public void play() {
        while (true){
            System.out.println(board.toString());
            players[current].makeMove(board);
            other(current);
        }
    }
    public void other(int c){
        if(c == 0) current = 1;
        else current = 0;
    }
}
