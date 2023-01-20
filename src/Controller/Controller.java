package Controller;

import javax.swing.JOptionPane;

import Model.Board.Board;
import Model.Pieces.Empty;
import Model.Pieces.MovablePiece;
import Model.Pieces.Piece;
import Model.Pieces.Immovable.Flag;
import Model.Pieces.Immovable.Trap;
import Model.Pieces.Immovable.Trespassing;
import Model.Pieces.Movable.Dragon;
import Model.Pieces.Movable.SpecialMovable.Dwarf;
import Model.Pieces.Movable.SpecialMovable.Scout;
import Model.Pieces.Movable.SpecialMovable.Slayer;
import Model.Player.Player; 

public class Controller {
    private Player p1, p2;
    private Board board;
    private int turn, round;
    private String gm;

    // ======= SETTERS / GETTERS ========

    /**
     * <b>Transformer</b> mutative
     * <b>Pre</b> Valid Player
     * <b>Post</b> Sets the field p1 as the Player given
     * @param p1 Player 1
     * @return void
     */
    public void setP1(Player p1) {
        this.p1 = p1;
    }

    /**
     * <b>Accessor</b>
     * <b>Pre</b> Field p1 initiated
     * <b>Post</b> Gets the field p1
     * @param void
     * @return Player 1
     */
    public Player getP1() {
        return p1;
    }

    /**
     * <b>Transformer</b> mutative
     * <b>Pre</b> Valid Player
     * <b>Post</b> Sets the field p2 as the Player given
     * @param p2 Player 2
     * @return void
     */
    public void setP2(Player p2) {
        this.p2 = p2;
    }

    /**
     * <b>Accessor</b>
     * <b>Pre</b> Field p2 initiated
     * <b>Post</b> Gets the field p2
     * @param void
     * @return Player 2
     */
    public Player getP2() {
        return p2;
    }

    /**
     * <b>Accessor</b>
     * <b>Pre</b> Field p1, p2 initiated
     * <b>Post</b> Gets the field p1, p2
     * @param void
     * @return Player
     */
    public Player getPlayer(Player player) {
        if (player.equals(p1)) {
            return getP1();
        } else {
            return getP2();
        }
    }

    /**
     * <b>Transformer</b> mutative
     * <b>Pre</b> Valid Board
     * <b>Post</b> Sets the field b as the Board given
     * @param b Board
     * @return void
     */
    public void setB(Board b) {
        this.board = b;
    }

    /**
     * <b>Accessor</b>
     * <b>Pre</b> Field b initiated
     * <b>Post</b> Gets the field b
     * @param void
     * @return Board
     */
    public Board getB() {
        return board;
    }

    /**
     * <b>Transformer</b> mutative
     * <b>Pre</b> Valid int
     * <b>Post</b> Sets the field turn as the int given
     * @param turn Turn
     * @return void
     */
    public void setTurn(int turn) {
        this.turn = turn;
    }

    /**
     * <b>Accessor</b>
     * <b>Pre</b> Field turn initiated
     * <b>Post</b> Gets the field turn
     * @param void
     * @return Turn
     */
    public int getTurn() {
        return turn;
    }

    /**
     * <b>Transformer</b> mutative
     * <b>Pre</b> Valid int
     * <b>Post</b> Sets the field round as the int given
     * @param round Round
     * @return void
     */
    public void setRound(int round) {
        this.round = round;
    }

    /**
     * <b>Accessor</b>
     * <b>Pre</b> Field round initiated
     * <b>Post</b> Gets the field round
     * @param void
     * @return Round
     */
    public int getRound() {
        return round;
    }

    /**
     * <b>Transformer</b> mutative
     * <b>Pre</b> Valid String
     * <b>Post</b> Sets the field gm as the String given
     * @param gm Game mode
     * @return void
     */
    public void setGm(String gm) {
        this.gm = gm;
    }

    /**
     * <b>Accessor</b>
     * <b>Pre</b> Field gm initiated
     * <b>Post</b> Gets the field gm
     * @param void
     * @return Game mode
     */
    public String getGm() {
        return gm;
    }

    // ======= CONSTRUCTOR ========

