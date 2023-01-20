package Model.Pieces.Movable.SpecialMovable;

import Model.Pieces.Movable.SpecialMovablePiece;

public class Dwarf extends SpecialMovablePiece{
    /**
     * <b>Constructor</b>
     * <b>Pre</b> Valid instances of String
     * <b>Post</b> Makes an instance of class Dwarf
     * @param type
     * @return void
     */
    public Dwarf(String type) {
        super(3, "Dwarf", type, type.equals("R") ? "src/Model/images/redPieces/dwarfR.png" : "src/Model/images/bluePieces/dwarfB.png");
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
