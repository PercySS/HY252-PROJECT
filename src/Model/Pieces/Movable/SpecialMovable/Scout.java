package Model.Pieces.Movable.SpecialMovable;

import Model.Pieces.Movable.SpecialMovablePiece;

public class Scout extends SpecialMovablePiece { 
    /**
     * <b>Constructor</b>
     * <b>Pre</b> Valid instances of String
     * <b>Post</b> Makes an instance of class Scout
     * @param type
     * @return void
     */
    public Scout(String type) {
        super(2, "Scout", type, type.equals("R") ? "src/Model/images/redPieces/scoutB.png" : "src/Model/images/bluePieces/scoutB.png");
    }
    
    /**
     * <b>Transformer</b>
     * <b>Pre</b> Valid instances of SpecialMovablePiece
     * <b>Post</b> Overrides move method with ideal movement / attack patterns
     * @param void
     * @return void
     */
    @Override
    public void move() {
        
    }
    
}
