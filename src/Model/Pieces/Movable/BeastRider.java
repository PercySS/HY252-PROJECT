package Model.Pieces.Movable;

import Model.Pieces.MovablePiece;

public class BeastRider extends MovablePiece{
    /**
     * <b>Constructor</b>
     * <b>Pre</b> Valid instances of String
     * <b>Post</b> Makes an instance of class BeastRider
     * @param type
     * @return void
     */
    public BeastRider(String type) {
        super(7, "Beast Rider", type, type.equals("R") ? "src/Model/images/redPieces/beastRiderR.png" : "src/Model/images/bluePieces/beastRiderB.png");
    } 
}
