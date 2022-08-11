public class Hotel {
    private final String name;
    private final int weekdayRate;
    private final int weekendRate;
    private final int ratings;
    private long totalCost;

    public Hotel(String name, int weekdayRate, int weekendRate, int ratings) {
        this.name = name;
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
        this.ratings = ratings;
    }

    public String getName() {
        return name;
    }

    public int getWeekdayRate() {
        return weekdayRate;
    }

    public int getWeekendRate() {
        return weekendRate;
    }

    public long getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(long totalCost) {
        this.totalCost = totalCost;
    }

    public int getRatings() {
        return ratings;
    }
}
