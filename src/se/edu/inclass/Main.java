package se.edu.inclass;

import se.edu.inclass.data.DataManager;
import se.edu.inclass.task.Deadline;
import se.edu.inclass.task.Task;
import se.edu.inclass.task.TaskNameComparator;

import java.util.ArrayList;

public class Main {

    private TaskNameComparator taskNameComparator;

    public static void main(String[] args) {
        System.out.println("Welcome to Task (stream) manager\n");
        DataManager dm = new DataManager("./data/data.txt");
        ArrayList<Task> tasksData = dm.loadData();


        System.out.println();
        System.out.println("Printing deadlines");
        printDeadlines(tasksData);
        printDeadlinesUsingString(tasksData);
        System.out.println("Total number of values " + countDeadlineUsingStream(tasksData));

        System.out.println("Total number of deadlines: " + countDeadlines(tasksData));
        printData(tasksData);
        printDataUsingStream(tasksData);
    }

    private static int countDeadlineUsingStream(ArrayList<Task> tasks) {
        int count =(int)tasks.stream()
                .filter(t -> t instanceof Deadline)
                .count();

        return count;
    }
    private static int countDeadlines(ArrayList<Task> tasksData) {
        int count = 0;
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                count++;
            }
        }
        return count;
    }

    public static void printData(ArrayList<Task> tasksData) {
        System.out.println("Printing data using iteration");
        for (Task t : tasksData) {
            System.out.println(t);
        }
    }

    public static void printDataUsingStream (ArrayList<Task> tasks) {
        System.out.println("Printing data using streams");
        tasks.stream() // Convert to stream
                .forEach(System.out::println);
        //tasks.parallelStream() // Good for large amounts of data
    }
    public static void printDeadlines(ArrayList<Task> tasksData) {
        System.out.println("Printing data using iteration");
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                System.out.println(t);
            }
        }
    }

    public static void printDeadlinesUsingString(ArrayList<Task> tasks) {
        System.out.println("Printing data using streams");
        tasks.stream()
                .filter(t -> t instanceof Deadline) // Filtering based on this check
                .forEach(System.out::println);
    }
}
