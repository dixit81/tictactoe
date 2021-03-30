public class Game {

    public static void main(final String[] args) {

        System.out.println("Welcome to Tic Tac Toe - basic version");

        final Board board = new Board(new String[3][3]);
        final GameController gameController = new GameController(board);
        gameController.beginGame();
        // Line below should be in GameController
//        final String[][] squares = board.initialiseBoard();
//        board.printBoardState(squares);



        /*final Player player1 = new Player(inputForPlayer1);
        final Player player2 =
        System.out.println("Player 1 is now " + player1.getPlayerChoice());

        String otherChoice = player2.getPlayerChoice();

        System.out.println("Player 2 has been assigned as " + otherChoice);
        System.out.println("----------------------------------------------");
        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);*/
//        boolean onSwitch = gameController2.beginGame(players, squares);

    }

}
