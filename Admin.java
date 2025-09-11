package rental;

import javax.management.MBeanRegistration;
import java.util.*;

public class Admin {
    Scanner sc= new Scanner(System.in);
    private final String userName="Praga";
    private final String passWord="Praga@123";
    Vehicle vehicle=null;
    AdminService as=null;

    public boolean login(String username, String password) {
        return username.equals(userName) && password.equals(passWord);
    }


    public void adminMenu() {
        List<String> menu=Arrays
        while (true){
            System.out.println("Press 1 -> Add Vehicle");
            System.out.println("Press 2 - > Remove Vehicle");
            System.out.println("Press 3 -> Edit the Vehicle");
            System.out.println("Press 4 -> Show All Vehicles");
            System.out.println("Press 5 -> Exit");
            System.out.println("Enter the Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> as.addVehicle();
                case 2 -> as.removeVehicle();
                case 3 -> as.editVehicle();
                case 4 -> as.showAllVehicles();
                case 5 -> exit();
                default -> System.out.println("Invalid choice entered..please enter the correct choice");
            }
        }
    }

    public void exit(){
        System.out.println("You have choosen Exit Option");
        System.exit(0);
    }

}
