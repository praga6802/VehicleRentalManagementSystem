package rental;
import java.util.Scanner;

public class Truck extends Vehicle{
    String truckBrand, truckModel;
    double yearOfExperience;
    int noOfDays;
    Vehicle vehicle;

    public Truck(String vehicleType, Customer customer){
        super(vehicleType,customer);
        this.noOfDays=customer.getNoOfDays();
    }
    //for vehicle availability
    public Truck(String vehicleType, String truckBrand, String truckModel){
        super(vehicleType,truckBrand,truckModel);
    }
    public Truck(){}
    //truck brands
    String[] truckBrand1= {
            "Bharat Benz", "Tata Motors", "Ashok Leyland"
    };

    //truck brand models
    String[][] truckModel1={
            {"Bharat Benz MDT 1217C", "Bharat Benz HDT 2826R", "Bharat Benz HDTC 2828C"},
            {"Tata Motors LPT 710","Tata Motors SFC 712","Tata Motors LPT 712"},
            {"Ashok Leyland Partner Super", "Ashok Leyland Ecomet Star", "Ashok Leyland Boss"},
    };
    //Availability of truck
    boolean[][] isRented ={
            {false, false, true},
            {true, false, true},
            {false, true, false},
    };

    public String[] getTruckBrandList(){
        return truckBrand1;
    }
    public String[][] getTruckModelList(){
        return truckModel1;
    }

    Scanner sc= new Scanner(System.in);

    //check availability of truck
    public boolean checkAvailability(String truckBrand, String truckModel) {
        for (int i = 0; i < truckBrand1.length; i++) {
            if (truckBrand1[i].equalsIgnoreCase(truckBrand)) {//checking out brand and this.brand is matching
                for (int j = 0; j < truckModel1[i].length; j++) {
                    if (truckModel1[i][j].equalsIgnoreCase(truckModel)) { //check the modelname and this .model name matching
                        if (isRented[i][j]) { // if it matches with model name & it checks for available
                            return false; //if it is not rented
                        } else {
                            return true; //if it is rented
                        }
                    }
                }
                //this not matches with brand and brand model
                System.out.println("Your Car " + truckModel + " is not found under " + truckBrand);
                break;
            }
        }
        return false;
    }
    public void rentVehicleType() {
        System.out.println("Enter years of Experience (Min Exp. 3 Years): ");
        yearOfExperience = sc.nextDouble();
        sc.nextLine();
        if (yearOfExperience >= 3) {
            System.out.println("Which Brand do you want?");
            System.out.println("Press 1 --> Bharat Benz, Press 2 --> TATA Motors, Press 3 --> Ashok Leyland");
            String truckBrandOption = sc.next();
            //case for bike brand
            switch (truckBrandOption) {

                //case for HONDA
                case "1":
                    truckBrand = "Bharat Benz";
                    System.out.println("---"+truckBrand+" Models ---");
                    System.out.println("Which Model you want?");
                    System.out.println("Press 1 --> Bharat Benz MDT 1217C, Press 2 --> Bharat Benz HDT 2826R, Press 3 -->Bharat Benz HDTC 2828C");
                    String bharatTruckModeloption = sc.next();
                    if (bharatTruckModeloption.equals("1")) {
                        truckModel = "Bharat Benz MDT 1217C";
                    } else if (bharatTruckModeloption.equals("2")) {
                        truckModel = "Bharat Benz HDT 2826R";
                    } else if (bharatTruckModeloption.equals("3")) {
                        truckModel = "Bharat Benz HDTC 2828C";
                    } else {
                        System.out.println("You have chosen invalid option from Bharat Benz!");
                    }
                    break;

                //case for TATA Motors
                case "2":
                    truckBrand = "TATA Motors";
                    System.out.println("---"+truckBrand+" Models ---");
                    System.out.println("Which Model you want?");
                    System.out.println("Press 1 --> TATA Motors LPT 710, Press 2 --> TATA Motors SFC 712, Press 3 --> TATA Motors LPT 712");
                    String tataTruckModelOption = sc.next();
                    if (tataTruckModelOption.equals("1")) {
                        truckModel = "TATA Motors LPT 710";
                    } else if (tataTruckModelOption.equals("2")) {
                        truckModel = "TATA Motors SFC 712";
                    } else if (tataTruckModelOption.equals("3")) {
                        truckModel = "TATA Motors LPT 712";
                    } else {
                        System.out.println("You have chosen invalid option from TATA Motors!");
                    }
                    break;

                //case for HYUNDAI
                case "3":
                    truckBrand = "Ashok Leyland";
                    System.out.println("---"+truckBrand+" Models ---");
                    System.out.println("Which Model you want?");
                    System.out.println("Press 1 --> Ashok Leyland Partner Super, Press 2 --> Ashok Leyland Ecomet Star, Press 3 --> Ashok Leyland Boss");
                    String ashokLeylandTruckModelOption = sc.next();
                    if (ashokLeylandTruckModelOption.equals("1")) {
                        truckModel = "Ashok Leyland Partner Super";
                    } else if (ashokLeylandTruckModelOption.equals("2")) {
                        truckModel = "Ashok Leyland Ecomet Star";
                    } else if (ashokLeylandTruckModelOption.equals("3")) {
                        truckModel = "Ashok Leyland Boss";
                    } else {
                        System.out.println("You have chosen invalid option from Ashok Leyland!");
                    }
                    break;
                default:
                    System.out.println("You did not select any trucks");
            }
        }
        else{
            System.out.println("Experience is less than 3 years! Sorry we wont provide car rentals!");
        }
    }


    double hour=0.0;
    double totalDayRent;
    double totalHourRent;
    public double calculateRentalCost() {
        //if the user enters no of days >0 day rent
        if (noOfDays > 0) {
            System.out.println("No of Days: " + noOfDays);
            if(truckBrand.equals("Bharat Benz")){
                totalDayRent = noOfDays * 1500;
            }
            else if(truckBrand.equals("TATA Motors")){
                totalDayRent=noOfDays * 1600;
            }
            else if(truckBrand.equals("Ashok Leyland")){
                totalDayRent=noOfDays * 1300;
            }
            return totalDayRent;
        }

        //hourly rent
        else {
            System.out.println("Enter the no of hours: ");
            hour = sc.nextDouble();
            if(truckBrand.equals("Bharat Benz")){
                totalHourRent = hour * 400;
            }
            else if(truckBrand.equals("TATA Motors")){
                totalHourRent= hour * 500;
            }
            else if(truckBrand.equals("Ashok Leyland")){
                totalHourRent= hour * 300;
            }
            return totalHourRent;
        }
    }

    public void printReceipt(){
        System.out.println("-------------Welcome to "+rentalName+"----------------");
        System.out.println("Customer Name: "+customer.getCustomer_name());
        System.out.println("ID Proof: "+customer.getIdproof());
        System.out.println("Age: "+customer.getAge());
        System.out.println("Contact Number: "+customer.getContactNo());
        System.out.println("License Available: "+customer.getLicenseAvl());
        System.out.println("License Available Type: "+customer.getLicenseavlType());
        System.out.println("Rent Vehicle: "+vehicleType);
        System.out.println("Truck Brand: "+truckBrand);
        System.out.println("Truck Model: "+truckModel);
        if(noOfDays > 0){
            System.out.println("No Of Days: "+noOfDays);
            System.out.println("Rental Cost= "+totalDayRent);
        }
        else{
            System.out.println("Hours Taken: "+hour);
            System.out.println("Rental Cost= "+totalHourRent);
        }
        System.out.println("=======================================");
        System.out.println("THANK YOU! VISIT AGAIN!");
    }
}

