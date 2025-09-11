package rental;
import java.util.*;
import java.util.stream.Collectors;

import static rental.RentalRules.COMPANY_NAME;

public class Car extends Vehicle {
	String carBrand, carModel;
	double yearOfExperience;
	String fuelTypeOption = "";
	Vehicle vehicle;

	List<String> carBrands = Arrays.asList(
			"HONDA", "HYUNDAI", "MARUTI", "TATA", "KIA", "MAHINDRA", "TATA EV", "KIA EV"
	);

	String[][] carModels = {
			{"Amaze", "City", "Civic"},          // HONDA
			{"i10", "i20", "Creta"},             // HYUNDAI
			{"Baleno", "Celerio", "Dzire"},      // MARUTI
			{"Curvv", "Harrier", "Altroz"},      // TATA
			{"Seltos", "Sonet", "Syros"},        // KIA
			{"BE 6", "XEV 9e", "XUV400"},        // MAHINDRA
			{"Tiago EV", "Nexon EV", "Punch EV"},// TATA EV
			{"EV6", "EV5", "EV9"}                 // KIA EV
	};

	// availability of car
	boolean[][] isRented = {{false, false, true}, {false, true, false},
			{false, false, true}, {true, false, true}, {true, false, false}, {false, false, false},
			{false, false, true}, {false, true, true}};

	Map<String, List<String>> carModelMap = new HashMap<>();

	double noOfDays;
	private int seats;

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	// Constructors
	// for renting car
	public Car(String vehicleType, Customer customer) {
		super(vehicleType, customer);
		this.noOfDays = customer.getNoOfDays();
	}

	//car availability
	public Car(String vehicleType) {
		super(vehicleType);
	}

	// for add new car
	public Car(String id, String brand, String carMode, String model, FuelPricing fuelPrice, int seats, boolean isRented) {
		super(id, brand, carMode, model, fuelPrice, isRented);
		this.seats = seats;
	}

	public String getVehicleType() {
		return "car";
	}

	// for vehicle availability
	public Car(String vehicleType, String carBrand, String carModel) {
		super(vehicleType, carBrand, carModel);
	}

	public List<String> showCarBrandsList() {
		System.out.println("---Available " + getVehicleType() + " Brands---");
		List<String> carBrandList = carBrands.stream().sorted().collect(Collectors.toList());
		System.out.print(String.join(",", carBrandList));
		return carBrandList;
	}

	public void initializeCarModelMap() {
		for (int i = 0; i < carBrands.size(); i++) {
			carModelMap.put(carBrands.get(i), Arrays.asList(carModels[i]));
		}
	}

	public List<String> showCarModelList(String carBrand) {
		System.out.println("Available models for " + carBrand);
		return carModelMap.getOrDefault(carBrand, Collections.emptyList());
	}


