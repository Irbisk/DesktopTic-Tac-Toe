package tictactoe;

import com.sun.tools.javac.Main;

import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import static tictactoe.TicTacToe.labelStatus;

public class Game {
    enum GameMode {HH, HR, RH, RR}


    private int value;
    private int move;
    static boolean gameIsOver = true;
    final private int[][] cells = new int[3][3];
    private boolean newGame;
    private final int CELL_X = 10;
    private final int CELL_O = 200;
    private final int CELL_EMPTY = 0;

    Logger logger = Logger.getLogger(Main.class.getName());


    public Game() {
        for (int[] cell : cells) {
            Arrays.fill(cell, 0);
        }
        newGame = true;
        gameIsOver = false;
    }

    public void gameMove(GameMode gameMode) {
        switch (gameMode) {
            case RR:
                String result = checkProgress();
                if (!gameIsOver) {
                        if (move % 2 == 1) {
                        labelStatus.setText("The turn of Robot Player (X)");
                        Timer timer = new Timer();
                        timer.schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    computerGoes();
                                }
                            }, 1000);
                    } else if (move % 2 == 0) {
                        labelStatus.setText("The turn of Robot Player (O)");
                        Timer timer = new Timer();
                        timer.schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    computerGoes();
                                }
                            }, 1000);
                    }
                } else {
                    if (!"Draw".equals(result)) {
                        result = String.format("The Robot Player (%s) wins", result);
                    }
                    Board.buttonsList.forEach(x -> x.setEnabled(false));

                    labelStatus.setText(result);
                }

                break;
            case HR:
                result = checkProgress();

                if (!gameIsOver) {
                    if (move % 2 == 1) {
                        labelStatus.setText("The turn of Robot Player (O)");

                    } else if (move % 2 == 0) {
                        labelStatus.setText("The turn of Human Player (X)");
                    }
                } else {
                    if (move % 2 == 1) {
                        if (!"Draw".equals(result)) {
                            result = String.format("The Human Player (%s) wins", result);
                        }
                        labelStatus.setText(result);
                        Board.buttonsList.forEach(x -> x.setEnabled(false));
                    } else {
                        if (!"Draw".equals(result)) {
                            result = String.format("The Robot Player (%s) wins", result);
                        }
                        labelStatus.setText(result);
                        Board.buttonsList.forEach(x -> x.setEnabled(false));
                    }

                }
                break;
            case RH:
                result = checkProgress();

                if (!gameIsOver) {
                    if (move % 2 == 0) {
                        labelStatus.setText("The turn of Robot Player (X)");
                        Timer timer = new Timer();
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                computerGoes();
                            }
                        }, 1000);
                    } else if (move % 2 == 1) {
                        labelStatus.setText("The turn of Human Player (O)");
                    }
                } else {
                    if (move % 2 == 0) {
                        if (!"Draw".equals(result)) {
                            result = String.format("The Human Player (%s) wins", result);
                        }
                        labelStatus.setText(result);
                        Board.buttonsList.forEach(x -> x.setEnabled(false));
                    } else {
                        if (!"Draw".equals(result)) {
                            result = String.format("The Robot Player (%s) wins", result);
                        }
                        labelStatus.setText(result);
                        Board.buttonsList.forEach(x -> x.setEnabled(false));
                    }
                }

                break;
            default:
                result = checkProgress();
                if (!gameIsOver) {
                    if (move % 2 == 0) {
                        labelStatus.setText("The turn of Human Player (X)");
                    } else if (move % 2 == 1) {
                        labelStatus.setText("The turn of Human Player (O)");
                    }
                } else {
                    if (!"Draw".equals(result)) {
                        result = String.format("The Human Player (%s) wins", result);
                    }
                    labelStatus.setText(result);
                    Board.buttonsList.forEach(x -> x.setEnabled(false));

                }
        }
    }

    private void computerGoes() {
        Cell cell = chooseRandomCell();
        GameButton button = GameButton.defineButton(cell);
        button.setSymbol();
    }


    public Cell chooseRandomCell() {
        Cell cell = null;
        boolean isEmpty = false;
        while (!isEmpty) {
            int x = new Random().nextInt(3);
            int y = new Random().nextInt(3);
            cell = new Cell(x, y);
            isEmpty = cellIsEmpty(cell);
        }
        return cell;
    }


    public int setSymbol(Cell cell) {
        int result = cells[cell.getX()][cell.getY()];
        if (cellIsEmpty(cell) && !gameIsOver) {
            if (newGame) {
                result = CELL_X;
                value = CELL_O;
                newGame = false;
            } else if (value == CELL_O) {
                result = CELL_O;
                value = CELL_X;
            } else if (value == CELL_X) {
                result = CELL_X;
                value = CELL_O;
            }
            cells[cell.getX()][cell.getY()] = result;
            move++;
        }

        if (gameIsOver) {
            result = CELL_EMPTY;
        }

        return result;
    }

    public String checkProgress() {
        String result = null;

        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                count += cells[i][j];
            }
            if (checkCount(count) != null) {
                result = checkCount(count);
                gameIsOver = true;
                break;
            }
            count = 0;
        }
        if (!gameIsOver) {
            for (int j = 0; j < 3; j++) {
                for (int i = 0; i < 3; i++) {
                    count += cells[i][j];
                }
                if (checkCount(count) != null) {
                    result = checkCount(count);
                    count = 0;
                    gameIsOver = true;
                    break;
                }
                count = 0;
            }
        }

        if (!gameIsOver) {
            for (int i = 0, j = 0; i < 3; i++, j++) {
                count += cells[i][j];
            }
            if (checkCount(count) != null) {
                result = checkCount(count);
                gameIsOver = true;
            }
        }
        if (!gameIsOver) {
            count = 0;
            for (int i = 0, j = 2; i < 3; i++, j--) {
                count += cells[i][j];
            }
            if (checkCount(count) != null) {
                result = checkCount(count);
                gameIsOver = true;
            }
        }
        if (!gameIsOver && move == 9) {
            result = "Draw";
            gameIsOver = true;
        }
        logger.log(Level.INFO, result);
        return result;
    }

    private String checkCount(int count) {
        String result = null;
        if (count == 30) {
            result = "X";
        } else if (count == 600) {
            result = "O";
        }
        return result;
    }

    public boolean cellIsEmpty(Cell cell) {
        int value = cells[cell.getX()][cell.getY()];
        if (value == 0) {
            return true;
        } else return false;
    }
}
