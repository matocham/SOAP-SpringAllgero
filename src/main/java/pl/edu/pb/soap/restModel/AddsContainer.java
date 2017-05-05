package pl.edu.pb.soap.restModel;

import java.util.List;

/**
 * Created by Mateusz on 04.05.2017.
 */
public class AddsContainer {
    List<Advertisement> adds;
    int totalCount;

    public AddsContainer() {
    }

    public AddsContainer(List<Advertisement> adds) {
        this.adds = adds;
    }

    public AddsContainer(List<Advertisement> adds, int totalCount) {
        this.adds = adds;
        this.totalCount = totalCount;
    }

    public List<Advertisement> getAdds() {
        return adds;
    }

    public void setAdds(List<Advertisement> adds) {
        this.adds = adds;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
