package rental;
import java.util.*;

import java.util.stream.Collectors;

public class Bike extends Vehicle {
	private double cc;
	Scanner sc = new Scanner(System.in);

	List<String> bikeBrands=Arrays.asList("Suzuki", "Honda", "TVS", "Bajaj", "Yamaha", "Royal Enfield", "Kawasaki", "Ducati", "BMW",
			"Ola", "Aprilla", "Ather", "Matter", "Revolt", "Oben");


	String[][] bikeModels = {
			{"Access 125", "Burgman Street", "Avenis"},                // Suzuki
			{"Activa 110", "Activa 125", "Dio 125"},                   // Honda
			{"Jupiter 125", "Ntorq 125", "Zest 125"},                  // TVS
			{"Pulsar 150", "Pulsar 220", "Dominar 400"},               // Bajaj
			{"FZ-X", "MT-15", "R15 V4"},                               // Yamaha
			{"Classic 350", "Meteor 650", "Hunter 350", "Interceptor 650"}, // Royal Enfield
			{"Ninja H2R", "Ninja ZX-10R", "Ninja H2 SX"},              // Kawasaki
			{"Panigale V4", "Panigale V4R", "Streetfighter V2"},       // Ducati
			{"M 1000 XR", "S 1000 R", "M 1000 RR"},                    // BMW
			{"S1 Pro+", "S1 Air", "Gig"},                              // Ola
			{"Typhoon"},                                               // Aprilia
			{"450S", "450X", "450 Apex"},                              // Ather
			{"Aera 5000", "Aera 5000+"},                               // Matter
			{"RV400"},                                                 // Revolt
			{"Rorr"}                                                   // Oben
	};

	Map<String,List<String>> bikeModelMap= new HashMap<>();

	// availability of bikes
	boolean[][] isRented = {{false, false, true}, // suzuki scooters
			{false, false, false}, // honda scooters
			{false, true, false}, // tvs scooters
			{false, false, false}, // bajaj
			{true, false, false}, // yamaha
			{false, false, false,true}, // royal enfield
			{true, true, false}, {false, true, false}, {false, false, true}, {false, true, false}, {true},
			{false, true, true}, {false, false}, {false}, {true}};


	// for renting vehicles
	public Bike(String vehicleType, Customer customer) {
		super(vehicleType, customer);
		//this.noOfDays = customer.getNoOfDays();
	}

	public Bike(String vehicleType) {
		super(vehicleType);
	}

	// for adding vehicle
	public Bike(String id, String brand,String subType, String model, FuelPricing fuelPrice,double cc, boolean isRented){
		super(id,brand,subType, model,fuelPrice, isRented);
		this.cc=cc;
	}

	// for vehicle availability
	public Bike(String vehicleType, String bikeBrand, String bikeModel) {
		super(vehicleType, bikeBrand, bikeModel);
	}


	// getting all bike models
	public String[][] getBikeModels() {
		return bikeModels;
	}

	public String getVehicleType(){
		return "bike";
	}


	//show all bike brands
	public List<String> showBikeBrandsList() {
		System.out.println("---Available " + getVehicleType() + " Brands---");
		List<String> bikeBrandsList = bikeBrands.stream().sorted().collect(Collectors.toList());
		System.out.print(String.join(",",bikeBrandsList));
		return bikeBrandsList;
	}

	public void initializeBikeModelMap(){
		for(int i=0;i<bikeBrands.size();i++){
			bikeModelMap.put(bikeBrands.get(i),Arrays.asList(bikeModels[i]));
		}
	}

	//show model from bike brand
	public List<String> showBikeModelsList(String bikeBrand) {
		System.out.println("Available Models for '"+bikeBrand+"'");
		return bikeModelMap.getOrDefault(bikeBrand,Collections.emptyList());
	}

