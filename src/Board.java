public class Board {
    public static final int SIZE = 3;
    private static final String[] NUMBERING = {" 0 | 1 | 2 ", "---+---+---",
            " 3 | 4 | 5 ", "---+---+---", " 6 | 7 | 8 "};
    private static final String LINE = NUMBERING[1];
    private static final String DELIM = "     ";
    private Symbol[] fields;

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
}
