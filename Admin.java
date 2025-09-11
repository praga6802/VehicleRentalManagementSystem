package rental;

import javax.management.MBeanRegistration;
import java.util.*;


//hi
public class Admin {
    Scanner sc= new Scanner(System.in);
    private final String userName="Praga";
    private final String password="Praga@123";
    Vehicle vehicle=null;
    AdminService as=null;

    public boolean login(String username, String password) {
        return username.equals(userName) && password.equals(password);
    }


    public void adminMenu() {
        AdminService as= new AdminService();
        List<String> menu= Arrays.asList("Add Vehicle", "Remove Vehicle", "Update Vehicle", "Delete Vehicle", "Exit");
        int choice=0;
        while (true) {
            for (int i = 0; i < menu.size(); i++) {
                System.out.println("Press " + (i + 1) + "-> " + menu.get(i));
            }
            try{
                System.out.println("Enter the Choice: ");
                choice = sc.nextInt();
                sc.nextLine();
                break;
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input, Please enter a number");
            }
        }
        switch (choice) {
            case 1 -> as.addVehicle();
            case 2 -> as.removeVehicle();
            case 3 -> as.editVehicle();
            case 4 -> as.showAllVehicles();
            case 5->{
                System.out.println("You have chosen Exit Option");
            }
            default -> System.out.println("Invalid input, Please try again");
        }
    }
}
