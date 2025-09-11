package rental;

import java.util.*;

public class AdminService {
    Scanner sc= new Scanner(System.in);
    Admin admin=null;
    Vehicle vehicle=null;


    private List<Vehicle> vehicles= new ArrayList<>();
    public void addVehicle(){
        System.out.println("Enter the vehicle Type(car/bike/truck):");
        String type=sc.nextLine().trim().toLowerCase();

        System.out.println("Enter the vehicle ID:");
        String id=sc.nextLine();

        System.out.println("Enter the Vehicle Brand: ");
        String brand=sc.nextLine().trim();

        System.out.println("Enter the vehicle Model:");
        String model=sc.nextLine().trim();

        Map<String,FuelPricing> fuelPriceMap= new HashMap<>();
        System.out.println("How many Fuel types?");
        int count=sc.nextInt();
        sc.nextLine();
        boolean isRented=false;
        String fuelType=null;
        for(int i=0;i<count;i++){
            System.out.println("Enter the fuel type "+(i+1));
            fuelType=sc.nextLine().trim().toLowerCase();
            System.out.println("Enter the per day Rate: ");
            double dailyRate=sc.nextDouble();
            System.out.println("Enter the hourly Rate:");
            double hourlyRate=sc.nextDouble();
            sc.nextLine();
            fuelPriceMap.put(fuelType,new FuelPricing(dailyRate,hourlyRate));
        }

        switch(type){
            case "bike":
                System.out.println("Enter the Bike Type: ");
                String bikeType=sc.nextLine();
                System.out.println("Enter the Bike CC");
                double cc=sc.nextDouble();
                FuelPricing price=fuelPriceMap.get(fuelType);
                vehicles.add(new Bike(id,brand,bikeType, model,price, cc, isRented));
                System.out.println(brand+" "+model+" added successfully");
                break;

            case "car":
                System.out.println("Enter the Car Type: ");
                String carType=sc.nextLine();
                System.out.println("Enter the number of seats");
                int seats=sc.nextInt();
                FuelPricing carPrice=fuelPriceMap.get(fuelType);
                vehicles.add(new Car(id,brand,carType,model, carPrice,seats, isRented));
                System.out.println(brand+" "+model+" added successfully");
                break;
            case "truck":
                System.out.println("Enter the loading Capacity (in tons.)");
                double capacity=sc.nextDouble();
                FuelPricing truckPrice=fuelPriceMap.get(fuelType.toLowerCase());
                vehicles.add(new Truck(id,brand,model,truckPrice,capacity,isRented));
                System.out.println(brand+" "+model+" added successfully");
                break;
            default:
                System.out.println("Invalid Input!");
        }
    }

    public void removeVehicle(){
        System.out.println("Enter the vehicle Type(Car/bike/truck):");
        String type=sc.nextLine().trim().toLowerCase();

        System.out.println("Enter the vehicle ID:");
        String vehicleId=sc.nextLine().trim();
        boolean removed=false;

        Iterator<Vehicle> vehicleIterator= vehicles.iterator();
        while(vehicleIterator.hasNext()){
            vehicle= vehicleIterator.next();
            boolean typeMatches=false;

            switch (type){
                case "car":
                    typeMatches=vehicle instanceof Car;
                    break;
                case "bike":
                    typeMatches=vehicle instanceof Bike;
                    break;
                case "truck":
                    typeMatches=vehicle instanceof Truck;
                    break;
                default:
                    System.out.println("Invalid Vehicle Type");
                    return;
            }
            if(typeMatches && vehicle.getVehicleID().equalsIgnoreCase(vehicleId)){
                vehicleIterator.remove();
                removed=true;
                System.out.println(vehicle.getVehicleBrand()+" "+vehicle.getVehicleModel()+" has been removed successfully..");
                return;

            }
        }
        if(!removed){
            System.out.println("Vehicle ID mis match");
        }

    }

    public void editVehicle(){
        System.out.println("Enter the vehicle Type(Car/bike/truck):");
        String type=sc.nextLine().trim().toLowerCase();

        System.out.println("Enter the vehicle ID:");
        String vehicleId=sc.nextLine().trim();

        Vehicle vehicleEdit=null;

        for(Vehicle v:vehicles){
            if(v.getVehicleID().equalsIgnoreCase(vehicleId)&& v.getVehicleType().equalsIgnoreCase(type)){
                System.out.println("Id:"+v.getVehicleID()+" vehicle type:"+v.getVehicleType());
                vehicleEdit=v;
                break;
            }
        }
        if(vehicleEdit==null){
            System.out.println("Vehicle Not Found!");
            return;
        }
        while(true) {
            System.out.println("Which field do you want to update?");
            System.out.println("Press 1 -> Brand,\n Press 2 -> Model, \n Press 3 -> Update Fuel pricing, \n Press 4 -> Cancel Edit");
            int updateChoice = sc.nextInt();

            switch (updateChoice) {
                case 1:
                    System.out.println("Enter the New Brand: ");
                    String newBrand = sc.nextLine();
                    vehicleEdit.setVehicleBrand(newBrand);
                    System.out.println(newBrand + " is updated..");
                    break;
                case 2:
                    System.out.println("Enter the New Model: ");
                    String newModel = sc.nextLine();
                    vehicleEdit.setVehicleModel(newModel);
                    System.out.println(newModel + " is updated..");
                    break;
                case 3:
                    System.out.println("Enter the New Fuel Type:");
                    String newFuelType = sc.next();
                    System.out.println("Enter the New daily rate:");
                    double newDailyRate = sc.nextDouble();
                    System.out.println("Enter the New hour rate:");
                    double newHourlyRate = sc.nextDouble();
                    FuelPricing updatePricing = new FuelPricing(newDailyRate, newHourlyRate);
                    vehicleEdit.setPrice(updatePricing);
                    System.out.println("Fuel Price Updated..");
                    break;
                case 4:
                    System.out.println("Edit Cancelled");
                    return;
                default:
                    System.out.println("Invalid Option!");
            }
        }

    }



    public void showAllVehicles(){
        System.out.println("Enter the Vehicle Type(Car/Bike/Truck):");
        String vehicleType=sc.next().toLowerCase();
        boolean found=false;

        for(Vehicle v:vehicles){
            switch (vehicleType){
                case "car":
                    if(v instanceof  Car){
                        System.out.println(v);
                        found=true;
                    }
                    break;
                case "bike":
                    if(v instanceof  Bike){
                        System.out.println(v);
                        found=true;
                    }
                    break;
                case "truck":
                    if(v instanceof Truck){
                        System.out.println(v);
                        found=true;
                    }
                    break;
                default:
                    System.out.println("Invalid Vehicle Type!");
                    return;
            }

        }
        if(!found){
            System.out.println("No vehicle type found under "+vehicleType);
        }
    }
}
