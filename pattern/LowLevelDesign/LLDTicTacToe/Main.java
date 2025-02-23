package LLDTicTacToe;

public class Main {
    public static void main(String[] args) {
        TicTactoe game = new TicTactoe();
        game.initialize();
        System.out.println("game winner is: " + game.startGame());


    }
}
