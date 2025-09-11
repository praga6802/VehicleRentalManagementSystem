package rental;
import java.util.*;
import java.util.stream.Collectors;

public class Truck extends Vehicle {
	String truckBrand, truckModel;
	double yearOfExperience;
	double noOfDays;
	Vehicle vehicle;
	Scanner sc = new Scanner(System.in);

	// truck brands
	List<String> truckBrands=Arrays.asList("Bharat Benz", "TATA Motors", "Ashok Leyland");
	// truck brand models
	Map<String, List<String>> truckModelMap= new HashMap<>();
	String[][] truckModels = {
			{"MDT 1217C", "HDT 2826R", "HDTC 2828C"},
			{"LPT 710", "SFC 712", "LPT 712"},
			{"Partner Super", "Ecomet Star", "Boss"}
	};
	// Availability of truck
	boolean[][] isRented = {{false, false, true}, {true, false, true}, {false, true, false},};

	// Constructors
	//rent truck
	public Truck(String vehicleType, Customer customer) {
		super(vehicleType, customer);
		this.noOfDays = customer.getNoOfDays();
	}

	private double capacity;

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	// for adding vehicle
	public Truck(String id, String brand, String model, FuelPricing fuelPrice, double capacity, boolean isRented){
		super(id,brand, model,fuelPrice, isRented);
		this.capacity=capacity;
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
	public List<String> getTruckBrandList() {
		return truckBrands;
	}

	// getting all truck models
	public String[][] getTruckModelList() {
		return truckModels;
	}
	public String getVehicleType(){
		return "truck";
	}

	public List<String> showTruckBrandsList() {
		System.out.println("---Available " + getVehicleType() + " Brands---");
		List<String> truckBrandsList = truckBrands.stream().sorted().collect(Collectors.toList());
		System.out.println(String.join(",", truckBrandsList));
		return truckBrandsList;
	}

	public void initializeTruckModelMap(){
		for (int i=0;i<truckBrands.size();i++){
			truckModelMap.put(truckBrands.get(i),Arrays.asList(truckModels[i]));
		}
	}

	public List<String> showTruckModelsList(String truckBrand){
		System.out.println("Available models for "+truckBrand);
		return truckModelMap.getOrDefault(truckBrand,Collections.emptyList());
	}

	public List<String> getRentVehicleDetails(String vehicleType) {

		for (int i = 0; i < truckBrands.size(); i++) {
			System.out.println("Press " + (i + 1) + "-> " + truckBrands.get(i));
		}
		String brandChoice = sc.nextLine();
		try {
			int index = Integer.parseInt(brandChoice) - 1;
			if (index >= 0 && index < truckBrands.size()) {
				String truckBrand = truckBrands.get(index);
				setVehicleBrand(truckBrand);
			} else {
				System.out.println("Please enter valid number");
				return getRentVehicleDetails(vehicleType); // retry brand selection
			}
		} catch (NumberFormatException n) {
			System.out.println("Invalid Input, Enter a Number");
			return getRentVehicleDetails(vehicleType); // retry brand selection
		}

		//getting all models
		initializeTruckModelMap();
		List<String> availableModels = showTruckModelsList(getVehicleBrand());
		for (int i = 0; i < availableModels.size(); i++) {
			System.out.println("Press " + (i + 1) + "-> " + availableModels.get(i));
		}
		String choice = sc.nextLine();
		try {
			int index = Integer.parseInt(choice) - 1;
			if (index >= 0 && index < availableModels.size()) {
				String truckModel = availableModels.get(index);
				setVehicleModel(truckModel);
			} else {
				System.out.println("Please enter valid number");
				return getRentVehicleDetails(vehicleType); // retry model selection
			}
		} catch (NumberFormatException n) {
			System.out.println("Invalid Input, Enter a Number");
			return getRentVehicleDetails(vehicleType); // retry model selection
		}
		return Arrays.asList(getVehicleBrand(), getVehicleModel());
	}


	// check availability for bike
	public void checkAvailability(String vehicleType, String brand, String model) {
		int brandIndex = truckBrands.indexOf(brand);
		int modelIndex = Arrays.asList(truckModels[brandIndex]).indexOf(model);

		// check if rented
		if (!isRented[brandIndex][modelIndex]) {
			System.out.println(model + " is available..");
		} else {
			System.out.println("\n" + model + " is already rented!..");
			while(true) {
				System.out.println("Do you want to see other Truck? (yes/no)");
				String choice = sc.nextLine();

				if(choice.equalsIgnoreCase("yes")) {
					List<String> newSelection = getRentVehicleDetails(vehicleType);
					// Recursively check availability for the new selection
					checkAvailability(vehicleType, newSelection.get(0), newSelection.get(1));
					break; // exit current loop after recursive check
				} else if(choice.equalsIgnoreCase("no")) {
					System.out.println("Thank You!");
					break; // exit method
				} else {
					System.out.println("Invalid Input, Enter yes or no");
				}
			}
		}
	}

	// rent for truck
	public void rentVehicleType() {
		setFuelType("Diesel");
		setVehicleSubType("Manual Gear");
		while (true) {
			System.out.println("Which brand do you want?");
			for (int i = 0; i < truckBrands.size(); i++) {
				System.out.println("Press " + (i + 1) + " ->" + truckBrands.get(i));
			}
			String choice = sc.nextLine();

			try {
				int index = Integer.parseInt(choice) - 1;
				if (index >= 0 && index < truckBrands.size()) {
					String selectBrand = truckBrands.get(index);
					setVehicleBrand(selectBrand);

					int selectBrandIndex = truckBrands.indexOf(selectBrand);
					String[] models = truckModels[selectBrandIndex];

					List<String> modelList = Arrays.asList(models);
					chooseVehicleModel(selectBrand, modelList);
					break;
				}
				else {
					System.out.println("Invalid Option! Please try again");
				}
			} catch (NumberFormatException n) {
				System.out.println("Invalid input, pLease Enter a number");

			}
		}
	}
	public void chooseVehicleModel(String brand, List<String> models) {
		initializeTruckModelMap();
		if (models == null || models.isEmpty()) {
			System.out.println("No models available for " + brand);
			return;
		}

		System.out.println("Models available for " + brand);
		for (int i = 0; i < models.size(); i++) {
			System.out.println("Press " + (i + 1) + "-> " + models.get(i));
		}
		String modelChoice = sc.nextLine();

		try {
			int index = Integer.parseInt(modelChoice) - 1;
			if (index >= 0 && index < models.size()) {
				String truckModel = models.get(index);
				setVehicleModel(truckModel);
				System.out.println("You selected " + brand + " " + truckModel);
			} else {
				System.out.println("Invalid Option");
			}
		} catch (NumberFormatException n) {
			System.out.println("Invalid Input, Please enter number");
		}

	}

	//calculate rental cost for truck
	public double calculateRentalCost() {
		Map<String, Integer> dayRates = new HashMap<>();
		Map<String, Integer> hourRates = new HashMap<>();
		dayRates.put("DIESEL-MANUAL GEAR-BHARAT BENZ", 15000);
		dayRates.put("DIESEL-MANUAL GEAR-TATA MOTORS", 12000);
		dayRates.put("DIESEL-MANUAL GEAR-ASHOK LEYLAND", 10000);

		hourRates.put("DIESEL-MANUAL GEAR-BHARAT BENZ", 1000);
		hourRates.put("DIESEL-MANUAL GEAR-TATA MOTORS", 900);
		hourRates.put("DIESEL-MANUAL GEAR-ASHOK LEYLAND", 800);
		return calculateKeyRent(dayRates,hourRates);
	}
}


