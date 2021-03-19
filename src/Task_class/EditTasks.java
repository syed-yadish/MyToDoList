package Task_class;

import java.io.*;
import java.util.*;

import UserInput_class.*;
import Main_class.*;


public class EditTasks {

    /**
     * This method first checks if the file exist or not.
     * Then it gives an option to user to Edit it.
     * Returns an updated List.
     */

    public static List<Object> editTasksFromFile() throws IOException {

		//UserInput addData = new UserInput();
		//Tasks taskObject;
        List<Object> listOfTasks = new ArrayList<>(); // List for storing objects.
        File taskList = new File("/Users/yadishbukhari/desktop/MyToDoLy/tasksList.txt");

        if(taskList.exists() && !taskList.isDirectory()) {

            //File f = new File(fileName);
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(taskList));

            try {
                listOfTasks = (List<Object>) ois.readObject();

                System.out.println("----------------------------------- ");
                System.out.println("Edit tasks by providing task title |");
                System.out.println("(1) Update Task                    |");
                System.out.println("(2) Mark task as done              |");
                System.out.println("(3) Remove task                    |");
                System.out.println("----------------------------------- ");

                Scanner reader = new Scanner(System.in);  // Input from user
                int options  = reader.nextInt(); // Takes input as an int.

                boolean optionCheck = true;

                // WHILE LOOP TO CHECK IF CORRECT MENU OPTION IS ADDED
                while (optionCheck)
                {

                    if(options < 4 && options > 0) {
                        break;
                    }else
                        System.out.println("Add correct option");
                    options = reader.nextInt();
                }
                switch(options){

                    case 1: // UPDATE TASK

                        System.out.println("> Enter title of the task you wish to update \n");
                        String titleToSearch = getInput(); // Calling method getInput to ask the user for title
                        updateTask(titleToSearch, listOfTasks); // Calling method updateTask and providing title name and a list of tasks

                        break;

                    case 2: // MARK TASK AS DONE

                        System.out.println("> Give title of the task to mark it As Done");
                        String titleToSearch2 = getInput();
                        markTaskDone(titleToSearch2, listOfTasks); // Calling method markTaskDone

                        break;

                    case 3: // REMOVE TASK

                        System.out.println("> Enter title of the task you wish to remove ");
                        String titleToSearch3 = getInput();
                        removeTask(titleToSearch3, listOfTasks); // Calling method removeTask

                        break;
                }
            } catch (ClassNotFoundException e) {
                System.out.println("Unable to edit the task");
            }
            //System.out.println("The Object has been read from the file");
            ois.close();
        }else {
            System.out.println("File does not exist");
        }
        return listOfTasks;
    }


    public static void updateTask(String titleToSearch, List<Object> listTasks) {
        // INITIALIZING OBJECT OF CLASS TASKS
        Tasks taskObject = new Tasks();
        UserInput addData = new UserInput();

        for (int i=0; i < listTasks.size(); i++) {

            if (titleToSearch.toLowerCase().trim().equals(((Tasks) listTasks.get(i)).getTitle())) {

                System.out.println("> Details of the task you wish to update: \n");
                System.out.println(((Tasks) listTasks.get(i)).getDetails());
                taskObject = addData.addNewTask();
                System.out.println("> Updated Task: \n");
                System.out.println(taskObject.getDetails());
                listTasks.set(i, taskObject);
                System.out.println("> Object found");
            }
        }
    }


    public static void markTaskDone(String titleSearch, List<Object> listTasks) {
        Tasks taskObject = new Tasks();
        for (int i=0; i < listTasks.size(); i++) {

            if (titleSearch.toLowerCase().trim().equals(((Tasks) listTasks.get(i)).getTitle())) {
                taskObject = (Tasks) listTasks.get(i);
                System.out.println("> " + i++ + taskObject.getDetails());
                taskObject.setStatus("completed");
                listTasks.set(i, taskObject);
                System.out.println("> Updated status " + ((Tasks) listTasks.get(i)).getDetails());
                break;
            }
            else {
                System.out.println("> No such task exists");
            }
        }
    }


    public static void removeTask(String titleSearch, List<Object> listTasks) {

        Iterator<Object> it = listTasks.iterator();
        while(it.hasNext()) {
            Tasks ds = (Tasks) it.next();
            if (titleSearch.toLowerCase().trim()
                    .equals(ds.getTitle())) {
                it.remove();
                System.out.println("> Task has been removed");
                break;
            }
        }
    }


    public static String getInput() {
        Scanner scan = new Scanner(System.in);
        String userInput = "";

        try {
            userInput = scan.nextLine();
        } catch (Exception e) {
            System.out.println("Don't get you");
        }
        return userInput;
    }
}