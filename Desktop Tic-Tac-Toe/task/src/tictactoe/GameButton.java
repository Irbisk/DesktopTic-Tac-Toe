package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameButton extends JButton implements ActionListener {

    public GameButton(String cell) {
        super(cell);
        setName("Button" + cell);
        setText(" ");
        setFont(new Font("Arial", Font.BOLD, 40));
        setFocusPainted(false);
        addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (!Game.gameIsOver) {
            String cell = this.getName();
            System.out.println(cell);
            setSymbol();
        }
    }


    public void setSymbol(){
        String buttonName = this.getName();
        Cell cell = defineCell(buttonName);
        int value = TicTacToe.game.setSymbol(cell);
        switch (value) {
            case 10:
                this.setText("X");
            break;
            case 200:
                this.setText("O");
                break;
            default:
        }
        TicTacToe.game.gameMove(TicTacToe.gameMode);

    }



    public Cell defineCell(String buttonName) {
        Cell cell = new Cell();
        switch (buttonName) {
            case "ButtonA1":
                cell = new Cell(2, 0);
                break;
            case "ButtonA2":
                cell = new Cell(1, 0);
                break;
            case "ButtonA3":
                cell = new Cell(0, 0);
                break;
            case "ButtonB1":
                cell = new Cell(2, 1);
                break;
            case "ButtonB2":
                cell = new Cell(1, 1);
                break;
            case "ButtonB3":
                cell = new Cell(0, 1);
                break;
            case "ButtonC1":
                cell = new Cell(2, 2);
                break;
            case "ButtonC2":
                cell = new Cell(1, 2);
                break;
            case "ButtonC3":
                cell = new Cell(0, 2);
                break;
            default:
        }
        return cell;
    }

    public static GameButton defineButton(Cell cell) {
        if (cell.getX() == 2 && cell.getY() == 0) {
            return Board.buttonsList.get(6);
        } else if (cell.getX() == 1 && cell.getY() == 0) {
            return Board.buttonsList.get(3);
        } else if (cell.getX() == 0 && cell.getY() == 0) {
            return Board.buttonsList.get(0);
        } else if (cell.getX() == 2 && cell.getY() == 1) {
            return Board.buttonsList.get(7);
        } else if (cell.getX() == 1 && cell.getY() == 1) {
            return Board.buttonsList.get(4);
        } else if (cell.getX() == 0 && cell.getY() == 1) {
            return Board.buttonsList.get(1);
        } else if (cell.getX() == 2 && cell.getY() == 2) {
            return Board.buttonsList.get(8);
        } else if (cell.getX() == 1 && cell.getY() == 2) {
            return Board.buttonsList.get(5);
        } else if (cell.getX() == 0 && cell.getY() == 2) {
            return Board.buttonsList.get(2);
        } else {
            return null;
        }
    }
}
