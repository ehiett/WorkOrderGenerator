/*
 * Author: Ethan Hiett
 * Course: COP3503
 * Project #: 3
 * Title : Objects and Classes - Work Order Generator
 * Due Date: 11/27/2023
 *
 * Takes employee data file and two different ticket data files as input, reads the data into lists and queues, 
 * separates the employees by tier, then assigns each ticket to a valid employee and writes the work orders to
 * a .csv file
 * 
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/* Takes employee data file and two different ticket data files as input, reads the data into lists and queues, 
 * separates the employees by tier, then assigns each ticket to a valid employee and writes the work orders to
 * a .csv file
 */

public class Project3 {
    public static String employeeFileName = "inputData/employee_data.csv";
    public static String tier1TicketFileName = "inputData/tier1_ticket_data.csv";
    public static String tier2TicketFileName = "inputData/tier2_ticket_data.csv";
    public static String workOrderFileName = "outputData/workorder_data.csv";    
    public static ArrayList<Employee> employeeList = new ArrayList<Employee>();
    public static Queue<Ticket> tier1TicketFile = new LinkedList<Ticket>();
    public static Queue<Ticket> tier2TicketFile = new LinkedList<Ticket>();
    public static ArrayList<WorkOrder> workOrderList = new ArrayList<WorkOrder>();

    // Creates the work orders using the lists of Employees and Customers
    public static void createWorkOrders() {
        //Various variable declarations to simplify the creation of the WorkOrder objects in the proper order
        ArrayList<Employee> tier1EmployeeList = new ArrayList<Employee>();
        ArrayList<Employee> tier2EmployeeList = new ArrayList<Employee>();
        Queue<Employee> tier1EmployeeQueue = new LinkedList<Employee>();
        Queue<Employee> tier2EmployeeQueue = new LinkedList<Employee>();
        ArrayList<Employee> fullEmployeeWorkorderList = new ArrayList<Employee>();
        ArrayList<Ticket> fullTicketWorkorderList = new ArrayList<Ticket>();
        String[] splitDataArray;

        //Creates the date format for the createdDate variable of the WorkOrder constructor
        LocalDateTime currentDate = LocalDateTime.now(); 
        String createdAt = String.format(currentDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss")));

        //Iterates through the list of all employees and separates them by tier
        for(Employee employee:employeeList) {
            splitDataArray = employee.getFileData().split(",");
            if (splitDataArray.length > 4) { //tier2
                tier2EmployeeList.add(employee);
            }
            else { //tier1
                tier1EmployeeList.add(employee);
            }
        }
        //Iterates through the tier1EmployeeList adding each employee in order to tier1 and tier2 queues, repeating until
        //there is one employee in each queue for each ticket (essentially handles the assignment of the employees 
        //to the tickets in the proper order)
        int y = 0;
        for (int i = 0; i < tier1TicketFile.size(); i++) {
            if (y == tier1EmployeeList.size() - 1) {
                y = 0;
            }
            tier1EmployeeQueue.add(tier1EmployeeList.get(y));
            y++;
        }
        y = 0;
        for (int i = 0; i < tier2TicketFile.size(); i++) {
            if (y == tier2EmployeeList.size() - 1) {
                y = 0;
            }
            tier2EmployeeQueue.add(tier2EmployeeList.get(y));
            y++;
        }
        //Puts all the ordered employees into one ArrayList to simplify iteration when creating the workorders
        while (!tier2EmployeeQueue.isEmpty()) {
            fullEmployeeWorkorderList.add(tier2EmployeeQueue.remove());
        }
        while (!tier1EmployeeQueue.isEmpty()) {
            fullEmployeeWorkorderList.add(tier1EmployeeQueue.remove());
        }
        //Puts all the ordered tickets into one ArrayList to simplify iteration when creating the workorders
        for (Ticket ticket:tier2TicketFile) {
            fullTicketWorkorderList.add(ticket);
        }
        for (Ticket ticket:tier1TicketFile) {
            fullTicketWorkorderList.add(ticket);
        }        

        //Iterates through the two previous ArrayLists, creating the workorders and adding them to their own ArrayList
        WorkOrder workOrder;
        for (int i = 0; i < fullTicketWorkorderList.size(); i++) {
            workOrder = new WorkOrder(fullEmployeeWorkorderList.get(i), fullTicketWorkorderList.get(i), createdAt);
            workOrderList.add(workOrder);
        }
    }
        public static void main(String[] args) {
        System.out.println("COP3503 Project 3 - Work Order Generator \n");

        FileHandler fileHandler = new FileHandler();

        fileHandler.readEmployeeData(employeeList, employeeFileName); //Reads in the employee data file

        fileHandler.readTicketDataLog(); //Outputs "reading ticket data" to console and the log file
        
        //Reads in the ticket data files and outputs the corresponding message to the console and the log file
        tier1TicketFile = fileHandler.readTicketData(tier1TicketFileName);
        tier2TicketFile = fileHandler.readTicketData(tier2TicketFileName);
        
        fileHandler.createWorkOrdersLog(); //Outputs "creating work orders" to the consol and the log file
        createWorkOrders(); //Creates work orders
        fileHandler.writeData(workOrderFileName, workOrderList); //Ouputs work orders to the log file and work order file
    }
}
