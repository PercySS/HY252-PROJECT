package Model.PieceBag;


import Model.Pieces.Piece;
import Model.Pieces.Immovable.Flag;
import Model.Pieces.Immovable.Trap;
import Model.Pieces.Movable.BeastRider;
import Model.Pieces.Movable.Dragon;
import Model.Pieces.Movable.Elf;
import Model.Pieces.Movable.Knight;
import Model.Pieces.Movable.Mage;
import Model.Pieces.Movable.Sorceress;
import Model.Pieces.Movable.UnleashedBeast;
import Model.Pieces.Movable.SpecialMovable.*;
import Model.Player.Player;

import java.util.ArrayList;
import java.util.Collections;

public class PieceBag {
    private ArrayList<Piece> bag;
    private int[] pieceCounter;

    public PieceBag(Player player, String mode) {
        bag = new ArrayList<Piece>();
        pieceCounter = new int[12];
        initBag(player, mode);
    }

    public ArrayList<Piece> getBag() {
        return bag;
    }

    public int[] getPieceCounter() {
        return pieceCounter;
    }

    public void addPiece(Piece p) {
        bag.add(p);
        if (p instanceof Flag) {
            pieceCounter[0]++;
        } else if (p instanceof Trap) {
            pieceCounter[1]++;
        } else if (p instanceof Slayer) {
            pieceCounter[2]++;
        } else if (p instanceof Scout) {
            pieceCounter[3]++;
        } else if (p instanceof Dwarf) {
            pieceCounter[4]++;
        } else if (p instanceof Elf) {
            pieceCounter[5]++;
        } else if (p instanceof UnleashedBeast) {
            pieceCounter[6]++;
        } else if (p instanceof Sorceress) {
            pieceCounter[7]++;
        } else if (p instanceof BeastRider) {
            pieceCounter[8]++;
        } else if (p instanceof Knight) {
            pieceCounter[9]++;
        } else if (p instanceof Mage) {
            pieceCounter[10]++;
        } else if (p instanceof Dragon) {
            pieceCounter[11]++;
        }
    }

    public void removePiece(Piece p) {
        bag.remove(p);
        if (p instanceof Flag) {
            pieceCounter[0]--;
        } else if (p instanceof Trap) {
            pieceCounter[1]--;
        } else if (p instanceof Slayer) {
            pieceCounter[2]--;
        } else if (p instanceof Scout) {
            pieceCounter[3]--;
        } else if (p instanceof Dwarf) {
            pieceCounter[4]--;
        } else if (p instanceof Elf) {
            pieceCounter[5]--;
        } else if (p instanceof UnleashedBeast) {
            pieceCounter[6]--;
        } else if (p instanceof Sorceress) {
            pieceCounter[7]--;
        } else if (p instanceof BeastRider) {
            pieceCounter[8]--;
        } else if (p instanceof Knight) {
            pieceCounter[9]--;
        } else if (p instanceof Mage) {
            pieceCounter[10]--;
        } else if (p instanceof Dragon) {
            pieceCounter[11]--;
        }
    }

    public void setPieceCounter(int index, int counter) {
        pieceCounter[index] = counter;
    }

    public void initBag(Player player, String mode) {
        if (mode.equals("Normal")) {
            for (int i = 0; i < 1; i++) {
                addPiece(new Flag(player.getType()));
                setPieceCounter(0, 1);
            }
            
            for (int i = 0; i < 6; i++) {
                addPiece(new Trap(player.getType()));
                setPieceCounter(1, 6);
            }

            for (int i = 0; i < 1; i++) {
                addPiece(new Slayer(player.getType()));
                setPieceCounter(2, 1);
            }

            for (int i = 0; i < 4; i++) {
                addPiece(new Scout(player.getType()));
                setPieceCounter(3, 4);
            }

            for (int i = 0; i < 5; i++) {
                addPiece(new Dwarf(player.getType()));
                setPieceCounter(4, 5);
            }

            for (int i = 0; i < 2; i++) {
                addPiece(new Elf(player.getType()));
                setPieceCounter(5, 2);
            }

            for (int i = 0; i < 2; i++) {
                addPiece(new UnleashedBeast(player.getType()));
                setPieceCounter(6, 2);
            }

            for (int i = 0; i < 2; i++) {
                addPiece(new Sorceress(player.getType()));
                setPieceCounter(7, 2);
            }

            for (int i = 0; i < 3; i++) {
                addPiece(new BeastRider(player.getType()));
                setPieceCounter(8, 3);
            }

            for (int i = 0; i < 2; i++) {
                addPiece(new Knight(player.getType()));
                setPieceCounter(9, 2);
            }

            for (int i = 0; i < 1; i++) {
                addPiece(new Mage(player.getType()));
                setPieceCounter(10, 1);
            }

            for (int i = 0; i < 1; i++) {
                addPiece(new Dragon(player.getType()));
                setPieceCounter(11, 1);
            }

        } else {
            for (int i = 0; i < 1; i++) {
                addPiece(new Flag(player.getType()));
                setPieceCounter(0, 1);
            }

            for (int i = 0; i < 3; i++) {
                addPiece(new Trap(player.getType()));
                setPieceCounter(1, 3);
            }

            for (int i = 0; i < 1; i++) {
                addPiece(new Slayer(player.getType()));
                setPieceCounter(2, 1);
            }

            for (int i = 0; i < 2; i++) {
                addPiece(new Scout(player.getType()));
                setPieceCounter(3, 2);
            }

            for (int i = 0; i < 2; i++) {
                addPiece(new Dwarf(player.getType()));
                setPieceCounter(4, 2);
            }

            for (int i = 0; i < 1; i++) {
                addPiece(new Elf(player.getType()));
                setPieceCounter(5, 1);
            }

            for (int i = 0; i < 1; i++) {
                addPiece(new UnleashedBeast(player.getType()));
                setPieceCounter(6, 1);
            }

            for (int i = 0; i < 1; i++) {
                addPiece(new Sorceress(player.getType()));
                setPieceCounter(7, 1);
            }

            for (int i = 0; i < 1; i++) {
                addPiece(new BeastRider(player.getType()));
                setPieceCounter(8, 1);
            }

            for (int i = 0; i < 1; i++) {
                addPiece(new Knight(player.getType()));
                setPieceCounter(9, 1);
            }

            for (int i = 0; i < 1; i++) {
                addPiece(new Mage(player.getType()));
                setPieceCounter(10, 1);
            }

            for (int i = 0; i < 1; i++) {
                addPiece(new Dragon(player.getType()));
                setPieceCounter(11, 1);
            }
        }
        Collections.shuffle(bag);
        System.out.println("Bag size: " + bag.size());
        System.out.println("Bag contents: ");
        for (int i = 0; i < bag.size(); i++) {
            System.out.println(bag.get(i).getName());
        }
    }
}
