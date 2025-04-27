package rental;

public interface RentalRules {

	int MAX_NO_OF_DAYS = 10;
	String rentalName = "Green Valley";
	String vehicleBrand = "", vehicleModel = "";

	double calculateRentalCost();

	boolean checkAvailability(String bikeBrand, String bikeModel);

	void printReceipt();

	void rentVehicleType();
}
