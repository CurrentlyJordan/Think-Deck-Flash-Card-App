package nyc.c4q.jordansmith.thinkdeck;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import nyc.c4q.jordansmith.thinkdeck.Model.Deck;

/**
 * Created by jordansmith on 10/28/16.
 */

public class ListOfDecksFragment extends Fragment implements Serializable{

    List<Deck> deckList = new ArrayList<Deck>();
    RecyclerView listDecksRecyclerView;
    Deck deck;
    FragmentManager fragmentManager;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.list_decks_layout,container,false);
        fragmentManager = getFragmentManager();


        if (this.getArguments() != null) {
            Bundle bundle = new Bundle(this.getArguments());
            deck = (Deck) bundle.getSerializable("addedDeck");
            testLog();

            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this.getContext());
            SharedPreferences.Editor sharedEditor = prefs.edit();

            Gson gson = new Gson();
            String jsonDecks1 = prefs.getString("decksList", " ");
            if (jsonDecks1.equals(" ")) {
                deckList.add(deck);
            } else {
                Type type = new TypeToken<List<Deck>>() {
                }.getType();
                deckList = gson.fromJson(jsonDecks1, type);
                deckList.add(deck);
            }

            Gson gson2 = new Gson();
            String jsonDecks = gson2.toJson(deckList);
            sharedEditor.putString("decksList", jsonDecks);
            sharedEditor.apply();

        }

        else{
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this.getContext());
            SharedPreferences.Editor sharedEditor = prefs.edit();

            Gson gson = new Gson();
            String jsonDecks1 = prefs.getString("decksList", " ");

            Type type = new TypeToken<List<Deck>>() {
            }.getType();
            deckList = gson.fromJson(jsonDecks1, type);

//            if (jsonDecks1.equals(" ")) {
//                deckList.add(deck);
//            }
//            else {
//                Type type = new TypeToken<List<Deck>>() {
//                }.getType();
//                deckList = gson.fromJson(jsonDecks1, type);
//                deckList.add(deck);
//            }
            Gson gson2 = new Gson();
            String jsonDecks = gson2.toJson(deckList);
            sharedEditor.putString("decksList", jsonDecks);
            sharedEditor.apply();

        }


//        Gson gson2 = new Gson();
//        String jsonDecks = gson2.toJson(deckList);
//        sharedEditor.putString("decksList", jsonDecks);
//        sharedEditor.apply();




        listDecksRecyclerView = (RecyclerView) view.findViewById(R.id.list_decks_recyclerview);
        listDecksRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ListDeckAdapter adapter = new ListDeckAdapter(fragmentManager,deckList);
        listDecksRecyclerView.setAdapter(adapter);


        return view;
    }

    public void testLog(){
        for (int i = 0; i < deck.getCardsList().size(); i++) {
            Log.d( "Card " + i, deck.getCardsList().get(i).getFrontText() + " " + deck.getCardsList().get(i).getBackText() );
        }
    }

    @Override
    public void onStop() {
        super.onStop();

    }
}
