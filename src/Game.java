public class Game {

    public static void main(final String[] args) {

        System.out.println("Welcome to Tic Tac Toe - basic version");

        final Board board = new Board(new String[3][3]);
        final GameOverChecker gameOverChecker = new GameOverChecker();
        final GameController gameController = new GameController(board, gameOverChecker);
        gameController.beginGame();

    }

}
