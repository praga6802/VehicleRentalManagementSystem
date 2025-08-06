package rental;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Vehicle implements RentalRules {

	Scanner sc= new Scanner(System.in);
	private String vehicleType;
	private String vehicleSubType;
	private String vehicleBrand;
	private String vehicleModel;
	private String[] brandVehiclesList; // Stores brand names
	private String[][] modelVehiclesList;
	private String fuelType;
	private double hourRent;
	private double dayRent;
	Customer customer;
	String fuelTypeOption, vehicleTypeOption, brandTypeOption, modelTypeOption;


	public Vehicle(String vehicleType, Customer customer) {

		this.vehicleType = vehicleType;
		//this.customer=customer;
		this.customer = new Customer(customer.getIdProof(), customer.getCustomerName(), customer.getContactNo(),customer.getAge(), customer.getNoOfDays(),customer.getNoOfHours(), customer.getLicenseAvl(), customer.getLicenseAvlType(),customer.getRentVehicleType());
	}
	public Vehicle(String vehicleType, String vehicleBrand, String vehicleModel) {
		this.vehicleType = vehicleType;
		this.vehicleBrand = vehicleBrand;
		this.vehicleModel = vehicleModel;
	}

	public Vehicle(String vehicleType){
		this.vehicleType=vehicleType;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public double getHourRent() {
		return hourRent;
	}

	public void setHourRent(double hourRent) {
		this.hourRent = hourRent;
	}

	public double getDayRent() {
		return dayRent;
	}

	public void setDayRent(double dayRent) {
		dayRent = dayRent;
	}


	public String getVehicleSubType() {
		return vehicleSubType;
	}

	public void setVehicleSubType(String vehicleSubType) {
		this.vehicleSubType = vehicleSubType;
	}


	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}
	public void setvehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	public void setVehicleBrandList(String[] brandVehiclesList) {
		this.brandVehiclesList = brandVehiclesList;
	}
	public void setVehicleModelList(String[][] modelVehiclesList) {
		this.modelVehiclesList = modelVehiclesList;
	}

	// getters
	public String getVehicleType() {
		return vehicleType;
	}
	public String getFuelType() {
		return fuelType;
	}
	public String getVehicleBrand() {
		return vehicleBrand;
	}
	public String getVehicleModel() {
		return vehicleModel;
	}
	public String[] getVehicleBrandList() {
		return brandVehiclesList;
	}
	public String[][] getVehicleModelList() {
		return modelVehiclesList;
	}



	public abstract List<String> getRentVehicleDetails(String vehicleType);

	public void receiptVerification(){
		System.out.println("Do you want to your receipt?(Yes/No)");
		String receipt = sc.next();
		if (receipt.equalsIgnoreCase("yes")) {
			printReceipt();
		} else {
			System.out.println("Thank you for keeping green environment");
		}
	}

	public void printReceipt() {
		System.out.println("-------------Welcome to " + COMPANY_NAME + "----------------");
		System.out.println("Customer Name: " + customer.getCustomerName());
		System.out.println("ID Proof: " + customer.getIdProof());
		System.out.println("Age: " + customer.getAge());
		System.out.println("Contact Number: " + customer.getContactNo());
		System.out.println("License Available Type: " + customer.getLicenseAvlType());
		System.out.println("Rent Vehicle: " + getVehicleType());
		System.out.println("Fuel Type: " + getFuelType());
		System.out.println("Vehicle Type: " + getVehicleSubType());
		System.out.println("Vehicle Brand: " + getVehicleBrand());
		System.out.println("Vehicle Model: " + getVehicleModel());
		double rentalCost=calculateRentalCost();
		if (customer.getNoOfDays() > 0) {
			System.out.println("No Of Days: " + customer.getNoOfDays());
		} else {
			System.out.println("Hours Taken: " + customer.getNoOfHours());
		}
		System.out.println("Rental Cost= " + rentalCost);
		System.out.println("==========================================");
		System.out.println("THANK YOU! VISIT AGAIN!");
		sc.close();
	}
}
