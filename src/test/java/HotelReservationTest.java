import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class HotelReservationTest {
    static HotelReservationService hotelReservationService;

    @BeforeAll
    static void initialize() {
        hotelReservationService = new HotelReservationService();
        hotelReservationService.addHotel(new Hotel("Lakewood", 110, 80, 90, 80, 3));
        hotelReservationService.addHotel(new Hotel("Bridgewood", 160, 110, 60, 50, 4));
        hotelReservationService.addHotel(new Hotel("Ridgewood", 220, 100, 150, 40, 5));
    }

    @Test
    void givenHotel_ShouldBe_AddedToHotelList() {
        boolean result = hotelReservationService.addHotel(new Hotel("Lakewood", 110, 80, 90, 80, 3));
        Assertions.assertTrue(result);
    }

    @Test
    void givenCheckInAndCheckOutDates_ShouldReturn_CheapestHotel() throws DateFormatException {
        Hotel hotel = hotelReservationService.getCheapestBestRatedHotel("01-08-2022", "10-08-2022", HotelReservationService.CustomerType.REGULAR);
        Assertions.assertEquals("Lakewood", hotel.getName());
    }

    @Test
    void givenWeekendDates_ShouldReturn_CheapestHotel() throws DateFormatException {
        Hotel hotel = hotelReservationService.getCheapestBestRatedHotel("13-08-2022", "14-08-2022", HotelReservationService.CustomerType.REGULAR);
        Assertions.assertEquals("Bridgewood", hotel.getName());
    }

    @Test
    void givenDateRange_ShouldReturn_CheapestBestRatedHotel() throws DateFormatException {
        Hotel hotel = hotelReservationService.getCheapestBestRatedHotel("12-09-2020", "13-09-2020", HotelReservationService.CustomerType.REGULAR);
        Assertions.assertEquals("Bridgewood", hotel.getName());
    }

    @Test
    void customerShould_getBestRatedHotel() {
        Hotel hotel = hotelReservationService.getBestRatedHotel();
        Assertions.assertEquals("Ridgewood", hotel.getName());
    }

    @Test
    void givenWeekendDates_ForRewardedCustomersReturn_CheapestHotel() throws DateFormatException {
        Hotel hotel = hotelReservationService.getCheapestBestRatedHotel("12-09-2020", "13-09-2020", HotelReservationService.CustomerType.REWARDED);
        Assertions.assertEquals("Ridgewood", hotel.getName());
    }

    @Test
    void givenDate_WhenValidFormat_shouldReturnTrue() throws DateFormatException {
        boolean result = hotelReservationService.validateInputDate("01-01-2000");
        Assertions.assertTrue(result);
    }

    @Test
    void givenDate_WhenInValidFormat_shouldThrowException() {
        Assertions.assertThrows(DateFormatException.class, () -> hotelReservationService.validateInputDate("0101-2000"));
    }
}
