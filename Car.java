package rental;
import java.util.Scanner;

public class Car extends Vehicle implements RentalRules{
    String carBrand, carModel;
    double yearOfExperience;
    public Car(String vehicleType, String carBrand, String carModel){
        super(vehicleType,carBrand,carModel);
    }

    public Car(String vehicleType){
        super(vehicleType);
    }

    Scanner sc= new Scanner(System.in);

    String carTypeOption="";
    String carBrandOption="";
    String carModelOption="";

    //rent for car
    public void rentVehicleType() {
        System.out.println("Enter years of Experience: ");
        yearOfExperience = sc.nextDouble();
        sc.nextLine();
        if (yearOfExperience >= 0.6) {
            System.out.println("Which type of car do you want? Press -- 1 Normal, Press 2 --> EV Cars");
            fuelTypeOption = sc.nextLine();
            switch (fuelTypeOption) {
                //case for Normal Car
                case "1":
                    fuelTypeOption = "Normal";
                    System.out.println("Which type of gear system do you want?");
                    System.out.println("Press 1 --> Manual Gear, Press 2 --> Automatic Gear");
                    carTypeOption = sc.next();
                    switch (carTypeOption) {
                        //case normal manual gear
                        case "1":
                            System.out.println("Which Brand do you want?");
                            System.out.println("Press 1 --> HONDA, Press 2 --> TATA, Press 3 --> HYUNDAI");
                            carBrandOption = sc.next();
                            //case for normal manual brand
                            switch (carBrandOption) {
                                //case for HONDA
                                case "1":
                                    System.out.println("--- HONDA Car Models ---");
                                    carBrand = "HONDA";
                                    System.out.println("Which Model you want?");
                                    System.out.println("Press 1 --> Honda Amaze, Press 2 --> Honda City, Press 3 --> Honda Civic");
                                    String hondaCarModelOption = sc.next();
                                    if (hondaCarModelOption.equals("1")) {
                                        carModel = "Honda Amaze";
                                    } else if (hondaCarModelOption.equals("2")) {
                                        carModel = "Honda City";
                                    } else if (hondaCarModelOption.equals("3")) {
                                        carModel = "Honda Civic";
                                    } else {
                                        System.out.println("You have chosen invalid option from HONDA!");
                                    }
                                    break;

                                //case for TATA
                                case "2":
                                    System.out.println("--- TATA Car Models ---");
                                    carBrand = "TATA";
                                    System.out.println("Which Model you want?");
                                    System.out.println("Press 1 --> TATA Tiago, Press 2 --> TATA Nexon, Press 3 --> TATA Punch");
                                    String tataCarModelOption = sc.next();
                                    if (tataCarModelOption.equals("1")) {
                                        carModel = "TATA Tiago";
                                    } else if (tataCarModelOption.equals("2")) {
                                        carModel = "TATA Nexon";
                                    } else if (tataCarModelOption.equals("3")) {
                                        carModel = "TATA Punch";
                                    } else {
                                        System.out.println("You have chosen invalid option from TATA!");
                                    }
                                    break;

                                //case for HYUNDAI
                                case "3":
                                    System.out.println("--- HYUNDAI Car Models ---");
                                    carBrand = "HYUNDAI";
                                    System.out.println("Which Model you want?");
                                    System.out.println("Press 1 --> Hyundai i20, Press 2 --> Hyundai i10, Press 3 --> Hyundai Creta");
                                    String hyundaiCarModelOption = sc.next();
                                    if (hyundaiCarModelOption.equals("1")) {
                                        carModel = "Hyundai i20";
                                    } else if (hyundaiCarModelOption.equals("2")) {
                                        carModel = "Hyundai i10";
                                    } else if (hyundaiCarModelOption.equals("3")) {
                                        carModel = "Hyundai Creta";
                                    } else {
                                        System.out.println("You have chosen invalid option from HYUNDAI!");
                                    }
                                    break;
                                default:
                                    System.out.println("You did not selected any manual gear system cars");
                            }
                            break;

                        //case for normal automatic gear
                        case "2":
                            System.out.println("Which Brand do you want?");
                            System.out.println("Press 1 --> MARUTI, Press 2 --> TATA, Press 3 --> KIA");
                            carBrandOption = sc.next();
                            //case for normal manual brand
                            switch (carBrandOption) {
                                //case for MARUTI Automatic
                                case "1":
                                    System.out.println("--- MARUTI Automatic Car Models ---");
                                    carBrand = "MARUTI";
                                    System.out.println("Which Model you want?");
                                    System.out.println("Press 1 --> Maruti Baleno, Press 2 --> Maruti Celerio, Press 3 --> Maruti Dzire");
                                    String marutiAutoCarModelOption = sc.next();
                                    if (marutiAutoCarModelOption.equals("1")) {
                                        carModel = "Maruti Baleno";
                                    } else if (marutiAutoCarModelOption.equals("2")) {
                                        carModel = "Maruti Celerio";
                                    } else if (marutiAutoCarModelOption.equals("3")) {
                                        carModel = "Maruti Dzire";
                                    } else {
                                        System.out.println("You have chosen invalid option from Maruti Automatic!");
                                    }
                                    break;

                                //case for TATA Automatic
                                case "2":
                                    System.out.println("--- TATA Automatic Car Models ---");
                                    carBrand = "TATA";
                                    System.out.println("Which Model you want?");
                                    System.out.println("Press 1 --> TATA Curvv, Press 2 --> TATA Harrier, Press 3 --> TATA Altroz");
                                    String tataAutoCarModelOption = sc.next();
                                    if (tataAutoCarModelOption.equals("1")) {
                                        carModel = "TATA Curvv";
                                    } else if (tataAutoCarModelOption.equals("2")) {
                                        carModel = "TATA Harrier";
                                    } else if (tataAutoCarModelOption.equals("3")) {
                                        carModel = "TATA Altroz";
                                    } else {
                                        System.out.println("You have chosen invalid option from TATA Automatic!");
                                    }
                                    break;

                                //case for KIA Automatic
                                case "3":
                                    System.out.println("---KIA Automatic Car Models ---");
                                    carBrand = "KIA";
                                    System.out.println("Which Model you want?");
                                    System.out.println("Press 1 --> KIA Seltos, Press 2 --> KIA Sonet, Press 3 --> KIA Syros");
                                    String kiaAutoCarModelOption = sc.next();
                                    if (kiaAutoCarModelOption.equals("1")) {
                                        carModel = "KIA Seltos";
                                    } else if (kiaAutoCarModelOption.equals("2")) {
                                        carModel = "KIA Sonet";
                                    } else if (kiaAutoCarModelOption.equals("3")) {
                                        carModel = "KIA Syros";
                                    } else {
                                        System.out.println("You have chosen invalid option from KIA Automatic!");
                                    }
                                    break;
                                default:
                                    System.out.println("You did not selected any automatic gear system cars");
                            }
                    }
                    break;

                    //case for EV Cars
                case "2":
                    fuelTypeOption = "EV";
                    switch (carTypeOption) {
                        case "1":
                            System.out.println("Which Brand do you want?");
                            System.out.println("Press 1 --> MAHINDRA, Press 2 --> TATA, Press 3 --> KIA");
                            carBrandOption = sc.next();
                            //case for normal manual brand
                            switch (carBrandOption) {
                                //case for HONDA
                                case "1":
                                    System.out.println("--- MAHINDRA EV Car Models ---");
                                    carBrand = "MAHINDRA";
                                    System.out.println("Which Model you want?");
                                    System.out.println("Press 1 --> MAHINDRA BE 6, Press 2 --> MAHINDRA XEV 9e, Press 3 --> MAHINDRA XUV400");
                                    String mahindraEVCarModelOption = sc.next();
                                    if (mahindraEVCarModelOption.equals("1")) {
                                        carModel = "MAHINDRA BE 6";
                                    } else if (mahindraEVCarModelOption.equals("2")) {
                                        carModel = "MAHINDRA XEV 9e";
                                    } else if (mahindraEVCarModelOption.equals("3")) {
                                        carModel = "MAHINDRA XUV400";
                                    } else {
                                        System.out.println("You have chosen invalid option from MAHINDRA EV!");
                                    }
                                    break;

                                //case for TATA
                                case "2":
                                    System.out.println("--- TATA EV Car Models ---");
                                    carBrand = "TATA";
                                    System.out.println("Which Model you want?");
                                    System.out.println("Press 1 --> TATA Tiago EV, Press 2 --> TATA Nexon EV, Press 3 --> TATA Punch EV");
                                    String tataCarModelOption = sc.next();
                                    if (tataCarModelOption.equals("1")) {
                                        carModel = "TATA Tiago EV";
                                    } else if (tataCarModelOption.equals("2")) {
                                        carModel = "TATA Nexon EV";
                                    } else if (tataCarModelOption.equals("3")) {
                                        carModel = "TATA Punch EV";
                                    } else {
                                        System.out.println("You have chosen invalid option from TATA EV!");
                                    }
                                    break;

                                //case for KIA
                                case "3":
                                    System.out.println("--- KIA EV Car Models ---");
                                    carBrand = "KIA";
                                    System.out.println("Which Model you want?");
                                    System.out.println("Press 1 --> KIA EV6, Press 2 --> KIA EV5, Press 3 --> KIA EV9");
                                    String hyundaiCarModelOption = sc.next();
                                    if (hyundaiCarModelOption.equals("1")) {
                                        carModel = "KIA EV6";
                                    } else if (hyundaiCarModelOption.equals("2")) {
                                        carModel = "KIA EV5";
                                    } else if (hyundaiCarModelOption.equals("3")) {
                                        carModel = "KIA EV9";
                                    } else {
                                        System.out.println("You have chosen invalid option from KIA EV!");
                                    }
                                    break;
                                default:
                                    System.out.println("You did not selected any EV cars");
                            }
                    }
                    break;
                    //not select both ev and normal cars
                default:
                    System.out.println("You did not select any Option!");
            }
        }
        System.out.println("Fuel Mode: "+fuelTypeOption);
        System.out.println("Car Brand: "+carBrand);
        System.out.println("Car Model: "+carModel);
    }

    public double calculateRentalCost(){
        return 0.0;
    }
    public void checkAvailability(){
    }
}

