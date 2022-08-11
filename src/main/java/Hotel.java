public class Hotel {
    private final String name;
    private int weekdayRate;
    private int weekdayRewardedRate;
    private int weekendRate;
    private  int weekendRewardedRate;
    private int ratings;
    private long totalCost;
    boolean isRewardCustomer;

    public Hotel(String name, int weekdayRate, int weekdayRewardedRate, int weekendRate, int weekendRewardedRate, int ratings) {
        this.name = name;
        this.weekdayRate = weekdayRate;
        this.weekdayRewardedRate = weekdayRewardedRate;
        this.weekendRate = weekendRate;
        this.weekendRewardedRate = weekendRewardedRate;
        this.ratings = ratings;
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

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
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

    public boolean isRewardCustomer() {
        return isRewardCustomer;
    }

    public void setRewardCustomer(boolean rewardCustomer) {
        isRewardCustomer = rewardCustomer;
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
