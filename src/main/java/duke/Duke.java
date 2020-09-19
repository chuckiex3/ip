package duke;

import duke.commands.Deadline;
import duke.commands.Event;
import duke.commands.Task;
import duke.commands.ToDo;
import duke.exceptions.DukeException;
import duke.exceptions.SaveFileException;
import duke.exceptions.TimeException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.String;

import static duke.Save.convertTextToTask;

public class Duke {
    public static int numberOfTasks = 0; // stores the number of tasks saved
    public static Scanner in = new Scanner(System.in);
    public static final ArrayList<Task> tasks = new ArrayList<>();
    public static File fileName =  new File ("./data/taskList.txt");
    public static String fileDirectory = ("./data");
    public static boolean notQuit = true;

    public static void main(String[] args) throws Exception {
        Printer.printGreeting();
        findSavedFile();

        do {
            getMessage();
        } while (notQuit);
    }

    /**
     * creates a .txt file if no file can be found
     * otherwise load content that has been saved previously into the ArrayList
     *
     * @throws Exception when file cannot be found
     */
    private static void findSavedFile() throws Exception {
        try {
            File folder = new File(fileDirectory);
            if (folder.exists()) {
                System.out.println("folder has been found @" + folder.getAbsolutePath());
            } else {
                folder.mkdir();
                System.out.println("\tweewoo Toto has made a folder~");
            }

            if (fileName.createNewFile()) {
                System.out.println("hehe Toto just made a new file for you! @ "
                        + fileName.getAbsolutePath() + " :o3");
                Printer.printDivider();
            } else {
                System.out.println("\tToto found your saved file..");
                Scanner s = new Scanner(fileName);
                while (s.hasNext()) {
                    String input = s.nextLine();
                    tasks.add(convertTextToTask(input));
                    numberOfTasks++;
                }
                Printer.printSaveMessage();
            }
        } catch (FileNotFoundException f) {
            System.out.print("file not found");
        }
    }

    /**
     * gets command(s) from the user and executes it(them) appropriately
     * available duke.commands: list, done, deadline, event, todo
     *
     * @throws DukeException when task description is missing from [input]
     * @throws TimeException when [time] is missing from [input]
     * @throws SaveFileException when there are exceptions thrown when opening/saving file
     */
    private static void getMessage() throws Exception {
        String input = in.nextLine();
        try {
            if (input.equals("bye")) {
                Printer.printBye();
                notQuit = false;
            } else if (input.equals("list")) {
                listTasks(tasks);
            } else if (input.contains("done")) {
                markAsDone(input);
                if (numberOfTasks == 0) {
                    throw new SaveFileException();
                }
            } else if (input.contains("delete")) {
                deleteTask(input);
            } else if (input.contains("deadline")) {
                addDeadline(input);
            } else if (input.contains("event")) {
                addEvent(input);
            } else if (input.contains("todo")) {
                addToDo(input);
            } else {
                Printer.printErrorMessage();
            }
        } catch (DukeException d) {
            System.out.println("\tno task description! :o");
            Printer.printDivider();
        } catch (TimeException t) {
            System.out.println("\tno time given! you don't have forever though...owo");
            Printer.printDivider();
        } catch (SaveFileException s) {
            System.out.println("\tencountered problems when saving!");
            Printer.printDivider();
        }
    }

    /**
     * prints out everything in the ArrayList of tasks
     *
     * @param tasks ArrayList of tasks
     */
    public static void listTasks (ArrayList<Task> tasks) {
        Printer.printDivider();
        if (numberOfTasks == 0) {
            System.out.println("\tyour task list is empty");
        } else {
            for (int j = 0; j < numberOfTasks; j++) {
                System.out.println((j+1) + ": " + tasks.get(j));
            }
        }
        Printer.printDivider();
    }

    /**
     * add deadline to tasks list
     * e.g. deadline [input] /by [time]
     *
     * @param input task description
     * @throws DukeException when there is no task description in the [input]
     * @throws TimeException when [time] is missing from [input]
     */

