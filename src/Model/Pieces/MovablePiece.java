package Model.Pieces;
    
public abstract class MovablePiece extends Piece{
    // ======= CONSTRUCTORS ========
    /**
     * <b>Constructor</b>
     * <b>Pre</b> Valid instances of String
     * <b>Post</b> Makes an instance of class MovablePiece
     * @param name
     * @param type
     * @param imageUrlShow
     * @return void
     */
    public MovablePiece(int rank, String name, String type, String imageUrlShow) {
        super(rank, name, type, imageUrlShow);
        setMovable(true);
    }

    // ======= METHODS ========

    /**
     * <b>Transformer</b>
     * <b>Pre</b> Valid instance of Piece
     * <b>Post</b> Moves the piece accross the board
     * @param null
     * @return void Changes the piece's position in the board if possible
     */
    public void move() {
        // code here
    };


    /**
     * <b>Transformer</b>
     * <b>Pre</b> Valid instance of Piece
     * <b>Post</b> Sends Piece to captivity and takes its place on the board
     * @param Piece Opponent's piece that is into battle
     * @return null Captures opponent's piece if attack was succesfull
     */
    public void capture(Piece piece) {
        
    }
}
