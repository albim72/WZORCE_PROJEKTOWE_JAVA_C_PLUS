public class Main {
    public static void main(String[] args) {
        CustomerCSV oldCustomer = new CustomerCSV("John,Smith,johnsm@yahoo.com,+48876432123");
        //Adapter do wykorzystania w nowym wydaniu
        CustomerJSON adaptedCustomer = new CustomerAdapter(oldCustomer);

        System.out.println("Full name: " + adaptedCustomer.getFullName());
        System.out.println("Email: " + adaptedCustomer.getEmail());
        System.out.println("Phone Number: " + adaptedCustomer.getPhoneNumber());
    }
}
