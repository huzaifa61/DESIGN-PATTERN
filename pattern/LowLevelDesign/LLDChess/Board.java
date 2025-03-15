package LLDChess;

public class Board {
    private Cell[][] cells = new Cell[8][8];

    public void initialize() {

    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }



}
