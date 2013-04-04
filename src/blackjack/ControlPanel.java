/*
 * ControlPanel.java
 * Author: HeapsOfRam
 */
package blackjack;

import java.io.*;
import java.text.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.event.*;
import java.util.Stack;

public class ControlPanel extends JPanel{
    private ViewPanel view;
    private JPanel buttonPanel;
    
    private JButton startButton, hitButton, stayButton, splitButton, helpButton, endButton;
    private ButtonHandler buttonListener;
    
    private Deck deck;
    private Card[] hand;
            
    public ControlPanel(ViewPanel view){
        this.view = view;
        buttonPanel = new JPanel();
        buttonListener = new ButtonHandler();
        
        startButton = new JButton("START");
        startButton.setToolTipText("Start a new game");
        startButton.setMargin(new Insets(5,5,10,5));
        startButton.addActionListener(buttonListener);
        
        hitButton = new JButton("HIT");
        hitButton.setToolTipText("Receive another card");
        hitButton.setMargin(new Insets(5,5,10,5));
        hitButton.addActionListener(buttonListener);
        
        stayButton = new JButton("STAY");
        stayButton.setToolTipText("Finish round");
        stayButton.setMargin(new Insets(5,5,10,5));
        stayButton.addActionListener(buttonListener);
        
        splitButton = new JButton("SPLIT");
        splitButton.setToolTipText("Split cards");
        splitButton.setMargin(new Insets(5,5,10,5));
        splitButton.addActionListener(buttonListener);
        
        helpButton = new JButton("HELP");
        helpButton.setToolTipText("Display help menu");
        helpButton.setMargin(new Insets(5,5,10,5));
        helpButton.addActionListener(buttonListener);
        
        endButton = new JButton("END");
        endButton.setToolTipText("End current game");
        endButton.setMargin(new Insets(5,5,10,5));
        endButton.addActionListener(buttonListener);
        
        buttonPanel.add(startButton);
        buttonPanel.add(hitButton);
        buttonPanel.add(stayButton);
        buttonPanel.add(splitButton);
        buttonPanel.add(helpButton);
        buttonPanel.add(endButton);
        
        add(BorderLayout.CENTER, buttonPanel);
    }
    
    class ButtonHandler implements ActionListener{
        Card[] dealer;
        Card[] user;
        Deck deck;
        int spot, userTotal, dealerTotal;
        
        public void actionPerformed(ActionEvent e){
            if(e.getActionCommand().equals("START")){
                dealer = new Card[13];
                user = new Card[13];
                deck = new Deck();
                spot = 2;
                userTotal = 0;
                dealerTotal = 0;
                
                deck.shuffle();
                
                for(int i = 0; i < 2; i++){
                    user[i] = deck.deal();
                    userTotal += user[i].getBNum();
                    System.out.println("USER: " + user[i]);
                    dealer[i] = deck.deal();
                    dealerTotal += dealer[i].getBNum();
                    System.out.println("DEALER: " + dealer[i]);
                }
                System.out.println("USERTOTAL " + userTotal);
            }
            if(e.getActionCommand().equals("HIT")){
                if(deck != null){
                    user[spot] = deck.deal();
                    userTotal += user[spot].getBNum();
                    spot++;
                }
                
                System.out.println("CARD: "  + user[spot - 1]); 
                System.out.println("USERTOTAL " + userTotal);
                
                if(userTotal == 21){
                    System.out.println("BLACKJACK");
                }
                if(userTotal > 21){
                    System.out.println("LOOOOSE");
                }
            }
            if(e.getActionCommand().equals("STAY")){
                
            }
            if(e.getActionCommand().equals("SPLIT")){
                
            }
            if(e.getActionCommand().equals("HELP")){
                JOptionPane.showMessageDialog(null, "Try to get 21!  Beat the dealer to win.  Don't go over 21 or you will bust."
                        + "\nStart begins a new game at any time"
                        + "\nHit adds a card to your hand"
                        + "\nStay holds the hand you currently have"
                        + "\nSplit only works when you have two cards of equal value...gain two hands to double your chances"
                        + "\nEnd quits the current session"
                        + "\nFace cards are 10, Aces are either 1 or 11");
            }
            if(e.getActionCommand().equals("END")){
                System.exit(0);
            }
        }
    }
    
}
