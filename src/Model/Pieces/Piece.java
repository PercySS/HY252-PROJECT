package Model.Pieces;
import javax.swing.ImageIcon;

public abstract class Piece {
    private int rank;
    private String name;
    private String type;
    private ImageIcon imageUrlShow;
    private ImageIcon imageUrlHide;
    private boolean isCaptured;
    private boolean movable;

    // ======= SETTERS / GETTERS ========

    /**
     * <b>Transformer</b> mutative
     * <b>Pre</b> Valid int
     * <b>Post</b> Sets the field as the given integer
     * @param rank The rank of the Piece
     * @return void 
     */
    public void setRank(int rank) {
        this.rank = rank;
    }

    /**
     * <b>Accessor</b>
     * <b>Pre</b> Field rank initiated
     * <b>Post</b> Gets the field rank
     * @param void 
     * @return Rank of the piece
     */
    public int getRank() {
        return rank;
    }

    /**
     * <b>Transformer</b> mutative
     * <b>Pre</b> Valid String
     * <b>Post</b> Sets the field name as the String given
     * @param name Name of the piece.
     * @return void
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <b>Accessor</b>
     * <b>Pre</b> Field name initiated
     * <b>Post</b> Gets the field name
     * @param void
     * @return Name of the piece
     */
    public String getName() {
        return name;
    }

    /**
     * <b>Transformer</b> mutative
     * <b>Pre</b> Valid String
     * <b>Post</b> Sets field type as the type given
     * @param type The type of the piece
     * @return void
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * <b>Accessor</b>
     * <b>Pre</b> Field type initiated
     * <b>Post</b> Gets the field type
     * @param void
     * @return The type of the piece
     */
    public String getType() {
        return type;
    }

    /**
     * <b>Transformer</b> mutative
     * <b>Pre</b> Valid String
     * <b>Post</b> Makes new ImageIcon as the image of the piece and sets the field ImageUrlShow as the ImageIcon made
     * @param imageUrl The imageUrl of the piece face-up
     * @return void
     */
    public void setImageUrlShow(String imageUrl) {
        this.imageUrlShow = new ImageIcon(imageUrl);
    }

    /**
     * <b>Accessor</b>
     * <b>Pre</b> Field imageUrlShow initiated
     * <b>Post</b> Gets the field imageUrlShow
     * @param void
     * @return The imageUrl of the piece face-up 
     */
    public ImageIcon getImageUrlShow() {
        return imageUrlShow;
    }

    /**
     * <b>Transformer</b> mutative
     * <b>Pre</b> Valid String
     * <b>Post</b> Makes new ImageIcon as the image of the piece and sets the field ImageUrlShow as the ImageIcon made
     * @param imageUrl The imageUrl of the piece face-down
     * @return void
     */
    public void setImageUrlHide(String imageUrl) {
        this.imageUrlHide = new ImageIcon(imageUrl);
    }

    /**
     * <b>Accessor</b>
     * <b>Pre</b> Field imageUrlHide initiated
     * <b>Post</b> Gets the field imageUrlHide
     * @param void
     * @return The imageUrl of the piece face-down
     */
    public ImageIcon getImageUrlHide() {
        return imageUrlHide;
    }

    /**
     * <b>Transformer</b> mutative
     * <b>Pre</b> Valid boolean
     * <b>Post</b> Sets field isCaptured as the boolean given
     * @param isCaptured The status of the piece
     * @return void
     */
    public void setIsCaptured(boolean isCaptured) {
        this.isCaptured = isCaptured;
    }

    /**
     * <b>Accessor</b>
     * <b>Pre</b> Field isCaptured initiated
     * <b>Post</b> Gets the field isCaptured
     * @param void
     * @return The status of the piece
     */
    public boolean getIsCaptured() {
        return isCaptured;
    }

    /**
     * <b>Transformer</b> mutative
     * <b>Pre</b> Valid boolean
     * <b>Post</b> Sets field movable as the boolean given
     * @param movable The status of the piece
     * @return void
     */
    public void setMovable(boolean movable) {
        this.movable = movable;
    }

    /**
     * <b>Accessor</b>
     * <b>Pre</b> Field movable initiated
     * <b>Post</b> Gets the field movable
     * @param void
     * @return The status of the piece
     */
    public boolean getMovable() {
        return movable;
    }
         
    // ======= CONSTRUCTORS ========

    /** 
     * <b>Constructor</b>
     * <b>Pre</b> Valid int, String, String, String, String, boolean
     * <b>Post</b> Makes new instance of class Piece
     * @param rank rank of the piece
     * @param name name of the piece
     * @param type red or blue based on the player
     * @param imageUrlShow card face up 
     * @param imageUrlHide card face down
     * @param isCaptured true if cpatured
     *                   false if not captured
     * @return valid instance of class piece 
     */
    public Piece(int rank, String name, String type, String imageUrlShow) {
        setRank(rank);
        setName(name);
        setType(type);
        setImageUrlShow(imageUrlShow);
        setImageUrlHide(type == "R" ? "src/Model/images/redPieces/redHidden.png" : "src/Model/images/bluePieces/blueHidden.png");
        setIsCaptured(false);
    }


    // ======= METHODS ========
    
    // /**
    //  * @param Piece The opponent's piece
    //  * @return 0 win
    //  *         1 lose
    //  */
    // public abstract int battle(Piece piece);




}
