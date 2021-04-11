import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

public class Board {

    private final String[][] squares;

    public Board(final String[][] squares) {
        this.squares = Objects.requireNonNull(squares, "squares must not be null");
    }

    public String[][] initialiseBoard() {
        IntStream.range(0, squares.length).forEach(i -> Arrays.fill(squares[i], "_"));
        return squares;
    }

    public void printBoardState(final String[][] squares) {
        for (final String[] square : squares) {
            for (final String s : square) {
                System.out.printf("| %s ", s);
                System.out.print("|");
            }
            System.out.println(" ");
        }

    }
}
