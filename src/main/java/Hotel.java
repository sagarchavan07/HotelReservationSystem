public class Hotel {
    private final String name;
    private final int rating;
    private int weekdayRate;
    private int weekdayRewardedRate;
    private int weekendRate;
    private int weekendRewardedRate;

    private long totalCost;

    public Hotel(String name, int weekdayRate, int weekdayRewardedRate, int weekendRate, int weekendRewardedRate, int rating) {
        this.name = name;
        this.weekdayRate = weekdayRate;
        this.weekdayRewardedRate = weekdayRewardedRate;
        this.weekendRate = weekendRate;
        this.weekendRewardedRate = weekendRewardedRate;
        this.rating = rating;
    }

    public int getWeekdayRate() {
        return weekdayRate;
    }

    public void setWeekdayRate(int weekdayRate) {
        this.weekdayRate = weekdayRate;
    }

    public int getWeekendRate() {
        return weekendRate;
    }

    public void setWeekendRate(int weekendRate) {
        this.weekendRate = weekendRate;
    }

    public int getRating() {
        return rating;
    }

    public long getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(long totalCost) {
        this.totalCost = totalCost;
    }

    public String getName() {
        return this.name;
    }

    public int getWeekdayRewardedRate() {
        return weekdayRewardedRate;
    }

    public void setWeekdayRewardedRate(int weekdayRewardedRate) {
        this.weekdayRewardedRate = weekdayRewardedRate;
    }

    public int getWeekendRewardedRate() {
        return weekendRewardedRate;
    }

    public void setWeekendRewardedRate(int weekendRewardedRate) {
        this.weekendRewardedRate = weekendRewardedRate;
    }
}
