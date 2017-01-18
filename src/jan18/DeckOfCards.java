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
public class DeckOfCards 
{
   ArrayList<Card> deck;
   
   public DeckOfCards()
   {
       String[] suits={"hearts","diamonds","spades","clubs"};
       String[] faceNames={"two","three","four","five","six","seven","eight","nine","ten","jack","queen","king","ace"};
       
       for(String suit:suits)
       {
           for(int i=0; i<faceNames.length;i++)
           {
               Card newCard = new Card(suit, faceNames[i],i+2);
               deck.add(newCard);
           }
       }
   }
}
