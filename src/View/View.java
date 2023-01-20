package View;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.*;
import javax.swing.event.MouseInputListener;


import Controller.Controller;
import Model.Pieces.Empty;
import Model.Pieces.ImmovablePiece;
import Model.Pieces.Immovable.Trespassing;



/**
 *
 * @author Thanos
 */
public class View extends JFrame {
    private JButton[][] grid;
    private boolean iconSelected;
    private JButton selected1;
    private int selected1_i, selected1_j, selected2_i, selected2_j;
    private Controller controller;
    private JPanel board_jp;
    private JPanel info_jp;
    private JPanel rules;
    private JPanel playRules;
    private JLabel top;
    private JLabel red_army;
    private JLabel full_attack;
    private JPanel statsLabJPanel;
    private JPanel statsJPanel;
    private JPanel statsJPanel1;
    private JPanel statsJPanel2;
    private JPanel statsJPanel3;
    private JLabel playerTurnJLabel;
    private JLabel statsJLabel;
    private JLabel successRateJLabel;
    private int ctr = 0;




    
    
    /**
     * <b>Constructor</b> mutative
     * <b>Pre</b> void
     * <b>Post</b> Begins the game graphics
     * @param turn Turn
     * @return void
     * @throws IOException
     */
    public View() throws IOException {
        String gamemode = JOptionPane.showInputDialog(null, "Options", "Choose Gamemode",JOptionPane.QUESTION_MESSAGE, null, new String[] { "Normal", "Reduced Army", "Full Attack", "Both" }, "Normal").toString(); 
        System.out.println("Game mode:" + gamemode);
        controller = new Controller(gamemode); 
        
        makeTheFrame(gamemode);
        
        pack();
    }

    /**
     * <b>Transformer</b> mutative
     * <b>Pre</b> Valid String
     * <b>Post</b> Makes the Frame according to the game mode
     * @param turn Turn
     * @return void
     */
    public void makeTheFrame(String gm) throws IOException {
        this.setTitle("Stratego Ice vs Fire (By PercySS)");
        this.setPreferredSize(new Dimension(1200, 1000));
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        drawTheBoardPanel();
        this.add(board_jp, BorderLayout.WEST);
        drawTheInfoPanel(gm);
        this.add(info_jp, BorderLayout.EAST);
        this.setLocation(0, 0);
        this.setResizable(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("./src/Model/images/percySSthinking.png");
        this.setIconImage(icon.getImage());
        this.setVisible(true);
        this.isAlwaysOnTop();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        System.out.println("Width : " + this.getWidth() + ", Height: " + this.getHeight());
    } 

    /**
     * <b>Transformer</b> mutative
     * <b>Pre</b> void
     * <b>Post</b> Draws the board panel
     * @param void
     * @return void
     * @throws IOException
     */
    public void drawTheBoardPanel() throws IOException {
        board_jp = new JPanel();
        board_jp.setLayout(new GridLayout(8, 10));
        board_jp.setBackground(Color.gray);
        board_jp.setPreferredSize(new Dimension(850, 1000));
        board_jp.setBorder(BorderFactory.createLineBorder(Color.black));
        
        grid = new JButton[8][10];

        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 10; j++) {
                //System.out.println("Button: i = " + i + ", j = " + j);
                grid[i][j] = new JButton("Button: " + i);
                grid[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                grid[i][j].setIcon(this.controller.getB().getBoard()[i][j].getImageUrlHide());
                grid[i][j].setBorder(BorderFactory.createLineBorder(Color.getColor("BLACK")));
                grid[i][j].setPreferredSize(new Dimension(145, 217));
                if (!(this.controller.getB().getBoard()[i][j] instanceof Trespassing)) {
                    grid[i][j].addMouseListener(new CardListener());
                }
                grid[i][j].setOpaque(true);
                grid[i][j].setVisible(true);
                board_jp.add(grid[i][j]);
            }
        }
        setOpp();
        board_jp.setOpaque(true);
        board_jp.setVisible(true);
        this.add(board_jp, BorderLayout.WEST);
    }


