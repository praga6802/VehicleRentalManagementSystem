package rental;
import java.util.*;

import static rental.RentalRules.COMPANY_NAME;

public class Bike extends Vehicle {

	Scanner sc = new Scanner(System.in);
	String[] bikeBrands = {"Suzuki", "Honda", "TVS", "Bajaj", "Yamaha", "Royal Enfield", "Kawasaki", "Ducati", "BMW",
			"Ola", "Aprilla", "Ather", "Matter", "Revolt", "Oben"};

	String[][] bikeModels = {{"Suzuki Access 125", "Suzuki Burgmann Street", "Suzuki Avenis"}, // suzuki scooters
			{"Honda Activa 110", "Honda Activa 125", "Honda Dio 125"}, // honda scooters
			{"TVS Jupiter 125", "TVS NTORQ 125", "TVS ZEST 125"}, // tvs scooters
			{"Bajaj Pulsar 150", "Bajaj Pulsar 220", "Bajaj Dominor 400"}, // bajaj
			{"Yamaha FZ X", "Yamaha MT 15", "Yamaha R15 V4"}, // yamaha
			{"Royal Enfield Classic 350", "Royal Enfield Meteor 650", "Royal Enfield Hunter 350", "Royal Enfield Interceptor 650"}, // royal enfield
			{"KAWASAKI NINJA H2R", "KAWASAKI NINJA ZX-10R", "KAWASAKI NINJA H2 SX"},
			{"DUCATI PANIGALE V4", "DUCATI PANIGALE V4R", "DUCATI STREET FIGHTER V2"},
			{"BMW M 1000 XR", "BMW S 1000 R", "BMW M 1000 RR"}, {"OLA S1 Pro+", "OLA S1 Air", "OLA Gig"},
			{"Aprilla Typhoon"}, {"ATHER 450 S", "ATHER 450 X", "ATHER 450 APEX"},
			{"MATTER AERA 5000", "MATTER AERA 5000+"}, {"REVOLT RV400"}, {"OBEN RORR"}

	};

