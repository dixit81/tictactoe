import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Scanner;

public class GameController {

    private final Board board;

    public GameController(final Board board) {
        this.board = board;
    }

    public boolean beginGame() {

        int boxChoice = 0;
        // Initialise board
        String[][] squares = board.initialiseBoard();

        // Get Player inputs for X,O and assign them
        final List<Player> allPlayers = createPlayersBasedOnChoice();

        while (true) {
            System.out.println("Player 1 - please choose your square. Enter your answer as a number from 1-9");
            boxChoice = sanitiseChoice();
            allPlayers.get(0).placeMarkerOnSquareChoice(squares, boxChoice);
            board.printBoardState(squares);

            if (gameOverChecker(squares)) {
                System.out.println("Player 1 wins!");
                return true;
            }

            System.out.println("Player 2 - please choose your square. Enter your answer as a number from 1-9");
            boxChoice = sanitiseChoice();
            allPlayers.get(1).placeMarkerOnSquareChoice(squares, boxChoice);
            board.printBoardState(squares);

            if (gameOverChecker(squares)) {
                System.out.println("Player 2 wins!");
                return true;
            }
        }

    }

    private boolean gameOverChecker(final String[][] squares) {

        if (horizontalGameOverChecker(squares)) return true;
        if (verticalGameOverChecker(squares)) return true;
        if (leftRightDiagonalChecker(squares)) return true;
        if (rightLeftDiagonalChecker(squares)) return true;

        return false;
    }

    private boolean rightLeftDiagonalChecker(final String[][] squares) {
        int countX = 0;
        int countO = 0;

        for (int i = 0, j = squares.length - 1; i < squares.length; i++, j--) {
            if (squares[i][j].equals("X")) {
                countX++;
            } else if (squares[i][j].equals("O")) {
                countO++;
            }

            if (countO == squares.length || countX == squares.length) {
                return true;
            }
        }

        return false;
    }

    private boolean leftRightDiagonalChecker(final String[][] squares) {
        int countX = 0;
        int countO = 0;

        for (int i = 0, j = 0; i < squares.length; i++, j++) {
            if (squares[i][j].equals("X")) {
                countX++;
            } else if (squares[i][j].equals("O")) {
                countO++;
            }
        }

        if (countO == squares.length || countX == squares.length) {
            return true;
        }

        return false;

    }

    private boolean verticalGameOverChecker(final String[][] squares) {
        int countX = 0;
        int countO = 0;
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares.length; j++) {
                if (squares[j][i].equals("X")) {
                    countX++;
                } else if (squares[j][i].equals("O")) {
                    countO++;
                }
            }

            if (countO == squares.length || countX == squares.length) {
                return true;
            }

            countX = 0;
            countO = 0;
        }

        return false;
    }

    private boolean horizontalGameOverChecker(final String[][] squares) {
        int countX = 0;
        int countO = 0;

        for (final String[] rowContent : squares) {
            for (final String content : rowContent) {
                if (content.equals("X")) {
                    countX++;
                } else if (content.equals("O")) {
                    countO++;
                }
            }

            if (countO == squares.length || countX == squares.length) {
                return true;
            }

            countX = 0;
            countO = 0;
        }

        return false;
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
