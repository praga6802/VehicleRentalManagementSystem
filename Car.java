package rental;
import java.util.Scanner;

public class Car extends Vehicle implements RentalRules{
    String carBrand, carModel;
    double yearOfExperience;
    String fuelTypeOption="";


    //for renting car
    int noOfDays;
    public Car(String vehicleType, Customer customer){
        super(vehicleType,customer);
        this.noOfDays=customer.getNoOfDays();
    }
    public Car(){}

    //for vehicle availability
    public Car(String vehicleType, String carBrand, String carModel){
        super(vehicleType,carBrand,carModel);
    }

    String[] carBrand1= {
            "Honda","Tata","Hyundai",//normal manual
            "Maruti","Tata","Kia",//normal automatic
            "Mahindra","Tata","Kia" // ev automatic
    };

    String[][] carModel1={
        {"Honda Amaze", "Honda City", "Honda Civic"},
        {"Tata Tiago", "Tata Nexon", "Tata Punch"},
        {"Hyundai i10", "Hyundai i20", "Hyundai Creta"},
        {"Maruti Baleno", "Maruti Celerio", "Maruti Dzire"},
        {"Tata Curvv","Tata Harrier","Tata Altroz"},
        {"Kia Seltos","Kia Sonet","Kia Syros"},
        {"Mahindra BE 6","Mahindra XEV 9e", "Mahindra XUV400"},
        {"Tata Tiago EV", "Tata Nexon EV", "Tata Punch EV"},
        {"Kia EV6","KIA EV5", "KIA EV9 "}
    };
    //availability of car
    boolean[][] isRented ={
        {false, false, true},
        {true, false, true},
        {false, true, false},
        {false, false, true},
        {true,false,true},
        {true,false,false},
        {false,false, false},
        {false, false, true},
        {false,true,true}
    };

    Scanner sc= new Scanner(System.in);
    String carTypeOption="";
    String carBrandOption="";
    String carModelOption="";

    public String[] getCarBrand1() {
        return carBrand1;
    }

    public String[][] getCarModel1() {
        return carModel1;
    }

    //check availabilty for car
    public boolean checkAvailability(String carBrand, String carModel) {
        for (int i = 0; i < carBrand1.length; i++) {
            if (carBrand1[i].equalsIgnoreCase(carBrand)) {//checking out brand and this.brand is matching
                for (int j = 0; j < carModel1[i].length; j++) {
                    if (carModel1[i][j].equalsIgnoreCase(carModel)) { //check the modelname and this .model name matching
                        if (isRented[i][j]) { // if it matches with model name & it checks for available
                            return false; //if it is not rented
                        } else {
                            return true; //if it is rented
                        }
                    }
                }
                //this not matches with brand and brand model
                System.out.println("Your Car " + carModel + " is not found under " + carBrand);
                break;
            }
        }
        return false;
    }

