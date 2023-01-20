package Model.Captivity;

import Model.Pieces.Piece;
import Model.Player.Player;

public class Captivity {
    private Piece[] captured;
    private Integer[] sumCaptured;
    private String type;


    /**
     * <b>Constructor</b>
     * <b>Pre</b>
     * <b>Post</b> Creates valid instance of class Captivity
     * @param void
     * @return void
     */
    public Captivity(Player player) {
        captured = new Piece[11];
        sumCaptured = new Integer[11];
        setType(player.getType());
        initCaptivity();
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
    
    /**
     * <b>Accessor</b>
     * <b>Pre</b> Valid instance of class Captivity
     * <b>Post</b> Gets the arraylist of captured pieces
     * @param void
     * @return ArrayList<Piece> as the captured pieces
     */
    public void initCaptivity() {
        for(int i = 0; i < 11; i++) {
            captured[i] = null;
            sumCaptured[i] = 0;
        }
    }

    /**
     * <b>Accessor</b>
     * <b>Pre</b> Valid instance of class Captivity
     * <b>Post</b> Gets the status of the arralist 
     * @param void
     * @return true arraylist is empty
     *         false arraylist has at list a piece
     */
    public boolean isEmpty() {
        return captured.length == 0 ? true : false;
    }

    /**
     * <b>Transformer</b> mutative
     * <b>Pre</b> Valid instance of class Captivity
     * <b>Post</b> Adds a piece to the arraylist
     * @param p Piece the dead Piece
     * @return void
     */
    public void addCaptured(Piece piece) {
        for(int i = 0; i < 11; i++) {
            if(captured[i] == null) {
                captured[i] = piece;
                sumCaptured[i] = 1;
                break;
            } else if(captured[i].equals(piece)) {
                sumCaptured[i]++;
                break;
            }
        }
    }


    /**
     * <b>Transformer</b> mutative
     * <b>Pre</b> Valid instance of class Captivity
     * <b>Post</b> Removes piece of arrraylist captured 
     * @param p Piece the dead Piece
     * @return Piece as the revived piece
     */
    public Piece removeCaptured(Piece piece) {
        for(int i = 0; i < 11; i++) {
            if(captured[i].equals(piece)) {
                if(sumCaptured[i] > 1) {
                    sumCaptured[i]--;
                    return captured[i];
                } else {
                    captured[i] = null;
                    sumCaptured[i] = 0;
                    return captured[i];
                }
            }
        }
        return null;
    }
}
