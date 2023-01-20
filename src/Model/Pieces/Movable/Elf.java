package Model.Pieces.Movable;

import Model.Pieces.MovablePiece;

public class Elf extends MovablePiece{
    /**
     * <b>Constructor</b>
     * <b>Pre</b> Valid instances of String
     * <b>Post</b> Makes an instance of class Elf
     * @param type
     * @return void
     */
    public Elf(String type) {
        super(4, "Elf", type, type.equals("R") ? "src/Model/images/redPieces/elfR.png" : "src/Model/images/bluePieces/elfB.png");
    }
}
