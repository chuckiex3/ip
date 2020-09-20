package duke;

import duke.commands.Task;
import duke.exceptions.DukeException;
import duke.exceptions.SaveFileException;
import duke.exceptions.TimeException;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.String;

public class Duke {
    public static int numberOfTasks = 0; // stores the number of tasks saved
    public static Scanner in = new Scanner(System.in);
    public static final ArrayList<Task> tasks = new ArrayList<>();
    public static File fileName =  new File ("./data/taskList.txt");
    public static String fileDirectory = ("./data");
    public static boolean notQuit = true;
    private Ui ui;

    public static void main(String[] args) throws Exception {
        Printer.printGreeting();
        Save.findSavedFile();

        do {
            getMessage();
        } while (notQuit);
    }

    /**
     * Gets command(s) from the user and executes it(them) appropriately.
     * Available commands: list, done, deadline, event, todo.
     *
     * @throws DukeException when task description is missing from [input].
     * @throws TimeException when [time] is missing from [input].
     * @throws SaveFileException when there are exceptions thrown when opening/saving file.
     */
    private static void getMessage() throws Exception {
        String input = in.nextLine();
        try {
            if (input.equals("bye")) {
                Printer.printBye();
                notQuit = false;
            } else if (input.equals("list")) {
                Printer.listTasks(tasks);
            } else if (input.contains("done")) {
                TaskList.markAsDone(input);
                if (numberOfTasks == 0) {
                    throw new SaveFileException();
                }
            } else if (input.contains("delete")) {
                TaskList.deleteTask(input);
            } else if (input.contains("deadline")) {
                TaskList.addDeadline(input);
            } else if (input.contains("event")) {
                TaskList.addEvent(input);
            } else if (input.contains("todo")) {
                TaskList.addToDo(input);
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
}
