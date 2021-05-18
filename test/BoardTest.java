import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BoardTest {

    private String[][] squares;
    private Board board;

    @BeforeEach
    void setUp() {
        squares = new String[1][1];
        board = new Board(squares);
    }

    @Test
    void testConstructorThrows() {
        assertThatThrownBy(() -> new Board(null))
                .hasMessage("squares must not be null")
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void initialiseBoardOfSize1() {
        final String[][] expectedSquare = {{"_"}};
        assertThat(board.initialiseBoard()).isDeepEqualTo(expectedSquare);
    }

    @Test
    void printBoardOfSize1() throws UnsupportedEncodingException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        board.initialiseBoard();
        board.printBoardState(squares);

        final String actualOutput = outContent.toString("UTF8");
        final String expectedOutput = "| _ | " + System.lineSeparator();
        assertThat(actualOutput).isEqualTo(expectedOutput);

    }
}