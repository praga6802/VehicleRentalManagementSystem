package rental;
import java.util.Scanner;


public class Bike extends Vehicle{

    Scanner sc = new Scanner(System.in);
    String bikeBrandOption;
    String bikeTypeOption;
    String fuelTypeOption;
    
    String bikeBrand;
    String bikeModel;
    
    Customer customer;
   
    //for checking JONI availability of vehicles

    String[] bikeBrand1 = {"Suzuki", "Honda", "TVS", "Bajaj", "Yamaha", "Royal Enfield","Kawasaki", "Ducati", "BMW","Ola", "Aprilla", "Ather", "Matter", "Revolt", "Oben"};

    String[][] bikeModel1 = {
            {"Suzuki Access 125", "Suzuki Burgmann Street", "Suzuki Avenis"},//suzuki scooters
            {"Honda Activa 110", "Honda Activa 125", "Honda Dio 125"},// honda scooters
            {"TVS Jupiter 125", "TVS NTORQ 125", "TVS ZEST 125"}, //tvs scooters
            {"Bajaj Pulsar 150", "Bajaj Pulsar 220", "Bajaj Dominor 400"}, //bajaj
            {"Yamaha FZ X", "Yamaha MT 15", "Yamaha R15 V4"}, //yamaha
            {"Royal Enfield Classic 350", "Royal Enfield Meteor 650", "Royal Enfield Hunter 350", "Royal Enfield Interceptor 650"}, //royal enfield
            {"KAWASAKI NINJA H2R", "KAWASAKI NINJA ZX-10R", "KAWASAKI NINJA H2 SX"},
            {"DUCATI PANIGALE V4", "DUCATI PANIGALE V4R", "DUCATI STREET FIGHTER V2"},
            {"BMW M 1000 XR", "BMW S 1000 R", "BMW M 1000 RR"},
            {"OLA S1 Pro+", "OLA S1 Air", "OLA Gig"},
            {"Aprilla Typhoon"},
            {"ATHER 450 S", "ATHER 450 X", "ATHER 450 APEX"},
            {"MATTER AERA 5000", "MATTER AERA 5000+"},
            {"REVOLT RV400"},
            {"OBEN RORR"}

    };
    
    public void showVehicles() {
    	
    }
    //stock of bikes
    boolean[][] isRented = {
        {false, false, true},//suzuki scooters
        {false, false, false},// honda scooters
        {false, true, false}, //tvs scooters
        {false, false, false}, //bajaj
        {true, false, false}, //yamaha
        {false, false, false}, //royal enfield
        {true, true, false},
        {false, true, false},
        {false, false, true},
        {false, true, false},
        {true},
        {false, true, true},
        {false, false},
        {false},
        {true}
    };

    int noOfDays;
    //for renting vehicles
    public Bike(String vehicleType, Customer customer) {
        super(vehicleType, customer);
        this.noOfDays=customer.getNoOfDays();
    }

    //getting bike details
    public Bike(String vehicleType, String bikeBrand, String bikeModel) {
        super(vehicleType, bikeBrand, bikeModel);
    }
    public String[] getBikeBrand1() {
        return bikeBrand1;
    }

    public String[][] getBikeModel1() {
        return bikeModel1;
    }

    public Bike() {
    }


    //check availability for bike
    public boolean checkAvailability(String bikeModel) {
            for (int i = 0; i < bikeBrand1.length; i++) {
                if (bikeBrand1[i].equalsIgnoreCase(bikeBrand)) {//checking out brand and this.brand is matching
                	
                    for (int j = 0; j < bikeModel1[i].length; j++) {
                        if (bikeModel1[i][j].equalsIgnoreCase(bikeModel)) { 
                        	System.out.println(bikeModel1[i][j]);//check the modelname and this .model name matching
                            if (isRented[i][j]) { // if it matches with model name & it checks for available
                                return false; //if it is not rented
                            } else {
                                return true; //if it is rented
                            }
                        }
                    }
                    //this not matches with brand and brand model
                    System.out.println("Your Bike " + bikeModel + " is not found under " + bikeBrand);
                }
            }
            return false;
       }