    /**
     * <b>Transformer</b> mutative
     * <b>Pre</b> void
     * <b>Post</b> Draws the info panel
     * @param gm String gamemode
     * @return void
     */
    public void drawTheInfoPanel(String gm) {
        info_jp = new JPanel();
        info_jp.setLayout(new BoxLayout(info_jp, BoxLayout.Y_AXIS));
        info_jp.setPreferredSize(new Dimension(350, 1000));
        info_jp.setBorder(BorderFactory.createLineBorder(Color.black));
        //info_jp.setBackground(new ImageIcon("./src/Model/war.jpg"));
        info_jp.setBackground(Color.gray);
        info_jp.setVisible(true);
        info_jp.setOpaque(true);


        playRules = new JPanel();

        top = new JLabel("Ενεργοί Κανόνες");
        top.setFont(new Font("Serif", Font.BOLD, 20));
        top.setHorizontalTextPosition(JLabel.CENTER);
        top.setVerticalTextPosition(JLabel.CENTER);
        top.setForeground(Color.black);
        playRules.add(top);
        playRules.setBackground(Color.lightGray);
        playRules.setVisible(true);
        playRules.setOpaque(true);
        playRules.setPreferredSize(new Dimension(info_jp.getWidth(), 50));
        playRules.setBorder(BorderFactory.createLineBorder(Color.black));
        info_jp.add(playRules);

        rules = new JPanel();
        rules.setLayout(new BorderLayout());
        rules.setPreferredSize(new Dimension(info_jp.getWidth(), 150));
        rules.setBackground(Color.gray);
        
        red_army = new JLabel("Μειωμένος Στρατός");
        JCheckBox box1 = new JCheckBox();
        box1.setEnabled(false);
        red_army.setFont(new Font("Serif", Font.BOLD, 20));
        red_army.add(box1);
        red_army.setForeground(gm.equals("Reduced Army") || gm.equals("Both") ? Color.green : Color.black);
        red_army.setHorizontalAlignment(JLabel.CENTER);
        rules.add(red_army , BorderLayout.NORTH);


        full_attack = new JLabel("Καμία Υποχώρηση");
        rules.add(full_attack, BorderLayout.SOUTH);
        full_attack.setFont(new Font("Serif", Font.BOLD, 20));
        full_attack.setForeground(gm.equals("Full Attack") || gm.equals("Both") ? Color.green : Color.black);
        full_attack.setHorizontalAlignment(JLabel.CENTER);
        
        rules.setVisible(true);
        info_jp.add(rules);

        statsLabJPanel = new JPanel();
        statsJLabel = new JLabel("Στατιστικά");
        statsJLabel.setFont(new Font("Serif", Font.BOLD, 20));
        statsJLabel.setHorizontalTextPosition(JLabel.CENTER);
        statsJLabel.setVerticalTextPosition(JLabel.BOTTOM);
        statsJLabel.setForeground(Color.black);
        statsLabJPanel.add(statsJLabel);
        statsLabJPanel.setBackground(Color.lightGray);
        statsLabJPanel.setVisible(true);
        statsLabJPanel.setOpaque(true);
        statsLabJPanel.setPreferredSize(new Dimension(info_jp.getWidth(), 150));
        info_jp.add(statsLabJPanel);


        statsJPanel = new JPanel();
        statsJPanel.setLayout(new BorderLayout());
        statsJPanel.setPreferredSize(new Dimension(info_jp.getWidth(), 250));
        statsJPanel.setBackground(Color.gray);
        statsJPanel.setVisible(true);
        statsJPanel.setOpaque(true);
        statsJPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        statsJPanel1 = new JPanel();
        statsJPanel1.setLayout(new BorderLayout());
        statsJPanel1.setPreferredSize(new Dimension(info_jp.getWidth(), 100));
        playerTurnJLabel = new JLabel("Player " + (controller.getTurn() == 1 ? "1" : "2") + " turn");
        playerTurnJLabel.setHorizontalTextPosition(JLabel.CENTER);
        playerTurnJLabel.setFont(new Font("Serif", Font.BOLD, 20));
        playerTurnJLabel.setVerticalTextPosition(JLabel.CENTER);
        playerTurnJLabel.setForeground(Color.black);
        playerTurnJLabel.setVisible(true);
        statsJPanel1.add(playerTurnJLabel, BorderLayout.NORTH);
        statsJPanel1.setBackground(Color.gray);
        statsJPanel1.setVisible(true);
        statsJPanel1.setOpaque(true);
        statsJPanel.add(statsJPanel1, BorderLayout.NORTH);

        statsJPanel2 = new JPanel();
        statsJPanel2.setLayout(new BorderLayout());
        statsJPanel2.setPreferredSize(new Dimension(info_jp.getWidth(), 50));
        successRateJLabel = new JLabel("Ποσοστό επιτ. επιθέσεων: " + (controller.getTurn() == 1 ? (controller.getP1().getSuccesfullAttacks() /  (controller.getP1().getAttacks() + 1)): (controller.getP2().getSuccesfullAttacks() /  (controller.getP2().getAttacks() + 1))) + "%");
        successRateJLabel.setFont(new Font("Serif", Font.BOLD, 20));
        successRateJLabel.setHorizontalTextPosition(JLabel.CENTER);
        successRateJLabel.setVerticalTextPosition(JLabel.CENTER);
        successRateJLabel.setForeground(Color.black);
        successRateJLabel.setVisible(true);
        statsJPanel2.add(successRateJLabel, BorderLayout.NORTH);
        statsJPanel2.setBackground(Color.gray);
        statsJPanel2.setVisible(true);
        statsJPanel2.setOpaque(true);
        statsJPanel.add(statsJPanel2, BorderLayout.CENTER);

        statsJPanel3 = new JPanel();
        statsJPanel3.setLayout(new GridLayout(1, 2));

        

        info_jp.add(statsJPanel);
        
        
        JPanel captivityLabJPanel = new JPanel();
        JLabel captivityJLabel = new JLabel("Αιχμαλωτίσεις");
        captivityJLabel.setFont(new Font("Serif", Font.BOLD, 20));
        captivityJLabel.setHorizontalTextPosition(JLabel.CENTER);
        captivityJLabel.setVerticalTextPosition(JLabel.CENTER);
        captivityJLabel.setForeground(Color.black);
        captivityLabJPanel.add(captivityJLabel);
        captivityLabJPanel.setBackground(Color.lightGray);
        captivityLabJPanel.setVisible(true);
        captivityLabJPanel.setOpaque(true);
        captivityLabJPanel.setPreferredSize(new Dimension(info_jp.getWidth(), 150));
        info_jp.add(captivityLabJPanel);

        JPanel captivityJPanel = new JPanel();
        captivityJPanel.setLayout(new BoxLayout(captivityJPanel, BoxLayout.X_AXIS));
        captivityJPanel.setPreferredSize(new Dimension(info_jp.getWidth(), 300));
        captivityJPanel.setBackground(Color.gray);
        captivityJPanel.setVisible(true);
        captivityJPanel.setOpaque(true);
        JButton out_of_order = new JButton();
        out_of_order.setIcon(new ImageIcon("./src/Model/images/outoforder.png"));
        out_of_order.setPreferredSize(new Dimension(info_jp.getWidth(), 100));
        out_of_order.setVisible(true);
        out_of_order.setOpaque(true);
        out_of_order.setBorder(BorderFactory.createLineBorder(Color.black));
        out_of_order.setBackground(Color.gray);
        out_of_order.addMouseListener(new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ctr++;
                if (ctr == 10) {
                    JOptionPane.showMessageDialog(null, "Are you blind or something?");
                } else if (ctr == 15){
                    JOptionPane.showMessageDialog(null, "You are blind!");
                    controller.endGame("ZZ");;
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
        captivityJPanel.add(out_of_order);
        info_jp.add(captivityJPanel);

        
    }

    /**
     *
     * <b>Private class</b> 
     */
    private class CardListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            JButton button = (JButton) e.getSource();
            int x = 0, y = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 10; j++) {
                    if (button == grid[i][j]) {
                        x = i;
                        y = j;
                    }
                }
            }