    /**
     * <b>Constructor</b>
     * <b>Pre</b> Valid Player, Board, int, String
     * <b>Post</b> Creates a new Controller object
     * @param p1 Player 1
     * @param p2 Player 2
     * @param b Board
     * @param turn Turn
     * @param round Round
     * @param gm Game mode
     * @return void
     */
    public Controller(String mode) {
        setP1(new Player("Player 1", "B", mode));
        setP2(new Player("Player 2", "R", mode));
        setB(new Board(mode));
        setTurn(1);
        setRound(1);
        initBoard();
    }

    // ======= METHODS ========

    /**
     * <b>Transformer</b> mutative
     * <b>Pre</b> Valid instance of class Controller
     * <b>Post</b> Sets next turn
     * @param void
     * @return void
     */
    public void nextTurn() {
        if (getTurn() == 1) {
            setTurn(2);
        } else {
            setTurn(1);
            setRound(getRound() + 1);
        }
    }
    
    /**
     * <b>Transformer</b> mutative
     * <b>Pre</b> Valid instance of class Controller
     * <b>Post</b> Sets next round, adds one to the round counter
     * @param void
     * @return void
     */
    public void nextRound() {
        setRound(getRound() + 1);
    }

    /**
     * <b>Transformer</b> mutative
     * <b>Pre</b> Instance Controller must be initiated
     * <b>Post</b> Ends Game
     * @param void
     * @return void
     */
    public void endGame(String type) {
        if (type.equals("ZZ")) {
            JOptionPane.showMessageDialog(null, "MIN PRIZEIS");
        } else if (type.equals("U")) {
            JOptionPane.showMessageDialog(null, "Game ended due to the fact that you trash. No movable pieces left.");
            if (getTurn() == 1) {
                endGame("B");
            } else {
                endGame("R");
            }
        } else {
            JOptionPane.showMessageDialog(null, ("Game Over! Player " + (type.equals("R") ? "1" : "2") + " wins!"));
        }
        System.exit(0); 
    }


