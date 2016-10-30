package nyc.c4q.jordansmith.thinkdeck.Model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jordansmith on 10/26/16.
 */

public class Deck implements Serializable {
    List<Cards> cardsList;

    String deckName;
    int size;


    public List<Cards> getCardsList() {
        return cardsList;
    }

    public void setCardsList(List<Cards> cardsList) {
        this.cardsList = cardsList;
    }

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    public int getSize(){
        size = cardsList.size();
        return size;
    }

    public Deck(String deckName){
        this.deckName = deckName;
    }



}
