package Stratego;
/**
 * @author Dimitrios Makrogiannis csd4676
 * @version 1.0 (final PhaseA)
 * github PercySS
 * @link https://giathub.com/PercySS
 * @program Stratego Fire vs Ice (Variation Of Stratego)
 * 
 */


import java.io.IOException;

import View.View;

public class Stratego {
    /**
     * <b>Transformer</b> mutative
     * <b>Pre</b> Valid instance of class Stratego
     * <b>Post</b> Initiates the game
     * @param void
     * @return void
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        new View();
    }
}
