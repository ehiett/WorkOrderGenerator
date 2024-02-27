/* Creates a Customer object extended from Person with the necessary attributes
 */
public class Customer extends Person {
    private String customerId;
    private String accountNumber;

    //Customer constructor
    public Customer(String firstName, String lastName, String address, String phoneNumber, String email, String customerId, String accountNumber) {
        super(firstName, lastName, address, phoneNumber, email);
        this.customerId = customerId;
        this.accountNumber = accountNumber;
    }

    //Set and get functions for all the private variables
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    
    //Utilizes the Printable interface to get the file data for Customer objects
    @Override
    public String getFileData() {
        String fileData = getCustomerId() + "," + super.getFileData();
        return fileData;
    }
}
