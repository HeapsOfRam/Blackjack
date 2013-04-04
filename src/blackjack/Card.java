/*
 * Card.java
 * Author: HeapsOfRam
 */
package blackjack;

public class Card implements Comparable{
    private int num, suit;
    
    public final static int SPADE = 1;
    public final static int HEART = 2;
    public final static int CLUB = 3;
    public final static int DIAMOND = 4;
    
    public final static int ACE = 1;
    public final static int TWO = 2;
    public final static int THREE = 3;
    public final static int FOUR = 4;
    public final static int FIVE = 5;
    public final static int SIX = 6;
    public final static int SEVEN = 7;
    public final static int EIGHT = 8;
    public final static int NINE = 9;
    public final static int TEN = 10;
    public final static int JACK = 11;
    public final static int QUEEN = 12;
    public final static int KING = 13;
    
    public Card(int num, int suit){
        this.num = num;
        this.suit = suit;
    }
    
    public void setNum(int num)
    {this.num = num;}
    
    public void setSuit(int suit)
    {this.suit = suit;}
    
    public int getNum()
    {return num;}
    
    public int getBNum(){
        if(num > 10)
            return 10;
        return num;
    }
    
    public int getSuit()
    {return suit;}
    
    public String suitString(){
        switch(suit){
            case SPADE:
                return "Spades";
            case HEART:
                return "Hearts";
            case CLUB:
                return "Clubs";
            case DIAMOND:
                return "Diamonds";
            default:
                return "";
        }
    }
    
    public int compareTo(Object o){
        Card c = (Card) o;
        if(num > c.getNum())
            return 1;
        if(num < c.getNum())
            return -1;
        return 0;
    }
    
    public boolean equals(Object o){
        Card c = (Card) o;
        return (num == c.getNum() && suit == c.getSuit());
    }
    
    public String toString(){
        switch(suit){
            case SPADE:
                return "" + num + "ofSpades.png";
            case HEART:
                return "" + num + "ofHearts.png";
            case CLUB:
                return "" + num + "ofClubs.png";
            case DIAMOND:
                return "" + num + "ofDiamonds.png";
            default:
                return "" + num;
        }
    }
    
}
