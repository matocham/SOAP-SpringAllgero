package pl.edu.pb.soap.restModel;

/**
 * Created by Mateusz on 04.05.2017.
 */
public class Advertisement {
    long id;
    String title;
    String price;
    String priceType;
    String priceWithDelivery;
    String lastTime;
    String state;
    String endDate;
    String imageUrl;

    public Advertisement() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public String getPriceWithDelivery() {
        return priceWithDelivery;
    }

    public void setPriceWithDelivery(String priceWithDelivery) {
        this.priceWithDelivery = priceWithDelivery;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
