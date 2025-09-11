package rental;

import java.util.List;
import java.util.Scanner;

import static rental.RentalRules.*;

public class VehicleRentMain{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Vehicle vehicle = null;
		System.out.println("Welcome to "+ COMPANY_NAME+"..");
		System.out.println("Press 1 -> Admin, Press 2 -> User");
		int logChoice=sc.nextInt();
		switch (logChoice) {
			case 1:
				System.out.println("Enter Admin User name");
				String username = sc.next();
				System.out.println("Enter the password: ");
				String password = sc.next();
				Admin admin = new Admin();
				if (admin.login(username, password) == true) {
					admin.adminMenu();
				} else {
					System.out.println("Invalid User name or password");
				}
				break;

			case 2:
				Customer customer= new Customer();
				customer.customerMenu();
				break;

			default:
				System.out.println("Invalid Option! UnAuthorized User");
		}
	}
}
