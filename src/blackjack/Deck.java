/*
 * Deck.java
 * Author: HeapsOfRam
 */
package blackjack;

import java.util.Random;

public class Deck {
    Card[] c;
    int begin, end;
    final int SUITS = 4;
    final int NUMS = 13;
    final int CARDS = 52;
    
    Random gen;
    
    public Deck(){
        c = new Card[CARDS];
        populateDeck();
        shuffle();
        begin = 0;
        end = CARDS - 1;
    }
    
    public Deck(boolean shuffled){
        c = new Card[CARDS];
        populateDeck();
        if(shuffled){
            shuffle();
        }
        begin = 0;
        end = CARDS - 1;
    }
    
    private void populateDeck(){
        int count = 0;
        for(int s = 1; s <= SUITS; s++){
            for(int i = 1; i <= NUMS; i++){
                c[count] = new Card(i, s);
                count++;
            }
        }
    }
    
    public boolean contains(Card newCard){
        boolean cont = false;
        for(int i = 0; i <= end; i++){
            if(c[i].equals(newCard))
                cont = true;
        }
        return cont;
    }
    
    public void shuffle(){
        int loc;
        Card temp;
        gen = new Random();
        for(int i = end; i > 0; i--){
            temp = c[i];
            loc = gen.nextInt(end + 1);
            c[i] = c[loc];
            c[loc] = temp;
        }
    }
    
    public void shuffleTimes(int n){
        for(int i = 0; i < n; i++){
            shuffle();
        }
    }
    
    public void order(){
        populateDeck();
    }
    
    public Card deal(){
        Card temp = c[end];
        c[end] = null;
        end--;
        return temp;
    }
    
    public Card dealFrom(int n){
        if(n <= end && n >= begin)
            return c[n];
        return null;
    }
    
    public Card[] dealTimes(int n){
        if(n <= end && n > 0){
            Card[] temp = new Card[n];
            for(int i = 0; i < n; i++){
                temp[i] = dealFrom(i);
            }
            return temp;
        }
        return null;
    }
    
    public void insert(Card newCard){
        if(end != CARDS - 1){
            end++;
            if(!contains(newCard))
                c[end] = newCard;
        }            
    }
    
    public String toString(){
        for(int i = 0; i <= end; i++){
            System.out.println(c[i]);
        }
        return "";
    }
}