	// availability of bikes
	boolean[][] isRented = {{false, false, true}, // suzuki scooters
			{false, false, false}, // honda scooters
			{false, true, false}, // tvs scooters
			{false, false, false}, // bajaj
			{true, false, false}, // yamaha
			{false, false, false}, // royal enfield
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

	// for vehicle availability
	public Bike(String vehicleType, String bikeBrand, String bikeModel) {
		super(vehicleType, bikeBrand, bikeModel);
	}

	// getting all brands
	public String[] getBikeBrands() {
		return bikeBrands;
	}

	// getting all bike models
	public String[][] getBikeModels() {
		return bikeModels;
	}


	//show all bike brands
	public List<String> showBikeBrandsList() {
		System.out.println("---Available " + getVehicleType() + " Brands---");
		String[] brands = bikeBrands;
		List<String> bikeBrandsList = Arrays.asList(brands);
		for (int i = 0; i < bikeBrandsList.size(); i++) {
			System.out.print(bikeBrandsList.get(i));
			if (i < bikeBrandsList.size() - 1)
				System.out.print(",");
		}
		System.out.println();
		return bikeBrandsList;
	}

	//show all the bike brands
	public List<String> showBikeModelsList(String bikeBrand) {
		String[] bikeBrandsList = bikeBrands;
		String[][] bikeModelsList = bikeModels;
		List<String> model = new ArrayList<>();

		for (int i = 0; i < bikeBrandsList.length; i++) {
			if (bikeBrandsList[i].equalsIgnoreCase(bikeBrand)) {
				System.out.println("--- Available Models for " + bikeBrand + " ---");
				for (int j = 0; j < bikeModelsList[i].length; j++) {
					System.out.print(bikeModelsList[i][j]);
					if (j < bikeModelsList[i].length - 1) {
						System.out.print(", ");
					}
					model.add(bikeModelsList[i][j]);
				}
				System.out.println();
				break;
			}
		}
		return model;
	}

	public List<String> getRentVehicleDetails(String vehicleType) {

		List<String> availableBrands = showBikeBrandsList();

		System.out.println("\nEnter the Brand Name:");
		String bikeBrand = sc.nextLine();
		while (!brandExists(availableBrands, bikeBrand)) {
			System.out.println("Brand Not Found!");
			System.out.println("Re-enter the brand name");
			bikeBrand = sc.nextLine();
		}

		for (String brand : availableBrands) {
			if (brand.equalsIgnoreCase(bikeBrand))
				bikeBrand = brand;
			break;
		}

		List<String> availableModels = showBikeModelsList(bikeBrand);
		System.out.println("\nEnter Model Name: ");
		String bikeModel = sc.nextLine();

		while (!modelExists(availableModels, bikeModel)) {
			System.out.println("Model Not Found");
			System.out.println("Re- Enter the Brand model again..");
			bikeModel = sc.nextLine();
			//return new ArrayList<>();
		}

		for (String model : availableModels) {
			if (model.equalsIgnoreCase(bikeModel))
				bikeModel = model;
			break;
		}
		List<String> details = new ArrayList<String>();
		details.add(bikeBrand);
		details.add(bikeModel);
		return details;
	}

	// check availability for bike
	public void checkAvailability(String vehicleType, String bikeBrand, String bikeModel) {
		for (int i = 0; i < bikeBrands.length; i++) {
			if (bikeBrands[i].equalsIgnoreCase(bikeBrand)) {// checking out brand and this.brand is matching
				for (int j = 0; j < bikeModels[i].length; j++) {
					if (bikeModels[i][j].equalsIgnoreCase(bikeModel)) {
						if (!isRented[i][j]) { // if it matches with model name & it checks for available
							System.out.println("\n" + bikeModel + " is available..");
							return;
						} else {
							System.out.println("\n" + bikeModel + " is already rented!..");
							System.out.println("Do you want to see other bike?");
							String choice = sc.next();
							if (choice.equalsIgnoreCase("yes")) {
								List<String> details = getRentVehicleDetails(getVehicleType());
								String newBrand = details.get(0);
								String newModel = details.get(1);
								checkAvailability(vehicleType, newBrand, newModel);
							} else {
								System.out.println("Thank you!");
							}
						}
					}
				}
			}
		}
	}

	// rent for bike
	public void rentVehicleType() {
		System.out.println("Which mode of bike do you want? Press -- 1 Petrol or Press 2 --> EV Bikes");
		fuelTypeOption = sc.nextLine();
		switch (fuelTypeOption) {
			// case Normal Bikes
			case "1":
				setFuelType("Petrol");
				System.out.println("What type of bike do you want?");
				System.out.println("Press 1 --> Scooter, Press 2 --> Gear Bike, Press 3 --> Super Bikes");
				vehicleTypeOption = sc.next();
				switch (vehicleTypeOption) {
					// case scooters
					case "1":
						setVehicleSubType("Scooter");
						handleBrandSelection(getFuelType(), getVehicleSubType());
						break;
					case "2":
						setVehicleSubType("Gear Bike");
						handleBrandSelection(getFuelType(), getVehicleSubType());
						break;
					case "3":
						setVehicleSubType("Super Bikes");
						handleBrandSelection(getFuelType(), getVehicleSubType());
						break;
					default:
						System.out.println("You didn't select a valid Petrol "+getVehicleType()+" option.");
				}
				break;
			case "2":
				setFuelType("EV");
				System.out.println("What type of EV-Bike do you want?");
				System.out.println("Press 1 --> Scooter, Press 2 --> Gear Bike");
				vehicleTypeOption = sc.next();
				switch (vehicleTypeOption) {
					// case ev scooter
					case "1":
						setVehicleSubType("Scooter");
						handleBrandSelection(getFuelType(), getVehicleSubType());
						break;
					case "2":
						setVehicleSubType("Gear Bike");
						handleBrandSelection(getFuelType(), getVehicleSubType());
						break;
					default:
						System.out.println("You didn't select a valid EV bike option.");
				}
			default:
				System.out.println("Invalid Option, Please select the correct option!");
		}
	}

	public void handleBrandSelection(String fuelType, String vehicleSubType) {
		setFuelType(fuelType);
		setVehicleSubType(vehicleSubType);
		if (fuelType.equalsIgnoreCase("Petrol")) {
			if (vehicleSubType.equalsIgnoreCase("Scooter")) {
				System.out.println("Which Brand do you want?");
				System.out.println("Press 1 --> SUZUKI, Press 2 --> TVS, Press 3 --> HONDA");
				brandTypeOption = sc.next();
				switch (brandTypeOption) {
					// Suzuki Scooters
					case "1":
						setVehicleBrand("SUZUKI");
						chooseVehicleModel(getVehicleBrand(), new String[]{"Access 125", "Avenis", "Burgmann Street"});
						break;
					case "2":
						setVehicleBrand("TVS");
						chooseVehicleModel(getVehicleBrand(), new String[]{"Jupiter 125", "Ntorq 125", "Zest 125"});
						break;
					case "3":
						setVehicleBrand("HONDA");
						chooseVehicleModel(getVehicleBrand(), new String[]{"Activa i10", "Activa 125", "Dio 125"});
					default:
						System.out.println("You did not selected any " + getVehicleType() + " under " + getFuelType() + " type");
				}
			} else if (vehicleSubType.equalsIgnoreCase("Gear Bike")) {
				System.out.println("Which Brand do you want?");
				System.out.println("Press 1 --> BAJAJ, Press 2 --> YAMAHA, Press 3 --> ROYAL ENFIELD");
				brandTypeOption = sc.next();
				switch (brandTypeOption) {
					case "1":
						setVehicleBrand("BAJAJ");
						chooseVehicleModel(getVehicleBrand(), new String[]{"Pulsar 150", "Pulsar 220", "Dominar 400"});
						break;
					case "2":
						setVehicleBrand("YAMAHA");
						chooseVehicleModel(getVehicleBrand(), new String[]{"FZ X", "MT 15", "R15 V4"});
						break;
					case "3":
						setVehicleBrand("ROYAL ENFIELD");
						chooseVehicleModel(getVehicleBrand(), new String[]{"Classic 350", "Meteor 650", "hunter 350", "Interceptor 650"});
						break;
					default:
						System.out.println("You didn't select any " + getVehicleType() + " under " + getFuelType() + " type");
				}
			} else if (vehicleSubType.equalsIgnoreCase("Super Bikes")) {
				System.out.println("Which Brand do you want?");
				System.out.println("Press 1 --> KAWASAKI, Press 2 --> DUCATI, Press 3 --> BMW");
				vehicleTypeOption = sc.next();
				switch (vehicleTypeOption) {
					case "1":
						setVehicleBrand("KAWASKI");
						chooseVehicleModel(getVehicleBrand(), new String[]{"Ninja H2R", "Ninja ZX-10R", "Ninja H2 SX"});
						break;
					case "2":
						setVehicleBrand("DUCATI");
						chooseVehicleModel(getVehicleBrand(), new String[]{"Paningale V4", "Paningale V4 R", "Street Fighter V2"});
						break;
					case "3":
						setVehicleBrand("BMW");
						chooseVehicleModel(getVehicleBrand(), new String[]{"M 1000 XR", "S 1000 R", "M 1000 RR"});
						break;
					default:
						System.out.println("You didn't select any " + getVehicleType() + " under " + getFuelType() + " type");
				}
			}
		} else if (fuelType.equalsIgnoreCase("EV")) {
			if (vehicleSubType.equalsIgnoreCase("Scooter")) {
				System.out.println("Which Brand do you want?");
				System.out.println("Press 1 --> OLA, Press 2 --> APRILIA, Press 3 --> ATHER");
				brandTypeOption = sc.next();
				switch (brandTypeOption) {
					case "1":
						setVehicleBrand("OLA");
						chooseVehicleModel(getVehicleBrand(), new String[]{"S1 Pro", "S1 Pro+", "Gig"});
						break;
					case "2":
						setVehicleBrand("APRILIA");
						chooseVehicleModel(getVehicleBrand(), new String[]{"SR", "Typhoon"});
						break;
					case "3":
						setVehicleBrand("ATHER");
						chooseVehicleModel(getVehicleBrand(), new String[]{"450 S", "450 X", "450 Apex"});
						break;
					default:
						System.out.println("You didn't select any " + getVehicleType() + " under " + getFuelType() + " type");

				}
			} else if (vehicleSubType.equalsIgnoreCase("Gear Bike")) {
				System.out.println("Which Brand do you want?");
				System.out.println("Press 1 --> MATTER, Press 2 --> REVOLT, Press 3 --> OBEN");
				brandTypeOption = sc.next();
				switch (brandTypeOption) {
					case "1":
						setVehicleBrand("MATTER");
						chooseVehicleModel(getVehicleBrand(), new String[]{"Aera 5000", "Aera 5000+"});
						break;
					case "2":
						setVehicleBrand("REVOLT");
						chooseVehicleModel(getVehicleBrand(), new String[]{"Rv400"});
						break;
					case "3":
						setVehicleBrand("OBEN");
						chooseVehicleModel(getVehicleBrand(), new String[]{"RORR"});
					default:
						System.out.println("You didn't select any " + getVehicleType() + " under " + getFuelType() + " type");
				}
			}
		} else {
			System.out.println("You didn't select any option from bike category");
		}
	}

	//calculate rental cost for bike
	public double calculateRentalCost() {
		Map<String, Integer> dayRates = new HashMap<>();
		Map<String, Integer> hourRates = new HashMap<>();
		dayRates.put("Petrol-Scooter-SUZUKI", 400);
		dayRates.put("Petrol-Scooter-TVS", 400);
		dayRates.put("Petrol-Scooter-HONDA", 450);
		dayRates.put("Petrol-Gear Bike-BAJAJ", 500);
		dayRates.put("Petrol-Gear Bike-YAMAHA", 550);
		dayRates.put("Petrol-Gear Bike-ROYAL ENFIELD", 600);
		dayRates.put("Petrol-Super Bikes-KAWASAKI", 900);
		dayRates.put("Petrol-Super Bikes-DUCATI", 850);
		dayRates.put("Petrol-Super Bikes-BMW", 950);
		dayRates.put("EV-Scooter-OLA", 200);
		dayRates.put("EV-Scooter-APRILIA", 230);
		dayRates.put("EV-Scooter-ATHER", 250);
		dayRates.put("EV-Gear Bike-MATTER", 300);
		dayRates.put("EV-Gear Bike-REVOLT", 270);
		dayRates.put("EV-Gear Bike-OBEN", 240);

		hourRates.put("Petrol-Scooter-SUZUKI", 50);
		hourRates.put("Petrol-Scooter-TVS", 50);
		hourRates.put("Petrol-Scooter-HONDA", 60);
		hourRates.put("Petrol-Gear Bike-BAJAJ", 60);
		hourRates.put("Petrol-Gear Bike-YAMAHA", 65);
		hourRates.put("Petrol-Gear Bike-ROYAL ENFIELD", 60);
		hourRates.put("Petrol-Super Bikes-KAWASAKI", 200);
		hourRates.put("Petrol-Super Bikes-DUCATI", 190);
		hourRates.put("Petrol-Super Bikes-BMW", 210);
		hourRates.put("EV-Scooter-OLA", 20);
		hourRates.put("EV-Scooter-APRILIA", 30);
		hourRates.put("EV-Scooter-ATHER", 30);
		hourRates.put("EV-Gear Bike-MATTER", 70);
		hourRates.put("EV-Gear Bike-REVOLT", 75);
		hourRates.put("EV-Gear Bike-OBEN", 65);
		return calculateKeyRent(dayRates,hourRates);
	}
}
