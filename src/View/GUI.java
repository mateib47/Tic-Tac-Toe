package View;

import Controller.*;
import Model.Symbol;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private JPanel menu, game;
    private JLabel title;
    private JButton welcomeButton, submit;
    private JLabel player1;
    private JRadioButton human1;
    private JRadioButton computer1;
    private ButtonGroup player1gp;
    private JLabel player2;
    private JRadioButton human2;
    private JRadioButton computer2;
    private ButtonGroup player2gp;
    private JLabel name1, name2;
    private JTextField tname1, tname2;
    private JLabel difficulty1, difficulty2;
    private JRadioButton easy1, medium1, hard1,easy2, medium2, hard2;
    private ButtonGroup difficulty1gp, difficulty2gp;
    private JTextArea consoleView;
    private GameView view;
    public Game gameRun;



    public GUI() {
        consoleView = new JTextArea(50,50);
        consoleView.setPreferredSize(new Dimension(200,200));
        consoleView.setMaximumSize( consoleView.getPreferredSize() );
        view = new GameView(consoleView);

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
        GUI gui = new GUI();
        //gui.start();
    }

    public void start(){
        while(true){
            if(gameRun !=null)         gameRun.start();

        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == welcomeButton){
            resetFrame();
            menu = new JPanel();
            menu.setBorder(BorderFactory.createEmptyBorder(50, 50, 100, 100));
            menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));

            createPlayerType(1);
            createPlayerType(2);
            submit = new JButton("Submit");
            submit.addActionListener(this);
            menu.add(submit);


            frame.setContentPane(menu);
        } else if(e.getSource() == human1){
            name1.setVisible(true);
            tname1.setVisible(true);
            difficulty1.setVisible(false);
            easy1.setVisible(false);
            medium1.setVisible(false);
            hard1.setVisible(false);
        } else if(e.getSource() == computer1){
            name1.setVisible(false);
            tname1.setVisible(false);
            difficulty1.setVisible(true);
            easy1.setVisible(true);
            medium1.setVisible(true);
            hard1.setVisible(true);
        }
        else if(e.getSource() == human2){
            name2.setVisible(true);
            tname2.setVisible(true);
            difficulty2.setVisible(false);
            easy2.setVisible(false);
            medium2.setVisible(false);
            hard2.setVisible(false);

        } else if(e.getSource() == computer2){
            name2.setVisible(false);
            tname2.setVisible(false);
            difficulty2.setVisible(true);
            easy2.setVisible(true);
            medium2.setVisible(true);
            hard2.setVisible(true);
        }else if(e.getSource() == submit){//do smth when the input is empty
            Player player1;
            Player player2;

            if(human1.isSelected()){
                player1 = new HumanPlayer(tname1.getText(), Symbol.X, view);
            }else{
                if(easy1.isSelected()){
                    player1 = new ComputerPlayer(Symbol.X);
                }else if(medium1.isSelected()){
                    player1 = new ComputerPlayer(new SmartStrategy(), Symbol.X);
                }else{
                    player1 = new ComputerPlayer(new VerySmartStrategy(), Symbol.X);
                }
            }
            if(human2.isSelected()){
                player2 = new HumanPlayer(tname2.getText(), Symbol.O, view);
            }else{
                if(easy2.isSelected()){
                    player2 = new ComputerPlayer(Symbol.O);
                }else if(medium2.isSelected()){
                    player2 = new ComputerPlayer(new SmartStrategy(), Symbol.O);
                }else{
                    player2 = new ComputerPlayer(new VerySmartStrategy(), Symbol.O);
                }
            }
            resetFrame();
            SwingUtilities.updateComponentTreeUI(frame);
            game = new JPanel();
            game.setBorder(BorderFactory.createEmptyBorder(50, 50, 100, 100));
            game.setLayout(new BoxLayout(game, BoxLayout.Y_AXIS));
            game.add(consoleView);
            frame.setContentPane(game);
            // FIXME: 05/10/2021 smth not working
            gameRun = new Game(player1, player2, view);
            //gameRun.start();

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
            name1.setBorder(new EmptyBorder (0, 30, 0, 0));
            tname1 = new JTextField(80);
            tname1.setPreferredSize(new Dimension(60,20));
            tname1.setMaximumSize( tname1.getPreferredSize() );

            difficulty1 = new JLabel("Select Difficulty");
            difficulty1.setBorder(new EmptyBorder (0, 30, 0, 0));
            easy1 = new JRadioButton("Easy");
            easy1.setSize(75, 20);
            medium1 = new JRadioButton("Medium");
            medium1.setSize(75, 20);
            hard1 = new JRadioButton("Hard");
            hard1.setSize(75, 20);
            difficulty1gp = new ButtonGroup();
            difficulty1gp.add(easy1);
            difficulty1gp.add(medium1);
            difficulty1gp.add(hard1);
            easy1.setBorder(new EmptyBorder (0, 50, 0, 0));
            hard1.setBorder(new EmptyBorder (0, 50, 0, 0));
            medium1.setBorder(new EmptyBorder (0, 50, 0, 0));
            difficulty1.setVisible(false);
            easy1.setVisible(false);
            medium1.setVisible(false);
            hard1.setVisible(false);


            name1.setVisible(false);
            tname1.setVisible(false);

            human1.addActionListener(this);
            computer1.addActionListener(this);


            menu.add(player1);
            menu.add(human1);
            menu.add(computer1);
            menu.add(name1);
            menu.add(tname1);
            menu.add(difficulty1);
            menu.add(easy1);
            menu.add(medium1);
            menu.add(hard1);
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

            name2 = new JLabel("Name");
            name2.setBorder(new EmptyBorder (0, 30, 0, 0));
            tname2 = new JTextField(80);
            tname2.setPreferredSize(new Dimension(60,20));
            tname2.setMaximumSize( tname2.getPreferredSize() );

            difficulty2 = new JLabel("Select Difficulty");
            difficulty2.setBorder(new EmptyBorder (0, 30, 0, 0));
            easy2 = new JRadioButton("Easy");
            easy2.setSize(75, 20);
            medium2 = new JRadioButton("Medium");
            medium2.setSize(75, 20);
            hard2 = new JRadioButton("Hard");
            hard2.setSize(75, 20);
            difficulty2gp = new ButtonGroup();
            difficulty2gp.add(easy2);
            difficulty2gp.add(medium2);
            difficulty2gp.add(hard2);
            easy2.setBorder(new EmptyBorder (0, 50, 0, 0));
            hard2.setBorder(new EmptyBorder (0, 50, 0, 0));
            medium2.setBorder(new EmptyBorder (0, 50, 0, 0));
            difficulty2.setVisible(false);
            easy2.setVisible(false);
            medium2.setVisible(false);
            hard2.setVisible(false);


            name2.setVisible(false);
            tname2.setVisible(false);

            human2.addActionListener(this);
            computer2.addActionListener(this);


            menu.add(player2);
            menu.add(human2);
            menu.add(computer2);
            menu.add(name2);
            menu.add(tname2);
            menu.add(difficulty2);
            menu.add(easy2);
            menu.add(medium2);
            menu.add(hard2);
            menu.add(new JLabel(""));

        }

    }

    public void resetFrame(){
        frame.getContentPane().removeAll();
        frame.repaint();
    }
}
