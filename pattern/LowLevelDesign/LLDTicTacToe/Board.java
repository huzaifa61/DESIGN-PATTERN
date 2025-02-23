package LLDTicTacToe;




import java.util.ArrayList;
import java.util.List;



public class Board {

    int size;
    PlayingPiece[][] board;
    public Board(int size) {
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public boolean addPiece(int x, int y, PlayingPiece piece) {
        if( board[x][y] != null ){
            return false;
        }
        board[x][y]= piece;
        return true;
    }

    List<Pair<Integer,Integer>> getFreeCalls(){
        List<Pair<Integer,Integer>> cells = new ArrayList<>();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(board[i][j] == null){
                    Pair<Integer,Integer> temp = new Pair<>(i,j);

                    cells.add( temp);
                }
            }
        }
        return cells;
    }

    public void printBoard() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].pieceType.name() + "   ");
                } else {
                    System.out.print("    ");

                }
                System.out.print(" | ");
            }
            System.out.println();

        }
    }



}
