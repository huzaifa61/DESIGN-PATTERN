package LLDChess;


public class ChessGame {
    private Board board;
    private Player[] players;
    private Player currentPlayer;
    private GameStatus gameStatus;

    private void startGame() {
        board = new Board();
        players = new Player[2];
        gameStatus = GameStatus.ONGOING;
    }
    private boolean makeMove(Move move) {
        if(move.isValid()) {
            move.execute();
            swithPlayer();
            return true;
        }
        return false;
    }

    private void swithPlayer() {
        currentPlayer = (currentPlayer == players[0]) ? players[1] : players[0];

    }
    private boolean isCheckmate(Player player) {
        return player.equals(currentPlayer);
    }

}
