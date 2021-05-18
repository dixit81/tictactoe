import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void constructorThrows() {
        assertThatThrownBy(() -> new Player(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("playerChoice must not be null");
    }

    @Test
    void initialisedPlayerReturnsChoice() {
        final Player player = new Player("O");
        assertThat(player.getPlayerChoice()).isEqualTo("O");
    }

    @Test
    void givenSquaresAndANumberPlayerMarksTheirChoice() {

        final String[][] squares = {{"_"}};

        final Player player = new Player("X");
        final String[][] newSquares = player.placeMarkerOnSquareChoice(squares, 1);

        final String[][] actualSquares = {{"X"}};

        assertThat(newSquares).isDeepEqualTo(actualSquares);
    }
}