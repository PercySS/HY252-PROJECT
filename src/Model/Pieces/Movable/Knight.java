package Model.Pieces.Movable;

import Model.Pieces.MovablePiece;

public class Knight extends MovablePiece{
    /**
     * <b>Constructor</b>
     * <b>Pre</b> Valid instances of String
     * <b>Post</b> Makes an instance of class Knight
     * @param type
     * @return void 
     */
    public Knight(String type) {
        super(8, "Knight", type, type.equals("R") ? "src/Model/images/redPieces/knightR.png" : "src/Model/images/bluePieces/knightB.png");
    }
}
