package LLDChess;

class Move {
    private Cell from;
    private Cell to;
    private Piece piece;

    public Move(Cell from, Cell to, Piece piece) {
        this.from = from;
        this.to = to;
        this.piece = piece;
    }

    public boolean isValid() {
        return piece != null && piece.isValidMove(from, to);
    }

    public void execute() {
        to.setPiece(piece);
        from.setPiece(null);
        piece.setPosition(to);
    }
}