        public void rentVehicleType () {
            System.out.println("Which mode of bike do you want? Press -- 1 Normal or Press 2 --> EV Bikes");
            fuelTypeOption = sc.nextLine();
            switch (fuelTypeOption) {

                //case Normal Bikes
                case "1":
                    fuelTypeOption = "Normal";
                    System.out.println("What type of bike do you want?");
                    System.out.println("Press 1 --> Scooter, Press 2 --> Gear Bike, Press 3 --> Super Bikes");
                    bikeTypeOption = sc.next();
                    switch (bikeTypeOption) {
                        //case scooters
                        case "1":
                            bikeTypeOption = "Scooter";
                            System.out.println("Which Brand do you want?");
                            System.out.println("Press 1 --> SUZUKI, Press 2 --> TVS, Press 3 --> HONDA");
                            bikeBrandOption = sc.next();
                            switch (bikeBrandOption) {
                                //Suzuki Scooters
                                case "1":
                                	bikeBrand = "SUZUKI";
                                    System.out.println("---"+bikeBrand+" "+bikeTypeOption+" Models ---");
                                    System.out.println("Which Model you want?");
                                    System.out.println("Press 1 --> SUZUKI ACCESS 125, Press 2 --> SUZUKI AVENIS, Press 3 --> SUZUKI BURGMAN STREET");
                                    String suzukiScooterModelOption = sc.next();
                                    if (suzukiScooterModelOption.equals("1")) {
                                        bikeModel = "SUZUKI ACCESS 125";
                                    } else if (suzukiScooterModelOption.equals("2")) {
                                        bikeModel = "SUZUKI AVENIS";
                                    } else if (suzukiScooterModelOption.equals("3")) {
                                        bikeModel = "SUZUKI BURGMAN STREET";
                                    } else {
                                        System.out.println("You have chosen invalid option from SUZUKI!");
                                    }
                                    break;

                                //TVS Scooters
                                    
                                case "2":
                                	bikeBrand = "TVS";
                                	System.out.println("---"+bikeBrand+" "+bikeTypeOption+" Models ---");
                                    System.out.println("Which Model you want?");
                                    System.out.println("Press 1 --> TVS JUPITER 125, Press 2 --> TVS NTORQ 125, Press 3 --> TVS ZEST 125");
                                    String tvsScooterModelOption = sc.next();
                                    if (tvsScooterModelOption.equals("1")) {
                                        bikeModel = "TVS JUPITER 125";
                                    } else if (tvsScooterModelOption.equals("2")) {
                                        bikeModel = "TVS NTORQ 125";
                                    } else if (tvsScooterModelOption.equals("3")) {
                                        bikeModel = "TVS ZEST 125";
                                    } else {
                                        System.out.println("You have chosen invalid option from TVS!");
                                    }
                                    break;

                                //Honda Scooters
                                case "3":
                                	bikeBrand = "HONDA";
                                	System.out.println("---"+bikeBrand+" "+bikeTypeOption+" Models ---");
                                    System.out.println("Which Model you want?");
                                    System.out.println("Press 1 --> HONDA ACTIVA 110, Press 2 --> HONDA ACTIVA 125, Press 3 --> HONDA DIO 125");
                                    String hondaScooterModelOption = sc.next();
                                    if (hondaScooterModelOption.equals("1")) {
                                        bikeModel = "HONDA ACTIVA 110";
                                    } else if (hondaScooterModelOption.equals("2")) {
                                        bikeModel = "HONDA ACTIVA 125";
                                    } else if (hondaScooterModelOption.equals("3")) {
                                        bikeModel = "HONDA DIO 125";
                                    } else {
                                        System.out.println("You have chosen invalid option from HONDA!");
                                    }
                                    break;

                                default:
                                    System.out.println("You did not selected any scooters!");
                            }
                            break;
                        //case gear bikes
                        case "2":
                            bikeTypeOption = "Gear Bike";
                            System.out.println("Which Brand do you want?");
                            System.out.println("Press 1 --> BAJAJ, Press 2 --> YAMAHA, Press 3 --> ROYAL ENFIELD");
                            bikeBrandOption = sc.next();
                            //case for bike brand
                            switch (bikeBrandOption) {
                                //Bajaj Gear Bikes
                                case "1":
                                	bikeBrand = "BAJAJ";
                                	System.out.println("---"+bikeBrand+" "+bikeTypeOption+" Models ---");
                                    System.out.println("Which Model you want?");
                                    System.out.println("Press 1 --> Bajaj Pulsar 150, Press 2 --> Bajaj Pulsar 220, Press 3 --> Bajaj Dominar 400");
                                    String bajajBikeModelOption = sc.next();
                                    if (bajajBikeModelOption.equals("1")) {
                                        bikeModel = "Bajaj Pulsar 150";
                                    } else if (bajajBikeModelOption.equals("2")) {
                                        bikeModel = "Bajaj Pulsar 220";
                                    } else if (bajajBikeModelOption.equals("3")) {
                                        bikeModel = "Bajaj Dominar 400";
                                    } else {
                                        System.out.println("You have chosen invalid option from BAJAJ!");
                                    }
                                    break;

                                //Yamaha Gear Bikes
                                case "2":
                                	bikeBrand = "YAMAHA";
                                	System.out.println("---"+bikeBrand+" "+bikeTypeOption+" Models ---");
                                    System.out.println("Which Model you want?");
                                    System.out.println("Press 1 --> Yamaha FZ X, Press 2 --> Yamaha MT 15, Press 3 --> Yamaha R15 V4");
                                    String yamahaBikeModelOption = sc.next();
                                    if (yamahaBikeModelOption.equals("1")) {
                                        bikeModel = "Yamaha FZ X";
                                    } else if (yamahaBikeModelOption.equals("2")) {
                                        bikeModel = "Yamaha MT 15";
                                    } else if (yamahaBikeModelOption.equals("3")) {
                                        bikeModel = "Yamaha R15 V4";
                                    } else {
                                        System.out.println("You have chosen invalid option from YAMAHA!");
                                    }
                                    break;

                                //Royal Enfield Gear Bikes
                                case "3":
                                	bikeBrand = "ROYAL ENFIELD";
                                	System.out.println("---"+bikeBrand+" "+bikeTypeOption+" Models ---");
                                    System.out.println("Which Model you want?");
                                    System.out.println("Press 1 --> Royal Enfield Classic 350, Press 2 --> Royal Enfield Meteor 650, Press 3 --> Royal Enfield Hunter 350, Press 4 --> Royal Enfield Interceptor 650");
                                    String reBikeModelOption = sc.next();
                                    if (reBikeModelOption.equals("1")) {
                                        bikeModel = "Royal Enfield Classic 350";
                                    } else if (reBikeModelOption.equals("2")) {
                                        bikeModel = "Royal Enfield Meteor 650";
                                    } else if (reBikeModelOption.equals("3")) {
                                        bikeModel = "Royal Enfield Hunter 350";
                                    } else if (reBikeModelOption.equals("4")) {
                                        bikeModel = "Royal Enfield Interceptor 650";
                                    } else {
                                        System.out.println("You have chosen invalid option from ROYAL ENFIELD!");
                                    }
                                    break;

                                default:
                                    System.out.println("You did not selected any bikes!");
                            }
                            break;
                        //case super bikes
                        case "3":
                            bikeTypeOption = "Super Bikes";
                            System.out.println("Which Brand do you want?");
                            System.out.println("Press 1 --> KAWASAKI, Press 2 --> DUCATI, Press 3 --> BMW");
                            bikeBrandOption = sc.next();
                            switch (bikeBrandOption) {

                                //Kawasaki Super Bikes
                                case "1":
                                	bikeBrand = "KAWASAKI";
                                	System.out.println("---"+bikeBrand+" "+bikeTypeOption+" Models ---");
                                    System.out.println("Which Model you want?");
                                    System.out.println("Press 1 --> KAWASAKI NINJA H2R, Press 2 --> KAWASAKI NINJA ZX-10R, Press 3 --> KAWASAKI NINJA H2 SX");
                                    String kawasakiSuperBikeModelOption = sc.next();
                                    if (kawasakiSuperBikeModelOption.equals("1")) {
                                        bikeModel = "KAWASAKI NINJA H2R";
                                    } else if (kawasakiSuperBikeModelOption.equals("2")) {
                                        bikeModel = "KAWASAKI NINJA ZX-10R";
                                    } else if (kawasakiSuperBikeModelOption.equals("3")) {
                                        bikeModel = "KAWASAKI NINJA H2 SX";
                                    } else {
                                        System.out.println("You have chosen invalid option from KAWASAKI!");
                                    }
                                    break;
                                //case ducati super bikes
                                case "2":
                                	bikeBrand = "DUCATI";
                                	System.out.println("---"+bikeBrand+" "+bikeTypeOption+" Models ---");
                                    System.out.println("Which Model you want?");
                                    System.out.println("Press 1 --> DUCATI PANIGALE V4, Press 2 --> DUCATI PANIGALE V4 R, Press 3 --> DUCATI STREET FIGHTER V2");
                                    String ducatiSuperBikeModelOption = sc.next();
                                    if (ducatiSuperBikeModelOption.equals("1")) {
                                        bikeModel = "DUCATI PANIGALE V4";
                                    } else if (ducatiSuperBikeModelOption.equals("2")) {
                                        bikeModel = "DUCATI PANIGALE V4 R";
                                    } else if (ducatiSuperBikeModelOption.equals("3")) {
                                        bikeModel = "DUCATI STREET FIGHTER V2";
                                    } else {
                                        System.out.println("You have chosen invalid option from DUCATI!");
                                    }
                                    break;

                                //case BMW Super Bikes
                                case "3":
                                	bikeBrand = "BMW";
                                	System.out.println("---"+bikeBrand+" "+bikeTypeOption+" Models ---");
                                    System.out.println("Which Model you want?");
                                    System.out.println("Press 1 --> BMW M 1000 XR, Press 2 --> BMW S 1000 R, Press 3 --> BMW M 1000 RR");
                                    String bmwSuperBikeModelOption = sc.next();
                                    if (bmwSuperBikeModelOption.equals("1")) {
                                        bikeModel = "BMW M 1000 XR";
                                    } else if (bmwSuperBikeModelOption.equals("2")) {
                                        bikeModel = "BMW S 1000 R";
                                    } else if (bmwSuperBikeModelOption.equals("3")) {
                                        bikeModel = "BMW M 1000 RR";
                                    } else {
                                        System.out.println("You have chosen invalid option from BMW!");
                                    }
                                    break;
                                default:
                                    System.out.println("You did not selected any Super Bikes!");
                            }
                    }
                    break;
                //case for EV Bikes
                case "2":
                    fuelTypeOption = "EV";
                    System.out.println("What type of EV-Bike do you want?");
                    System.out.println("Press 1 --> Scooter, Press 2 --> Gear Bike");
                    bikeTypeOption = sc.next();
                    switch (bikeTypeOption) {

                        //case ev scooter
                        case "1":
                            bikeTypeOption = " EV Scooter";
                            System.out.println("Which Brand do you want?");
                            System.out.println("Press 1 --> OLA, Press 2 --> APRILLA, Press 3 --> ATHER");
                            bikeBrandOption = sc.next();
                            switch (bikeBrandOption) {

                                //ola ev scooters
                                case "1":
                                	 bikeBrand = "OLA";
                                	System.out.println("---"+bikeBrand+" "+bikeTypeOption+" Models ---");
                                    System.out.println("Which Model you want?");
                                    System.out.println("Press 1 --> OLA S1 Pro+, Press 2 --> OLA S1 Air, Press 3 --> OLA Gig");
                                    String olaScooterModelOption = sc.next();
                                    if (olaScooterModelOption.equals("1")) {
                                        bikeModel = "OLA S1 Pro+";
                                    } else if (olaScooterModelOption.equals("2")) {
                                        bikeModel = "OLA S1 Air";
                                    } else if (olaScooterModelOption.equals("3")) {
                                        bikeModel = "OLA Gig";
                                    } else {
                                        System.out.println("You have chosen invalid option from OLA EV!");
                                    }
                                    break;

                                //aprilla ev scooter
                                case "2":
                                	bikeBrand = "APRILLA";
                                    bikeModel = "Aprilla Typhoon";
                                	System.out.println("---"+bikeBrand+" "+bikeTypeOption+" Models ---");
                                    break;

                                //ather ev scooters
                                case "3":
                                	bikeBrand = "ATHER";
                                	System.out.println("---"+bikeBrand+" "+bikeTypeOption+" Models ---");
                                    System.out.println("Which Model you want?");
                                    System.out.println("Press 1 --> ATHER 450 S, Press 2 --> ATHER 450 X, Press 3 --> ATHER 450 APEX");
                                    String atherScooterModelOption = sc.next();
                                    if (atherScooterModelOption.equals("1")) {
                                        bikeModel = "ATHER 450 S";
                                    } else if (atherScooterModelOption.equals("2")) {
                                        bikeModel = "ATHER 450 X";
                                    } else if (atherScooterModelOption.equals("3")) {
                                        bikeModel = "ATHER 450 APEX";
                                    } else {
                                        System.out.println("You have chosen invalid option from ATHER EV!");
                                    }
                                    break;

                                default:
                                    System.out.println("You did not selected any Electric Scooters!");
                            }
                            break;

                        //case for EV Gear Bike
                        case "2":
                            bikeTypeOption = "EV Gear Bike";
                            System.out.println("Which Brand do you want?");
                            System.out.println("Press 1 --> MATTER, Press 2 --> REVOLT, Press 3 --> OBEN");
                            bikeBrandOption = sc.next();
                            switch (bikeBrandOption) {

                                //case matter ev gear bike
                                case "1":
                                	bikeBrand = "MATTER";
                                	System.out.println("---"+bikeBrand+" "+bikeTypeOption+" Models ---");
                                    System.out.println("Which Model you want?");
                                    System.out.println("Press 1 --> MATTER AERA 5000, Press 2 --> MATTER AERA 5000+");
                                    String matterBikeModelOption = sc.next();
                                    if (matterBikeModelOption.equals("1")) {
                                        bikeModel = "MATTER AERA 5000";
                                    } else if (matterBikeModelOption.equals("2")) {
                                        bikeModel = "MATTER AERA 5000+";
                                    } else {
                                        System.out.println("You have chosen invalid option from MATTER EV Gear!");
                                    }
                                    break;
                                //case revolt ev gear bike
                                case "2":
                                	bikeBrand = "REVOLT";
                                    bikeModel = "REVOLT RV400";
                                    System.out.println("---"+bikeBrand+" "+bikeTypeOption+" Models ---");
                                    break;
                                //case oben ev gear bike
                                case "3":
                                	bikeBrand = "OBEN";
                                    bikeModel = "OBEN RORR";
                                	System.out.println("---"+bikeBrand+" "+bikeTypeOption+" Models ---");
                                    break;

                                default:
                                    System.out.println("You did not selected any Electric Gear Bikes!");
                            }
                            break;
                        default:
                            System.out.println("You did not selected any EV Bikes!");
                    }
            }
        }

