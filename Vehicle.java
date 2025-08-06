package rental;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public abstract class Vehicle implements RentalRules {

	Scanner sc= new Scanner(System.in);
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
	public void setVehicleBrandList(String[] vehicleBrandList) {
		this.vehicleBrandList = vehicleBrandList;
	}
	public void setVehicleModelList(String[][] vehicleModelList) {
		this.vehicleModelList = vehicleModelList;
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
		return vehicleBrandList;
	}
	public String[][] getVehicleModelList() {
		return vehicleModelList;
	}

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

	public double calculateKeyRent(Map<String, Integer> dayRates, Map<String,Integer> hourRate){
		double rent=0.0;
		String key = getFuelType().trim() + "-" + getVehicleSubType().trim() + "-" + getVehicleBrand().trim().toUpperCase();

		if (customer.getNoOfDays() > 0) {
			if (dayRates.containsKey(key)) {
				rent = customer.getNoOfDays() * dayRates.get(key);
				return rent;
			} else {
				System.out.println("No daily day rent available for selected vehicle");
				return 0.0;
			}
		} else {
			if (hourRate.containsKey(key)) {
				rent = customer.getNoOfHours() * hourRate.get(key);
				return rent;
			} else {
				System.out.println("No hourly rent available for selected vehicle");
				return 0.0;
			}
		}
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
