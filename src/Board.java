import java.util.Arrays;
import java.util.stream.IntStream;

public class Board {

    private final String[][] squares;

    public Board(final String[][] squares) {
        this.squares = squares;
    }

    public String[][] initialiseBoard() {
        IntStream.range(0, squares.length).forEach(i -> Arrays.fill(squares[i], "_"));

        for (final String[] square : squares) {
            for (final String s : square) {
                System.out.printf("| %s ", s);
                System.out.print("|");
            }
            System.out.println(" ");
        }

        return squares;
    }



}
