package LLDChess;

class King extends Piece {
    public King(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Cell from, Cell to) {
        int dx = Math.abs(from.row - to.col);
        int dy = Math.abs(from.row - to.col);
        return (dx <= 1 && dy <= 1);
    }
}
