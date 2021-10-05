package View;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class GameView {
    private BufferedWriter fout;
    private JTextArea textArea;
    public GameView(OutputStream s) {
        this.fout = new BufferedWriter(new OutputStreamWriter(s));
    }
    public GameView(JTextArea a) {
        this.textArea = a;
        this.fout = null;
    }
    public void print(String text){
        if(fout != null){
            try {
                fout.write(text+"\n");
                fout.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            textArea.append(text);
        }
    }
    public void print(){
        if(fout != null){
            try {
                fout.write("\n");
                fout.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            textArea.append("\n");
        }
    }

}
