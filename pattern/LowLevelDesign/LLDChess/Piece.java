package LLDChess;

abstract class Piece {
    protected Color color;
    protected Cell position;

    public Piece(Color color) {
        this.color = color;
    }

    public Color getColor() { return color; }
    public void setPosition(Cell position) { this.position = position; }
    public abstract boolean isValidMove(Cell from, Cell to);
}