    /**
     * <b>Transformer</b> mutative
     * <b>Pre</b> Valid instance of class Controller
     * <b>Post</b> Initializes the board
     * @param void
     * @return void
     */
    public void initBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 10; j++) {
                this.board.getBoard()[i][j] = null;
            }
        }

        int ctr = p1.getPieces().getBag().size();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 10; j++) {
                if (ctr > 0) {
                    this.board.getBoard()[i][j] = p1.getPieces().getBag().get(ctr - 1);
                }
                ctr--;
            }
        }

        ctr = p2.getPieces().getBag().size();
        for (int i = 7; i >= 0; i--) {
            for (int j = 9; j >= 0; j--) {
                if (ctr > 0) {
                    this.board.getBoard()[i][j] = p2.getPieces().getBag().get(ctr - 1);
                }
                ctr--;
            }
        }

        this.board.getBoard()[3][2] = new Trespassing();
        this.board.getBoard()[3][3] = new Trespassing();
        this.board.getBoard()[4][2] = new Trespassing();
        this.board.getBoard()[4][3] = new Trespassing();
        this.board.getBoard()[3][6] = new Trespassing();
        this.board.getBoard()[3][7] = new Trespassing();
        this.board.getBoard()[4][6] = new Trespassing();
        this.board.getBoard()[4][7] = new Trespassing();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 10; j++) {
                if (this.board.getBoard()[i][j] == null) {
                    this.board.getBoard()[i][j] = new Empty();
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(this.board.getBoard()[i][j].getName() + " ");
            }
            System.out.println();
        }
    }


    /**
     * <b>Transformer</b> mutative
     * <b>Pre</b> Valid instance of class Controller
     * <b>Post</b> Swaps two pieces
     * @param x1 x coordinate of first piece
     * @param y1 y coordinate of first piece
     * @param x2 x coordinate of second piece
     * @param y2 y coordinate of second piece
     * @return boolean
     */
    public boolean swap(int x1, int y1, int x2, int y2) {
        boolean swapped = false;

        if ((x2 == x1 + 1 && y1 == y2 || x2 == x1 - 1 && y1 == y2 || x1 == x2 && y2 == y1 + 1 || x1 == x2 && y2 == y1 - 1 ) && !getB().getBoard()[x2][y2].getType().equals(getB().getBoard()[x1][y1].getType()) || (getB().getBoard()[x1][y1] instanceof Scout)) {
            if (getB().getBoard()[x1][y1] instanceof Slayer && getB().getBoard()[x2][y2] instanceof Dragon) {
                if (getTurn() == 1) {
                    p1.setAttacks(p1.getAttacks() + 1);
                    p1.setSuccesfullAttacks(p1.getSuccesfullAttacks() + 1);
                } else {
                    p2.setAttacks(p2.getAttacks() + 1);  
                }
                getB().getBoard()[x2][y2] = getB().getBoard()[x1][y1];
                getB().getBoard()[x1][y1] = new Empty();
                swapped = true;
                
            }

            if ((getB().getBoard()[x1][y1] instanceof Scout)) {
                boolean emptyroot = true;
                if (getB().getBoard()[x1][y1].getType().equals(getB().getBoard()[x1][y1].getType())) {
                    emptyroot = false;
                } else if (getB().getBoard()[x1][y1].getType().equals("R")) {    
                        if (y1 == y2) {
                            if (x1 >= x2) {
                                for (int i = x1 - 1; i >= x2; i--) {
                                    if (!(getB().getBoard()[i][y2] instanceof Empty)) {
                                        emptyroot = false;
                                        break;
                                    }
                                }
                            } else if (x1 < x2) {
                                for (int i = x1 - 1; i <= x2; i++) {

                                    if (!(getB().getBoard()[i][y2] instanceof Empty)) {
                                        System.out.println("I got in 1");
                                        emptyroot = false;
                                        break;
                                    }
                                }
                            }
                        } else if (x1 == x2) {
                            if (y1 >= y2) {
                                for (int i = y1 - 1; i >= y2; i--) {
                                    if (!(getB().getBoard()[i][y2] instanceof Empty)) {
                                        emptyroot = false;
                                        break;
                                    }
                                }
                            } else if (y1 < y2) {
                                for (int i = y1 - 1; i <= y2; i++) {
                                    if (!(getB().getBoard()[i][y2] instanceof Empty)) {
                                        emptyroot = false;
                                        break;
                                    }
                                }
                            } else {
                                emptyroot = false;
                            }
                            swapped = emptyroot;
                        } else {
                            emptyroot = false;
                        }
                } else {
                    if (y1 == y2) {
                        if (x1 >= x2) {
                            for (int i = x1; i >= x2; i--) {
                                if (!(getB().getBoard()[i][y2] instanceof Empty)) {
                                    emptyroot = false;
                                }
                            }
                        } else if (x1 < x2) {
                            for (int i = x1; i <= x2; i++) {
                                if (!(getB().getBoard()[i][y2] instanceof Empty)) {
                                    emptyroot = false;
                                }
                            }
                        }
                    } else if (x1 == x2) {
                        if (y1 >= y2) {
                            for (int i = y1; i >= y2; i--) {
                                if (!(getB().getBoard()[i][y2] instanceof Empty)) {
                                    emptyroot = false;
                                }
                            }
                        } else if (y1 < y2) {
                            for (int i = y1; i <= y2; i++) {
                                if (!(getB().getBoard()[i][y2] instanceof Empty)) {
                                    emptyroot = false;
                                }
                            }
                        }
                    } else {
                        swapped = false;
                    }
                }
    
                if (emptyroot && getB().getBoard()[x1][y1].getRank() > getB().getBoard()[x2][y2].getRank()) {
                    getB().getBoard()[x2][y2] = getB().getBoard()[x1][y1];
                    getB().getBoard()[x1][y1] = new Empty();
                    swapped = true;
                } else if (emptyroot && getB().getBoard()[x1][y1].getRank() == getB().getBoard()[x2][y2].getRank()) {
                    getB().getBoard()[x1][y1] = new Empty();
                    getB().getBoard()[x2][y2] = new Empty();
                    swapped = true;
                } else if (emptyroot && getB().getBoard()[x1][y1].getRank() < getB().getBoard()[x2][y2].getRank()) {
                    getB().getBoard()[x1][y1] = new Empty();
                    swapped = true;
                } else if ( emptyroot && getB().getBoard()[x2][y2] instanceof Trap) {
                    getB().getBoard()[x1][y1] = new Empty();
                    swapped = true;
                }

                if (emptyroot && getB().getBoard()[x2][y2].getType().equals(getB().getBoard()[x1][y1].getType())) {
                    emptyroot = false;
                }
            }
            
            if (!(getB().getBoard()[x1][y1] instanceof Dwarf) && getB().getBoard()[x2][y2] instanceof Trap) {
                if (getTurn() == 1) {
                    p1.setAttacks(p1.getAttacks() + 1);
                } else {
                    p2.setAttacks(p2.getAttacks() + 1);  
                }
                getB().getBoard()[x1][y1] = new Empty();
                swapped = true;
                
            }else if (getB().getBoard()[x2][y2] instanceof Trap && getB().getBoard()[x1][y1] instanceof Dwarf) {
                getB().getBoard()[x2][y2] = getB().getBoard()[x1][y1];
                getB().getBoard()[x1][y1] = new Empty();
                swapped = true;
                
            }
            
            if (getB().getBoard()[x1][y1] instanceof MovablePiece && getB().getBoard()[x2][y2] instanceof Empty) {
                Piece temp = this.board.getBoard()[x1][y1];
                this.board.getBoard()[x1][y1] = this.board.getBoard()[x2][y2];
                this.board.getBoard()[x2][y2] = temp;
                swapped = true;
                
            }
            
            if (getB().getBoard()[x1][y1].getRank() > getB().getBoard()[x2][y2].getRank()) {
                getB().getBoard()[x2][y2] = getB().getBoard()[x1][y1];
                getB().getBoard()[x1][y1] = new Empty();
                swapped = true;
            } else if (getB().getBoard()[x1][y1].getRank() < getB().getBoard()[x2][y2].getRank()) {
                getB().getBoard()[x1][y1] = new Empty();
                swapped = true;
            } else if (getB().getBoard()[x1][y1].getRank() == getB().getBoard()[x2][y2].getRank()) {
                getB().getBoard()[x1][y1] = new Empty();
                getB().getBoard()[x2][y2] = new Empty();
                swapped = true;
            }
            return swapped;
        }

        if (swapped) {
            if (getTurn() == 1) {
                p1.setAttacks(p1.getAttacks() + 1);
            } else {
                p2.setAttacks(p2.getAttacks() + 1);  
            }
        }
        return swapped;
    }


    /**
     * <b>Accessor</b>
     * <b>Pre</b> Game initiated
     * <b>Post</b> Ends Game
     * @param void
     * @return  void
     */
    public void checkENd() {
        boolean fr = false, fb = false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 10; j++) {
                if (getB().getBoard()[i][j] instanceof Flag) {
                    if (getB().getBoard()[i][j].getType() == "R") {
                        fr = true;
                    } else if (getB().getBoard()[i][j].getType() == "B") {
                        fb = true;                  
                    }
                }
            }
        }
        if (!fr) {
            endGame("B");
        } else if (!fb) {
            endGame("R");
        }
    }

    /**
     * <b>Accessor</b>
     * <b>Pre</b> Game initiated
     * <b>Post</b> Checks if game should be ended due to game inconvenience
     * @param void
     * @return  void
     */
    public void checkUnplayable() {
        boolean fb = true, fr = true;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 10; j++) {
                if (getB().getBoard()[i][j] instanceof MovablePiece) {
                    if (getB().getBoard()[i][j].getType() == "R") {
                        fr = false;
                    } else if (getB().getBoard()[i][j].getType() == "B") {
                        fb = false;                  
                    }
                }
            }
        }
        if (fr && fb) {
            System.out.println("Game ended due to the fact that you are both trashes. No movable pieces left. Its a draw.");
            endGame("U");
        }
        if (fr) {
            System.out.println("Game ended due to the fact that you are trash. No movable pieces left in your bag.");
            endGame("B");
        } else if (fb) {
            System.out.println("Game ended due to the fact that you are trash. No movable pieces left in your bag.");
            endGame("R");
        }
    }
}
