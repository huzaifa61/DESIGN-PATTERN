package LLDChess;

import java.awt.*;

public class Cell {
    public int row;
    public int col;
    private Piece piece;

    private Color color;

    private Cell(Color color, Piece piece, int row, int col) {
        this.color = color;
        this.piece = piece;
        this.row = row;
    }

    public Piece getPiece() {
        return piece;
    }
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean isEmpty() {
        return piece == null;
    }
}