    private static void addDeadline(String input) throws Exception {
        if (input.contains("/by")) {
            //splits the string into two parts, using "/by" as the divider
            input = input.replace("deadline", " ").trim();
            int dividerPosition = input.indexOf("/by");
            String by = input.substring(dividerPosition + 3).trim();
            String taskDescription = input.substring(0, dividerPosition).trim();

            //checks if there is any missing information - by, taskDescription
            if (taskDescription.isBlank()) { //if there is no task description
                throw new DukeException();
            } else if (by.isBlank()) { // if there is no [time] given
                throw new TimeException();
            } else { //if no problem with input
                numberOfTasks++;
                tasks.add(new Deadline(taskDescription, by));
                Printer.printDivider();
                System.out.println("\tToto added: " + taskDescription);
                System.out.println(numberOfTasks + ":" + tasks.get(numberOfTasks - 1));
                System.out.println("\tnow you have " + numberOfTasks + " task(s)");
                Printer.printDivider();
                Save.saveToTaskList(tasks, fileName);
            }
        } else { // when [time] parameter is missing
            throw new TimeException();
        }
    }

    /**
     * adds an event to tasks list
     * e.g. event [input] /at [time]
     *
     * @param input task description
     * @throws DukeException when there is no task description in the [input]
     * @throws TimeException when [time] is missing from [input]
     */
    private static void addEvent(String input) throws Exception {
        if (input.contains("/at")) {
            // splits the string into two parts, using "/at" as the divider
            input = input.replace("event", " ");
            int dividerPosition = input.indexOf("/at");
            String time = input.substring(dividerPosition + 3).trim();
            String taskDescription = input.substring(0, dividerPosition).trim();

            // checks if there is any missing information - time, taskDescription
            if (taskDescription.isBlank()) { //if there is no task description
                throw new DukeException();
            } else if (time.isBlank()) { //if there is no [time] given
                throw new TimeException();
            } else { //if no problem with input
                numberOfTasks++;
                tasks.add(new Event(taskDescription, time));
                Printer.printDivider();
                System.out.println("\tToto added: " + taskDescription);
                System.out.println(numberOfTasks + ":" + tasks.get(numberOfTasks - 1));
                System.out.println("\tnow you have " + numberOfTasks + " task(s)");
                Printer.printDivider();
                Save.saveToTaskList(tasks, fileName);
            }
        } else { // when [time] parameter is missing
            throw new TimeException();
        }
    }

    /**
     * adds to-do to the tasks
     * e.g. todo [input]
     *
     * @param input task description
     * @throws DukeException when task description is empty
     */
    private static void addToDo(String input) throws Exception {
        String taskDescription = input.replace("todo", " ");
        taskDescription = taskDescription.trim();

        //checks if there is a task description in [input]
        if (taskDescription.isBlank()) { //if there is no task description
            throw new DukeException();
        } else { //if no problem with the input
            numberOfTasks++;
            tasks.add(new ToDo(taskDescription));
            Printer.printDivider();
            System.out.println("\tToto added: " + taskDescription.trim());
            System.out.println(numberOfTasks + ":" + tasks.get(numberOfTasks-1));
            System.out.println("\tnow you have " + numberOfTasks + " task(s)");
            Printer.printDivider();
            Save.saveToTaskList(tasks, fileName);
        }
    }

    /**
     * marks the task associated with taskNum as done
     * condition: taskNum >= 1
     *
     * @param input task description
     */
    public static void markAsDone(String input) throws Exception {
        try {
            input = input.replace("done", "");
            int taskNum = Integer.parseInt(input.trim());
            tasks.get(taskNum-1).setAsDone();
            Printer.printDoneMessage(taskNum);
            Save.saveToTaskList(tasks, fileName);
        } catch (NullPointerException | IndexOutOfBoundsException n1) {
            Printer.printInvalidNumberMessage();
        } catch (NumberFormatException n2) {
            System.out.println("\tyou need to tell Toto the task number! @~@");
            Printer.printDivider();
        }
    }

    /**
     * removes the task associated with taskNum
     * condition: taskNum >= 1
     *
     * @param input task description
     */
    public static void deleteTask(String input) {
        try {
            input = input.replace("delete", "");
            int taskNum = Integer.parseInt(input.trim());
            Printer.printDeleteMessage(taskNum);
            Save.saveToTaskList(tasks, fileName);
        } catch (NullPointerException | IndexOutOfBoundsException n1) {
            Printer.printInvalidNumberMessage();
        } catch (NumberFormatException n2) {
            System.out.println("\tyou need to tell Toto the task number! @~@");
            Printer.printDivider();
        }
    }
}
