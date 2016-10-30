package nyc.c4q.jordansmith.thinkdeck;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.jordansmith.thinkdeck.Model.Cards;
import nyc.c4q.jordansmith.thinkdeck.Model.Deck;

import static nyc.c4q.jordansmith.thinkdeck.NewDeckFragment.NEW_DECK_NAME;

/**
 * Created by jordansmith on 10/25/16.
 */

public class AddCardsFragment extends Fragment implements View.OnClickListener {

    Button addCard;
    Button doneCard;
    TextView textview;
    EditText front_card_view;
    EditText back_card_view;
    List<Cards> newCardsList = new ArrayList<Cards>();
    String finalDeckName = " ";
    String frontCard;
    String backCard;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_card_layout, container, false);
        addCard = (Button) view.findViewById(R.id.add_button);
        doneCard = (Button) view.findViewById(R.id.done_button);
        textview = (TextView) view.findViewById(R.id.new_deck_name);
        front_card_view = (EditText) view.findViewById(R.id.clue_edit_text);
        back_card_view = (EditText) view.findViewById(R.id.answer_edit_text);

        Bundle bundle = this.getArguments();
        String deckNameText = "Add cards to " + bundle.getString(NEW_DECK_NAME);
        textview.setText(deckNameText);
        finalDeckName = bundle.getString(NEW_DECK_NAME);
        addCard.setOnClickListener(this);
        doneCard.setOnClickListener(this);

        return view;
        }


    @Override
    public void onClick(View v) {
        if(v.equals(addCard)){
            if(front_card_view.getText().toString().equals("")|| back_card_view.getText().toString().equals("")){
                Toast.makeText(getContext(), "Please enter values for both fields!", Toast.LENGTH_SHORT).show();
            }
            else {
                frontCard = front_card_view.getText().toString();
                backCard = back_card_view.getText().toString();
                Cards card = new Cards(frontCard, backCard);
                newCardsList.add(card);
                front_card_view.setText("");
                back_card_view.setText("");
                logCards();

            }

        }
        if(v.equals(doneCard)){
            Deck newDeck = new Deck(finalDeckName);
            newDeck.setCardsList(newCardsList);

            Bundle bundle = new Bundle();
            bundle.putSerializable("addedDeck",newDeck);
            ListOfDecksFragment newDeckFrag = new ListOfDecksFragment();
            newDeckFrag.setArguments(bundle);
            FragmentManager fm = getFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.replace(R.id.fragment_holder, newDeckFrag);
            transaction.commit();

        }
    }





    public void logCards(){
        for (int i = 0; i < newCardsList.size() ; i++) {
            Log.d(i + " card", newCardsList.get(i).getFrontText() + " " + newCardsList.get(i).getBackText());
        }
    }
}

