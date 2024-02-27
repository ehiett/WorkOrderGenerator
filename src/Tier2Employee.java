/* Creates a Tier2Employee object extended from Employee with the necessary attributes
 */
public class Tier2Employee extends Employee{
    private String certification;

    //Tier2Employee constructor
    public Tier2Employee(String firstName, String lastName, String address, String phoneNumber, String email, String employeeId, String clockedIn, String hiredDate, String certification) {
        super(firstName, lastName, address, phoneNumber, email, employeeId, clockedIn, hiredDate);
        this.certification = certification;
    }

    //Set and get functions for all the private variables
    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getCertification() {
        return certification;
    }

    //Utilizes the Printable interface to get the file data for Tier2Employee objects
    @Override
    public String getFileData() {
        String fileData = super.getFileData() + "," + getCertification();
        return fileData;
    }

}