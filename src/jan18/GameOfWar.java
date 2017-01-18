/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jan18;

import java.util.ArrayList;

/**
 *
 * @author Raman
 */
public class GameOfWar {
   private ArrayList<Card>p1Hand;
   private ArrayList<Card>p2Hand;
   
   public GameOfWar()
      {
          p1Hand = new ArrayList<>();
          p2Hand = new ArrayList<>();
          
          DeckOfCards theDeck= new DeckOfCards();
         theDeck.shuffle();
         
         dealTheCards(theDeck);
      }//end of constructor
   
   /**
    * This method will deal all the cards to the player
    */
    private void dealTheCards(DeckOfCards theDeck)
    {
        for(int cardNum=0;cardNum<52;cardNum++)
        {
            if(cardNum % 2==0)
                    p1Hand.add(theDeck.dealTheCard());
            else
                    p2Hand.add(theDeck.dealTheCard());
        }
    }
    /**
     * This method will simulate playing the Game called "War"
    **/
    public void playTheGame()
    {
        while(!p1Hand.isEmpty() && !p2Hand.isEmpty())
        {
            playHand();
        }
        if(p1Hand.isEmpty())
            System.out.println("Player 2 is the Winner");
        else
            System.out.println("Player1 is the winner");
    }
    /**
     * This method will simulate playing 1 hand at the game of war
     */
    private void playHand()
    {
        Card p1Card=p1Hand.remove(0);
        Card p2Card=p1Hand.remove(0);
        
        System.out.printf("Player1: %s cards in hand: %d", p1Card, p1Hand.size()+1);
        System.out.printf("\tPlayer2: %s cards in hand: %d", p2Card, p2Hand.size()+1);
        
       
        //player 1's card is higher than player 2's crd
        if(p1Card.getFaceValue() > p2Card.getFaceValue())
        {
           
             p1Hand.add(p1Card);
             p1Hand.add(p1Card);
        }
        
        //player 2's card is higher than player 1's 
        else if (p2Card.getFaceValue() > p1Card.getFaceValue())
        {
           p2Hand.add(p2Card);
           p2Hand.add(p2Card); 
        }
        
        //otherwise it's War
        else
        {
            ArrayList<Card> warPile = new ArrayList<>();
            warPile.add(p1Card);
            warPile.add(p2Card);
            playWarHand(warPile);
        } 
    }
    /**
     * This method will stimulate playing the "war" hand
     */
    private void playWarHand(ArrayList<Card> warPile)
    {
        //check if player 1 had enough cards
        if(p1Hand.size()<3)
        {
          p2Hand.addAll(p1Hand);
          p1Hand.clear();
          p2Hand.addAll(warPile);
          return;
        }
        //check if player 2 had enough cards
        if(p1Hand.size()<3)
        {
          p1Hand.addAll(p2Hand);
          p2Hand.clear();
          p1Hand.addAll(warPile);
          return;
        }
        
        warPile.add(p1Hand.remove(0));
        warPile.add(p1Hand.remove(0));
        warPile.add(p2Hand.remove(0));
        warPile.add(p2Hand.remove(0));
        
        Card p1Card = p1Hand.remove(0);
        Card p2Card = p2Hand.remove(0);
        
        System.out.printf("%n%n~~~~~~~WAR~~~~~~~~~%n");
        System.out.printf("Player1: %s cards in hand: %d", p1Card, p1Hand.size()+1);
        System.out.printf("\tPlayer2: %s cards in hand: %d", p2Card, p2Hand.size()+1);
        
        //if player 1 wins
        if(p1Card.getFaceValue()>p2Card.getFaceValue())
        {
            p1Hand.addAll(warPile);
            p1Hand.add(p1Card);
            p1Hand.add(p2Card);
        }
        else if(p2Card.getFaceValue()>p1Card.getFaceValue())
        {
            p2Hand.addAll(warPile);
            p2Hand.add(p2Card);
            p2Hand.add(p1Card);
        }
        else
        {
            warPile.add(p1Card);
            warPile.add(p2Card);
            this.playWarHand(warPile);
            
        }
            
    }
}
