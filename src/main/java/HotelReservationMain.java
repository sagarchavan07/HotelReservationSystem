import java.util.Scanner;

public class HotelReservationMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Hotel Reservation Program");
        HotelReservationService hotelReservationService = new HotelReservationService();
        hotelReservationService.addHotel(new Hotel("Lakewood", 110, 90, 3));
        hotelReservationService.addHotel(new Hotel("Bridgewood", 160, 60, 4));
        hotelReservationService.addHotel(new Hotel("Ridgewood", 220, 150, 5));

        System.out.println("Enter check-in date: (dd-mm=yyyy) ex. 01-01-2000");
        String checkInDate = scanner.nextLine();
        System.out.println("Enter check-out date: (dd-mm=yyyy)");
        String checkOutDate = scanner.nextLine();
        Hotel cheapestHotel = hotelReservationService.getCheapestBestRatedHotel(checkInDate, checkOutDate);
        System.out.println("Cheapest Hotel: " + cheapestHotel.getName() + ", Ratings : " + cheapestHotel.getRatings() + ", Total Cost: " + cheapestHotel.getTotalCost());
    }
}
