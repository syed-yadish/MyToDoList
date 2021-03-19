package Task_class;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.*;
import java.time.*;

import UserInput_class.*;
import Main_class.*;

//Class to read from a file and write to a file

public class ReadWriteTask {
    static List<Object> input = new ArrayList<>();
    static File taskList = new File("/Users/yadishbukhari/desktop/MyToDoLy/tasksList.txt");

    public ReadWriteTask() {
    }
        //This method will save tasks to a given location in directory.

        public void writeListToFile(List<Object> storeList) throws IOException
    {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(taskList));
        oos.writeObject(storeList);
        oos.flush();
        oos.close();
            System.out.println("The Object was successfully written to a file");
        }

    /**
     * This method reads the list of tasks from the given location.
     * It is the first method that is called.
     */

    public static List<Object> taskRead() throws IOException {

        if(taskList.exists() && !taskList.isDirectory()) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(taskList));
            try {
                input = (List<Object>) ois.readObject();
            }
            catch (ClassNotFoundException e) {
                System.out.println("Unable to read from file");
            }
        }
        return input;
    }

    /**
     * This method first check if the file exists or not.
     * It then reads the file and gives 3 options to the user
     * on how he wants to see the tasks.
     */
    public static List<Object> readListFromFile() throws IOException {

    System.out.println("------------------------------ ");
    System.out.println("(1) Show Entire Task List     |");
    System.out.println("(2) Show task list by date    |");
    System.out.println("(3) Sort by date              |");
    System.out.println("(4) Show task list by project |");
    System.out.println("------------------------------");


        Scanner reader = new Scanner(System.in);  // Reading from System.in
        int options  = reader.nextInt(); // Scans the next token of the input as an int.

        boolean optionCheck = true;

        // WHILE LOOP TO CHECK IF CORRECT MENU OPTION IS ADDED
        while (optionCheck)
        {

            if(options < 5 && options > 0) {
                break;

            }else
                System.out.println("Add correct option");
            options = reader.nextInt();

        }

        switch(options){
            // display entire list
            case 1:
                int k=1;
                for(Object first: input) {

                    System.out.println("> " + k++ + " " + ((Tasks) first).getDetails());
                }
                break;

            // search by given date
            case 2:
                System.out.println("Add date to search in format: DD-MM-YYYY");
                // Scanner reader2 = new Scanner(System.in);
                String dateToSearch = EditTasks.getInput(); // Calling getInput method from class EditTasks
                searchByDate(dateToSearch, input);

                break;

            // sort by date
            case 3:

                sortByDate(); // Calling method sort by date

                break;

            // search by project name
            case 4:
                System.out.println("Enter project name \n");

                String projectToSearch = EditTasks.getInput();
                searchByProject(projectToSearch);

        }
        return input;
    }

     // Method to search the list by given date.

    public static void searchByDate(String dateToSearch, List<Object> input) {

        boolean checkDateFormat=true;

        // while loop for checking date format
        while(checkDateFormat) {
            try {
                final LocalDate dateToSearchParsed = LocalDate.parse(dateToSearch, DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH));

                boolean dateFound=true;
                while(dateFound) {
                    try {
                        input.stream().filter(s-> dateToSearchParsed
                                .equals(((Tasks) s).getDueDate()))
                                .forEach(s-> System.out.println(((Tasks) s).getDetails()));
                        dateFound = false;
                    } catch (Exception e) {
                        System.out.println("Date not in system");

                    }
                }
                checkDateFormat = false;
            } catch (Exception e) {
                System.out.println("You did not provide the proper format");

            }
            break;
        }
    }

     //Method to sort the list of tasks by date

    public static void sortByDate() {

        try {
            // Sort the list by dates
            input.stream().sorted((o1, o2)->((Tasks) o1)
                    .getDueDate().compareTo(((Tasks)o2)
                            .getDueDate()))
                    .forEach(s-> System.out.println(((Tasks) s)
                            .getDetails()));


        } catch (Exception e) {
            System.out.println("Date not in system");
        }
    }

    /**
     * Method to search the task list by providing the project name
     */

    public static void searchByProject(String projectToSearch) {
        boolean search = true;
        if (search) {
            input.stream().filter(s-> projectToSearch.equals(((Tasks) s).getProject()))
                    .forEach(s-> System.out.println(((Tasks) s).getDetails()));
        }else {

            System.out.println("No such project exists in database");
        }
    }
}

