/* Creates an Employee object extended from Person with the necessary attributes
 */
public class Employee extends Person{
    private String employeeId;
    private String clockedIn;
    private String hiredDate;

    //Employee constructor
    public Employee(String firstName, String lastName, String address, String phoneNumber, String email, String employeeId, String clockedIn, String hiredDate) {
        super(firstName, lastName, address, phoneNumber, email);
        this.employeeId = employeeId;
        this.clockedIn = clockedIn;
        this.hiredDate = hiredDate;
    }

    //Set and get functions for all the private variables
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setClockedIn(String clockedIn) {
        this.clockedIn = clockedIn;
    }

    public void setHiredDate(String hiredDate) {
        this.hiredDate = hiredDate;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getClockedIn() {
        return clockedIn;
    }

    public String getHiredDate() {
        return hiredDate;
    }

    //Utilizes the Printable interface to get the file data for Employee objects
    @Override
    public String getFileData() {
        String fileData = getEmployeeId() + "," + super.getFileData() + "," + getClockedIn();
        return fileData;
    }
    
}
