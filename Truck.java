package rental;
import java.util.*;

public class Truck extends Vehicle {
	String truckBrand, truckModel;
	double yearOfExperience;
	double noOfDays;
	Vehicle vehicle;
	Scanner sc = new Scanner(System.in);

	// truck brands
	String[] truckBrands = {"Bharat Benz", "Tata Motors", "Ashok Leyland"};

	// truck brand models
	String[][] truckModels = {{"Bharat Benz MDT 1217C", "Bharat Benz HDT 2826R", "Bharat Benz HDTC 2828C"},
			{"Tata Motors LPT 710", "Tata Motors SFC 712", "Tata Motors LPT 712"},
			{"Ashok Leyland Partner Super", "Ashok Leyland Ecomet Star", "Ashok Leyland Boss"},};
	// Availability of truck
	boolean[][] isRented = {{false, false, true}, {true, false, true}, {false, true, false},};

	// Constructors
	//rent truck
	public Truck(String vehicleType, Customer customer) {
		super(vehicleType, customer);
		this.noOfDays = customer.getNoOfDays();
	}

	// for vehicle availability
	public Truck(String vehicleType, String truckBrand, String truckModel) {
		super(vehicleType, truckBrand, truckModel);
	}

	//truck availability
	public Truck(String vehicleType) {
		super(vehicleType);
	}

	// getting all car brands
	public String[] getTruckBrandList() {
		return truckBrands;
	}

	// getting all truck models
	public String[][] getTruckModelList() {
		return truckModels;
	}


	public List<String> showTruckBrandsList() {
		System.out.println("---Available " + getVehicleType() + " Brands---");
		// display the truck brands
		String[] truckBrandsList = getTruckBrandList();
		List<String> truckBrands = Arrays.asList(truckBrandsList);
		for (int i = 0; i < truckBrandsList.length; i++) {
			System.out.print(truckBrandsList[i]);
			if (i < truckBrandsList.length - 1) {
				System.out.print(", ");
			}
		}
		return truckBrands;
	}

	public List<String> showTruckModelsList(String truckBrandAvl) {
		String[][] truckModelList = truckModels; //getting all models
		String[] truckBrandsList = truckBrands; //getting all brands
		List<String> truckModels = new ArrayList<>();
		for (int i = 0; i < truckBrandsList.length; i++) {
			if (truckBrandsList[i].equalsIgnoreCase(truckBrandAvl)) { //our model and display name are same or not
				System.out.println("--- Available Models for " + truckBrandAvl + " ---");
				for (int j = 0; j < truckModelList[i].length; j++) {
					System.out.print(truckModelList[i][j]);
					if (j < truckModelList[i].length - 1) {
						System.out.print(", ");
					}
					truckModels.add(truckModelList[i][j]);
				}
				break;
			}
		}
		return truckModels;
	}

	public List<String> getRentVehicleDetails(String vehicleType) {
		List<String> truckBrands = showTruckBrandsList();
		System.out.println("\nEnter the Brand Name:");
		String truckBrand = sc.nextLine();
		while (!brandExists(truckBrands, truckBrand)) {
			System.out.println("Brand Not found");
			System.out.println("Re-Enter the brand name again");
			truckBrand = sc.nextLine();
		}
		for (String brand : truckBrands) {
			if (brand.equalsIgnoreCase(truckBrand)) {
				truckBrand = brand;
			}
		}
		List<String> truckModels = showTruckModelsList(truckBrand);
		System.out.println("\nEnter Model Name: ");
		String truckModel = sc.nextLine();
		while (!modelExists(truckModels, truckModel)) {
			System.out.println("Model Not found");
			System.out.println("Re-Enter the model name again");
			truckModel = sc.nextLine();
		}
		for (String model : truckModels) {
			if (model.equalsIgnoreCase(truckModel)) {
				truckModel = model;
			}
		}
		List<String> details = new ArrayList<String>();
		details.add(truckBrand);
		details.add(truckModel);
		return details;
	}

	// check availability for bike
	public void checkAvailability(String vehicleType, String truckBrand, String truckModel) {
		for (int i = 0; i < truckBrands.length; i++) {
			if (truckBrands[i].equalsIgnoreCase(truckBrand)) {// checking out brand and this.brand is matching
				for (int j = 0; j < truckModels[i].length; j++) {
					if (truckModels[i][j].equalsIgnoreCase(truckModel)) {
						if (!isRented[i][j]) { // if it matches with model name & it checks for available
							System.out.println(truckModel + " is available..");
						} else {
							System.out.println(truckModel + " is already rented!..");
							System.out.println("Do you want to see other vehicles?");
							String choice = sc.next();
							sc.nextLine();
							if (choice.equalsIgnoreCase("yes")) {
								List<String> details = getRentVehicleDetails(getVehicleType());
								String newBrand = details.get(0);
								String newModel = details.get(1);
								checkAvailability(vehicleType, newBrand, newModel);
							} else
								System.out.println("Thank You!");
						}
					}
				}
			}
		}
	}

	// rent for truck
	public void rentVehicleType() {
		setFuelType("Diesel");
		setVehicleSubType("Manual Gear");
		System.out.println("Enter years of Experience (Min Exp. 3 Years): ");
		yearOfExperience = sc.nextDouble();
		sc.nextLine();
		if (yearOfExperience >= 3) {
			System.out.println("Which Brand do you want?");
			System.out.println("Press 1 --> Bharat Benz, Press 2 --> TATA Motors, Press 3 --> Ashok Leyland");
			brandTypeOption = sc.next();
			// case for bike brand
			switch (brandTypeOption) {
				case "1":
					setVehicleBrand("Bharat Benz");
					chooseVehicleModel(getVehicleBrand(), new String[]{"MDT 1217C", "HDT 2826R", "HDTC 2828C"});
					break;

				case "2":
					setVehicleBrand("TATA Motors");
					chooseVehicleModel(getVehicleBrand(), new String[]{"LPT 710", "SFC 712", "LPT 712"});
					break;
				case "3":
					setVehicleBrand("Ashok Leyland");
					chooseVehicleModel(getVehicleBrand(), new String[]{"Partner Super", "Ecomet Star", "Boss"});
					break;
				default:
					System.out.println("You did not select any trucks");
			}
		} else {
			System.out.println("Experience is less than 3 years! Sorry we wont provide car rentals!");
		}
	}

	//calculate rental cost for truck
	public double calculateRentalCost() {
		Map<String, Integer> dayRates = new HashMap<>();
		Map<String, Integer> hourRates = new HashMap<>();
		dayRates.put("Diesel-Manual Gear-BHARAT BENZ", 15000);
		dayRates.put("Diesel-Manual Gear-TATA MOTORS", 12000);
		dayRates.put("Diesel-Manual Gear-ASHOK LEYLAND", 10000);

		hourRates.put("Diesel-Manual Gear-BHARAT BENZ", 1000);
		hourRates.put("Diesel-Manual Gear-TATA MOTORS", 900);
		hourRates.put("Diesel-Manual Gear-ASHOK LEYLAND", 800);
		return calculateKeyRent(dayRates,hourRates);
	}
}


