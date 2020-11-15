import com.google.common.collect.ImmutableMap;
import javafx.util.Pair;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GameController {

    // TODO maybe not use this map (figuratively)
    private static final Map<Integer, Pair<Integer, Integer>> OFFSETS = ImmutableMap.<Integer, Pair<Integer, Integer>>builder()
            .put(1, new Pair<>(0, 0))
            .put(2, new Pair<>(0, 1))
            .put(3, new Pair<>(0, 2))
            .put(4, new Pair<>(1, 0))
            .put(5, new Pair<>(1, 1))
            .put(6, new Pair<>(1, 2))
            .put(7, new Pair<>(2, 0))
            .put(8, new Pair<>(2, 1))
            .put(9, new Pair<>(2, 2))
            .build();

    public Player createPlayerWithNoChoice(final String inputFromPlayer1) {
        if (inputFromPlayer1.equalsIgnoreCase("X")) {
            return new Player("O");
        }

        return new Player("X");
    }

    public Player createPlayerWithChoice(final String inputFromConsole) {
        return new Player(inputFromConsole);
    }

    public boolean beginGame(final List<Player> players, final String[][] squares) {

        while (true) {
            final String[][] boardStatePlayer1 = boardStateAfterPlayer1(players, squares);

            if (checkGameOver(boardStatePlayer1)) {
                System.out.println("Player 1 wins!");
                return false;
            }

            final String[][] boardStatePlayer2 = boardStateAfterPlayer2(players, squares);

            if (checkGameOver(boardStatePlayer2)) {
                System.out.println("Player 2 wins!");
                return false;
            }
        }

    }

    // TODO what is this duplication man? Needs an interface
    private String[][] boardStateAfterPlayer1(final List<Player> players, final String[][] squares) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Player 1 enter your square number");
        final int player1Move = scanner.nextInt();
        return placeMarkerOnSquareChoice(squares, player1Move, players.get(0));
    }

    private String[][] boardStateAfterPlayer2(final List<Player> players, final String[][] squares) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Player 2 enter your square number");
        final int player2Move = scanner.nextInt();
        return placeMarkerOnSquareChoice(squares, player2Move, players.get(1));
    }


    private String[][] placeMarkerOnSquareChoice(final String[][] squares, final int square, final Player player) {
        // 1 is top left, 5 is middle and 9 is bottom right
        final Pair<Integer, Integer> rowColValues = OFFSETS.get(square);

        squares[rowColValues.getKey()][rowColValues.getValue()] = player.getPlayerChoice();

        printBoard(squares);

        return squares;

    }

    private void printBoard(final String[][] squares) {
        for (final String[] square : squares) {
            for (final String s : square) {
                System.out.printf("| %s ", s);
                System.out.print("|");
            }
            System.out.println(" ");
        }
    }

    // TODO massively violates DRY by using brute force, also a bit
    private boolean checkGameOver(final String[][] boardState) {

        int count = 0;
        int row, col;
        // condition 1 - all rows are same
        for (row = 0; row < boardState.length; row++) {
            for (col = 0; col < boardState[0].length; col++) {
                count += (boardState[row][col].equals("X") ? 1 :
                        boardState[row][col].equals("O") ? -1 : 0);

                if (count == 3 || count == -3) {
                    return true;
                }
            }
        }

        // condition 2 - all column are same
        // reset count to 0
        count = 0;
        for (row = 0; row < boardState.length; row++) {
            for (col = 0; col < boardState[0].length; col++) {
                count += (boardState[col][row].equals("X") ? 1 :
                        boardState[col][row].equals("O") ? -1 : 0);

                if (count == 3 || count == -3) {
                    return true;
                }
            }
        }

        // condition 3 - left to right diagonal
        // reset count to 0
        count = 0;
        for(int i=0; i<boardState.length; i++) {
            count += (boardState[i][i].equals("X") ? 1 :
                    boardState[i][i].equals("O") ? -1 : 0);
            if (count == 3 || count == -3) {
                return true;
            }
        }

        // condition 4 - right to left diagonal
        // reset count to 0
        count = 0;
        for(int i=0; i<boardState.length; i++) {
            for(int j = boardState[i].length - 1; j >= 0; j--)
            count += (boardState[i][j].equals("X") ? 1 :
                    boardState[i][j].equals("O") ? -1 : 0);
            if (count == 3 || count == -3) {
                return true;
            }
        }

        return false;
    }
}
