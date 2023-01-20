package Model.Pieces.Movable;

import Model.Pieces.MovablePiece;

public class Dragon extends MovablePiece{
    /**
     * <b>Constructor</b>
     * <b>Pre</b> Valid instances of String
     * <b>Post</b> Makes an instance of class Dragon
     * @param type
     * @return void
     */
    public Dragon(String type) {
        super(10, "Dragon", type, type.equals("R") ? "src/Model/images/redPieces/dragonR.png" : "src/Model/images/bluePieces/dragonB.png");
    }  
}
