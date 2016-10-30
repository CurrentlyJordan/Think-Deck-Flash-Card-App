package nyc.c4q.jordansmith.thinkdeck.Model;

import java.util.List;

/**
 * Created by jordansmith on 10/24/16.
 */

public class CatFacts {
    List<String> facts;
    String success;

    public List<String> getFacts() {
        return facts;
    }

    public void setFacts(List<String> facts) {
        this.facts = facts;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
