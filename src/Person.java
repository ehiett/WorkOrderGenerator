/* Creates a Person object with the necessary attributes
 */
public class Person implements Printable{
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String email;

    //Constructor for Person
    public Person(String firstName, String lastName, String address, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    //Set and get functions for each of the private variables
    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    //Utilizes the Printable interface to get the necessary file data that is used in the subclasses that extend Person objects
    @Override
    public String getFileData() {
        String fileData = getFirstName() + "," + getLastName();
        return fileData;
    }
}
