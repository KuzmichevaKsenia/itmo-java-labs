package multiapp;

public class Feedback {

    String hotel;
    private String date;
    private int rating;
    private boolean service;
    private boolean network;
    private String describe;

    public void setDate(String date) {
        this.date = date;
    }

    public void setRating(int rating) {
        if (rating > 10) rating = 10;
        if (rating < 0) rating = 0;
        this.rating = rating;
    }

    public void setService(boolean service) {
        this.service = service;
    }

    public void setNetwork(boolean network) {
        this.network = network;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        String satServ = (service) ? "yes" : "no";
        String satNet = (network) ? "yes" : "no";
        return "\n Hotel: " + hotel
                + "\n  date of last visit: " + date
                + "\n  rating: " + rating
                + "\n  satisfaction with service: " + satServ
                + "\n  satisfaction with network: " + satNet
                + "\n  describe: " + describe;
    }
}
