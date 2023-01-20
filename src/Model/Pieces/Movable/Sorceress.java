package Model.Pieces.Movable;

import Model.Pieces.MovablePiece;

public class Sorceress extends MovablePiece{
    /**
     * <b>Constructor</b>
     * <b>Pre</b> Valid instances of String
     * <b>Post</b> Makes an instance of class Sorceress
     * @param type
     * @return void
     */
    public Sorceress(String type) {
        super(6, "Sorceress", type, type.equals("R") ? "src/Model/images/redPieces/sorceressR.png" : "src/Model/images/bluePieces/sorceressB.png");
    }
}
