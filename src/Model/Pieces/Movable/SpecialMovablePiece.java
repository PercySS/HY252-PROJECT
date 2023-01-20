package Model.Pieces.Movable;

import Model.Pieces.MovablePiece;

public abstract class SpecialMovablePiece extends MovablePiece{
    private boolean isSpecial;

    // ======= SETTERS / GETTERS ========
    /**
     * <b>Transformer</b>
     * <b>Pre</b> Valid boolean
     * <b>Post</b> Sets field isSpecial as the boolean given
     * @param isSpecial
     * @return void
     */
    public void setIsSpecial(boolean isSpecial) {
        this.isSpecial =  isSpecial;
    }

    /**
     * <b>Accessor</b>
     * <b>Pre</b> Valid instance of class SpecialMovablePiece
     * <b>Post</b> Gets the value of isSpecial field
     * @param void
     * @return boolean
     */
    public boolean GetIsSpecial() {
        return isSpecial;
    }

    // ======= CONSTRUCTORS ========
    /**
     * <b>Constructor</b>
     * <b>Pre</b> Valid instances of String, integers
     * <b>Post</b> Makes an instance of class specialMovablePiece
     * @param name
     * @param type
     * @param imageUrlShow
     * @return void
     */
    public SpecialMovablePiece(int rank, String name, String type, String imageUrlShow) {
        super(rank, name, type, imageUrlShow);
        setIsSpecial(true);
    }


    // ======= METHODS ========
    
}
