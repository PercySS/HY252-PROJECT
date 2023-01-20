package Model.Pieces.Movable.SpecialMovable;

import Model.Pieces.Movable.SpecialMovablePiece;

public class Slayer extends SpecialMovablePiece {
    /**
     * <b>Constructor</b>
     * <b>Pre</b> Valid instances of String
     * <b>Post</b> Makes an instance of class Slayer
     * @param type
     * @return void
     */
    public Slayer(String type) {
        super(1, "Slayer", type, type.equals("R") ? "src/Model/images/redPieces/slayerR.png" : "src/Model/images/bluePieces/slayerB.png");
    }
    
    /**
     * <b>Transformer</b>
     * <b>Pre</b> Valid instances of Movable piece
     * <b>Post</b> Overrides move method with ideal movement / attack patterns
     * @param void
     * @return void
     */
    @Override
    public void move() {
        
    }
    
}
