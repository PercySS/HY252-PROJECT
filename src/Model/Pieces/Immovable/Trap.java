package Model.Pieces.Immovable;

import Model.Pieces.ImmovablePiece;

public class Trap extends ImmovablePiece{
    /**
     * <b>Constructor</b>
     * <b>Pre</b> Valid instances of String
     * <b>Post</b> Makes an instance of class BeastRider
     * @param type
     * @return void
     */
    public Trap(String type) {
        super("Trap", type, type.equals("R") ? "src/Model/images/redPieces/trapR.png" : "src/Model/images/bluePieces/trapB.png");
    }
}
