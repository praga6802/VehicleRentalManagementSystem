package rental;

public class Customer {

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
	public Customer(String idProof, String customerName, String contactNo, int age, double noOfDays,double noOfHours, String licenseAvl, String licenseAvlType, String rentVehicleType) {
		this.customerName = customerName;
		this.idProof = idProof;
		this.contactNo = contactNo;
		this.age = age;
		this.licenseAvl = licenseAvl;
		this.licenseAvlType = licenseAvlType;
		this.rentVehicleType = rentVehicleType;
		this.noOfDays = noOfDays;
		this.noOfHours=noOfHours;
	}

}
