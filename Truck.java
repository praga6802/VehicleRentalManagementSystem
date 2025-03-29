package rental;
import java.util.Scanner;

public class Truck extends Vehicle implements RentalRules{
    String truckBrand, truckModel;
    double yearOfExperience;

    public Truck(String vehicleType, String TruckBrand, String TruckModel){
        super(vehicleType, TruckBrand,TruckModel );
    }
    public Truck(String vehicleType){
        super(vehicleType);
    }

    Scanner sc= new Scanner(System.in);
    public void rentVehicleType() {
        System.out.println("Enter years of Experience: ");
        yearOfExperience = sc.nextDouble();
        sc.nextLine();
        if (yearOfExperience >= 0.6) {
            System.out.println("Which Brand do you want?");
            System.out.println("Press 1 --> Bharat Benz, Press 2 --> TATA Motors, Press 3 --> Ashok Leyland");
            String truckbrandoption = sc.next();
            String truckmodeloption = "";
            //case for bike brand
            switch (truckbrandoption) {

                //case for HONDA
                case "1":
                    System.out.println("--- Bharat Benz Truck Models ---");
                    truckBrand = "Bharat Benz";
                    System.out.println("Which Model you want?");
                    System.out.println("Press 1 --> MDT 1217C, Press 2 --> HDT 2826R, Press 3 --> HDTC 2828C");
                    String bharatTruckModeloption = sc.next();
                    if (bharatTruckModeloption.equals("1")) {
                        truckModel = "MDT 1217C";
                    } else if (bharatTruckModeloption.equals("2")) {
                        truckModel = "HDT 2826R";
                    } else if (bharatTruckModeloption.equals("3")) {
                        truckModel = "HDTC 2828C";
                    } else {
                        System.out.println("You have chosen invalid option from Bharat Benz!");
                    }
                    break;

                //case for TATA Motors
                case "2":
                    System.out.println("--- TATA Motors Truck Models ---");
                    truckBrand = "TATA Motors";
                    System.out.println("Which Model you want?");
                    System.out.println("Press 1 --> TATA LPT 710, Press 2 --> TATA SFC 712, Press 3 --> TATA LPT 712");
                    String tataTruckModelOption = sc.next();
                    if (tataTruckModelOption.equals("1")) {
                        truckModel = "TATA LPT 710";
                    } else if (tataTruckModelOption.equals("2")) {
                        truckModel = "TATA SFC 712";
                    } else if (tataTruckModelOption.equals("3")) {
                        truckModel = "TATA LPT 712";
                    } else {
                        System.out.println("You have chosen invalid option from TATA Motors!");
                    }
                    break;

                //case for HYUNDAI
                case "3":
                    System.out.println("--- Ashok Leyland Models ---");
                    truckBrand = "Ashok Leyland";
                    System.out.println("Which Model you want?");
                    System.out.println("Press 1 --> Partner Super, Press 2 --> Ecomet Star, Press 3 --> Boss");
                    String ashokLeylandTruckModelOption = sc.next();
                    if (ashokLeylandTruckModelOption.equals("1")) {
                        truckModel = "Partner Super";
                    } else if (ashokLeylandTruckModelOption.equals("2")) {
                        truckModel = "Ecomet Star";
                    } else if (ashokLeylandTruckModelOption.equals("3")) {
                        truckModel = "Boss";
                    } else {
                        System.out.println("You have choosen invalid option from Ashok Leyland!");
                    }
                    break;
                default:
                    System.out.println("You did not select any trucks");
            }
        }
        else{
            System.out.println("We provide trucks for rental only the driver has minimum 3 years of experience");
        }
    }

    public double calculateRentalCost(){
        return 0.0;
    }
    public void checkAvailability(){

    }
}

