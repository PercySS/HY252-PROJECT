package Model.Board;

import Model.Pieces.*;

enum gameMode {
    NORMAL, 
    REDUCED_ARMY, 
    TAC0_0_11,
    BOTH
}

public class Board {
    private Piece[][] board;
    private gameMode gm;


    /**
     * <b>Trasnformer</b> mutative
     * <b>Pre</b> Valid String
     * <b>Post</b> Sets enum gm field of class
     * @param gm String 
     * @return void
     */
    public void setGM(String gm) {
        switch (gm) {
            case "NORMAL":
                this.gm = gameMode.NORMAL;
                System.out.println("NORMAL");
                break;
            case "REDUCED_ARMY":
                this.gm = gameMode.REDUCED_ARMY;
                System.out.println("REDUCED ARMY");
                break;
            case "TAC0_0_11":
                this.gm = gameMode.TAC0_0_11;
                System.out.println("TACTIC 0-0-11! FULL OFFENSE");
                break;
            default:
                this.gm = gameMode.NORMAL;
                break;
        }
    }

    /**
     * <b>Trasnformer</b> mutative
     * <b>Pre</b> Valid enum gameMode
     * <b>Post</b> Sets the field gm as given
     * @param gm enum gameMode
     * @return void
     */
    public void setGM(gameMode gm) {
        this.gm = gm;
    }
    
    /**
     * <b>Accessor</b>
     * <b>Pre</b> Valid instance of Board
     * <b>Post</b> Gets the gameMode of the board
     * @param void
     * @return enum gameMode
     */
    public gameMode getGM() {
        return this.gm;
    }

    /**
     * <b>Accessor</b>
     * <b>Pre</b> Valid instance of Board
     * <b>Post</b> Returns the board of the game
     * @param null
     * @return Piece[][] array of pieces that declare the board of the pieces and their positions
     */
    public Piece[][] getBoard() {
        return this.board;
    }

    /**
     * <b>Accessor</b>
     * <b>Pre</b> Valid integers
     * <b>Post</b> Gets piece in the position given from the indexes
     * @param x coordinate x
     * @param y coordinate y
     * @return Instance of Piece
     */
    public Piece getPiece(int x, int y) {
        return getBoard()[x][y];
    }

    /**
     * <b>Trasnformer</b> mutative
     * <b>Pre</b> Valid integers and valid instance of Piece
     * <b>Post</b> Sets the piece given in the given coordinates on the board
     * @param x
     * @param y 
     * @param p
     * @return
     */
    public void setPiece(int x, int y, Piece p) {
        getBoard()[x][y] = p;
    }

    /**
     * <b>Constructor</b>  
     * <b>Pre</b> Valid String 
     * <b>Post</b> Creates valid instance of Board
     * @param gm String
     * @return void
     */
    public Board(String gm) {
        setGM(gm);
        board = new Piece[8][10];
    }

    /**
     * <b>Trasnformer</b> mutative
     * <b>Pre</b> Valid integers that are used as coordinates in the board
     * <b>Post</b> Deletes a piece from the board
     * @param x coordinate x
     * @param y coordinate y
     * @return void
     */
    public void deletePiece(int x, int y) {
        getBoard()[x][y] = null;
    } 
    
}
