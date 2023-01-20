package Model.Pieces.Movable;

import Model.Pieces.MovablePiece;

public class UnleashedBeast extends MovablePiece{
    /**
     * <b>Constructor</b>
     * <b>Pre</b> Valid instances of String
     * <b>Post</b> Makes an instance of class UnleashedBeast
     * @param type
     * @return void
     */
    public UnleashedBeast(String type) {
        super(5, type.equals("R") ? "LavaBeast" : "Yeti", type, type.equals("R") ? "src/Model/images/redPieces/lavaBeast.png" : "src/Model/images/bluePieces/yeti.png");
    }
}
