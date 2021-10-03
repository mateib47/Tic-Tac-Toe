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
    private JRadioButton human1;
    private JRadioButton computer1;
    private ButtonGroup player1gp;
    private JLabel player2;
    private JRadioButton human2;
    private JRadioButton computer2;
    private ButtonGroup player2gp;
    private JLabel name1;
    private JTextField tname1;


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
            menu.setLayout(new GridLayout(3, 3));

            createPlayerType(1);
            createPlayerType(2);

            frame.setContentPane(menu);
            SwingUtilities.updateComponentTreeUI(frame);
        } else if(e.getSource() == human1){
            name1.setVisible(true);
            tname1.setVisible(true);
            System.out.println("ca");

        }
        SwingUtilities.updateComponentTreeUI(frame);

    }

    public void createPlayerType(int nr){
        if(nr == 1){
            player1 = new JLabel("Player 1");
            human1 = new JRadioButton("Human Player");
            human1.setSize(75, 20);
            computer1 = new JRadioButton("Computer Player");
            computer1.setSize(75, 20);
            player1gp = new ButtonGroup();
            player1gp.add(human1);
            player1gp.add(computer1);

            name1 = new JLabel("Name");
            name1.setFont(new Font("Arial", Font.PLAIN, 20));
            tname1 = new JTextField();
            tname1.setFont(new Font("Arial", Font.PLAIN, 15));
            name1.setVisible(false);
            tname1.setVisible(false);

            human1.addActionListener(this);

            menu.add(player1);
            menu.add(human1);
            menu.add(computer1);
            menu.add(name1);
            menu.add(tname1);
            menu.add(new JLabel(""));


        }else{
            player2 = new JLabel("Player 2");
            human2 = new JRadioButton("Human Player");
            human2.setSize(75, 20);
            computer2 = new JRadioButton("Computer Player");
            computer2.setSize(75, 20);
            player2gp = new ButtonGroup();
            player2gp.add(human2);
            player2gp.add(computer2);
            menu.add(player2);
            menu.add(human2);
            menu.add(computer2);
        }

    }

    public void resetFrame(){
        frame.getContentPane().removeAll();
        frame.repaint();
    }
}
