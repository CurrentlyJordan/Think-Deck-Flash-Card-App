package nyc.c4q.jordansmith.thinkdeck;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

import nyc.c4q.jordansmith.thinkdeck.Model.Deck;

/**
 * Created by jordansmith on 10/28/16.
 *
 */

public class ListDeckAdapter extends RecyclerView.Adapter<ListDeckViewHolder> implements Serializable {

    List<Deck> deckList;
    FragmentManager fragmentManager;

    public ListDeckAdapter(FragmentManager fragmentManager,List<Deck> deckList){
        this.fragmentManager = fragmentManager;
        this.deckList = deckList;
    }

    @Override
    public ListDeckViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);

        return new ListDeckViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(final ListDeckViewHolder holder, int position) {
        final Deck deck = deckList.get(position);
        holder.deckName.setText(deck.getDeckName());
        String cardNumber = "Cards: " + deck.getSize();
        holder.deckNumber.setText(cardNumber);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), holder.deckName.getText()+"", Toast.LENGTH_SHORT).show();
                Bundle bundle = new Bundle();
                bundle.putSerializable("TestDeck",deck);
                TestFragment testFragment = new TestFragment();
                testFragment.setArguments(bundle);
                fragmentManager.beginTransaction().replace(R.id.fragment_holder, testFragment).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return deckList.size();
    }




}
