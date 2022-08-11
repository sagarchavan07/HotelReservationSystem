import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HotelReservationService {
    public enum CustomerType {
        REGULAR, REWARDED
    }

    List<Hotel> hotelList = new ArrayList<>();

    boolean addHotel(Hotel hotel) {
        hotelList.add(hotel);
        return true;
    }

    Hotel getCheapestBestRatedHotel(String checkInDate, String checkOutDate, CustomerType customerType) throws DateFormatException {
        validateInputDate(checkInDate);
        validateInputDate(checkOutDate);
        if (customerType.equals(CustomerType.REWARDED)) {
            hotelList.forEach(hotel -> {
                hotel.setWeekdayRate(hotel.getWeekdayRewardedRate());
                hotel.setWeekendRate(hotel.getWeekendRewardedRate());
            });
        }
        LocalDate inDate = LocalDate.of(Integer.parseInt(checkInDate.substring(6, 10)), Integer.parseInt(checkInDate.substring(3, 5)), Integer.parseInt(checkInDate.substring(0, 2)));
        LocalDate outDate = LocalDate.of(Integer.parseInt(checkOutDate.substring(6, 10)), Integer.parseInt(checkOutDate.substring(3, 5)), Integer.parseInt(checkOutDate.substring(0, 2)));

        long totalNumberOfDays = getNumberOfDays(inDate, outDate);
        long weekendDays = getNumberOfWeekendDays(inDate, outDate);
        long weekDays = totalNumberOfDays - weekendDays;

        calculateTotalCost(weekDays, weekendDays);
        List<Hotel> hotelList1 = hotelList.stream().sorted((x, y) -> Long.compare(x.getTotalCost(), y.getTotalCost())).collect(Collectors.toList());
        List<Hotel> hotelList2 = hotelList1.stream().filter(x -> x.getTotalCost() == hotelList1.get(0).getTotalCost()).sorted((x, y) -> Integer.compare(y.getRating(), x.getRating())).collect(Collectors.toList());

        return hotelList2.get(0);
    }

    boolean validateInputDate(String date) throws DateFormatException {
        Pattern pattern = Pattern.compile("\\d{2}[/-]{1}\\d{2}[/-]{1}\\d{4}");
        boolean isValid = pattern.matcher(date).matches();
        if (isValid) {
            return true;
        } else {
            throw new DateFormatException("input date format is not correct");
        }
    }

    Hotel getBestRatedHotel() {
        return hotelList.stream().sorted((x, y) -> Integer.compare(y.getRating(), x.getRating())).collect(Collectors.toList()).get(0);
    }

    long getNumberOfDays(LocalDate checkInDate, LocalDate checkOutDate) {
        return (int) checkInDate.datesUntil(checkOutDate).count();
    }

    long getNumberOfWeekendDays(LocalDate checkInDate, LocalDate checkOutDate) {
        Stream<LocalDate> weekendDays = checkInDate.datesUntil(checkOutDate).filter(date -> {
            DayOfWeek day = date.getDayOfWeek();
            return (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY);
        });
        return weekendDays.count();
    }

    void calculateTotalCost(long weekDays, long weekendDays) {
        hotelList.forEach(x -> x.setTotalCost(weekDays * x.getWeekdayRate() + weekendDays * x.getWeekendRate()));
    }
}
