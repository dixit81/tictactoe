import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    public static void main(final String[] args) {

        System.out.println("Welcome to Tic Tac Toe - basic version");
        final GameController gameController = new GameController();
        final Board board = new Board(new String[3][3]);
        final String[][] squares = board.initialiseBoard();


        System.out.println("Player 1 - would you like to be X or O");
        final Scanner scanner = new Scanner(System.in);
        final String inputForPlayer1 = scanner.nextLine();
        final Player player1 = gameController.createPlayerWithChoice(inputForPlayer1);
        final Player player2 = gameController.createPlayerWithNoChoice(inputForPlayer1);
        System.out.println("Player 1 is now " + player1.getPlayerChoice());

        String otherChoice = player2.getPlayerChoice();

        System.out.println("Player 2 has been assigned as " + otherChoice);
        System.out.println("----------------------------------------------");
        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        boolean onSwitch = gameController.beginGame(players, squares);

    }

}
