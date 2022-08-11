import java.util.Scanner;

public class HotelReservationMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Hotel Reservation Program");
        HotelReservationService hotelReservationService = new HotelReservationService();
        hotelReservationService.addHotel(new Hotel("Lakewood", 110, 80, 90, 80, 3));
        hotelReservationService.addHotel(new Hotel("Bridgewood", 160, 110, 60, 50, 4));
        hotelReservationService.addHotel(new Hotel("Ridgewood", 220, 100, 150, 40, 5));

        System.out.println("Enter check-in date: (dd-mm=yyyy) ex. 01-01-2000");
        String checkInDate = scanner.nextLine();
        System.out.println("Enter check-out date: (dd-mm=yyyy)");
        String checkOutDate = scanner.nextLine();
        Hotel cheapestHotel = hotelReservationService.getCheapestBestRatedHotel(checkInDate, checkOutDate, true);
        System.out.println("Cheapest Hotel: " + cheapestHotel.getName() + ", Ratings : " + cheapestHotel.getRatings() + ", Total Cost: " + cheapestHotel.getTotalCost());
    }
}