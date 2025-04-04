package rental;

import java.util.Scanner;

public class VehicleRentMain extends RentalAdapter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		RentalAdapter vehicle;
		System.out.println("Welcome to "+rentalName+"..");
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
				System.out.println();
				System.out.println("Enter Model Name: ");
				String bikemodelAvl = sc.nextLine();
				vehicle = new Bike(vehicleType, bikeBrandAvl, bikemodelAvl);
				isRented = bike.checkAvailability(bikeBrandAvl, bikemodelAvl);
				if (isRented) {
					System.out.println(bikemodelAvl + " is available.");
				} 
				else {
					System.out.println(bikemodelAvl + " is currently not available.");
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
				System.out.println();
				System.out.println("Enter Model Name: ");
				String carmodelAvl = sc.nextLine();
				vehicle = new Bike(vehicleType, carmodelAvl, carmodelAvl);
				isRented = car.checkAvailability(carmodelAvl, carmodelAvl);
				if (isRented) {
					System.out.println(carmodelAvl + " is available.");
				} 
				else {
					System.out.println(carmodelAvl + " is currently not available.");
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
				System.out.println();
				System.out.println("Enter Model Name: ");
				String truckmodel = sc.nextLine();
				vehicle = new Truck(vehicleType, truckBrandAvl, truckmodel);
				isRented = truck.checkAvailability(truckBrandAvl, truckmodel);
				if (isRented) {
					System.out.println(truckmodel + " is available.");
				} else {
					System.out.println(truckmodel + " is currently not available.");
				}
				break;
			}
			break;

		// rent vehicles
		case "2":
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
			String licenseavl = sc.next();
			String licenseavltype = "";
			if (licenseavl.equals("Yes") || licenseavl.equals("yes")) {
				System.out.println("Enter the license of Vehicle Type(Car/Bike/Truck)");
				licenseavltype = sc.next();
			} else {
				System.out.println("Without Driving License.. We would not provide vehicles for rentals");
				sc.close();
				return;
			}
			System.out.println("ID Proof acceptable for renting \n Press 1. Aadhar, Press 2. Voter ID");
			System.out.println("Submit your ID Proof..");
			String idproof = sc.next();
			switch (idproof) {
			case "1":
				System.out.println(customer_name + " have selected \"Aadhar\"");
				idproof = "Aadhar";
				break;
			case "2":
				System.out.println(customer_name + " have selected \"Voter ID\" ");
				idproof = "Voter ID";
				break;
			default:
				System.out.println("Without ID Proof we are not provide for rentals...");
				sc.close();
				return;
			}
			System.out.println("Enter Contact Number: ");
			String contactno = sc.next();
			if (contactno.length() != 10) {
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
			String receipt = "";

			Customer customer = new Customer(idproof, customer_name, contactno, age, noOfDays, licenseavl,
					licenseavltype, rentVehicleType);
			// customer.enterCustomerDetails();
			// customer has only bike license
			if (licenseavltype.equals("Bike") || licenseavltype.equals("bike")) {
				System.out.println("You are eligible only for Bike Rentals..");
				rentVehicleType = "Bike";
				vehicle = new Bike(rentVehicleType, customer);
				vehicle.rentVehicleType();
				System.out.println("Rental Cost=" + vehicle.calculateRentalCost());
				System.out.println("Do you want to your receipt?(Yes/No)");
				receipt = sc.next();
				if (receipt.equals("yes") || receipt.equals("Yes")) {
					vehicle.printReceipt();
				} else {
					System.out.println("Thank you for keeping green environment");
				}
			}
			// customer has car license - bike, car
			else if (licenseavltype.equals("Car") || licenseavltype.equals("car")) {
				System.out.println("Available Vehicle Types");
				System.out.println("Press 1 --> Bike, Press 2 --> Car");
				System.out.println("Which type of Vehicle would you like to rental?");
				rentVehicleType = sc.next();
				switch (rentVehicleType) {
				case "1":

					vehicle = new Bike(rentVehicleType, customer);
					vehicle.rentVehicleType();
					System.out.println("Rental Cost=" + vehicle.calculateRentalCost());
					System.out.println("Do you want to your receipt?(Yes/No)");
					receipt = sc.next();
					if (receipt.equals("yes") || receipt.equals("Yes")) {
						vehicle.printReceipt();
					} else {
						System.out.println("Thank you for keeping green environment");
					}
					break;
				case "2":
					rentVehicleType = "Car";
					vehicle = new Car(rentVehicleType, customer);
					vehicle.rentVehicleType();
					System.out.println("Rental Cost=" + vehicle.calculateRentalCost());
					System.out.println("Do you want to your receipt?(Yes/No)");
					receipt = sc.next();
					if (receipt.equals("yes") || receipt.equals("Yes")) {
						vehicle.printReceipt();
					} else {
						System.out.println("Thank you for keeping green environment");
					}
					break;
				default:
					System.out.println("You did not select any option!");
				}
			}

			// customer has truck license - bike, car and truck
			else if (licenseavltype.equals("truck") || licenseavltype.equals("Truck")) {
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
					System.out.println("Do you want to your receipt?(Yes/No)");
					receipt = sc.next();
					if (receipt.equals("yes") || receipt.equals("Yes")) {
						vehicle.printReceipt();
					} else {
						System.out.println("Thank you for keeping green environment");
					}
					break;
				case "2":
					rentVehicleType = "Car";
					vehicle = new Car(rentVehicleType, customer);
					vehicle.rentVehicleType();
					System.out.println("Rental Cost=" + vehicle.calculateRentalCost());
					System.out.println("Do you want to your receipt?(Yes/No)");
					receipt = sc.next();
					if (receipt.equals("yes") || receipt.equals("Yes")) {
						vehicle.printReceipt();
					} else {
						System.out.println("Thank you for keeping green environment");
					}
					break;
				case "3":
					rentVehicleType = "Truck";
					vehicle = new Truck(rentVehicleType, customer);
					vehicle.rentVehicleType();
					System.out.println("Rental Cost=" + vehicle.calculateRentalCost());
					System.out.println("Do you want to your receipt?(Yes/No)");
					receipt = sc.next();
					if (receipt.equals("yes") || receipt.equals("Yes")) {
						vehicle.printReceipt();
					} else {
						System.out.println("Thank you for keeping green environment!");
					}
					break;
				default:
					System.out.println("You did not select any option!");
				}
			} else {
				System.out.println("Please Enter Valid Vehicle Name");
			}
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
