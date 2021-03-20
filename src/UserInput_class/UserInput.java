package UserInput_class;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

import Task_class.*;


 //A class to take details  of a task from User (title, duedate, status, project)

public class UserInput {

    //Method to take input for a new task
    public Tasks addNewTask() {

        String title = giveTitle();
        LocalDate dueDate = giveDueDate();
        String status = giveStatus();
        String project = giveProject();

        // Creating a new task by providing all user defined values as parameter
        Tasks taskObject2 = new Tasks(title, dueDate, status, project);

        return taskObject2;
    }

     // Method for giving new task a title
    public static String giveTitle() {


        //ASK USER TO GIVE TITLE

        System.out.println("Add title:");
        String title = EditTasks.getInput();
        return title;

    }

     // Method for giving new task a due date
    public static LocalDate giveDueDate() {

         //  ASK USER FOR A DUE DATE
        System.out.println("Add due date of the task in format: DD-MM-YYYY");
        //Scanner reader2 = new Scanner(System.in);

        // CHECK IF CORRECT DATE FORMAT IS PROVIDED AND ITS NOT IT PAST
        LocalDate dueDate = null;
        while(true) {
            String dateInput = EditTasks.getInput();
            try {

                // FORMAT CHECK
                dueDate = LocalDate.parse(dateInput, DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH));

                // DATE CHECK (MAKE SURE DATE IS NOT IN PAST)
                if (dueDate.isAfter(LocalDate.now())) {
                    break;

                }else {
                    System.out.println("Cannot add date in past");
                    System.out.println("Add the date again");
                }
            } catch (Exception e) {
                System.out.println("You did not provide the proper format");
                System.out.println("Add the date again");
            }

        }
        return dueDate;

    }


    // Method for giving new task a status (Completed or Pending)

    public static String giveStatus() {

        System.out.println("Status of the task: Completed, Pending ");
        String status= new String();
        while (true) {
            String temp1 = EditTasks.getInput();
            if (temp1.trim().toLowerCase().equals("completed") || temp1.trim().toLowerCase().equals("pending") )
            {
                System.out.println("Status updated as: " + temp1);
                status = temp1;
                break;
            }else
                System.out.println("You entered a wrong option");
        }
        return status;

    }


    // Method for assigning a project to newly created task.

    public static String giveProject() {

         // ASK USER FOR PROJECT NAME
        System.out.println("Add a name of the project of this task: ");
        String project = EditTasks.getInput();
        return project;

    }
}
