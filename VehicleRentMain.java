package rental;

import java.util.List;
import java.util.Scanner;

import static rental.RentalRules.*;

public class VehicleRentMain{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Vehicle vehicle;
		System.out.println("Welcome to "+ COMPANY_NAME+"..");
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
				vehicle=new Bike(vehicleType);
				List<String> bikeDetails=vehicle.getRentVehicleDetails(vehicleType);
				String bikeBrand= bikeDetails.get(0);
				String bikeModel=bikeDetails.get(1);
				vehicle.checkAvailability(vehicleType,bikeBrand,bikeModel);
				break;

				
			case "2": // car
				vehicleType = "Car";
				vehicle=new Car(vehicleType);
				List<String> carDetails=vehicle.getRentVehicleDetails(vehicleType);
				String carBrand= carDetails.get(0);
				String carModel=carDetails.get(1);
				vehicle.checkAvailability(vehicleType,carBrand,carModel);
				break;
				
			case "3": // truck
				vehicleType = "Truck";
				vehicle=new Truck(vehicleType);
				List<String> truckDetails=vehicle.getRentVehicleDetails(vehicleType);
				String truckBrand= truckDetails.get(0);
				String truckModel=truckDetails.get(1);
				vehicle.checkAvailability(vehicleType,truckBrand,truckModel);
				break;
			}
			break;

		// rent vehicles
		case "2":
			System.out.println("Enter Customer details...");
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
			if (licenseAvl.equalsIgnoreCase("yes")) {
				System.out.println("Enter the license of Vehicle Type(Car/Bike/Truck)");
				licenseAvlType = sc.next();
			} else {
				System.out.println("Without Driving License.. We would not provide vehicles for rentals");
				sc.close();
				return;
			}
			System.out.println("ID Proof acceptable for renting \n Press 1. Aadhar, Press 2. Voter ID");
			String idProof = sc.next();
			switch (idProof) {
			case "1":
				idProof = "Aadhar";
				break;
			case "2":
				idProof = "Voter ID";
				break;
			default:
				System.out.println("Without ID Proof we are not provide for rentals...");
				return;
			}
			System.out.println("Enter Contact Number: ");
			String contactNo = sc.next();
			if (contactNo.length() != 10) {
				System.out.println("Please provide 10 digit mobile number..");
				sc.close();
				return;
			}

			System.out.println("Enter the hours/days");
			String durationChoice=sc.next();
			double noOfDays = 0.0,noOfHours=0.0;
			if(durationChoice.equalsIgnoreCase("days")) {
				System.out.println("Enter the No of Days:");
				 noOfDays= sc.nextDouble();
				sc.nextLine();
				if (noOfDays > MAX_NO_OF_DAYS) {
					System.out.println("We are not provide more than 10 days...");
					sc.close();
					return;
				}
			}
			else{
				System.out.println("Enter the no of Hours:");
				noOfHours=sc.nextDouble();
				sc.nextLine();
			}
			String rentVehicleType = "";
			// case for selecting normal or ev vehicles
			String receipt = "";

			Customer customer = new Customer(idProof, customer_name, contactNo, age, noOfDays,noOfHours, licenseAvl, licenseAvlType, rentVehicleType);

			if (licenseAvlType.equalsIgnoreCase("Bike")) {
				System.out.println("You are eligible only for Bike Rentals..");
				vehicle = new Bike(rentVehicleType, customer);
				vehicle.setVehicleType("Bike");
				vehicle.rentVehicleType();
				vehicle.receiptVerification();
			}
			// customer has car license - bike, car
			else if (licenseAvlType.equalsIgnoreCase("Car")) {
				System.out.println("Available Vehicle Types");
				System.out.println("Press 1 --> Bike, Press 2 --> Car");
				System.out.println("Which type of Vehicle would you like to rental?");
				rentVehicleType = sc.next();
				switch (rentVehicleType) {
				case "1":
					vehicle = new Bike(rentVehicleType, customer);
					vehicle.setVehicleType("Bike");
					vehicle.rentVehicleType();
					vehicle.receiptVerification();
					break;
				case "2":
					vehicle = new Car(rentVehicleType, customer);
					vehicle.setVehicleType("Car");
					vehicle.rentVehicleType();
					vehicle.receiptVerification();
					break;
				default:
					System.out.println("You did not select any option!");
				}
			}

			// customer has truck license - bike, car and truck
			else if (licenseAvlType.equalsIgnoreCase("truck")) {
				System.out.println("Available Vehicle Types");
				System.out.println("Press 1 --> Bike, Press 2 --> Car, Press 3 --> Truck");
				System.out.println("Which type of Vehicle would you like to rental?");
				rentVehicleType = sc.next();
				switch (rentVehicleType) {
				case "1":
					rentVehicleType = "Bike";
					vehicle = new Bike(rentVehicleType, customer);
					vehicle.rentVehicleType();
					vehicle.receiptVerification();
					break;
				case "2":
					rentVehicleType = "Car";
					vehicle = new Car(rentVehicleType, customer);
					vehicle.rentVehicleType();
					vehicle.receiptVerification();
					break;
				case "3":
					rentVehicleType = "Truck";
					vehicle = new Truck(rentVehicleType, customer);
					vehicle.rentVehicleType();
					vehicle.receiptVerification();
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
