package Task_class;

import java.time.*;
import java.io.*;

import UserInput_class.*;
import Main_class.*;



     // A class to add task details (title, due date, status, project name).

    public class Tasks {


        private String taskTitle;
        private LocalDate dueDate;
        private String status;
        private String project;

        public Tasks() {} // Constructor with no parameters

        public Tasks(String taskTitle, LocalDate dueDate, String status, String project) {

            this.taskTitle = taskTitle;
            this.dueDate = dueDate;
            this.status = status;
            this.project = project;
        }

 //For the title

        public String getTitle()
        {
            return taskTitle;
        }

        public void setTitle(String title)
        {
            this.taskTitle = title;
        }

 // For the due date
        public LocalDate getDueDate()

        {
            return dueDate;
        }

        public void setDueDate(LocalDate dueDate)

        {
            this.dueDate = dueDate;
        }



        // For status of the project.

        public String getStatus()
        {
            return status;
        }


        public void setStatus(String status)
        {
            this.status = status;
        }

 //For the project of the task

        public String getProject()

        {
            return project;
        }

        public void setProject(String project)
        {
            this.project = project;
        }


         // Return all the task details

        public String getDetails()
        {
            return (" Title = " + taskTitle + ", " + " Due date = " + dueDate + ", " + " project = " + project);
        }

    }