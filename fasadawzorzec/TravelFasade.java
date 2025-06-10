public class TravelFasade {
    private FlightBooking flight;
    private HotelBooking hotel;
    private TaxiBooking taxi;

    public TravelFasade() {
        flight = new FlightBooking();
        hotel = new HotelBooking();
        taxi = new TaxiBooking();
    }

    public void bookTrip(String destination,String hotelCity, String taxiAddress) {
        flight.bookFlight(destination);
        hotel.bookHotel(hotelCity);
        taxi.bookTaxi(taxiAddress);
        System.out.println("Całość zarezerwowana -> lot + hotel + taxi!");
    }
}