	public List<String> getRentVehicleDetails(String vehicleType) {

		for (int i = 0; i < carBrands.size(); i++) {
			System.out.println("Press " + (i + 1) + "-> " + carBrands.get(i));
		}
		String brandChoice = sc.nextLine();
		try {
			int index = Integer.parseInt(brandChoice) - 1;
			if (index >= 0 && index < carBrands.size()) {
				String carBrand = carBrands.get(index);
				setVehicleBrand(carBrand);
			} else {
				System.out.println("Please enter valid number");
				return getRentVehicleDetails(vehicleType); // retry brand selection
			}
		} catch (NumberFormatException n) {
			System.out.println("Invalid Input, Enter a Number");
			return getRentVehicleDetails(vehicleType); // retry brand selection
		}

		//getting all models
		initializeCarModelMap();
		List<String> availableModels = showCarModelList(getVehicleBrand());
		for (int i = 0; i < availableModels.size(); i++) {
			System.out.println("Press " + (i + 1) + "-> " + availableModels.get(i));
		}

		String choice = sc.nextLine();
		try {
			int index = Integer.parseInt(choice) - 1;
			if (index >= 0 && index < availableModels.size()) {
				String carModel = availableModels.get(index);
				setVehicleModel(carModel);
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

	public void checkAvailability(String vehicleType, String brand, String model) {
		int brandIndex = carBrands.indexOf(brand);
		int modelIndex = Arrays.asList(carModels[brandIndex]).indexOf(model);

		// check if rented
		if (!isRented[brandIndex][modelIndex]) {
			System.out.println(model + " is available..");
		} else {
			System.out.println("\n" + model + " is already rented!..");

			while (true) {
				System.out.println("Do you want to see other car? (yes/no)");
				String choice = sc.nextLine();

				if (choice.equalsIgnoreCase("yes")) {
					List<String> newSelection = getRentVehicleDetails(vehicleType);
					// Recursively check availability for the new selection
					checkAvailability(vehicleType, newSelection.get(0), newSelection.get(1));
					break; // exit current loop after recursive check
				} else if (choice.equalsIgnoreCase("no")) {
					System.out.println("Thank You!");
					break; // exit method
				} else {
					System.out.println("Invalid Input, Enter yes or no");
				}
			}
		}
	}


	// rent for car
	public void rentVehicleType() {
		System.out.println("Enter years of Experience (Min Exp. 6 Months): ");
		yearOfExperience = sc.nextDouble();
		sc.nextLine();
		if (yearOfExperience >= 0.6) {
			while (true) {
				try {
					System.out.println("Which type of car do you want? Press -- 1 Petrol, Press 2 --> EV Cars");
					fuelTypeOption = sc.nextLine();
					if (fuelTypeOption.equals("1")) {
						setFuelType("Petrol");
						while (true) {
							try {
								System.out.println("Which type of gear system do you want?");
								System.out.println("Press 1 --> Manual Gear, Press 2 --> Automatic Gear");
								vehicleTypeOption = sc.next();
								if (vehicleTypeOption.equals("1")) {
									setVehicleSubType("Manual Gear");
									handleBrandSelection(getFuelType(), getVehicleSubType());
									break;
								} else if (vehicleTypeOption.equals("2")) {
									setVehicleSubType("Automatic Gear");
									handleBrandSelection(getFuelType(), getVehicleSubType());
									break;
								} else {
									System.out.println("Invalid Option.. Please Try again");
								}
							} catch (NumberFormatException n) {
								System.out.println("Invalid Input, Please enter a number");
							}
						}
						break;
					} else if (fuelTypeOption.equals("2")) {
						setFuelType("EV");
						setVehicleSubType("Automatic Gear");
						handleBrandSelection(getFuelType(),getVehicleSubType());
						break;
					} else {
						System.out.println("Invalid number, Please try again");
					}
				} catch (NumberFormatException n) {
					System.out.println("Invalid Input, Please try again..");
				}
			}
		} else {
			System.out.println("Experience is less than 6 months! Sorry we wont provide car rentals!");
		}
	}

	public void handleBrandSelection(String fuelType, String carSubType) {

		List<String> carBrand = new ArrayList<>();
		if (fuelType.equalsIgnoreCase("petrol") && carSubType.equalsIgnoreCase("Manual Gear")) {
			carBrand = Arrays.asList("Honda", "Suzuki");
		} else if (fuelType.equalsIgnoreCase("petrol") && carSubType.equalsIgnoreCase("Automatic Gear")) {
			carBrand = Arrays.asList("Maruti", "TATA", "KIA");
		} else if (fuelType.equalsIgnoreCase("EV") && carSubType.equalsIgnoreCase("Automatic Gear")) {
			carBrand = Arrays.asList("Maruti", "TATA", "KIA");
		}

		while (true) {
			System.out.println("Which brand do you want?");
			for (int i = 0; i < carBrand.size(); i++) {
				System.out.println("Press " + (i + 1) + " ->" + carBrand.get(i));
			}
			String choice = sc.nextLine();

			try {
				int index = Integer.parseInt(choice) - 1;
				if (index >= 0 && index < carBrand.size()) {
					String selectBrand = carBrand.get(index);
					setVehicleBrand(selectBrand);

					int selectBrandIndex = carBrand.indexOf(selectBrand);
					String[] models = carModels[selectBrandIndex];

					List<String> modelList = Arrays.asList(models);
					chooseVehicleModel(selectBrand, modelList);
					break;
				} else {
					System.out.println("Invalid Option! Please try again");
				}
			} catch (NumberFormatException n) {
				System.out.println("Invalid input, pLease Enter a number");

			}
		}
	}

	public void chooseVehicleModel(String brand, List<String> models) {
		initializeCarModelMap();
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
				String carModel = models.get(index);
				setVehicleModel(carModel);
				System.out.println("You selected " + brand + " " + carModel);
			} else {
				System.out.println("Invalid Option");
			}
		} catch (NumberFormatException n) {
			System.out.println("Invalid Input, Please enter number");
		}

	}

	//calculate rental cost for car
	public double calculateRentalCost() {
		// Day rates
		Map<String, Integer> dayRates = new HashMap<>();
		dayRates.put("PETROL-MANUAL GEAR-HONDA", 1000);
		dayRates.put("PETROL-MANUAL GEAR-HYUNDAI", 2000);
		dayRates.put("PETROL-AUTOMATIC GEAR-MARUTI", 2500);
		dayRates.put("PETROL-AUTOMATIC GEAR-TATA", 2700);
		dayRates.put("PETROL-AUTOMATIC GEAR-KIA", 3000);
		dayRates.put("EV-AUTOMATIC GEAR-MARUTI", 600);
		dayRates.put("EV-AUTOMATIC GEAR-TATA", 800);
		dayRates.put("EV-AUTOMATIC GEAR-KIA", 1000);

		// Hourly rates
		Map<String, Integer> hourRates = new HashMap<>();
		hourRates.put("PETROL-MANUAL GEAR-HONDA", 300);
		hourRates.put("PETROL-MANUAL GEAR-HYUNDAI", 600);
		hourRates.put("PETROL-AUTOMATIC GEAR-MARUTI", 450);
		hourRates.put("PETROL-AUTOMATIC GEAR-TATA", 400);
		hourRates.put("PETROL-AUTOMATIC GEAR-KIA", 500);
		hourRates.put("EV-AUTOMATIC GEAR-MARUTI", 200);
		hourRates.put("EV-AUTOMATIC GEAR-TATA", 300);
		hourRates.put("EV-AUTOMATIC GEAR-KIA", 400);

		return calculateKeyRent(dayRates,hourRates);
	}
}
