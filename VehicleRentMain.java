package rental;

import java.util.Scanner;

public class VehicleRentMain extends RentalAdapter {
	
	static Scanner sc= new Scanner(System.in);
	static RentalAdapter vehicle;
	
	//if it available asking the user to whether you want to rent this vehicle
	public static void rentResponse() {
		System.out.println("Do you want to rent this vehicle?(Yes/No)");
		String response=sc.nextLine();
		if(response.equalsIgnoreCase("yes")) {
			getCustomerDetails();
		}
		else {
			System.out.println("Thank You for visiting "+rentalName+" Rentals!");
		}
	}
	
	public static void checkReceipt() {
		System.out.println("Do you want to your receipt?(Yes/No)");
		String receipt = sc.next();
		if (receipt.equalsIgnoreCase("Yes")) {
			vehicle.printReceipt();
		} else {
			System.out.println("Thanks for supporting a paperless future and a healthier Earth!");
		}
	}
	
	public static void getCustomerDetails() {
		System.out.println("Please Enter Customer details...");
		System.out.println("Enter Customer Name: ");
		String customer_name = sc.nextLine();
		System.out.println("Enter Age: ");
		int age = sc.nextInt();
		sc.nextLine();
		if (age < 18) {
			System.out.println("Your are below age 18.. We are not provide for rentals..");
			sc.close();
			return;
		}
		System.out.println("Do you have License(Yes/No)?");
		String licenseAvl = sc.next();
		String licenseAvlType = "";
		if (licenseAvl.equalsIgnoreCase("Yes")) {
			System.out.println("Enter the license of Vehicle Type(Car/Bike/Truck)");
			licenseAvlType = sc.next();
			if(licenseAvlType.equalsIgnoreCase("car") || licenseAvlType.equalsIgnoreCase("bike") || licenseAvlType.equalsIgnoreCase("truck")) {
				System.out.println("License accepted for " + licenseAvlType + ". Proceeding with rental...");
			}
			else {
				System.out.println("License accepted only for bike, car and truck");
				return;
			}
		} 
		else { // if no license
			System.out.println("Without Driving License.. We would not provide vehicles for rentals");
			return;
		}
		System.out.println("ID Proof acceptable for renting \n Press 1. Aadhar, Press 2. Voter ID");
		System.out.println("Submit your ID Proof..");
		String idProof = sc.next();
		switch (idProof) {
		case "1":
			System.out.println(customer_name + " you have selected \"Aadhar\"");
			idProof = "Aadhar";
			break;
		case "2":
			System.out.println(customer_name + " you have selected \"Voter ID\" ");
			idProof = "Voter ID";
			break;
		default:
			System.out.println("Without ID Proof we are not provide for rentals...");
			sc.close();
			return;
		}
		System.out.println("Enter Contact Number: ");
		String contactNo = sc.next();
		if (contactNo.length() != 10) {
			System.out.println("Please provide 10 digit mobile number..");
			sc.close();
			return;
		}

		System.out.println("Enter the No of Days:");
		int noOfDays = sc.nextInt();
		sc.nextLine();
		if (noOfDays > MAX_NO_OF_DAYS) {
			System.out.println("We are not provide more than 10 days...");
			sc.close();
			return;
		}
		String rentVehicleType = "";
		// case for selecting normal or ev vehicles
		Customer customer = new Customer(idProof, customer_name, contactNo, age, noOfDays, licenseAvl,
				licenseAvlType, rentVehicleType);
		
		// customer has only bike license
		if (licenseAvlType.equalsIgnoreCase("Bike")) {
			System.out.println("You are eligible only for Bike Rentals..");
			rentVehicleType = "Bike";
			vehicle = new Bike(rentVehicleType, customer);
			vehicle.rentVehicleType();
			System.out.println("Rental Cost=" + vehicle.calculateRentalCost());
			checkReceipt();
		}
		// customer has car license - bike, car
		else if (licenseAvlType.equalsIgnoreCase("car")) {
			System.out.println("Available Vehicle Types");
			System.out.println("Press 1 --> Bike, Press 2 --> Car");
			System.out.println("Which type of Vehicle would you like to rental?");
			rentVehicleType = sc.next();
			switch (rentVehicleType) {
			case "1":
				rentVehicleType = "Bike";
				vehicle = new Bike(rentVehicleType, customer);
				vehicle.rentVehicleType();
				System.out.println("Rental Cost=" + vehicle.calculateRentalCost());
				checkReceipt();
				break;
			case "2":
				rentVehicleType = "Car";
				vehicle = new Car(rentVehicleType, customer);
				vehicle.rentVehicleType();
				System.out.println("Rental Cost=" + vehicle.calculateRentalCost());
				checkReceipt();
				break;
			default:
				System.out.println("You did not select any option!");
			}
		}

		// customer has truck license - bike, car and truck
		else if (licenseAvlType.equals("truck") || licenseAvlType.equals("Truck")) {
			System.out.println("Available Vehicle Types");
			System.out.println("Press 1 --> Bike, Press 2 --> Car, Press 3 --> Truck");
			System.out.println("Which type of Vehicle would you like to rental?");
			rentVehicleType = sc.next();
			switch (rentVehicleType) {
			case "1":
				rentVehicleType = "Bike";
				vehicle = new Bike(rentVehicleType, customer);
				vehicle.rentVehicleType();
				System.out.println("Rental Cost=" + vehicle.calculateRentalCost());
				checkReceipt();
				break;
				
			case "2":
				rentVehicleType = "Car";
				vehicle = new Car(rentVehicleType, customer);
				vehicle.rentVehicleType();
				System.out.println("Rental Cost=" + vehicle.calculateRentalCost());
				checkReceipt();
				break;
				
			case "3":
				rentVehicleType = "Truck";
				vehicle = new Truck(rentVehicleType, customer);
				vehicle.rentVehicleType();
				System.out.println("Rental Cost=" + vehicle.calculateRentalCost());
				checkReceipt();
				break;
				
			default:
				System.out.println("You did not select any option!");
			}
		}		
	}
	
