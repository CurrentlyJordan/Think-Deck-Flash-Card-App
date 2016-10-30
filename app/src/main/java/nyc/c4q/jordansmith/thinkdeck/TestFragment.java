package nyc.c4q.jordansmith.thinkdeck;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;

import nyc.c4q.jordansmith.thinkdeck.Model.Deck;

/**
 * Created by jordansmith on 10/29/16.
 */

public class TestFragment extends Fragment implements View.OnClickListener, Serializable{
    Deck deck;
    TextView cardTextView;
    Button flipCard;
    Button nextCard;
    String cardText;
    boolean cardState = false;
    int currentIndex = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test_layout,container,false);

        Bundle bundle = new Bundle(this.getArguments());
        deck = (Deck) bundle.getSerializable("TestDeck");

        cardTextView = (TextView)view.findViewById(R.id.card_view);
        flipCard = (Button) view.findViewById(R.id.flip_card_button);
        nextCard = (Button) view.findViewById(R.id.test_next_button);

        String firstCard = deck.getCardsList().get(0).getFrontText();
        cardTextView.setText(firstCard);
        flipCard.setOnClickListener(this);
        nextCard.setOnClickListener(this);






        return view;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.flip_card_button:
                if(cardState){
                    cardState = false;
                    cardText = deck.getCardsList().get(currentIndex).getFrontText();
                    cardTextView.setText(cardText);
                }
                else{
                    cardState = true;
                    cardText = deck.getCardsList().get(currentIndex).getBackText();
                    cardTextView.setText(cardText);

                }
                break;
            case R.id.test_next_button:
                if(currentIndex < deck.getCardsList().size() - 1){
                    currentIndex++;
                    cardText = deck.getCardsList().get(currentIndex).getFrontText();
                    cardTextView.setText(cardText);
                }
                else {
                    currentIndex = 0;
                    cardText = deck.getCardsList().get(currentIndex).getFrontText();
                    cardTextView.setText(cardText);
                }
                break;

        }


    }
}
