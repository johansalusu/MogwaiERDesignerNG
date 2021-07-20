package de.erdesignerng.visual;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.util.Random;

/**
 *
 * @author JohanSalusu
 */
 public class QuoteOfTheDay{
    static void QuoteOfTheDay(){
        String[] quote = {"You never know till you have tried.", "Never put off till tomorrow what you can do today.", "Experience is the best teacher.", "Practice makes perfect.", "Where there is a will, there is a way.", "A champion is someone who gets up even they can't."};
        Random rand = new Random();
        int r = rand.nextInt(6);
        JOptionPane.showMessageDialog(new JFrame(), quote[r], "Quote of the Day", JOptionPane.PLAIN_MESSAGE);
    }
}