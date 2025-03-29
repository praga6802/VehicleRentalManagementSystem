package rental;

public interface RentalRules {

    int MAX_NO_OF_DAYS=10;
    String rentalname="JONI rentals";

    double calculateRentalCost();
    void checkAvailability();
}
