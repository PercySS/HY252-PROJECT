package Model.Pieces.Immovable;

import Model.Pieces.ImmovablePiece;

public class Flag extends ImmovablePiece{
    /**
     * <b>Constructor</b>
     * <b>Pre</b> Valid instances of String
     * <b>Post</b> Makes an instance of class Flag
     * @param type
     * @return void
     */
    public Flag(String type) {
        super("Flag", type, type.equals("R") ? "src/Model/images/redPieces/flagR.png" : "src/Model/images/bluePieces/flagB.png");
    }
}
