## Repository Disclaimer
This repository contains the files for a project I completed in my COP3503-Programming II Course during my Sophomore Year at UNF. I received a grade of 100%. 

*IT IS NOT TO BE USED TO CHEAT ON ANY COURSEWORK OR PROJECTS IN ANY WAY*

It is meant mainly to display my understanding of foundational Object Oriented Programming concepts and ability to write functional and readable code to produce a program that satisfies all deliverable requirements exactly. 

It can serve as a learning resource/general guide to anyone taking a similar course or attempting to produce a program of similar functionality. It can be ran, tested, and inspected to provide insight into different foundational programming topics/concepts and possibly inspiration for those solving similar problems. However, this program is far from perfect as there are many different areas it could be improved/optimized, so use it to learn at your own risk. 

*DO NOT COPY AND PASTE ANY PARTS OF MY CODE AND SUBMIT IT AS YOUR OWN WORK FOR ASSIGNMENTS/PROJECTS AS THAT IS PLAGARISM/CHEATING*

## Project Description/Summary

A more step-by-step description of the implementation can be found in the comments of the code, but the program essentially takes three different files as input ('employee_data.csv', 'tier1_ticket_data.csv', 'tier2_ticket_data.csv') and assigns the tickets to employees to create work orders based on tiers. Employees with certifications will be assigned tier2 tickets and employees with no certifications will be assigned tier1 tickets. Due to the large number of tickets, all employees end up with multiple work orders, but each ticket/work order is only assigned to one employee at a time. The program logs its processes and the generated work orders in the 'log.txt' file found in the outputData folder (the processes are also displayed in the console as they are completed). The generated workorders are written to the 'workorder_data.csv' file, also found in the outputData folder. 

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


## How to Run the Program

I used both CMD and PowerShell to run and test the program. 

This is the batch script I used in CMD to run the code:

C:\...\Project 3>@echo off
set "JAVA_HOME=C:\Eclipse Adoptium\jdk-17.0.6.10-hotspot"
set "CLASSPATH=C:\...\Project 3\bin"
set "OPTIONS=-XX:+ShowCodeDetailsInExceptionMessages"

"%JAVA_HOME%\bin\java.exe" %OPTIONS% -cp "%CLASSPATH%" Project3

This is the script I used in PowerShell to run the code:

PS C:\...\Project 3>  c:; cd 'c:\...\Project 3'; & 'C:\Eclipse Adoptium\jdk-17.0.6.10-hotspot\bin\java.exe' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'C:\...\Project 3\bin' 'Project3'

*Do not try to copy and directly paste the scripts into a terminal without changing the paths to the directory in which you have installed your Java compiler, and the path to the directory in which you have downloaded this repository*

This is the expected console output:

COP3503 Project 3 - Work Order Generator 

Loading Employee Data
Loading Ticket Data
Creating Work Orders
Writing Work Order Data to File
Work Orders created. Program Exiting