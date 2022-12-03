package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Board extends JPanel{
    public static ArrayList<GameButton> buttonsList = new ArrayList<>();

    public Board () {
        setLayout(new GridLayout(3, 3));
        String[] cells = {"A3", "B3", "C3", "A2", "B2", "C2", "A1", "B1", "C1"};
        for (int i = 0; i < cells.length; i++) {
            buttonsList.add(new GameButton(cells[i]));
            add(buttonsList.get(i));
        }
        buttonsList.forEach(x -> x.setEnabled(false));

    }

    public static void enableButtons() {
        buttonsList.forEach(x -> x.setEnabled(true));
    }

    public static void clearButtons() {
        for (int i = 0; i < buttonsList.size(); i++) {
            buttonsList.get(i).setText(" ");
            buttonsList.forEach(x -> x.setEnabled(false));
        }
    }

}