        double hour = 0.0;
        double totalDayRent;
        double totalHourRent;
        public double calculateRentalCost () {
            if (noOfDays > 0) {
                if (fuelTypeOption.equals("Normal") && bikeTypeOption.equals("Scooter")) {
                    if (bikeBrand.equals("SUZUKI")) {
                        totalDayRent = noOfDays * 400;
                    } else if (bikeBrand.equals("TVS")) {
                        totalDayRent = noOfDays * 400;
                    } else if (bikeBrand.equals("HONDA")) {
                        totalDayRent = noOfDays * 450;
                    }
                } else if (fuelTypeOption.equals("Normal") && bikeTypeOption.equals("Gear Bike")) {
                    if (bikeBrand.equals("BAJAJ")) {
                        totalDayRent = noOfDays * 500;
                    } else if (bikeBrand.equals("YAMAHA")) {
                        totalDayRent = noOfDays * 550;
                    } else if (bikeBrand.equals("ROYAL ENFIELD")) {
                        totalDayRent = noOfDays * 600;
                    }
                } else if (fuelTypeOption.equals("Normal") && bikeTypeOption.equals("Super Bikes")) {
                    if (bikeBrand.equals("KAWASAKI")) {
                        totalDayRent = noOfDays * 900;
                    } else if (bikeBrand.equals("DUCATI")) {
                        totalDayRent = noOfDays * 850;
                    } else if (bikeBrand.equals("BMW")) {
                        totalDayRent = noOfDays * 950;
                    }
                } else if (fuelTypeOption.equals("EV") && bikeTypeOption.equals("Scooter")) {
                    if (bikeBrand.equals("OLA")) {
                        totalDayRent = noOfDays * 200;
                    } else if (bikeBrand.equals("APRILLA")) {
                        totalDayRent = noOfDays * 230;
                    } else if (bikeBrand.equals("ATHER")) {
                        totalDayRent = noOfDays * 250;
                    }
                } else if (fuelTypeOption.equals("EV") && bikeTypeOption.equals("Gear Bike")) {
                    if (bikeBrand.equals("MATTER")) {
                        totalDayRent = noOfDays * 300;
                    } else if (bikeBrand.equals("REVOLT")) {
                        totalDayRent = noOfDays * 270;
                    } else if (bikeBrand.equals("OBEN")) {
                        totalDayRent = noOfDays * 240;
                    }
                }
                return totalDayRent;
            }

            //hourly rent
            else {
                System.out.println("Enter the no of hours: ");
                hour = sc.nextDouble();
                if (fuelTypeOption.equals("Normal") && bikeTypeOption.equals("Scooter")) {
                    if (bikeBrand.equals("SUZUKI")) {
                        totalHourRent = hour * 50;
                    } else if (bikeBrand.equals("TVS")) {
                        totalHourRent = hour * 50;
                    } else if (bikeBrand.equals("HONDA")) {
                        totalHourRent = hour * 60;
                    }
                } else if (fuelTypeOption.equals("Normal") && bikeTypeOption.equals("Gear Bike")) {
                    if (bikeBrand.equals("BAJAJ")) {
                        totalHourRent = hour * 60;
                    } else if (bikeBrand.equals("YAMAHA")) {
                        totalHourRent = hour * 65;
                    } else if (bikeBrand.equals("ROYAL ENFIELD")) {
                        totalHourRent = hour * 60;
                    }
                } else if (fuelTypeOption.equals("Normal") && bikeTypeOption.equals("Super Bikes")) {
                    if (bikeBrand.equals("KAWASAKI")) {
                        totalHourRent = hour * 200;
                    } else if (bikeBrand.equals("DUCATI")) {
                        totalHourRent = hour * 190;
                    } else if (bikeBrand.equals("BMW")) {
                        totalHourRent = hour * 210;
                    }
                } else if (fuelTypeOption.equals("EV") && bikeTypeOption.equals("Scooter")) {
                    if (bikeBrand.equals("OLA")) {
                        totalHourRent = hour * 20;
                    } else if (bikeBrand.equals("APRILLA")) {
                        totalHourRent = hour * 30;
                    } else if (bikeBrand.equals("ATHER")) {
                        totalHourRent = hour * 30;
                    }
                } else if (fuelTypeOption.equals("EV") && bikeTypeOption.equals("Gear Bike")) {
                    if (bikeBrand.equals("MATTER")) {
                        totalHourRent = hour * 70;
                    } else if (bikeBrand.equals("REVOLT")) {
                        totalHourRent = hour * 75;
                    } else if (bikeBrand.equals("OBEN")) {
                        totalHourRent = hour * 65;
                    }
                }
                return totalHourRent;
            }
        }
  
        public void printReceipt () {
            System.out.println("-------------Welcome to " + rentalName + "----------------");
            System.out.println("Customer Name: " + customer.getCustomer_name());
            System.out.println("ID Proof: " + customer.getIdproof());
            System.out.println("Age: " + customer.getAge());
            System.out.println("Contact Number: " + customer.getContactNo());
            System.out.println("License Available: " + customer.getLicenseAvl());
            System.out.println("License Available Type: " + customer.getLicenseavlType());
            System.out.println("Rent Vehicle: " + vehicleType);
            System.out.println("Fuel Type: " + fuelTypeOption);
            System.out.println("Bike Type: " + bikeTypeOption);
            System.out.println("Bike Brand: " + bikeBrand);
            System.out.println("Bike Model: " + bikeModel);
            if (customer.getNoOfDays() > 0) {
                System.out.println("No Of Days: " + customer.getNoOfDays());
                System.out.println("Rental Cost= " + totalDayRent);
            } else {
                System.out.println("Hours Taken: " + hour);
                System.out.println("Rental Cost= " + totalHourRent);
            }
            System.out.println("==========================================");
            System.out.println("THANK YOU! VISIT AGAIN!");
            sc.close();
        }
        
}



