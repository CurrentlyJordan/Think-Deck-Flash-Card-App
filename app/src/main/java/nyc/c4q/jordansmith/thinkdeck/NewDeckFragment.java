package nyc.c4q.jordansmith.thinkdeck;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by jordansmith on 10/25/16.
 */

public class NewDeckFragment extends Fragment{

    Button newDeckButton;
    EditText newDeckEditText;
    String newDeckName;
    public static final String NEW_DECK_NAME = "New Deck Name";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.new_deck_layout,container,false);

        newDeckButton = (Button) view.findViewById(R.id.new_deck_button);
        newDeckEditText = (EditText) view.findViewById(R.id.new_deck_edit_text);

        newDeckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newDeckName = newDeckEditText.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString(NEW_DECK_NAME,newDeckName);
                AddCardsFragment f = new AddCardsFragment();
                f.setArguments(bundle);
                FragmentManager fManager = getFragmentManager();
                FragmentTransaction transaction = fManager.beginTransaction();
                transaction.replace(R.id.fragment_holder,f);
                transaction.commit();

            }
        });


        return view;
    }
}
