import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class GameController {

    private final Board board;
    private final GameOverChecker gameOverChecker;

    public GameController(final Board board,
                          final GameOverChecker gameOverChecker) {
        this.board = Objects.requireNonNull(board, "board must not be null");
        this.gameOverChecker = Objects.requireNonNull(gameOverChecker, "gameOverChecker must not be null");
    }

    public boolean beginGame() {
        // Initialise board
        String[][] squares = board.initialiseBoard();

        // Get Player inputs for X,O and assign them
        final List<Player> allPlayers = createPlayersBasedOnChoice();

        while (true) {
            for(int i=0; i<allPlayers.size(); i++) {
                System.out.println("Player " + (i + 1) + " - please choose your square. Enter your answer as a number from 1-9");
                allPlayers.get(i).placeMarkerOnSquareChoice(squares, sanitiseChoice());
                board.printBoardState(squares);

                if (gameOverChecker.checkAllPossibilities(squares)) {
                    System.out.println("Game Over!");
                    return true;
                }
            }
        }
    }

    private int sanitiseChoice() {
        final Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNext("[1-9]")) {
            System.out.println("Invalid square number entered, please check again!");
            scanner.next();
        }
        String boxNumber = scanner.next();
        System.out.println("Got it!");
        return Integer.parseInt(boxNumber);
    }

    private List<Player> createPlayersBasedOnChoice() {
        System.out.println("Player 1 - Please enter X or O");
        final String firstChoice = sanitiseInput();
        final Player player1 = new Player(firstChoice);

        final String otherChoice = determineOtherPlayerChoice(firstChoice);
        final Player player2 = new Player(otherChoice);
        System.out.println("Player 2 has been assigned " + otherChoice);

        return ImmutableList.of(player1, player2);

    }

    private String determineOtherPlayerChoice(final String firstChoice) {
        if (firstChoice.equalsIgnoreCase("X") || firstChoice.equalsIgnoreCase("x")) {
            return "O";
        } else {
            return "X";
        }
    }

    private String sanitiseInput() {
        final Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNext("[XOxo]")) {
            System.out.println("Incorrect input detected! Please try again!");
            scanner.next();
        }
        String input = scanner.next();
        System.out.println("Got it!");
        return input;
    }
}
