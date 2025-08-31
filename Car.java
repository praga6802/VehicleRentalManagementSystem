package rental;
import java.util.*;

import static rental.RentalRules.COMPANY_NAME;

public class Car extends Vehicle {
	String carBrand, carModel;
	double yearOfExperience;
	String fuelTypeOption = "";
	Vehicle vehicle;

	String[] carBrandList = { "HONDA", "HYUNDAI", // normal manual
			"MARUTI", "TATA", "KIA", // normal automatic
			"MAHINDRA", "TATA EV", "KIA EV" // EV automatic
	};

	String[][] carModelList = { { "HONDA Amaze", "HONDA City", "HONDA Civic" }, { "HYUNDAI i10", "HYUNDAI i20", "HYUNDAI Creta" },
			{ "MARUTI Baleno", "MARUTI Celerio", "MARUTI Dzire" }, { "TATA Curvv", "TATA Harrier", "TATA Altroz" },
			{ "KIA Seltos", "KIA Sonet", "KIA Syros" }, { "MAHINDRA BE 6", "MAHINDRA XEV 9e", "MAHINDRA XUV400" },
			{ "TATA Tiago EV", "TATA Nexon EV", "TATA Punch EV" }, { "KIA EV6", "KIA EV5", "KIA EV9 " } };
	// availability of car
	boolean[][] isRented = { { false, false, true }, { false, true, false },
			{ false, false, true }, { true, false, true }, { true, false, false }, { false, false, false },
			{ false, false, true }, { false, true, true } };


	double noOfDays;

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

	// for vehicle availability
	public Car(String vehicleType, String carBrand, String carModel) {
		super(vehicleType, carBrand, carModel);
	}

	public List<String> showCarBrandsList() {
		System.out.println("---Available " + getVehicleType() + " Brands---");
		String[] carBrands=carBrandList;
		List<String> carBrandsList= Arrays.asList(carBrands);
		for (int i = 0; i < carBrandsList.size(); i++) {
			System.out.print(carBrandsList.get(i));
			if (i < carBrands.length - 1) {
				System.out.print(", ");
			}
		}
		return carBrandsList;
	}

	public List<String> showCarModelsList(String carBrand) {
		List<String> models=new ArrayList<>();
		for (int i = 0; i < carBrandList.length; i++) {
			if (carBrandList[i].equalsIgnoreCase(carBrand)) { //our model and display name are same or not
				System.out.println("--- Available Models for " + carBrand + " ---");
				for (int j = 0; j < carModelList[i].length; j++) {
					System.out.print(carModelList[i][j]);
					if (j < carModelList[i].length - 1) {
						System.out.print(", ");
					}
					models.add(carModelList[i][j]);
				}
				System.out.println();
				break;
			}
		}
		return models;
	}

