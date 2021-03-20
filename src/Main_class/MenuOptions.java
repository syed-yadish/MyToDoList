package Main_class;

import java.util.*;
import java.io.IOException;

import Task_class.*;
import UserInput_class.*;

public class MenuOptions {

    static List<Object> listToWrite = new ArrayList<>();
    // list for writing new tasks

    public static void pWelcomeScreen()
    {
        System.out.println("--------------------------------------------");
        System.out.println(">>         Welcome to To Do List          <<");
        System.out.println("You have " + tasksNotDone() + "tasks to do and " + tasksDone() + "tasks are done" );
        System.out.println("(1) Show Task List (by date or project)     ");
        System.out.println("(2) Add New Task                            ");
        System.out.println("(3) Edit Task (mark as done, remove)");
        System.out.println("(4) Save                                    ");
        System.out.println("(5) Quit                                    ");
        System.out.println("--------------------------------------------");


        selectChoice();
    }

    // Reads tasks from the file
    public static void taskRead() {

        try {
            listToWrite = ReadWriteTask.listRead();
        }
         catch(IOException e2) {
                System.out.println("Unable to read the list");
            }

        }

     //This method counts how many tasks have been completed

    public static long tasksDone() {
     return listToWrite.stream()
     .filter(s -> "completed"
     .equals(((Tasks) s).getStatus()))
     .count();
     }


     // This method counts how many tasks are pending
    public static long tasksNotDone() {
        return listToWrite.stream().filter(s -> "pending"
                .equals(((Tasks) s).getStatus()))
                .count();
    }


    // This method asks user to select an option.

    public static void selectChoice() {

        System.out.println("Choose an option 1-4");
        Scanner reader = new Scanner(System.in); //Takes user input
        int options  = reader.nextInt(); //Takes next input as int
        boolean optionCheck = true;


        // CHECKS IF CORRECT OPTION IS ENTERED
        while (optionCheck)
        {
            if(options < 6 && options > 0){
                break;
            } else
                System.out.println("Enter correct option");
            options = reader.nextInt();
        }


        switch(options){

            case 1:
                // Show tasks list

                System.out.println("Option 1 selected: Show list of tasks");

                try {

                 //Calls ReadFromFile method from class ReadWriteTask
                 ReadWriteTask.readListFromFile();

                }
                 catch (IOException e1) {

                     System.out.println("Unable to read list from file");
                }

                pWelcomeScreen();
                break;

            case 2:

                //To add a new task
                Tasks taskObject = new Tasks();

                System.out.println("Option 2 selected");
                System.out.println("Add a new Task");

                 try {

                //Call method to add new tasks
                   //  taskObject = addData.addNewTask();
                     listToWrite.add(taskObject);
                     // add newly created task to arrayList
                     //System.out.println("taskObject has been written to listToWrite");
                 }

                 catch (NullPointerException e){
                    System.out.println("Invalid data entered");
                }

                pWelcomeScreen();
                break;

            case 3:
                // Edit tasks
                System.out.println("Option 3 selected");
                System.out.println("Edit Task"); //update, mark as done, remove.

                try {
                    listToWrite = EditTasks.editTasksFromFile();
                    int k = 1;
                    for (Object first : listToWrite) {

                        System.out.println(">" + k++ + " " + ((Tasks) first).getDetails());

                    }
                }

                catch (IOException e) {

                 System.out.println("Unable to edit the task");
                }

                pWelcomeScreen();
                break;

            case 4:
                //save the list of tasks
                ReadWriteTask inputOutput= new ReadWriteTask();

                System.out.println("Option 4 selected");
                System.out.println("Save Task");

                try {
                    inputOutput.writeListToFile(listToWrite);
                }
                catch (Exception e) {
                 System.out.println("Unable to save the task");
                }

                pWelcomeScreen();
                break;

            case 5:
                //To quit from program

                System.out.println("You choose to quit");
                System.out.println("Good Bye");
                System.exit(0);
                break;

                    default:
                        System.out.println("invalid option");
        }
    }
}