	//main method()
	public static void main(String[] args) {
		System.out.println("--- Welcome to "+rentalName+" Rentals--- ");
		System.out.println("Press 1 --> Check Vehicle Available, Press 2 --> Rent Vehicle, Press 3 --> Exit");
		String doOperation = sc.next();
		sc.nextLine();
		boolean isRented=false;
		switch (doOperation) {

		// to check vehicles
		case "1":
			System.out.println("Enter the Vehicle Type: Press 1 --> Bike, Press 2 --> Car, Press 3 --> Truck");
			String vehicleType = sc.next();
			sc.nextLine();
			switch (vehicleType) {
			
			// check vehicles available
			case "1": // bike
				vehicleType = "Bike";
				Bike bike = new Bike(vehicleType);
				bike.showBikeBrandsList();
				System.out.println();
				System.out.println("Enter the Brand Name:");
				String bikeBrandAvl = sc.nextLine();
				bike.showBikeModelsList(bikeBrandAvl);
				System.out.println("Enter the Model Name: ");
				String bikeModelAvl = sc.nextLine();
				vehicle = new Bike(vehicleType, bikeBrandAvl, bikeModelAvl);
				isRented = bike.checkAvailability(bikeBrandAvl, bikeModelAvl);
				if (isRented) {
					System.out.println(bikeModelAvl + " is available.");
					isRented=false;
				} 
				else {
					System.out.println(bikeModelAvl + " is currently not available.");
					isRented=true;
				}
				if(isRented==false) {
					rentResponse();
				}
				break;
				
			case "2": // car
				vehicleType = "Car";
				Car car = new Car(vehicleType);
				car.showCarBrandsList(); //displaying all car brands
				System.out.println();
				System.out.println("Enter the Brand Name:");
				String carBrandAvl = sc.nextLine();
				car.showCarModelsList(carBrandAvl); //displaying all models of selected car brand
				System.out.println("Enter the Model Name: ");
				String carModelAvl = sc.nextLine();
				vehicle = new Car(vehicleType, carBrandAvl, carModelAvl);
				isRented = car.checkAvailability(carBrandAvl, carModelAvl);
				if (isRented) {
					System.out.println(carModelAvl + " is available.");
					isRented=false;
				} 
				else {
					System.out.println(carModelAvl + " is currently not available.");
					isRented=true;
				}
				if(isRented==false) {
					rentResponse();
				}
				break;
				
			case "3": // truck
				vehicleType = "Truck";
				Truck truck = new Truck(vehicleType);
				truck.showTruckBrandsList(); //displaying all truck brands
				System.out.println();
				System.out.println("Enter the Brand Name:");
				String truckBrandAvl = sc.nextLine();
				truck.showTruckModelsList(truckBrandAvl); //displaying all models of selected truck brand
				System.out.println("Enter the Model Name: ");
				String truckModel = sc.nextLine();
				vehicle = new Truck(vehicleType, truckBrandAvl, truckModel);
				isRented = truck.checkAvailability(truckBrandAvl, truckModel);
				if (isRented) {
					System.out.println(truckModel + " is available.");
					isRented=false;
				} else {
					System.out.println(truckModel + " is currently not available.");
					isRented=true;
				}
				if(isRented==false) {
					rentResponse();
				}
				break;
				
			}
			break;

		// rent vehicles
		case "2":
			getCustomerDetails();
			break;

		// if the user pressed exit option
		case "3":
			System.out.println("You have choose Exit Option!");
			System.out.println("Thank you for your precious time!");
			sc.close();
			return;

		// if the user enters wrong option
		default:
			System.out.println("Your option is Invalid!");
		}
		sc.close();
	}
}