	public List<String> getRentVehicleDetails(String vehicleType){
		List<String> carBrands=showCarBrandsList();
		System.out.println();
		System.out.println("Enter the Brand Name:");
		String carBrand = sc.nextLine();
		while(!brandExists(carBrands,carBrand)){
			System.out.println("Brand Not Found!");
			System.out.println("Re-enter the Brand Name Again");
			carBrand=sc.nextLine();
		}
		for(String brand:carBrands){
			if(brand.equalsIgnoreCase(carBrand)){
				carBrand=brand;
			}
			break;
		}

		List<String> carModels=showCarModelsList(carBrand);
		System.out.println("\nEnter Model Name: ");
		String carModel = sc.nextLine();
		while(!modelExists(carModels,carModel)){
			System.out.println("Model Not found");
			System.out.println("Re-enter the model again");
			carModel=sc.nextLine();
		}
		for(String model: carModels){
			if(model.equalsIgnoreCase(carModel)){
				carModel=model;
				break;
			}
		}
		List<String> details=new ArrayList<String>();
		details.add(carBrand.trim());
		details.add(carModel.trim());
		return details;
	}
	public void checkAvailability(String vehicleType, String vehicleBrand, String vehicleModel) {
		for (int i = 0; i < carBrandList.length; i++) {
			if (carBrandList[i].equalsIgnoreCase(vehicleBrand)) {// checking out brand and this.brand is matching
				for (int j = 0; j < carModelList[i].length; j++) {
					if (carModelList[i][j].equalsIgnoreCase(vehicleModel)) {

						if (!isRented[i][j]) { // if it matches with model name & it checks for available
							System.out.println(vehicleModel+" is available..");
							return;
						} else {
							System.out.println(vehicleModel+ " is already rented!..");
							System.out.println("Do you want to see other vehicles?");
							String choice=sc.next();
							sc.nextLine();
							if(choice.equalsIgnoreCase("yes")){
								List<String> details=getRentVehicleDetails(getVehicleType());
								String newBrand=details.get(0);
								String newModel=details.get(1);
								checkAvailability(vehicleType,newBrand,newModel);
							}
							else
								System.out.println("Thank You!");
						}
					}
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
			System.out.println("Which type of car do you want? Press -- 1 Petrol, Press 2 --> EV Cars");
			fuelTypeOption = sc.nextLine();
			switch (fuelTypeOption) {
				// case for Normal Car
				case "1":
					setFuelType("Petrol");
					System.out.println("Which type of gear system do you want?");
					System.out.println("Press 1 --> Manual Gear, Press 2 --> Automatic Gear");
					vehicleTypeOption = sc.next();
					switch (vehicleTypeOption) {
						// case normal manual gear
						case "1":
							setVehicleSubType("Manual Gear");
							handleBrandSelection(getFuelType(), getVehicleSubType());
							break;
						case "2":
							setVehicleSubType("Automatic Gear");
							handleBrandSelection(getFuelType(), getVehicleSubType());
							break;
						default:
							System.out.println("You didn't select a valid Petrol " + getVehicleType() + " option.");
					}
					break;
				case "2":
					setFuelType("EV");
					setVehicleSubType("Automatic Gear");
				default:
					System.out.println("Invalid Option selected..");
			}
		}
		else {
			System.out.println("Experience is less than 6 months! Sorry we wont provide car rentals!");
		}
	}
	public void handleBrandSelection(String fuelType, String carSubType) {
		if (fuelType.equalsIgnoreCase("Petrol")) {
			if (carSubType.equalsIgnoreCase("Manual Gear")) {
				setFuelType(fuelType);
				setVehicleSubType(carSubType);
				System.out.println("Which Brand do you want?");
				System.out.println("Press 1 --> HONDA, Press 2 --> HYUNDAI");
				brandTypeOption = sc.next();
				// case for normal manual brand
				switch (brandTypeOption) {
					// case for HONDA
					case "1":
						setVehicleBrand("HONDA");
						chooseVehicleModel(getVehicleBrand(), new String[]{"Amaze", "City", "Civic"});
						break;
					case "2":
						setVehicleBrand("HYUNDAI");
						chooseVehicleModel(getVehicleBrand(), new String[]{"i20", "i10", "Creta"});
						break;
					case "3":
						setVehicleBrand("");
					default:
						System.out.println("You did not selected any " + getVehicleType() + " under " + getVehicleSubType());
				}
			} else if (getVehicleSubType().equalsIgnoreCase("Automatic Gear")) {
				System.out.println("Which Brand do you want?");
				System.out.println("Press 1 --> MARUTI, Press 2 --> TATA, Press 3 --> KIA");
				brandTypeOption = sc.next();
				// case for normal manual brand
				switch (brandTypeOption) {
					// case for MARUTI Automatic
					case "1":
						setVehicleBrand("MARUTI");
						chooseVehicleModel(getVehicleBrand(), new String[]{"Baleno", "Celerio", "Dzire"});
						break;
					case "2":
						setVehicleBrand("TATA");
						chooseVehicleModel(getVehicleBrand(), new String[]{"Curvv", "Harrier", "Altroz"});
						break;
					case "3":
						setVehicleBrand("KIA");
						chooseVehicleModel(getVehicleBrand(), new String[]{"Seltos", "Sonet", "Syros"});
						break;
					default:
						System.out.println("You did not selected any " + getVehicleType() + " under " + getVehicleSubType());

				}
			} else {
				System.out.println("You did not select any" + getVehicleType() + " under " + getFuelType());
			}
		}
		else if (fuelType.equalsIgnoreCase("EV")) {
			setFuelType(fuelType);
			setVehicleSubType(carSubType);
			System.out.println("Which Brand do you want?");
			System.out.println("Press 1 --> MARUTI, Press 2 --> TATA, Press 3 --> KIA");
			brandTypeOption = sc.next();
			// case for normal manual brand
			switch (brandTypeOption) {
				case "1":
					setVehicleBrand("MAHINDRA");
					chooseVehicleModel(getVehicleBrand(), new String[]{"BE 6", "XEV 9E", "XUV400"});
					break;
				case "2":
					setVehicleBrand("TATA");
					chooseVehicleModel(getVehicleBrand(), new String[]{"Tiago EV", "Nexon EV", "Punch EV"});
					break;
				case "3":
					setVehicleBrand("KIA");
					chooseVehicleModel(getVehicleBrand(), new String[]{"EV6", "EV5", "EV9"});
					break;

				default:
					System.out.println("You did not select any" + getVehicleType() + " under " + getFuelType());
			}
		}
		else {
			System.out.println("Invalid option - You entered wrong option under" + getVehicleType());
		}
	}

	//calculate rental cost for car
	public double calculateRentalCost() {
		Map<String, Integer> dayRates = new HashMap<>();
		Map<String, Integer> hourRates = new HashMap<>();

		dayRates.put("Petrol-Manual Gear-HONDA", 1000);
		dayRates.put("Petrol-Manual Gear-HYUNDAI", 2000);
		dayRates.put("Petrol-Automatic Gear-MARUTI", 2500);
		dayRates.put("Petrol-Automatic Gear-TATA", 2700);
		dayRates.put("Petrol-Automatic Gear-KIA", 3000);
		dayRates.put("Petrol-EV-MARUTI", 600);
		dayRates.put("Petrol-EV-TATA", 800);
		dayRates.put("Petrol-EV-KIA", 1000);

		hourRates.put("Petrol-Manual Gear-HONDA", 300);
		hourRates.put("Petrol-Manual Gear-HYUNDAI", 600);
		hourRates.put("Petrol-Automatic Gear-MARUTI", 450);
		hourRates.put("Petrol-Automatic Gear-TATA", 400);
		hourRates.put("Petrol-Automatic Gear-KIA", 500);
		hourRates.put("Petrol-EV-MARUTI", 200);
		hourRates.put("Petrol-EV-TATA", 300);
		hourRates.put("Petrol-EV-KIA", 400);
		return calculateKeyRent(dayRates, hourRates);
	}
}
