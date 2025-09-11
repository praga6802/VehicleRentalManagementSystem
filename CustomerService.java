package rental;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static rental.RentalRules.MAX_NO_OF_DAYS;

public class CustomerService {
    Customer customer=null;
    static Scanner sc= new Scanner(System.in);
    Vehicle vehicle=null;

    public void checkAvailability(){
        System.out.println("Enter the Vehicle Type: Press 1 --> Bike, Press 2 --> Car, Press 3 --> Truck");
        String vehicleType = sc.next();
        sc.nextLine();
        switch (vehicleType) {

            // check vehicles available
            case "1": // bike details
                vehicle = new Bike("Bike");
                vehicle.setVehicleType("Bike");
                List<String> bikeDetails = vehicle.getRentVehicleDetails(vehicle.getVehicleType());
                String bikeBrand = bikeDetails.get(0);
                String bikeModel = bikeDetails.get(1);
                vehicle.checkAvailability(vehicleType, bikeBrand, bikeModel);
                break;

            case "2": // car details
                vehicle = new Car(vehicleType);
                vehicle.setVehicleType("Car");
                List<String> carDetails = vehicle.getRentVehicleDetails(vehicle.getVehicleType());
                String carBrand = carDetails.get(0);
                String carModel = carDetails.get(1);
                vehicle.checkAvailability(vehicleType, carBrand, carModel);
                break;

            case "3": // truck details
                vehicle = new Truck(vehicleType);
                vehicle.setVehicleType("Truck");
                List<String> truckDetails = vehicle.getRentVehicleDetails(vehicle.getVehicleType());
                String truckBrand = truckDetails.get(0);
                String truckModel = truckDetails.get(1);
                vehicle.checkAvailability(vehicleType, truckBrand, truckModel);
                break;
            default:
                System.out.println("Invalid input! Please enter correct input");
        }
    }

    public void rentVehicle(){
        customer=registerDetails();
        String rentVehicleType = null;
        if (customer.getRentVehicleType().equalsIgnoreCase("Bike")) vehicle = new Bike("Bike", customer);
        else if (customer.getRentVehicleType().equalsIgnoreCase("Car")) vehicle= new Car("Car",customer);
        else if (customer.getRentVehicleType().equalsIgnoreCase("Truck")) vehicle= new Truck("Truck",customer);

        if (vehicle != null) {
            vehicle.rentVehicleType();
            vehicle.receiptVerification();
        }
    }
    public static Customer registerDetails() {
        System.out.println("--- Enter Customer details--- ");
        System.out.println("Enter Customer Name: ");
        String customer_name = sc.nextLine();
        int age=0;
        while(true) {
            try {
                System.out.println("Enter Age: ");
                age = sc.nextInt();
                sc.nextLine();
                if (age < 18) {
                    System.out.println("Your are below age 18.. We are not provide for rentals..");
                    continue;
                }
                break;
            }
            catch (InputMismatchException e){
                System.out.println("Invalid Input..Please enter a valid age");
                sc.nextLine();
            }
        }
        System.out.println("Do you have License(Yes/No)?");
        String licenseAvl = sc.next();
        String licenseAvlType = "";
        if (licenseAvl.equalsIgnoreCase("yes")) {
            while (true){
            System.out.println("Enter the license of Vehicle Type(Car/Bike/Truck)");
            licenseAvlType = sc.next();
            if (licenseAvlType.equalsIgnoreCase("car") || licenseAvlType.equalsIgnoreCase("truck") || licenseAvlType.equalsIgnoreCase("bike")) {
                break;
            }
            else{
                System.out.println("Enter the correct input");
            }
        }
        }
        else {
            System.out.println("Without Driving License.. We would not provide vehicles for rentals");
        }

        String rentVehicleType = "";
        String vehicleChoice = "";
        String idProofChoice = "";
        String idProofType = "";
        if (licenseAvlType.equalsIgnoreCase("Bike")) {
            System.out.println("You're eligible only for Bike rentals.");
            rentVehicleType = "Bike";
        }
        else if (licenseAvlType.equalsIgnoreCase("Car")) {
            System.out.println("Available Vehicle Types: Press -> 1. Bike, Press 2-> Car");
            System.out.print("Enter the Option:");
            vehicleChoice = sc.next();
            rentVehicleType = vehicleChoice.equals("1") ? "Bike" : vehicleChoice.equals("2") ? "Car" : "Invalid Option";
        }
        else if (licenseAvlType.equalsIgnoreCase("Truck")) {
            System.out.println("Available Vehicle Types: Press -> 1. Bike, Press 2-> Car, Press->3 Truck");
            System.out.print("Press the Option Number:");
            vehicleChoice = sc.next();
            rentVehicleType = vehicleChoice.equals("1") ?"Bike" : vehicleChoice.equals("2") ? "Car" :vehicleChoice.equals("3")?"Truck":"Invalid Option";
        }
        System.out.println("ID Proof acceptable for renting \nPress 1. Aadhar, Press 2. Voter ID");
        idProofChoice = sc.next();
        idProofType = idProofChoice.equals("1") ? "Aadhar" : "Voter ID";
        String contactNo = "";
        while (true) {
            try {
                System.out.println("Enter 10-digit Contact Number: ");
                contactNo = sc.next();
                sc.nextLine();
                if (contactNo.length() != 10 || !contactNo.matches("\\d{10}")) {
                    System.out.println("Please provide 10 digit mobile number..");
                    continue;
                }
                break;
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Invalid Input.. Please try again..");
            }
        }
        int durationChoice = 0;
        double noOfDays = 0.0, noOfHours = 0.0;

        while (true) {
            System.out.println("Enter the Press 1->Days, Press 2->Hours");
            String duration=sc.nextLine().trim();

            if(duration.isEmpty()){
                System.out.println("Input cannot be empty");
                continue;
            }
            if (duration.equals("1")) {
                System.out.println("Enter the No of Days:");
                try {
                    noOfDays = Double.parseDouble(sc.nextLine());
                    if (noOfDays > MAX_NO_OF_DAYS) {
                        System.out.println("We do not provide more than " + MAX_NO_OF_DAYS + " days");
                        continue;
                    }
                    break;
                }
                catch (NumberFormatException e){
                    System.out.println("Invalid Input, Please enter a number");
                }
            }
            else if (duration.equals("2")) {
                System.out.println("Enter the No of Hours:");
                try {
                    noOfHours = Double.parseDouble(sc.nextLine());
                    break; // valid input, exit loop
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number, try again.");
                }
            }
            else {
                System.out.println("Invalid Option, enter 1 or 2");
            }
        }
        return new Customer(idProofType, customer_name, contactNo, age, noOfDays, noOfHours, licenseAvl, licenseAvlType, rentVehicleType);
        }
    }

