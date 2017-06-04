package pl.edu.pb.soap.restModel;

/**
 * Created by Mateusz on 04.06.2017.
 */
public class EndingInfo {
    boolean ending;

    public EndingInfo(boolean ending) {
        this.ending = ending;
    }

    public boolean isEnding() {
        return ending;
    }

    public void setEnding(boolean ending) {
        this.ending = ending;
    }
}
