package rental;

public abstract class Vehicle{

    protected String vehicleCategory;
    protected String fuelType;
    protected String vehicleType;
    protected String vehicleBrand;
    protected String vehicleModel;
    protected int noOfDays;
    protected String[] brandVehicles1; // Stores brand names
    protected String[][] modelVehicles;

    Customer customer;

    public Vehicle(String vehicleCategory, String vehicleBrand, String vehicleModel, String fuelType, String vehicleType){
        this.vehicleCategory=vehicleCategory;
        this.vehicleBrand=vehicleBrand;
        this.vehicleModel=vehicleModel;
        this.fuelType=fuelType;
        this.vehicleType=vehicleType;
    }
    //for renting
    public Vehicle(String vehicleType, Customer customer){
        this.vehicleType=vehicleType;
        this.noOfDays= customer.getNoOfDays();
        this.customer= new Customer(customer.getIdproof(), customer.getCustomer_name(),customer.getContactNo(),customer.getAge(),customer.getNoOfDays(), customer.getLicenseAvl(), customer.getLicenseavlType(),customer.getRentVehicleType());

    }

    public Vehicle(){}
    //for checking vehicle availability for bike
    public Vehicle(String vehicleType,String[] brandVehicles1, String[][] modelVehicles){
        this.vehicleType=vehicleType;
        this.brandVehicles1=brandVehicles1;
        this.modelVehicles=modelVehicles;
    }
    public Vehicle(String vehicleType, String vehicleBrand, String vehicleModel){
        this.vehicleType=vehicleType;
        this.vehicleBrand=vehicleBrand;
        this.vehicleModel=vehicleModel;
    }


    // setters
    public void setVehicleType(String vehicleType){
        this.vehicleType=vehicleType;
    }
    public void setVehicleBrandList(String[] brandVehicles1){
        this.brandVehicles1=brandVehicles1;
    }
    public void setVehicleModelList(String[][] modelVehicles){
        this.modelVehicles=modelVehicles;
    }

    //getters
    public String getVehicleType(){
        return vehicleType;
    }
    public String[] getVehicleBrandList(){
        return brandVehicles1;
    }
    public String[][] getVehicleModelList(){
        return modelVehicles;
    }

    public abstract boolean checkAvailability(String vehicleBrand, String vehicleModel);
    public abstract void rentVehicleType();
    public abstract void printReceipt();
    public abstract double calculateRentalCost();
}