    //rent for car
    public void rentVehicleType() {
        System.out.println("Enter years of Experience (Min Exp. 6 Months): ");
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
                            carTypeOption="Manual Gear";
                            System.out.println("Which Brand do you want?");
                            System.out.println("Press 1 --> HONDA, Press 2 --> TATA, Press 3 --> HYUNDAI");
                            carBrandOption = sc.next();
                            //case for normal manual brand
                            switch (carBrandOption) {
                                //case for HONDA
                                case "1":
                                    carBrand = "HONDA";
                                    System.out.println("---"+carBrand+" Car Models ---");
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
                                    carBrand = "Tata";
                                    System.out.println("---"+carBrand+" Car Models ---");
                                    System.out.println("Which Model you want?");
                                    System.out.println("Press 1 --> Tata Tiago, Press 2 --> Tata Nexon, Press 3 --> Tata Punch");
                                    String tataCarModelOption = sc.next();
                                    if (tataCarModelOption.equals("1")) {
                                        carModel = "Tata Tiago";
                                    } else if (tataCarModelOption.equals("2")) {
                                        carModel = "Tata Nexon";
                                    } else if (tataCarModelOption.equals("3")) {
                                        carModel = "Tata Punch";
                                    } else {
                                        System.out.println("You have chosen invalid option from TATA!");
                                    }
                                    break;

                                //case for HYUNDAI
                                case "3":
                                    carBrand = "Hyundai";
                                    System.out.println("---"+carBrand+" Car Models ---");
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
                            carTypeOption="Automatic Gear";
                            System.out.println("Which Brand do you want?");
                            System.out.println("Press 1 --> MARUTI, Press 2 --> TATA, Press 3 --> KIA");
                            carBrandOption = sc.next();
                            //case for normal manual brand
                            switch (carBrandOption) {
                                //case for MARUTI Automatic
                                case "1":
                                    carBrand = "Maruti";
                                    System.out.println("---"+carBrand+" Automatic Car Models ---");
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
                                    carBrand = "TATA";
                                    System.out.println("---"+carBrand+" Automatic Car Models ---");
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
                                    carBrand = "KIA";
                                    System.out.println("---"+carBrand+" Automatic Car Models ---");
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

                //case for EV Cars for only automatic no manual gear
                case "2":
                    fuelTypeOption = "EV";
                    carTypeOption="Automatic Gear";
                    System.out.println("Which Brand do you want?");
                    System.out.println("Press 1 --> MAHINDRA, Press 2 --> TATA, Press 3 --> KIA");
                    carBrandOption = sc.next();
                    //case for normal manual brand
                    switch (carBrandOption) {
                        //case for HONDA
                        case "1":
                            carBrand = "MAHINDRA";
                            //carTypeOption="Automatic Gear";
                            System.out.println("---"+carBrand+" EV Car Models ---");
                            System.out.println("Which Model you want?");
                            System.out.println("Press 1 --> MAHINDRA BE 6, Press 2 --> MAHINDRA XEV 9e, Press 3 --> MAHINDRA XUV400");
                            String mahindraEVCarModelOption = sc.next();
                            if(mahindraEVCarModelOption.equals("1")) {
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
                            carBrand = "TATA";
                            System.out.println("---"+carBrand+" EV Car Models ---");
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
                            carBrand = "KIA";
                      
                            System.out.println("---"+carBrand+" EV Car Models ---");
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
                    break; //case ev car done

                //not select both ev and normal cars
                default:
                    System.out.println("You did not select any Option!");
            }
        }
        else{
            System.out.println("Experience is less than 6 months! Sorry we wont provide car rentals!");
        }
    }


    double hour=0.0;
    double totalDayRent;
    double totalHourRent;
    public double calculateRentalCost() {

        //if the user enters no of days >0 day rent
        if (noOfDays > 0) {
            System.out.println("No of Days: " + noOfDays);
            if (fuelTypeOption.equals("Normal") && carTypeOption.equals("Manual Gear")) {
                if(carBrand.equals("HONDA")){
                    totalDayRent = noOfDays * 1000;
                }
                else if(carBrand.equals("TATA")){
                    totalDayRent=noOfDays * 1500;
                }
                else if(carBrand.equals("HYUNDAI")){
                    totalDayRent=noOfDays * 2000;
                }
            }
            else if (fuelTypeOption.equals("Normal") && carTypeOption.equals("Automatic Gear")) {
                if(carBrand.equals("MARUTI")){
                    totalDayRent = noOfDays * 2500;
                }
                else if(carBrand.equals("TATA")){
                    totalDayRent=noOfDays * 2700;
                }
                else if(carBrand.equals("KIA")){
                    totalDayRent=noOfDays * 3000;
                }
            }
            else if (fuelTypeOption.equals("EV")) {
                if(carBrand.equals("MAHINDRA")){
                    totalDayRent = noOfDays * 600;
                }
                else if(carBrand.equals("TATA")){
                    totalDayRent=noOfDays * 800;
                }
                else if(carBrand.equals("KIA")){
                    totalDayRent=noOfDays * 1000;
                }
            }
            return totalDayRent;
        }

        //hourly rent
        else {
            System.out.println("Enter the no of hours: ");
            hour = sc.nextDouble();
            if (fuelTypeOption.equals("Normal") && carTypeOption.equals("Manual Gear")) {
                if(carBrand.equals("HONDA")){
                    totalHourRent =hour * 300;
                }
                else if(carBrand.equals("TATA")){
                    totalHourRent=hour * 500;
                }
                else if(carBrand.equals("HYUNDAI")){
                    totalHourRent=hour * 600;
                }
            }
            else if (fuelTypeOption.equals("Normal") && carTypeOption.equals("Automatic Gear")) {
                if(carBrand.equals("MARUTI")){
                    totalHourRent =hour * 400;
                }
                else if(carBrand.equals("TATA")){
                    totalHourRent=hour * 500;
                }
                else if(carBrand.equals("KIA")){
                    totalHourRent=hour * 700;
                }
            }
            else if (fuelTypeOption.equals("EV")) {
                if(carBrand.equals("MAHINDRA")){
                    totalHourRent = hour * 200;
                }
                else if(carBrand.equals("TATA")){
                    totalHourRent=hour * 300;
                }
                else if(carBrand.equals("KIA")){
                    totalHourRent=hour * 400;
                }
            }
            return totalHourRent;
        }
    }

    public void printReceipt(){
        System.out.println("-------------Welcome to "+rentalname+"----------------");
        System.out.println("Customer Name: "+customer.getCustomer_name());
        System.out.println("Customer ID Proof: "+customer.getIdproof());
        System.out.println("Customer Age: "+customer.getAge());
        System.out.println("Customer Contact Number: "+customer.getContactNo());
        System.out.println("License Available: "+customer.getLicenseAvl());
        System.out.println("License Available Type: "+customer.getLicenseavlType());
        System.out.println("Rent Vehicle: "+vehicleType);
        System.out.println("Fuel Type: "+fuelTypeOption);
        System.out.println("Car Type: "+this.carTypeOption);
        System.out.println("Car Brand: "+carBrand);
        System.out.println("Car Model: "+carModel);
        if(customer.getNoOfDays() > 0){
            System.out.println("No Of Days: "+customer.getNoOfDays());
            System.out.println("Rental Cost= "+totalDayRent);
        }
        else{
            System.out.println("Hours Taken: "+hour);
            System.out.println("Rental Cost= "+totalHourRent);
        }
        System.out.println("==========================================");
        System.out.println("THANK YOU! VISIT AGAIN!");
    }
}

