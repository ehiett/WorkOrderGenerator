import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/* Contains all the necessary methods to read in the data from the files, and then writes the workOrders to their own file 
 * Also outputs all the necessary messages to the console and the log file
 */
public class FileHandler {
    private static final DateTimeFormatter LOG_DATE_FORMAT = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss"); //Date format for the log file

    //Writes the workOrder data to a file from the workOrder ArrayList
    public void writeData(String workOrderFileName, ArrayList<WorkOrder> workOrderList) {
        FileWriter fileWriter;
        logger("Writing Work Order Data to File");
        System.out.println("Writing Work Order Data to File");
        try {
            fileWriter = new FileWriter(workOrderFileName);
            PrintWriter printWriter = new PrintWriter(fileWriter);     
            printWriter.println("customer_id,customer_first_name,customer_last_name,ticket_id,ticket_createdAt,workorder_createdAt,employee_id,employee_first_name,employee_last_name,clocked_in,certification");       
            //Iterates through all the workOrders in the list, gets the data, and outputs the data to the file and log line-by-line
            for (WorkOrder workOrder:workOrderList) {
                printWriter.println(workOrder.getFileData());
                logger(workOrder.getFileData());
            }
            logger("Work Orders created. Program Exiting");
            System.out.println("Work Orders created. Program Exiting");
            printWriter.close();
        } 
        catch (IOException e) { //Catches possible input stream errors from the fileWriter/printWriter
            e.getMessage();
        }
		
    }

    //Reads in the data from the employee files and adds each Employee object to their respective ArrayList based on tier
    public void readEmployeeData(ArrayList<Employee> employeeList, String employeeFileName) {
        String[] splitData;
        String tier = "";
        System.out.println("Loading Employee Data");
        logger("Loading Employee Data");
        try (Scanner scnr = new Scanner(new FileReader(employeeFileName))) {
            scnr.nextLine();
            while (scnr.hasNextLine()) {
                splitData = scnr.nextLine().split(","); //Separates the Employee attributes so the tier can be checked
                tier = splitData[8];

                if (tier.equals("tier2")) {
                    Tier2Employee employee = new Tier2Employee(splitData[1], splitData[2], splitData[4], splitData[5], splitData[3], splitData[0], splitData[6], splitData[7], splitData[9]);
                    employeeList.add(employee);
                }
                else if (tier.equals("tier1")) {
                    Employee employee = new Employee(splitData[1], splitData[2], splitData[4], splitData[5], splitData[3], splitData[0], splitData[6], splitData[7]);
                    employeeList.add(employee);
                }
            }
        } 
        catch (FileNotFoundException e) { //Catches possible errors raised by trying to read the data from the given file
            e.getMessage();
        }
    }

    //Prints messages the console and the log file 
    public void readTicketDataLog() {
        System.out.println("Loading Ticket Data");
        logger("Loading Ticket Data");
    }
    //Prints messages the console and the log file
    public void createWorkOrdersLog() {
        System.out.println("Creating Work Orders");
        logger("Creating Work Orders");
    }
    //Reads the ticket data in from the ticket file given in the argument and stores the Ticket objects in an ArrayList
    public LinkedList<Ticket> readTicketData(String ticketFileName) {
        LinkedList<Ticket> ticketList = new LinkedList<Ticket>();
        String[] splitData;

        try (Scanner scnr = new Scanner(new FileReader(ticketFileName))) {
            scnr.nextLine();
            //Creates the Customer object then the Ticket object, which uses the Customer object as an attribute,
            //then adds the Ticket to the ArrayList
            while (scnr.hasNextLine()) { 
                splitData = scnr.nextLine().split(",");
                Customer customer = new Customer(splitData[1], splitData[2], splitData[4], splitData[5], splitData[3], splitData[0], splitData[6]);
                Ticket ticket = new Ticket(customer, splitData[8], splitData[7]);
                ticketList.add(ticket);
            }
        }
        catch (FileNotFoundException e) { //Catches possible errors raised by trying to read the data from the given file
            e.getMessage();
        }

        return ticketList;
    }

    //Creates the log message format and outputs the message provided in the argument to the log file
    private void logger(String log) {
        LocalDateTime currentDate = LocalDateTime.now();
        String formattedLog = String.format("log: %s : %s", currentDate.format(LOG_DATE_FORMAT), log);
        try (PrintWriter printWriter = new PrintWriter(new FileWriter("outputData/log.txt", true))) {
            printWriter.println(formattedLog);
        } 
        catch (IOException e) { //Catches possible input stream errors
            e.getMessage();
        }
    }
}
