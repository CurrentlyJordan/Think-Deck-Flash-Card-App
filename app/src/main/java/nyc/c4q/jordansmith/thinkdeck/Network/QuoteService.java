package nyc.c4q.jordansmith.thinkdeck.Network;

import nyc.c4q.jordansmith.thinkdeck.Model.CatFacts;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jordansmith on 10/23/16.
 */

public interface QuoteService {

    @GET("api/facts")
    Call<CatFacts> getFact();


}
