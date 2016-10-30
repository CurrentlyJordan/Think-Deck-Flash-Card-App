package nyc.c4q.jordansmith.thinkdeck.Model;

/**
 * Created by jordansmith on 10/26/16.
 */

public class Cards {
    String frontText;

    String backText;

    public Cards(String frontText,String backText){
       this.frontText = frontText;
        this.backText = backText;

    }


    public String getFrontText() {
        return frontText;
    }

    public void setFrontText(String frontText) {
        this.frontText = frontText;
    }

    public String getBackText() {
        return backText;
    }

    public void setBackText(String backText) {
        this.backText = backText;
    }
}
