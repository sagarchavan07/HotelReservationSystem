import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class HotelReservationTest {
    static HotelReservationService hotelReservationService;

    @BeforeAll
    static void initialize() {
        hotelReservationService = new HotelReservationService();
        hotelReservationService.addHotel(new Hotel("Lakewood", 110));
        hotelReservationService.addHotel(new Hotel("Bridgewood", 160));
        hotelReservationService.addHotel(new Hotel("Ridgewood", 220));
    }

    @Test
    void givenHotel_ShouldBe_AddedToHotelList() {
        boolean result = hotelReservationService.addHotel(new Hotel("Lakewood", 110));
        Assertions.assertTrue(result);
    }

    @Test
    void givenCheckInAndCheckOutDates_userShould_GetCheapestHotel() {
        Hotel hotel = hotelReservationService.getCheapestHotel("01-08-2022", "10-08-2022");
        Assertions.assertEquals("Lakewood", hotel.getName());
    }

}
