package LLDTicTacToe;

import lombok.Data;

@Data
public class Player {
    String name;
    PlayingPiece playingPiece;
    Player(String name,PlayingPiece playingPiece) {
        this.name = name;
        this.playingPiece = playingPiece;
    }
}
