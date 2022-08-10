public class HotelReservationMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Hotel Reservation Program");
        HotelReservationSevice hotelReservationSevice=new HotelReservationSevice();
        hotelReservationSevice.addHotel(new Hotel("Lakewood",110));
    }
}
