import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameControllerTest {

    @Mock
    private GameOverChecker gameOverChecker;

    @Mock
    private Board board;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void constructorThrows() {
        assertThatThrownBy(() -> new GameController(null, gameOverChecker))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("board must not be null");

        assertThatThrownBy(() -> new GameController(board, null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("gameOverChecker must not be null");
    }

}
