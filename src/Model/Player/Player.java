package Model.Player;

import Model.Captivity.Captivity;
import Model.PieceBag.PieceBag;
import Model.Pieces.Piece;

public class Player {
    private String name;
    private String type;
    private int attacks, succesfullAttacks;
    private Captivity captivity;
    private int totalCaptured;
    private PieceBag pieces;


    // ======= SETTERS / GETTERS ========

    /**
     * <b>Transformer</b> mutative
     * <b>Pre</b> Valid String
     * <b>Post</b> Sets the field name as the String given
     * @param name Name of the player
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
     * @return Name of the player
     */
    public String getName() {
        return name;
    }
    
    /**
     * <b>Transformer</b> mutative
     * <b>Pre</b> Valid String
     * <b>Post</b> Sets field type as the type given
     * @param type The type of the player
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
     * @return Type of the player
     */
    public String getType() {
        return type;
    }
    
    /**
     * <b>Transformer</b> mutative
     * <b>Pre</b> Valid int
     * <b>Post</b> Sets the field attacks as the given integer
     * @param attacks The number of attacks of the player
     * @return void 
     */
    public void setAttacks(int attacks) {
        this.attacks = attacks;
    }

    /**
     * <b>Accessor</b>
     * <b>Pre</b> Field attacks initiated
     * <b>Post</b> Gets the field attacks
     * @param void 
     * @return Number of attacks of the player
     */
    public int getAttacks() {
        return attacks;
    }
    
    /**
     * <b>Transformer</b> mutative
     * <b>Pre</b> Valid int
     * <b>Post</b> Sets the field succesfullAttacks as the given integer
     * @param succesfullAttacks The number of succesfull attacks of the player
     * @return void 
     */
    public void setSuccesfullAttacks(int succesfullAttacks) {
        this.succesfullAttacks = succesfullAttacks;
    }
    
    /**
     * <b>Accessor</b>
     * <b>Pre</b> Field succesfullAttacks initiated
     * <b>Post</b> Gets the field succesfullAttacks
     * @param void 
     * @return Number of succesfull attacks of the player
     */
    public int getSuccesfullAttacks() {
        return succesfullAttacks;
    }

    // ======= CONSTRUCTORS ========

    /**
     * <b>Constructor</b>
     * <b>Pre</b> Valid instances of String
     * <b>Post</b> Makes an instance of class Player
     * @param name
     * @param type
     * @return void
     */
    public Player(String name, String type, String mode) {
        setName(name);
        setType(type);
        setAttacks(0);
        setSuccesfullAttacks(0);
        captivity = new Captivity(this);
        pieces = new PieceBag(this, mode);
        setTotalCaptured(0);
        
    }


    // ======= METHODS ========

    /**
     * <b>Transformer</b> mutative
     * <b>Pre</b> Valid instance of Piece
     * <b>Post</b> Adds the given piece to the captivity
     * @param piece
     * @return void
     */
    public void addCaptured(Piece piece) {
        captivity.addCaptured(piece);
        totalCaptured++;
    }

    /**
     * <b>Transformer</b> mutative
     * <b>Pre</b> Valid instance of Piece
     * <b>Post</b> Removes the given piece from the captivity
     * @param piece
     * @return Piece from captivity
     */
    public void setTotalCaptured(int cap) {
        totalCaptured = cap;
    }
    
    /**
     * <b>Accessor</b>
     * <b>Pre</b> Field captivity initiated
     * <b>Post</b> Gets the field captivity
     * @param void
     * @return Captivity of the player
     */
    public int getTotalCaptured() {
        return totalCaptured;
    }

    /**
     * <b>Transformer</b> mutative
     * <b>Pre</b> Instance of Player Initiated
     * <b>Post</b> Adds one to the number of attacks
     * @param piece
     * @return Piece from captivity
     */
    public void addAttack() {
        attacks++;
    }
    
    /**
     * <b>Transformer</b> mutative
     * <b>Pre</b> Instance of Player Initiated
     * <b>Post</b> Adds one to the number of succesfull attacks
     * @param piece
     * @return void
     */
    public void addSuccesfullAttack() {
        succesfullAttacks++;
    } 

    /**
     * <b>Accessor</b>
     * <b>Pre</b> Field pieces initiated
     * <b>Post</b> Gets the field pieces
     * @param void
     * @return Pieces of the player
     */
    public PieceBag getPieces() {
        return pieces;
    }
}
