package rental;

import java.util.List;
import java.util.Scanner;

import static rental.RentalRules.*;

public class VehicleRentMain{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Vehicle vehicle = null;
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
			case "1": // bike details
				vehicle=new Bike(vehicleType);
				vehicle.setVehicleType("Bike");
				List<String> bikeDetails=vehicle.getRentVehicleDetails(vehicle.getVehicleType());
				String bikeBrand= bikeDetails.get(0);
				String bikeModel=bikeDetails.get(1);
				vehicle.checkAvailability(vehicleType,bikeBrand,bikeModel);
				break;

				
			case "2": // car details
				vehicle=new Car(vehicleType);
				vehicle.setVehicleType("Car");
				List<String> carDetails=vehicle.getRentVehicleDetails(vehicle.getVehicleType());
				String carBrand= carDetails.get(0);
				String carModel=carDetails.get(1);
				vehicle.checkAvailability(vehicleType,carBrand,carModel);
				break;
				
			case "3": // truck details
				vehicle=new Truck(vehicleType);
				vehicle.setVehicleType("Truck");
				List<String> truckDetails=vehicle.getRentVehicleDetails(vehicle.getVehicleType());
				String truckBrand= truckDetails.get(0);
				String truckModel=truckDetails.get(1);
				vehicle.checkAvailability(vehicleType,truckBrand,truckModel);
				break;
			}
			break;

		// rent vehicles
		case "2":
			Customer customer=Customer.registerDetails();
			String rentVehicleType = null;
			if (customer.getRentVehicleType().equalsIgnoreCase("Bike")) {
				System.out.println("You are eligible only for Bike Rentals..");
				vehicle = new Bike("Bike", customer);
			}
			// customer has car license - bike, car
			else if (customer.getRentVehicleType().equalsIgnoreCase("Car")) {
				System.out.println("Available Vehicle Types");
				System.out.println("Press 1 --> Bike, Press 2 --> Car");
				System.out.println("Which type of Vehicle would you like to rental?");
				rentVehicleType = sc.next();
				switch (rentVehicleType) {
				case "1":
					vehicle = new Bike("Bike", customer);
					break;
				case "2":
					vehicle = new Car("Car", customer);
					break;
				default:
					System.out.println("You did not select any option!");
				}
			}

			// customer has truck license - bike, car and truck
			else if (customer.getRentVehicleType().equalsIgnoreCase("Truck")) {
				System.out.println("Available Vehicle Types");
				System.out.println("Press 1 --> Bike, Press 2 --> Car, Press 3 --> Truck");
				System.out.println("Which type of Vehicle would you like to rental?");
				rentVehicleType = sc.next();
				switch (rentVehicleType) {
				case "1":
					vehicle = new Bike("Bike", customer);
					break;
				case "2":
					vehicle = new Car("Car", customer);
					break;
				case "3":
					vehicle = new Truck("Truck", customer);
					break;
				default:
					System.out.println("You did not select any option!");
				}
			}
			if(vehicle!=null){
				vehicle.rentVehicleType();
				vehicle.receiptVerification();
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
