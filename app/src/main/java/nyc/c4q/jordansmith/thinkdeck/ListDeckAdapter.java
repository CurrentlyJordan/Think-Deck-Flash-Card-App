package nyc.c4q.jordansmith.thinkdeck;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.jordansmith.thinkdeck.Model.Deck;

/**
 * Created by jordansmith on 10/28/16.
 *
 */

public class ListDeckAdapter extends RecyclerView.Adapter<ListDeckViewHolder> {

    List<Deck> deckList;

    public ListDeckAdapter(List<Deck> deckList){
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
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(v.getContext(), holder.deckName.getText()+"", Toast.LENGTH_SHORT).show();
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("TestDeck",deck);
//                TestFragment testFragment = new TestFragment();
//                testFragment.setArguments(bundle);
////                FragmentManager fm = getFragmentManager
////                getFragmentManager()
////                FragmentTransaction transaction = fm.beginTransaction();
////                transaction.replace(R.id.fragment_holder, testFragment);
////                transaction.commit();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return deckList.size();
    }




}
