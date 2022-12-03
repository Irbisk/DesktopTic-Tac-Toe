package tictactoe;

import javax.swing.*;
import java.awt.*;


public class TicTacToe extends JFrame {
    static Board board = new Board();
    static Game game;
    static Game.GameMode gameMode = Game.GameMode.HH;
    JPanel buttonsField = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel statusField = new JPanel(new FlowLayout(FlowLayout.LEFT));
    static JButton player1 = new JButton("Player1");
    static JButton player2 = new JButton("Player2");
    static JButton resetButton = new JButton("Start");
    static JLabel labelStatus = new JLabel();
    JMenu jMenu = new JMenu("Game");
    JMenuBar jMenuBar = new JMenuBar();
    private JMenuItem jMenuItemHH = new JMenuItem("Human vs Human");
    private JMenuItem jMenuItemHR = new JMenuItem("Human vs Robot");
    private JMenuItem jMenuItemRH = new JMenuItem("Robot vs Human");
    private JMenuItem jMenuItemRR = new JMenuItem("Robot vs Robot");
    private JMenuItem jMenuItemExit = new JMenuItem("Exit");




    public TicTacToe() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tic Tac Toe");
        setSize(450, 450);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setResizable(false);
        setVisible(true);

        jMenu.setName("MenuGame");
        jMenuItemHH.setName("MenuHumanHuman");
        jMenuItemHR.setName("MenuHumanRobot");
        jMenuItemRH.setName("MenuRobotHuman");
        jMenuItemRR.setName("MenuRobotRobot");
        jMenuItemExit.setName("MenuExit");

        player1.setName("ButtonPlayer1");
        player1.setText("Human");
        player2.setName("ButtonPlayer2");
        player2.setText("Human");
        resetButton.setName("ButtonStartReset");
        labelStatus.setName("LabelStatus");


        buttonsField.setMaximumSize(new Dimension(450, 50));
        buttonsField.add(player1);
        buttonsField.add(resetButton);
        buttonsField.add(player2);

        statusField.setMaximumSize(new Dimension(450, 50));
        statusField.add(labelStatus);

        jMenuBar.add(jMenu);

        jMenu.add(jMenuItemHH);
        jMenu.add(jMenuItemHR);
        jMenu.add(jMenuItemRH);
        jMenu.add(jMenuItemRR);
        jMenu.addSeparator();
        jMenu.add(jMenuItemExit);

        setJMenuBar(jMenuBar);
        add(buttonsField);
        add(board);
        add(statusField);
        labelStatus.setText("Game is not started");

        resetButton.addActionListener(x -> reset());
        jMenuItemHH.addActionListener(x -> {
            player1.setText("Human");
            player2.setText("Human");
            start(player1, player2);
        });
        jMenuItemHR.addActionListener(x -> {
            player1.setText("Human");
            player2.setText("Robot");
            start(player1, player2);
        });
        jMenuItemRH.addActionListener(x -> {
            player1.setText("Robot");
            player2.setText("Human");
            start(player1, player2);
        });
        jMenuItemRR.addActionListener(x -> {
            player1.setText("Robot");
            player2.setText("Robot");
            start(player1, player2);
        });
        jMenuItemExit.addActionListener(x -> System.exit(1));





        player1.addActionListener(x -> {
            if (player1.getText().equals("Human")) {
                player1.setText("Robot");
            } else {
                player1.setText("Human");
            }
        });
        player2.addActionListener(x -> {
            if (player2.getText().equals("Human")) {
                player2.setText("Robot");
            } else {
                player2.setText("Human");
            }
        });
    }

    public static void start(JButton player1, JButton player2) {
        if (player1.getText().equals("Human") && player2.getText().equals("Human")) {
            gameMode = Game.GameMode.HH;
            labelStatus.setText("The turn of Human player (X)");
        } else if (player1.getText().equals("Human") && player2.getText().equals("Robot")) {
            gameMode = Game.GameMode.HR;
            labelStatus.setText("The turn of Human player (X)");
        } else if (player1.getText().equals("Robot") && player2.getText().equals("Human")) {
            gameMode = Game.GameMode.RH;
            labelStatus.setText("The turn of Robot player (X)");
        } else if (player1.getText().equals("Robot") && player2.getText().equals("Robot")) {
            gameMode = Game.GameMode.RR;
            labelStatus.setText("The turn of Robot player (X)");
        }

        game = new Game();
        game.gameMove(gameMode);
        Board.buttonsList.forEach(x -> x.setEnabled(true));

        resetButton.setText("Reset");
        player1.setEnabled(false);
        player2.setEnabled(false);
    }



    public static void reset() {
        if (labelStatus.getText().equals("Game is not started")) {
            start(player1, player2);

        } else {
            Board.clearButtons();
            labelStatus.setText("Game is not started");
            player1.setEnabled(true);
            player2.setEnabled(true);
            resetButton.setText("Start");
        }
    }
}


