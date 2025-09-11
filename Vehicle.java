package rental;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public abstract class Vehicle implements RentalRules {

	Scanner sc= new Scanner(System.in);
	private String vehicleID;
	private String vehicleType;
	private String vehicleSubType;
	private String vehicleBrand;
	private String vehicleModel;
	private String[] vehicleBrandList; // Stores brand names
	private String[][] vehicleModelList;
	private String fuelType;
	private double hourRent;
	private double dayRent;
	Customer customer;
	String fuelTypeOption, vehicleTypeOption, brandTypeOption, modelTypeOption;
	LocalDateTime date= LocalDateTime.now();
	DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yy hh:mm:ss a");
	String dateFormat=date.format(formatter);
	protected FuelPricing price;





	private boolean isRented;


	// ----- constructors
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

	// for adding bike class
	public Vehicle(String vehicleID, String vehicleBrand, String vehicleSubType, String vehicleModel,FuelPricing price, boolean isRented){
		this.vehicleBrand=vehicleBrand;
		this.vehicleID=vehicleID;
		this.vehicleModel=vehicleModel;
		this.vehicleSubType=vehicleSubType;
		this.price=price;
		this.isRented=isRented;
	}
	public String toString(){
		return "Brand:"+vehicleBrand+", Model: "+vehicleModel+", Day Rent:"+getDayRent()+", Hour rent: "+getHourRent();
	}


	// for adding truck class
	public Vehicle(String id, String brand, String model, FuelPricing price, boolean isRented){
		this.vehicleBrand=brand;
		this.vehicleModel=model;
		this.vehicleID=id;
		this.price=price;
		this.isRented=isRented;
	}

	//
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
		return vehicleBrandList;
	}
	public String[][] getVehicleModelList() {
		return vehicleModelList;
	}
	public FuelPricing getPrice() {
		return price;
	}
	public String getVehicleID() {
		return vehicleID;
	}

	public String getVehicleSubType() {
		return vehicleSubType;
	}


	public double getHourRent() {
		return price.getHourlyRate();
	}

	public double getDayRent() {
		return price.getDailyRate();
	}
	public boolean isRented() {
		return isRented;
	}
	// setters

	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}
	public Vehicle(String vehicleType){
		this.vehicleType=vehicleType;
	}
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	public void setHourRent(double hourRent) {
		this.hourRent = hourRent;
	}
	public void setDayRent(double dayRent) {
		dayRent = dayRent;
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
	public void setVehicleBrandList(String[] vehicleBrandList) {
		this.vehicleBrandList = vehicleBrandList;
	}
	public void setVehicleModelList(String[][] vehicleModelList) {
		this.vehicleModelList = vehicleModelList;
	}
	public void setRented(boolean rented) {
		isRented = rented;
	}

	public void setPrice(FuelPricing price) {
		this.price = price;
	}
	// -------------------------------- methods-------------------------------------

	public void receiptVerification(){
		System.out.println("Do you want to your receipt?(Yes/No)");
		String receipt = sc.next();
		if (receipt.equalsIgnoreCase("yes")) {
			printReceipt();
		} else {
			System.out.println("Thank you for keeping green environment");
		}
	}


	public boolean brandExists(List<String> brands, String bikeBrand) {
		for (String brand : brands) {
			if (brand.equalsIgnoreCase(bikeBrand))
				return true;
		}
		return false;
	}

	public boolean modelExists(List<String> models, String bikeModel) {
		for (String model : models) {
			if (model.equalsIgnoreCase(bikeModel)) {
				return true;
			}
		}
		return false;
	}

	public void chooseVehicleModel(String brandName, String brandModels[]) {
		System.out.println("--- " + brandName + " " + getVehicleSubType() + " Models ---");
		System.out.println("Select the Model from " + brandName);
		for (int i = 0; i < brandModels.length; i++) {
			System.out.println("Press " + (i + 1) + "-->" + brandName + " " + brandModels[i]);
		}
		int modelOption = sc.nextInt();
		try {
			if (modelOption >= 1 && modelOption <= brandModels.length) {
				setVehicleModel(brandName + " " + brandModels[modelOption - 1]);
			} else {
				System.out.println("Invalid model option for" + brandName);
			}
		} catch (NumberFormatException n) {
			System.out.println("Please enter a valid Number");
		}
	}


	//call from bike or car or truck
	public double calculateKeyRent(Map<String, Integer> dayRates, Map<String,Integer> hourRate){
		double rent=0.0;
		String key = getFuelType().trim().toUpperCase() + "-" + getVehicleSubType().trim().toUpperCase()+ "-" + getVehicleBrand().trim().toUpperCase();
		if (customer.getNoOfDays() > 0) {
			if (dayRates.containsKey(key)) {
				rent = customer.getNoOfDays() * dayRates.get(key);
			} else {
				System.out.println("No daily day rent available for selected vehicle");
			}
		} else {
			if (hourRate.containsKey(key)) {
				rent = customer.getNoOfHours() * hourRate.get(key);
			} else {
				System.out.println("No hourly rent available for selected vehicle");
			}
		}
		return rent;
	}


	public abstract double calculateRentalCost();

	public abstract List<String> getRentVehicleDetails(String type);
	public void printReceipt() {
		System.out.println("-------------Welcome to " + COMPANY_NAME + "----------------");
		System.out.println("Date & Time:"+dateFormat);
		System.out.println("=================================================");
		System.out.println("Customer Name: " + customer.getCustomerName());
		System.out.println("ID Proof: " + customer.getIdProof());
		System.out.println("Age: " + customer.getAge());
		System.out.println("Contact Number: " + customer.getContactNo());
		System.out.println("License Available Type: " + customer.getLicenseAvlType());
		System.out.println("Rent Vehicle: " + customer.getRentVehicleType());
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
	}
}
