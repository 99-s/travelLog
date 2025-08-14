package Trip;

public class TripModel {
    private int id;
    private String title;
    private String startDate;
    private String endDate;

    public TripModel(int id, String title, String startDate, String endDate) {
        this.id = id;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
