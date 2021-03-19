package Main_class;

/**
 * A To Do List
 * To create and edit tasks by the user.
 *
 * Author Yadish Bukhari
 * 2021.03.01
 */


public class Main {

    /**
     * Main has two methods.
     * taskRead() >> reads tasks from the file.
     * pWelcomeS() >> prints the menu Welcome Screen and choices.
     */


    public static void main(String[] args) {
	MenuOptions.taskRead(); //checks if created task already exist.
	MenuOptions.pWelcomeScreen(); //prints the menu options at the start.
    }
}
