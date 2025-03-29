package rental;
import java.util.Scanner;


public class Bike extends Vehicle implements RentalRules{
    String bikeBrand, bikeModel;
    double bikeRentPricePerDay;
    public Bike(String vehicleType, String bikeBrand, String bikeModel){
        super(vehicleType, bikeBrand, bikeModel);
    }

    public Bike(String vehicleType){
        super(vehicleType);
    }

    Customer customer;
    Scanner sc = new Scanner(System.in);

    String bikeBrandOption="";
    String bikeTypeOption="";

    public void rentVehicleType() {
        System.out.println("Which mode of bike do you want? Press -- 1 Normal or Press 2 --> EV Bikes");
        fuelTypeOption = sc.nextLine();
        switch (fuelTypeOption) {

            //case Normal Bikes
            case "1":
                fuelTypeOption="Normal";
                System.out.println("What type of bike do you want?");
                System.out.println("Press 1 --> Scooter, Press 2 --> Gear Bike, Press 3 --> Super Bikes");
                bikeTypeOption = sc.next();
                switch (bikeTypeOption) {
                    //case scooters
                    case "1":
                        System.out.println("Which Brand do you want?");
                        System.out.println("Press 1 --> SUZUKI, Press 2 --> TVS, Press 3 --> HONDA");
                        bikeBrandOption = sc.next();
                        switch (bikeBrandOption) {

                            //Suzuki Scooters
                            case "1":
                                System.out.println("--- SUZUKI SCOOTER Models ---");
                                bikeBrand = "SUZUKI";
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
                                System.out.println("--- TVS SCOOTER Models ---");
                                bikeBrand = "TVS";
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
                                System.out.println("--- HONDA SCOOTER Models ---");
                                bikeBrand = "HONDA";
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
                        System.out.println("Which Brand do you want?");
                        System.out.println("Press 1 --> BAJAJ, Press 2 --> YAMAHA, Press 3 --> ROYAL ENFIELD");
                        bikeBrandOption = sc.next();
                        //case for bike brand
                        switch (bikeBrandOption) {
                            //Bajaj Gear Bikes
                            case "1":
                                System.out.println("--- BAJAJ Bike Models ---");
                                bikeBrand = "BAJAJ";
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
                                System.out.println("--- YAMAHA Bike Models ---");
                                bikeBrand = "YAMAHA";
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
                                System.out.println("--- ROYAL ENFIELD Bike Models ---");
                                bikeBrand = "ROYAL ENFIELD";
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
                        System.out.println("Which Brand do you want?");
                        System.out.println("Press 1 --> KAWASAKI, Press 2 --> DUCATI, Press 3 --> BMW");
                        bikeBrandOption = sc.next();
                        switch (bikeBrandOption) {

                            //Kawasaki Super Bikes
                            case "1":
                                System.out.println("--- KAWASAKI Super Bikes ---");
                                bikeBrand = "KAWASAKI";
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
                                System.out.println("--- DUCATI Super Bikes ---");
                                bikeBrand = "DUCATI";
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
                                System.out.println("--- BMW Super Bikes ---");
                                bikeBrand = "BMW";
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
                fuelTypeOption="EV Bike";
                System.out.println("What type of EV-Bike do you want?");
                System.out.println("Press 1 --> Scooter, Press 2 --> Gear Bike");
                bikeTypeOption = sc.next();
                switch (bikeTypeOption) {

                    //case ev scooters
                    case "1":
                        System.out.println("Which Brand do you want?");
                        System.out.println("Press 1 --> OLA, Press 2 --> APRILLA, Press 3 --> ATHER");
                        bikeBrandOption = sc.next();
                        switch (bikeBrandOption) {

                            //ola ev scooters
                            case "1":
                                System.out.println("--- OLA EV Scooters ---");
                                bikeBrand = "OLA";
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
                                System.out.println("--- APRILLA EV Scooters ---");
                                bikeBrand = "APRILLA";
                                bikeModel = "Aprilla Typhoon";
                                break;

                            //ather ev scooters
                            case "3":
                                System.out.println("--- ATHER EV Scooters ---");
                                bikeBrand = "ATHER";
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

                        //case for EV Gear Bike
                    case "2":
                        System.out.println("Which Brand do you want?");
                        System.out.println("Press 1 --> MATTER, Press 2 --> REVOLT, Press 3 --> OBEN");
                        bikeBrandOption = sc.next();
                        switch (bikeBrandOption) {

                            //case matter ev gear bike
                            case "1":
                                System.out.println("--- MATTER EV Gear Bikes ---");
                                bikeBrand = "MATTER";
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
                                System.out.println("--- REVOLT EV Gear Bikes ---");
                                bikeBrand = "REVOLT";
                                bikeModel = "REVOLT RV400";
                                break;
                            //case oben ev gear bike
                            case "3":
                                System.out.println("--- OBEN EV Gear Bikes ---");
                                bikeBrand = "OBEN";
                                bikeModel = "OBEN RORR";
                                break;

                            default:
                                System.out.println("You did not selected any Electric Gear Bikes!");
                        }
                }
            }
        System.out.println("Fuel Mode: "+fuelTypeOption);
        System.out.println("Bike Brand: "+bikeBrand);
        System.out.println("Bike Model: "+bikeModel);
    }

    public double calculateRentalCost(){
        return 0.0;
    }

    public void checkAvailability(){}
}


