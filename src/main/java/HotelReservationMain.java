import java.util.Scanner;

public class HotelReservationMain {
    public static void main(String[] args) throws DateFormatException {
        System.out.println("Welcome to Hotel Reservation Program");
        Scanner scanner = new Scanner(System.in);
        HotelReservationService hotelReservationService = new HotelReservationService();

        hotelReservationService.addHotel(new Hotel("Lakewood", 110, 80, 90, 80, 3));
        hotelReservationService.addHotel(new Hotel("Bridgewood", 160, 110, 60, 50, 4));
        hotelReservationService.addHotel(new Hotel("Ridgewood", 220, 100, 150, 40, 5));

        System.out.println("Enter check-in date: (dd-mm-yyyy OR dd/mm/yyyy) ");
        String checkInDate = scanner.nextLine();
        System.out.println("Enter check-out date: (dd-mm-yyyy)");
        String checkOutDate = scanner.nextLine();

        Hotel cheapestHotel = hotelReservationService.getCheapestBestRatedHotel(checkInDate, checkOutDate, HotelReservationService.CustomerType.REWARDED);
        System.out.println("Cheapest Hotel for Rewarded customer: " + cheapestHotel.getName() + ", Ratings : " + cheapestHotel.getRating() + ", Total Cost: " + cheapestHotel.getTotalCost());

        Hotel cheapestHotel1 = hotelReservationService.getCheapestBestRatedHotel(checkInDate, checkOutDate, HotelReservationService.CustomerType.REGULAR);
        System.out.println("Cheapest Hotel for Regular customer: " + cheapestHotel1.getName() + ", Ratings : " + cheapestHotel1.getRatings() + ", Total Cost: " + cheapestHotel1.getTotalCost());

    }
}