	//rent vehicle bike
	public List<String> getRentVehicleDetails(String vehicleType) {

		for (int i = 0; i < bikeBrands.size(); i++) {
			System.out.println("Press " + (i + 1) + "-> " + bikeBrands.get(i));
		}
		String brandChoice = sc.nextLine();
		try {
			int index = Integer.parseInt(brandChoice) - 1;
			if (index >= 0 && index < bikeBrands.size()) {
				String bikeBrand = bikeBrands.get(index);
				setVehicleBrand(bikeBrand);
			} else {
				System.out.println("Please enter valid number");
				return getRentVehicleDetails(vehicleType); // retry brand selection
			}
		} catch (NumberFormatException n) {
			System.out.println("Invalid Input, Enter a Number");
			return getRentVehicleDetails(vehicleType); // retry brand selection
		}

		//getting all models
		initializeBikeModelMap();
		List<String> availableModels = showBikeModelsList(getVehicleBrand());
		for (int i = 0; i < availableModels.size(); i++) {
			System.out.println("Press " + (i + 1) + "-> " + availableModels.get(i));
		}

		String choice = sc.nextLine();
		try {
			int index = Integer.parseInt(choice) - 1;
			if (index >= 0 && index < availableModels.size()) {
				String bikeModel = availableModels.get(index);
				setVehicleModel(bikeModel);
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


	// check availability for selected bike brand with model
	public void checkAvailability(String vehicleType, String brand, String model) {
		int brandIndex = bikeBrands.indexOf(brand);
		int modelIndex = Arrays.asList(bikeModels[brandIndex]).indexOf(model);

		// check if rented
		if (!isRented[brandIndex][modelIndex]) {
			System.out.println(model + " is available..");
		} else {
			System.out.println("\n" + model + " is already rented!..");

			while(true) {
				System.out.println("Do you want to see other bike? (yes/no)");
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
	// rent for bike
	public void rentVehicleType() {
		List<String> bikeMode;
		while (true) {
			System.out.println("Which type do you want? Press -- 1 Petrol, Press 2 --> EV Bikes");
			fuelTypeOption = sc.nextLine();

			// 1 -> for petrol
			if (fuelTypeOption.equals("1")) {
				setFuelType("petrol");
				bikeMode = Arrays.asList("Scooter", "Gear Bike", "Super Bikes");
				break;
			}

			//2 for ev
			else if (fuelTypeOption.equals("2")) {
				setFuelType("EV");
				bikeMode = Arrays.asList("Scooter", "Gear Bike");
				break;
			} else {
				System.out.println("Invalid Option! Please try again");

			}
		}

		while (true) {
			System.out.println("What type of " + getFuelType() + " bike do you want?");
			for (int i = 0; i < bikeMode.size(); i++) {
				System.out.println("Press " + (i + 1) + "-> " + bikeMode.get(i));
			}

			String choice = sc.nextLine();
			try {
				int index = Integer.parseInt(choice) - 1;
				if (index >= 0 && index < bikeMode.size()) {
					String selectedType = bikeMode.get(index);
					setVehicleSubType(selectedType);
					handleBrandSelection(getFuelType(), selectedType);
					break;
				}
				else {
					System.out.println("Invalid Option! Please try again");
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input, please enter a number.");
			}
		}
	}


	public void handleBrandSelection(String fuelType, String vehicleSubType) {
		setFuelType(fuelType);
		setVehicleSubType(vehicleSubType);

		List<String> bikeBrand = new ArrayList<>();
		if (fuelType.equalsIgnoreCase("petrol") && vehicleSubType.equalsIgnoreCase("Scooter")) {
			bikeBrand = Arrays.asList("Suzuki", "TVS", "Honda");
		} else if (fuelType.equalsIgnoreCase("petrol") && vehicleSubType.equalsIgnoreCase("Gear Bike")) {
			bikeBrand = Arrays.asList("Bajaj", "Yamaha", "Royal Enfield");
		} else if (fuelType.equalsIgnoreCase("petrol") && vehicleSubType.equalsIgnoreCase("Super Bikes")) {
			bikeBrand = Arrays.asList("Kawasaki", "Ducati", "BMW");
		} else if (fuelType.equalsIgnoreCase("Ev") && vehicleSubType.equalsIgnoreCase("Scooter")) {
			bikeBrand = Arrays.asList("Ola", "Aprilla", "Ather");
		} else if (fuelType.equalsIgnoreCase("Ev") && vehicleSubType.equalsIgnoreCase("Gear Bike")) {
			bikeBrand = Arrays.asList("Matter", "Revolt", "Oben");
		}

		while (true) {
			System.out.println("Which brand do you want?");
			for (int i = 0; i < bikeBrand.size(); i++) {
				System.out.println("Press " + (i + 1) + " ->" + bikeBrand.get(i));
			}
			String choice = sc.nextLine();

			try {
				int index = Integer.parseInt(choice) - 1;
				if (index >= 0 && index < bikeBrand.size()) {
					String selectBrand = bikeBrand.get(index);
					setVehicleBrand(selectBrand);

					int selectBrandIndex = bikeBrands.indexOf(selectBrand);
					String[] models = bikeModels[selectBrandIndex];

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

	public void chooseVehicleModel(String brand, List<String>models){
		initializeBikeModelMap();
		if(models==null || models.isEmpty()){
			System.out.println("No models available for "+brand);
			return;
		}

		System.out.println("Models available for "+brand);
		for (int i=0;i<models.size();i++){
			System.out.println("Press "+(i+1)+"-> "+models.get(i));
		}
		String modelChoice=sc.nextLine();

		try{
			int index=Integer.parseInt(modelChoice)-1;
			if(index>=0 && index<models.size()){
				String bikeModel=models.get(index);
				setVehicleModel(bikeModel);
				System.out.println("You selected "+brand+" "+bikeModel);
			}
			else{
				System.out.println("Invalid Option");
			}
		}
		catch (NumberFormatException n){
			System.out.println("Invalid Input, Please enter number");
		}

	}

	//calculate rental cost for bike
	public double calculateRentalCost() {
		// Use uppercase keys for consistency
		Map<String, Integer> dayRates = new HashMap<>();
		Map<String, Integer> hourRates = new HashMap<>();

		// Petrol Bikes
		dayRates.put("PETROL-SCOOTER-SUZUKI", 400);
		dayRates.put("PETROL-SCOOTER-TVS", 400);
		dayRates.put("PETROL-SCOOTER-HONDA", 450);
		dayRates.put("PETROL-GEAR BIKE-BAJAJ", 500);
		dayRates.put("PETROL-GEAR BIKE-YAMAHA", 550);
		dayRates.put("PETROL-GEAR BIKE-ROYAL ENFIELD", 600);
		dayRates.put("PETROL-SUPER BIKES-KAWASAKI", 900);
		dayRates.put("PETROL-SUPER BIKES-DUCATI", 850);
		dayRates.put("PETROL-SUPER BIKES-BMW", 950);

		// EV Bikes
		dayRates.put("EV-SCOOTER-OLA", 200);
		dayRates.put("EV-SCOOTER-APRILLA", 230);
		dayRates.put("EV-SCOOTER-ATHER", 250);
		dayRates.put("EV-GEAR BIKE-MATTER", 300);
		dayRates.put("EV-GEAR BIKE-REVOLT", 270);
		dayRates.put("EV-GEAR BIKE-OBEN", 240);

		// Hourly rates (same keys, different values)
		hourRates.put("PETROL-SCOOTER-SUZUKI", 50);
		hourRates.put("PETROL-SCOOTER-TVS", 50);
		hourRates.put("PETROL-SCOOTER-HONDA", 60);
		hourRates.put("PETROL-GEAR BIKE-BAJAJ", 60);
		hourRates.put("PETROL-GEAR BIKE-YAMAHA", 65);
		hourRates.put("PETROL-GEAR BIKE-ROYAL ENFIELD", 60);
		hourRates.put("PETROL-SUPER BIKES-KAWASAKI", 200);
		hourRates.put("PETROL-SUPER BIKES-DUCATI", 190);
		hourRates.put("PETROL-SUPER BIKES-BMW", 210);

		hourRates.put("EV-SCOOTER-OLA", 20);
		hourRates.put("EV-SCOOTER-APRILLA", 30);
		hourRates.put("EV-SCOOTER-ATHER", 30);
		hourRates.put("EV-GEAR BIKE-MATTER", 70);
		hourRates.put("EV-GEAR BIKE-REVOLT", 75);
		hourRates.put("EV-GEAR BIKE-OBEN", 65);

		// Call key rent calculator
		return calculateKeyRent(dayRates, hourRates);
	}
}
	

