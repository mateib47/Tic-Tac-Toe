import java.util.ArrayList;
import java.util.List;

public class Board {
    public static final int SIZE = 3;
    private static final String[] NUMBERING = {" 0 | 1 | 2 ", "---+---+---",
            " 3 | 4 | 5 ", "---+---+---", " 6 | 7 | 8 "};
    private static final String LINE = NUMBERING[1];
    private static final String DELIM = "     ";
    private Symbol[] fields;
    private Symbol winner;

    public Board() {
        this.fields = new Symbol[SIZE*SIZE];
        this.reset();
    }
    public void reset(){
        for(int i = 0; i < SIZE*SIZE; i++){
            this.fields[i] = Symbol.E;
        }
    }
    public String toString() {
        String s = "";
        for (int i = 0; i < SIZE; i++) {
            String row = "";
            for (int j = 0; j < SIZE; j++) {
                row = row + " " + getField(i, j).toString() + " ";
                if (j < SIZE - 1) {
                    row = row + "|";
                }
            }
            s = s + row + DELIM + NUMBERING[i * 2];
            if (i < SIZE - 1) {
                s = s + "\n" + LINE + DELIM + NUMBERING[i * 2 + 1] + "\n";
            }
        }
        return s;
    }

    public Symbol getField(int row, int col) {
        return this.fields[this.index(row,col)];
    }
    public int index(int row, int col) {
        return row*SIZE+col;
    }
    public void setField(int i, Symbol s) {
        this.fields[i] = s;
    }

    public boolean checkGameOver() {
        if (isFull() || hasWinner()){
            return true;
        }else{
            return false;
        }
    }

    private boolean hasWinner() {
        return this.isWinner(Symbol.O) || this.isWinner(Symbol.X);
    }

    private boolean isWinner(Symbol s) {
        if(this.row(s) || this.column(s) || this.diagonal(s)){
            winner = s;
            return true;
        }
        return false;
    }
    private boolean diagonal(Symbol s) {
        int counter = 0;
        for(int i=0; i < SIZE;i++){
            if(this.fields[index(i,i)].equals(s))
                counter++;
        }
        if(counter == SIZE){
            return true;
        }else{
            counter = 0;
        }
        for(int i=0; i < SIZE;i++){
            if(this.fields[index(i,SIZE - i - 1)].equals(s))
                counter++;
        }
        if(counter == SIZE){
            return true;
        }
        return false;
    }
    private boolean row(Symbol s) {
        int counter = 0;
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++) {
                if (this.fields[index(i,j)].equals(s))
                    counter++;
            }
            if(counter == SIZE){
                return true;
            }else{
                counter = 0;
            }
        }
        return false;
    }
    private boolean column(Symbol s) {
        int counter = 0;
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++) {
                if (this.fields[index(j,i)].equals(s))
                    counter++;
            }
            if(counter == SIZE){
                return true;
            }else{
                counter = 0;
            }
        }
        return false;
    }

    private boolean isFull() {
        for(int i = 0; i < SIZE*SIZE; i++){
            if(this.fields[i].equals(Symbol.E))
                return false;
        }
        return true;
    }

    public Symbol getWinnerSymbol() {
        return winner;
    }

    public boolean isField(int choice) {
        return 0 <= choice && choice< SIZE*SIZE;
    }

    public boolean isEmpty(int choice) {
        return fields[choice].equals(Symbol.E);
    }

    public List<Integer> getEmptyFields(){
        List<Integer> fields = new ArrayList<>();
        for(int i=0; i < SIZE*SIZE; i++){
            if(isEmpty(i)){
                fields.add(i);
            }
        }
        return fields;
    }
}
