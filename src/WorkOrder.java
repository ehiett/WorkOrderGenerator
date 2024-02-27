/* Creates a WorkOrder object with the necessary attributes
 */
public class WorkOrder implements Printable{
    private Employee employee;
    private Ticket ticket;
    private String createdAt;

    //WorkOrder constructor
    public WorkOrder(Employee employee, Ticket ticket, String createdAt) {
        this.employee = employee;
        this.ticket = ticket;
        this.createdAt = createdAt;
    }

    //Set and get functions for all the private variables
    public void setEmployee(Employee employee) {
        this.employee = employee; 
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    //Utilizes the Printable interface to get the file data for WorkOrder objects
    @Override
    public String getFileData() {
        String fileData = ticket.getFileData() + "," + getCreatedAt() + "," + employee.getFileData();
        return fileData;
    }
}
