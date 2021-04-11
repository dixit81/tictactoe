import com.google.common.collect.ImmutableMap;
import javafx.util.Pair;

import java.util.Map;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class Player {

    private final String playerChoice;

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

    public Player(final String playerChoice) {
        this.playerChoice = requireNonNull(playerChoice, "playerChoice must not be null");
    }

    public String[][] placeMarkerOnSquareChoice(final String[][] squares, final int square) {
        final Pair<Integer, Integer> rowColValues = OFFSETS.get(square);

        squares[rowColValues.getKey()][rowColValues.getValue()] = this.getPlayerChoice();

        return squares;
    }

    public String getPlayerChoice() {
        return playerChoice;
    }

}
