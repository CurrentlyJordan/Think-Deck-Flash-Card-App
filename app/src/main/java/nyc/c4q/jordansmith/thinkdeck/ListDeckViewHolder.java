package nyc.c4q.jordansmith.thinkdeck;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by jordansmith on 10/28/16.
 */

public class ListDeckViewHolder extends RecyclerView.ViewHolder {

    TextView deckName;
    TextView deckNumber;

    ListDeckViewHolder(View itemView){
        super(itemView);

        deckName = (TextView) itemView.findViewById(R.id.title_view);
        deckNumber = (TextView) itemView.findViewById(R.id.number_view);

    }



}
