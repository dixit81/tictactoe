import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameOverCheckerTest {

    private String[][] squares = new String[3][3];

    @Test
    void checkThreeXHorizontallyIsGameOver() {

        for (int j = 0; j < squares.length; j++) {
            squares[0][j] = "X";
        }

        fillEmptySquares();

        final GameOverChecker gameOverChecker = new GameOverChecker();
        final boolean isGameOver = gameOverChecker.checkAllPossibilities(squares);
        assertThat(isGameOver).isTrue();
    }

    @Test
    void checkThreeOVerticallyIsGameOver() {
        for (int i = 0; i < squares.length; i++) {
            squares[i][0] = "O";
        }

        fillEmptySquares();

        final GameOverChecker gameOverChecker = new GameOverChecker();
        final boolean isGameOver = gameOverChecker.checkAllPossibilities(squares);
        assertThat(isGameOver).isTrue();
    }

    @Test
    void checkThreeXBottomRightTopLeftDiagonalIsGameOver() {
        for (int i = 0, j = 2; i < 3; i++, j--) {
            squares[i][j] = "X";
        }

        fillEmptySquares();

        final GameOverChecker gameOverChecker = new GameOverChecker();
        final boolean isGameOver = gameOverChecker.checkAllPossibilities(squares);
        assertThat(isGameOver).isTrue();
    }

    @Test
    void checkThreeOBottomLeftTopRightDiagonalIsGameOver() {
        for (int i = 2, j = 0; j < 3; i--, j++) {
            squares[i][j] = "O";
        }

        fillEmptySquares();

        final GameOverChecker gameOverChecker = new GameOverChecker();
        final boolean isGameOver = gameOverChecker.checkAllPossibilities(squares);
        assertThat(isGameOver).isTrue();
    }

    @Test
    void checkTwoXHorizontallyAndOneOIsNotGameOver() {
        squares[0][0] = "X";
        squares[0][1] = "X";
        squares[0][2] = "O";
        // control
        squares[1][1] = "O";

        fillEmptySquares();

        final GameOverChecker gameOverChecker = new GameOverChecker();
        final boolean isGameOver = gameOverChecker.checkAllPossibilities(squares);
        assertThat(isGameOver).isFalse();
    }

    @Test
    void checkTwoXVerticallyAndOneOIsNotGameOver() {
        squares[0][0] = "X";
        squares[1][0] = "X";
        squares[2][0] = "O";
        // control
        squares[1][1] = "O";

        fillEmptySquares();

        final GameOverChecker gameOverChecker = new GameOverChecker();
        final boolean isGameOver = gameOverChecker.checkAllPossibilities(squares);
        assertThat(isGameOver).isFalse();
    }

    @Test
    void checkTwoXBottomRightTopLeftDiagonalAndOneOIsNotGameOver() {
        squares[2][2] = "X";
        squares[1][1] = "X";
        squares[0][0] = "O";
        // control
        squares[1][0] = "O";

        fillEmptySquares();

        final GameOverChecker gameOverChecker = new GameOverChecker();
        final boolean isGameOver = gameOverChecker.checkAllPossibilities(squares);
        assertThat(isGameOver).isFalse();
    }

    @Test
    void checkTwoOBottomLeftTopRightDiagonalAndOneXIsNotGameOver() {
        squares[0][2] = "O";
        squares[1][1] = "O";
        squares[2][0] = "X";
        // control
        squares[1][0] = "O";

        fillEmptySquares();

        final GameOverChecker gameOverChecker = new GameOverChecker();
        final boolean isGameOver = gameOverChecker.checkAllPossibilities(squares);
        assertThat(isGameOver).isFalse();
    }

    private void fillEmptySquares() {
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                if (squares[i][j] == null) {
                    squares[i][j] = "_";
                }
            }
        }
    }
}