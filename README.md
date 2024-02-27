## Project Description/Summary

This repository contains the files for a project I completed in my COP3503-Programming II Course at UNF. 

A more step-by-step description of the implementation can be found in the comments of the code, but the program essentially takes three different files as input ('employee_data.csv', 'tier1_ticket_data.csv', 'tier2_ticket_data.csv') and assigns the tickets to employees to create work orders based on tiers. Employees with certifications will be assigned tier2 tickets and employees with no certifications will be assigned tier1 tickets. Due to the large number of tickets, all employees end up with multiple work orders, but each ticket/work order is only assigned to one employee at a time. The program logs its processes (the processes are also displayed in the console as they are completed) and the generated work orders in the 'log.txt' file found in the outputData folder. The generated workorders are also written to the 'workorder_data.csv' file, also found in the outputData folder. 

## Folder Structure

The project was developed and tested using Visual Studio Code and the Java Project Manager
extension with no build tools. The default file structure includes the first three files named below.

- `src`: folder holding the main Java sourcecode for the project
- `lib`: folder to maintain dependencies (none for this project)
- `bin`: folder holding the compiled output files
- `Instructions`:  folder containing the project instructions, deliverables, output format examples, and other resources
- `inputData`: folder holding the given input data files
- `outputData`: folder holding the output files
- `.vscode`: vscode JSON configuration file
