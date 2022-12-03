package tictactoe;

import com.sun.tools.javac.Main;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ApplicationRunner {
    public static void main(String[] args) {
        new TicTacToe();
        Logger logger = Logger.getLogger(Main.class.getName());
        logger.log(Level.INFO, "ATTN CREW!");
    }
}