            if (!iconSelected) {
                System.out.println("Selected: " + x + ", " + y + " name: " + controller.getB().getBoard()[x][y].getName() + ".");

                if (controller.getTurn() == 1 && controller.getB().getBoard()[x][y].getType().equals("B")) {
                    JOptionPane.showMessageDialog(null, "Player 1 turn");
                    iconSelected = false;
                } else if (controller.getTurn() == 2 && controller.getB().getBoard()[x][y].getType().equals("R")) {
                    JOptionPane.showMessageDialog(null, "Player 2 turn");
                    iconSelected = false;
                } else if (controller.getB().getBoard()[x][y] instanceof ImmovablePiece || controller.getB().getBoard()[x][y] instanceof Empty) {
                    JOptionPane.showMessageDialog(null, "Δεν μπορείτε να επιλέξετε αυτό το κομμάτι.");
                } else {
                    selected1 = button;
                    selected1_i = x;
                    selected1_j = y;
                    iconSelected = true;
                }
            } else if (iconSelected && !button.equals(selected1)) {
                System.out.println("Selected: " + x + ", " + y + " name: " + controller.getB().getBoard()[x][y].getName() + ".");
                selected2_i = x;
                selected2_j = y;
                if (controller.getB().getBoard()[selected1_i][selected1_j].getType().equals(controller.getB().getBoard()[selected2_i][selected2_j].getType())) {
                    JOptionPane.showMessageDialog(null, "You can't swap your own pieces");
                    iconSelected = false;
                } else {

                    if (controller.swap(selected1_i, selected1_j, selected2_i, selected2_j)) {
                        update(); 
                        iconSelected = false;
                        System.out.println(controller.getRound());
                        System.out.println(controller.getTurn());
                        setOpp();
                    } else {
                        JOptionPane.showMessageDialog(null, "Never swapped");
                        iconSelected = false;
                    }
                }
            } else if (iconSelected && button.equals(selected1)) {
                iconSelected = false;
                System.out.println("Piece Unselected");
            }
  
        }

        @Override
        public void mousePressed(MouseEvent e) {
                
        }

        @Override
        public void mouseReleased(MouseEvent e) {
                 
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
                
        }
    
    }

    /**
     * <b>Transformer</b>  mutative
     * <b>Pre</b> void
     * <b>Post</b> Sets the board for the player to play next
     * @param void
     * @return  void
     */
    public void setOpp() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (controller.getB().getBoard()[i][j] instanceof Trespassing) {
                    continue;
                }
                if (controller.getTurn() == 1) {
                    if (controller.getB().getBoard()[i][j].getType().equals("R")) {
                        grid[i][j].setIcon(controller.getB().getBoard()[i][j].getImageUrlShow());
                    } else {
                        grid[i][j].setIcon(controller.getB().getBoard()[i][j].getImageUrlHide());
                    }
                } else if (controller.getTurn() == 2) {
                    if (controller.getB().getBoard()[i][j].getType().equals("B")) {
                        grid[i][j].setIcon(controller.getB().getBoard()[i][j].getImageUrlShow());
                    } else {
                        grid[i][j].setIcon(controller.getB().getBoard()[i][j].getImageUrlHide());
                    }
                }               
            }
        }
        
       
    }


    /**
     * <b>Transformer</b>  mutative
     * <b>Pre</b> void
     * <b>Post</b> Updates the board
     * @param void
     * @return  void
     */
    public void update() {
        controller.nextTurn();
        this.repaint();
        this.revalidate();
        this.pack();
        controller.checkENd();
        controller.checkUnplayable();
    }
}
