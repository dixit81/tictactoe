import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GameControllerTest {

    @Test
    void constructorThrows() {
        Assertions.assertThatThrownBy(() -> new GameController(null))
                .hasMessage("board must not be null")
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void setUpPlayersCorrectly() {
        final Board board = mock(Board.class);
        final GameController gameController = new GameController(board);
        gameController.beginGame();
    }
}