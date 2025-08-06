package rental;

public interface RentalRules {

	double MAX_NO_OF_DAYS = 10;
	String COMPANY_NAME = "EZ Rent";

	double calculateRentalCost();

	void checkAvailability(String vehicleType, String vehicleBrand, String vehicleModel);

	void printReceipt();

	void rentVehicleType();



}
