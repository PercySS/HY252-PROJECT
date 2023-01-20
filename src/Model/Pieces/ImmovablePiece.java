package Model.Pieces;

public abstract class ImmovablePiece extends Piece {
    
     // ======= CONSTRUCTORS ========
    /**
     * <b>Constructor</b>
     * <b>Pre</b> Valid instances of String
     * <b>Post</b> Makes an instance of class ImmovablePiece
     * @param name
     * @param type
     * @param imageUrlShow
     * @return void
     */
    public ImmovablePiece(String name, String type, String imageUrlShow) {
        super(-1, name, type, imageUrlShow);
        setMovable(false);
    }    
}
