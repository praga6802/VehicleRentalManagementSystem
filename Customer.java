package rental;
import java.util.Scanner;
public class Customer {
    private String idproof, customer_name, contactNo, licenseavl, licenseavlType, rentVehicleType;
    private int age, noOfDays;
    Scanner sc= new Scanner(System.in);
    //customer details
    Customer(String idproof,String customer_name, String contactNo, int age, int noOfDays, String licenseavl, String licenseavlType, String rentVehicleType){
        this.customer_name=customer_name;
        this.idproof=idproof;
        this.contactNo=contactNo;
        this.age=age;
        this.licenseavl=licenseavl;
        this.licenseavlType=licenseavlType;
        this.rentVehicleType=rentVehicleType;
        this.noOfDays=noOfDays;
    }
    public Customer(){

    }

    //setters()
    public void setCustomer(String customer_name){
        this.customer_name=customer_name;
    }
    public void setIdproof(String idproof){
        this.idproof=idproof;
    }
    public void setContactNo(String contactNo){
        this.contactNo=contactNo;
    }
    public void setAge(int age){
        this.age=age;
    }
    public void setRentVehicleType(String rentVehicleType){
        this.rentVehicleType=rentVehicleType;
    }
    public void setNoOfDays(int noOfDays){
        this.noOfDays=noOfDays;
    }
    public void setLicenseavlType(String licenseavlType){
        this.licenseavlType=licenseavlType;
    }
    public void setLicenseAvl(String licenseavl){
        this.licenseavl=licenseavl;
    }

    //getters()
    public String getCustomer_name(){
        return customer_name;
    }
    public String getContactNo(){
        return contactNo;
    }
    public int getAge(){
        return age;
    }
    public String getRentVehicleType(){
        return rentVehicleType;
    }
    public int getNoOfDays(){
        return noOfDays;
    }
    public String getLicenseavlType(){
        return licenseavlType;
    }
    public String getLicenseAvl(){
        return licenseavl;
    }
    public String getIdproof(){
        return idproof;
    }

    //String idproof,String customer_name, String contactNo, int age, int noOfDays, String licenseavl, String licenseavlType, String rentVehicleType
    public void enterCustomerDetails(){
        System.out.println("Customer name: "+customer_name);
        System.out.println("Id proof: "+idproof);
        System.out.println("ContactNo: "+contactNo);
        System.out.println("Age: "+age);
        System.out.println("No Of Days: "+noOfDays);
        System.out.println("License Available: "+licenseavl);
        System.out.println("Type of License Available: "+licenseavlType);
        System.out.println("Renting Vehicle: "+rentVehicleType);
    }
}
