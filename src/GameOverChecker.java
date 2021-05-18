public class GameOverChecker {

    public boolean checkAllPossibilities(final String[][] squares) {

        if (horizontalGameOverChecker(squares)) return true;
        if (verticalGameOverChecker(squares)) return true;
        if (bottomLeftTopRightDiagonalChecker(squares)) return true;
        if (bottomRightTopLeftDiagonalChecker(squares)) return true;

        return false;
    }

    private boolean bottomRightTopLeftDiagonalChecker(final String[][] squares) {
        int countX = 0;
        int countO = 0;

        for (int i = 0, j = squares.length - 1; i < squares.length; i++, j--) {
            if (squares[i][j].equals("X")) {
                countX++;
            } else if (squares[i][j].equals("O")) {
                countO++;
            }

            if (countO == squares.length || countX == squares.length) {
                return true;
            }
        }

        return false;
    }

    private boolean bottomLeftTopRightDiagonalChecker(final String[][] squares) {
        int countX = 0;
        int countO = 0;

        for (int i = 0, j = 0; i < squares.length; i++, j++) {
            if (squares[i][j].equals("X")) {
                countX++;
            } else if (squares[i][j].equals("O")) {
                countO++;
            }
        }

        return countO == squares.length || countX == squares.length;

    }

    private boolean verticalGameOverChecker(final String[][] squares) {
        int countX = 0;
        int countO = 0;

        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares.length; j++) {
                if (squares[j][i].equals("X")) {
                    countX++;
                } else if (squares[j][i].equals("O")) {
                    countO++;
                }
            }

            if (countO == squares.length || countX == squares.length) {
                return true;
            }

            countX = 0;
            countO = 0;
        }

        return false;
    }

    private boolean horizontalGameOverChecker(final String[][] squares) {
        int countX = 0;
        int countO = 0;

        for (final String[] rowContent : squares) {
            for (final String content : rowContent) {
                if (content.equals("X")) {
                    countX++;
                } else if (content.equals("O")) {
                    countO++;
                }
            }

            if (countO == squares.length || countX == squares.length) {
                return true;
            }

            countX = 0;
            countO = 0;
        }

        return false;
    }


}
