package rental;
import java.util.Scanner;
public class VehicleRentMain {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to JONI Vehicle Rentals..");
        System.out.println("Please Enter Customer details...");
        System.out.println("Enter Customer Name: ");
        String customername = sc.nextLine();
        System.out.println("Do you have License(Yes/No)?");
        String licenseavl = sc.next();
        String licenseavltype = "";
        if (licenseavl.equals("Yes") || licenseavl.equals("yes")) {
            System.out.println("Enter the license of Vehicle Type");
            licenseavltype = sc.next();
        } else {
            System.out.println("Without Driving License.. We would not provide vehicles for rentals");
            return;
        }
        System.out.println("ID Proof acceptable for renting \n Press 1. Aadhar, Press 2. Voter ID");
        System.out.println("Submit your ID Proof..");
        String idproof = sc.next();
        switch (idproof) {
            case "1":
                System.out.println("You have selected \"Aadhar\"");
                idproof="Aadhar";
                break;
            case "2":
                System.out.println("You have selected \"Voter ID\" ");
                idproof="Voter ID";
                break;
            default:
                System.out.println("Without ID Proof we are not provide for rentals...");
                return;
        }
        System.out.println("Enter Contact Number: ");
        String contactno = sc.next();
        if (contactno.length() != 10) {
            System.out.println("Please provide 10 digit mobile number..");
            return;
        }
        System.out.println("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        if (age < 18) {
            System.out.println("Your are below age 18.. We are not provide for rentals..");
            return;
        }
        System.out.println("Enter the No of Days:");
        int noOfDays = sc.nextInt();
        sc.nextLine();
        if (noOfDays > 10) {
            System.out.println("We are not provide more than 10 days...");
            return;
        }

        Vehicle vehicle;
        String rentVehicleType = "";
        //case for selecting normal or ev vehicles


        // customer has only bike license
        if (licenseavltype.equals("Bike") || licenseavltype.equals("bike")) {
            System.out.println("You are eligible only for Bike Rentals..");
            rentVehicleType="Bike";
            vehicle = new Bike(rentVehicleType);
            vehicle.rentVehicleType();
        }
        // customer has car license - bike, car
        else if (licenseavltype.equals("Car") || licenseavltype.equals("car")) {
            System.out.println("Available Vehicle Types");
            System.out.println("Press 1 --> Bike, Press 2 --> Car");
            System.out.println("Which type of Vehicle would you like to rental?");
            rentVehicleType = sc.next();
            switch (rentVehicleType) {
                case "1":
                    rentVehicleType="Bike";
                    vehicle = new Bike(rentVehicleType);
                    vehicle.rentVehicleType();
                    break;
                case "2":
                    rentVehicleType="Car";
                    vehicle = new Car(rentVehicleType);
                    vehicle.rentVehicleType();
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
                    rentVehicleType="Bike";
                    vehicle = new Bike(rentVehicleType);
                    vehicle.rentVehicleType();
                    break;
                case "2":
                    rentVehicleType="Car";
                    vehicle = new Car(rentVehicleType);
                    vehicle.rentVehicleType();
                    break;
                case "3":
                    rentVehicleType="Truck";
                    vehicle = new Truck(rentVehicleType);
                    vehicle.rentVehicleType();
                    break;
                default:
                    System.out.println("You did not select any option!");
            }
        } else {
            System.out.println("Please Enter Valid Vehicle Name");
        }
        Customer customer = new Customer(idproof, customername, contactno, age, noOfDays, licenseavl, licenseavltype, rentVehicleType);
        customer.enterCustomerDetails();
    }
}

