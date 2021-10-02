package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private JPanel menu;
    private JLabel title;
    private JButton welcomeButton;
    private JLabel player1;
    private JRadioButton human;
    private JRadioButton computer;


    public GUI() {
        frame = new JFrame();
        panel = new JPanel();

        title = new JLabel("Play Tic Tac Toe", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setBorder(BorderFactory.createEmptyBorder(0,0,40,0));

        JLabel welcomeText = new JLabel("Welcome to my Tic-Tac-Toe game implementation.", SwingConstants.CENTER);
        welcomeButton = new JButton("Let's get started!");
        welcomeButton.addActionListener(this);


        panel.setBorder(BorderFactory.createEmptyBorder(180, 180, 180, 180));
        panel.setLayout(new GridLayout(4, 4));
        panel.add(title);
        panel.add(welcomeText);
        panel.add(welcomeButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("TicTacToe GUI");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == welcomeButton){
            resetFrame();
            menu = new JPanel();
            menu.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
            menu.setLayout(new GridLayout(4, 4));

            player1 = new JLabel("Player 1");
            human = new JRadioButton("Human Player");
            human.setSelected(true);
            human.setSize(75, 20);
            computer = new JRadioButton("Computer Player");
            computer.setSelected(true);
            computer.setSize(75, 20);
            menu.add(player1);
            menu.add(human);
            menu.add(computer);

            frame.setContentPane(menu);

        }
    }

    public void resetFrame(){
        frame.getContentPane().removeAll();
        frame.repaint();
    }
}
