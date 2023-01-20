package Model.Pieces.Movable;

import Model.Pieces.MovablePiece;

public class Mage extends MovablePiece{   
    /**
     * <b>Constructor</b>
     * <b>Pre</b> Valid instances of String
     * <b>Post</b> Makes an instance of class Mage
     * @param type
     * @return void
     */
    public Mage(String type) {
        super(9, "Mage", type, type.equals("R") ? "src/Model/images/redPieces/mageR.png" : "src/Model/images/bluePieces/mageB.png");
    }    
}
