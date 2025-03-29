package rental;

public abstract class Vehicle{

    String vehicleType;
    String vehicleBrand;
    String vehicleModel;
    String fuelTypeOption;
    public Vehicle(String vehicleType, String vehicleBrand, String vehicleModel){
        this.vehicleType=vehicleType;
        this.vehicleBrand=vehicleBrand;
        this.vehicleModel=vehicleModel;
    }

    public Vehicle(String vehicleType){
        this.vehicleType=vehicleType;
    }

    // setters
    public void setVehicleType(String vehicleType){
        this.vehicleType=vehicleType;
    }
    public void setVehicleBrand(String vehicleBrand){
        this.vehicleBrand=vehicleBrand;
    }
    public void setVehicleModel(String vehicleModel){
        this.vehicleModel=vehicleModel;
    }

    //getters
    public String getVehicleType(){
        return vehicleType;
    }
    public String getVehicleBrand(){
        return vehicleBrand;
    }
    public String getVehicleModel(){
        return vehicleModel;
    }

    public abstract void rentVehicleType();

}
