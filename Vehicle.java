package rental;

public abstract class Vehicle extends RentalAdapter {

	protected String vehicleCategory;
	protected String fuelType;
	protected String vehicleType;
	protected String vehicleBrand;
	protected String vehicleModel;
	protected int noOfDays;
	protected String[] brandVehiclesList; // Stores brand names
	protected String[][] modelVehiclesList;
	Customer customer;

	//Constructors
	// for renting vehicles
	public Vehicle(String vehicleType, Customer customer) {
		this.vehicleType = vehicleType;
		this.customer = new Customer(customer.getIdproof(), customer.getCustomerName(), customer.getContactNo(),
				customer.getAge(), customer.getNoOfDays(), customer.getLicenseAvl(), customer.getLicenseavlType(),
				customer.getRentVehicleType());
	}

	public Vehicle(String vehicleType) {
		this.vehicleType=vehicleType;
	}

	// for checking vehicle availability for bike
	public Vehicle(String vehicleType, String[] brandVehiclesList, String[][] modelVehiclesList) {
		this.vehicleType = vehicleType;
		this.brandVehiclesList = brandVehiclesList;
		this.modelVehiclesList = modelVehiclesList;
	}

	public Vehicle(String vehicleType, String vehicleBrand, String vehicleModel) {
		this.vehicleType = vehicleType;
		this.vehicleBrand = vehicleBrand;
		this.vehicleModel = vehicleModel;
	}

	// setters()
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public void setVehicleCategory(String vehicleCategory) {
		this.vehicleCategory = vehicleCategory;
	}

	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}

	public void setvehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	public void setVehicleBrandList(String[] brandVehiclesList) {
		this.brandVehiclesList = brandVehiclesList;
	}

	public void setVehicleModelList(String[][] modelVehiclesList) {
		this.modelVehiclesList = modelVehiclesList;
	}

	// getters()
	public String getVehicleType() {
		return vehicleType;
	}

	public String getFuelType() {
		return fuelType;
	}

	public String getVehicleCategory() {
		return vehicleCategory;
	}

	public String getVehicleBrand() {
		return vehicleBrand;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public String[] getVehicleBrandList() {
		return brandVehiclesList;
	}

	public String[][] getVehicleModelList() {
		return modelVehiclesList;
	}
}
