/* Creates a Ticket object with the necessary attributes
 */
public class Ticket implements Printable{
    private Customer customer;
    private String createdAt;
    private String ticketId;

    //Ticket constructor
    public Ticket(Customer customer, String createdAt, String ticketId) {
        this.customer = customer;
        this.createdAt = createdAt;
        this.ticketId = ticketId;
    }

    //Set and get functions for all private variables
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getTicketId() {
        return ticketId;
    }

    //Utilizes the Printable interface to get the file data for Ticket objects
    @Override
    public String getFileData() {
        String fileData = customer.getFileData() + "," + getTicketId() + "," + getCreatedAt();
        return fileData;
    }
}
