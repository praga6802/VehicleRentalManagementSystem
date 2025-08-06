package rental;

import java.util.InputMismatchException;
import java.util.Scanner;

import static rental.RentalRules.MAX_NO_OF_DAYS;

public class Customer {
	static Scanner sc = new Scanner(System.in);
	private String idProof, customerName, contactNo, licenseAvl, licenseAvlType, rentVehicleType;
	private int age;
	private double noOfDays;
	private double noOfHours;

	public double getNoOfHours() {
		return noOfHours;
	}

	public void setNoOfHours(double noOfHours) {
		this.noOfHours = noOfHours;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getIdProof() {
		return idProof;
	}

	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getLicenseAvl() {
		return licenseAvl;
	}

	public void setLicenseAvl(String licenseAvl) {
		this.licenseAvl = licenseAvl;
	}

	public String getLicenseAvlType() {
		return licenseAvlType;
	}

	public void setLicenseAvlType(String licenseAvlType) {
		this.licenseAvlType = licenseAvlType;
	}

	public String getRentVehicleType() {
		return rentVehicleType;
	}

	public void setRentVehicleType(String rentVehicleType) {
		this.rentVehicleType = rentVehicleType;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(double noOfDays) {
		this.noOfDays = noOfDays;
	}

	// customer details
	public Customer(String idProof, String customerName, String contactNo, int age, double noOfDays, double noOfHours, String licenseAvl, String licenseAvlType, String rentVehicleType) {
		this.customerName = customerName;
		this.idProof = idProof;
		this.contactNo = contactNo;
		this.age = age;
		this.licenseAvl = licenseAvl;
		this.licenseAvlType = licenseAvlType;
		this.rentVehicleType = rentVehicleType;
		this.noOfDays = noOfDays;
		this.noOfHours = noOfHours;
	}

	public static Customer registerDetails() {
		System.out.println("Enter Customer details...");
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
			System.out.println("Enter the license of Vehicle Type(Car/Bike/Truck)");
			licenseAvlType = sc.next();
		} else {
			System.out.println("Without Driving License.. We would not provide vehicles for rentals");
		}
		String rentVehicleType = "";
		String vehicleChoice = "";
		String idProofChoice = "";
		String idProofType = "";
		if (licenseAvlType.equalsIgnoreCase("Bike")) {
			System.out.println("You're eligible only for Bike rentals.");
			rentVehicleType = "Bike";
		} else if (licenseAvlType.equalsIgnoreCase("Car")) {

			System.out.println("Available Vehicle Types:\n1. Bike\n2. Car");
			System.out.print("Press the Option Number:");
			vehicleChoice = sc.next();
			rentVehicleType = vehicleChoice.equals("1") ? "Bike" : vehicleChoice.equals("2") ? "Car" : "";
		} else if (licenseAvlType.equalsIgnoreCase("Truck")) {

			System.out.println("Available Vehicle Types:\n1. Bike\n2. Car\n3. Truck");
			System.out.print("Press the Option Number:");
			vehicleChoice = sc.next();
			rentVehicleType = vehicleChoice.equals("1") ? "Bike" : vehicleChoice.equals("2") ? "Car" : "Truck";
		}


		System.out.println("ID Proof acceptable for renting \n Press 1. Aadhar, Press 2. Voter ID");
		idProofChoice = sc.next();
		idProofType = idProofChoice.equals("1") ? "Aadhar" : "Voter ID";
		String contactNo = "";
		while (true) {
			try {
				System.out.println("Enter 10-digit Contact Number: ");
				contactNo = sc.next();
				if (contactNo.length() != 10 || !contactNo.matches("\\d{10}")) {
					System.out.println("Please provide 10 digit mobile number..");
					continue;
				}
				System.out.println("Contact Number: " + contactNo);
				break;
			} catch (InputMismatchException | NumberFormatException e) {
				System.out.println("Invalid Input.. Please try again..");
			}
		}
		int durationChoice = 0;
		double noOfDays = 0.0, noOfHours = 0.0;
		String duration = "";
		while (true) {
			try {
				System.out.println("Enter the Press 1->days, Press 2->hours");
				durationChoice = sc.nextInt();
				duration = String.valueOf(durationChoice);
			} catch (InputMismatchException e) {
				System.out.println("Invalid Input..");
			}
			if (duration.equalsIgnoreCase("1")) {
				System.out.println("Enter the No of Days:");
				noOfDays = sc.nextDouble();
				sc.nextLine();
				if (noOfDays > MAX_NO_OF_DAYS) {
					System.out.println("We are not provide more than 10 days...");
				}
			} else if (duration.equalsIgnoreCase("2")) {
				System.out.println("Enter the no of Hours:");
				noOfHours = sc.nextDouble();
				sc.nextLine();
			} else {
				System.out.println("Invalid Option..");
				continue;
			}
			return new Customer(idProofType, customer_name, contactNo, age, noOfDays, noOfHours, licenseAvl, licenseAvlType, rentVehicleType);
		}
}
}
