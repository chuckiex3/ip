package duke;

import duke.commands.Deadline;
import duke.commands.Event;
import duke.commands.ToDo;
import duke.exceptions.DukeException;
import duke.exceptions.TimeException;

/**
 * Contains the task list.
 * Has operations to add and delete tasks in the list.
 */
public class TaskList {
    /**
     * Adds deadline to tasks list.
     * e.g. deadline [input] /by [time]
     *
     * @param input task description
     * @throws DukeException when there is no task description in the [input].
     * @throws TimeException when [time] is missing from [input].
     */
    static void addDeadline(String input) throws Exception {
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
                Duke.numberOfTasks++;
                Duke.tasks.add(new Deadline(taskDescription, by));
                Printer.printDivider();
                System.out.println("\tToto added: " + taskDescription);
                System.out.println(Duke.numberOfTasks + ":" + Duke.tasks.get(Duke.numberOfTasks - 1));
                System.out.println("\tnow you have " + Duke.numberOfTasks + " task(s)");
                Printer.printDivider();
                Save.saveToTaskList(Duke.tasks, Duke.fileName);
            }
        } else { // when [time] parameter is missing
            throw new TimeException();
        }
    }

    /**
     * Adds an event to tasks list.
     * e.g. event [input] /at [time]
     *
     * @param input task description.
     * @throws DukeException when there is no task description in the [input].
     * @throws TimeException when [time] is missing from [input].
     */
    static void addEvent(String input) throws Exception {
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
                Duke.numberOfTasks++;
                Duke.tasks.add(new Event(taskDescription, time));
                Printer.printDivider();
                System.out.println("\tToto added: " + taskDescription);
                System.out.println(Duke.numberOfTasks + ":" + Duke.tasks.get(Duke.numberOfTasks - 1));
                System.out.println("\tnow you have " + Duke.numberOfTasks + " task(s)");
                Printer.printDivider();
                Save.saveToTaskList(Duke.tasks, Duke.fileName);
            }
        } else { // when [time] parameter is missing
            throw new TimeException();
        }
    }

    /**
     * Adds to-do to the tasks
     * e.g. todo [input]
     *
     * @param input task description
     * @throws DukeException when task description is empty
     */
    static void addToDo(String input) throws Exception {
        String taskDescription = input.replace("todo", " ");
        taskDescription = taskDescription.trim();

        //checks if there is a task description in [input]
        if (taskDescription.isBlank()) { //if there is no task description
            throw new DukeException();
        } else { //if no problem with the input
            Duke.numberOfTasks++;
            Duke.tasks.add(new ToDo(taskDescription));
            Printer.printDivider();
            System.out.println("\tToto added: " + taskDescription.trim());
            System.out.println(Duke.numberOfTasks + ":" + Duke.tasks.get(Duke.numberOfTasks-1));
            System.out.println("\tnow you have " + Duke.numberOfTasks + " task(s)");
            Printer.printDivider();
            Save.saveToTaskList(Duke.tasks, Duke.fileName);
        }
    }

    /**
     * Marks the task associated with taskNum as done.
     * Condition: taskNum >= 1
     *
     * @param input task description.
     */
    public static void markAsDone(String input) throws Exception {
        try {
            input = input.replace("done", "");
            int taskNum = Integer.parseInt(input.trim());
            Duke.tasks.get(taskNum-1).setAsDone();
            Printer.printDoneMessage(taskNum);
            Save.saveToTaskList(Duke.tasks, Duke.fileName);
        } catch (NullPointerException | IndexOutOfBoundsException n1) {
            Printer.printInvalidNumberMessage();
        } catch (NumberFormatException n2) {
            System.out.println("\tyou need to tell Toto the task number! @~@");
            Printer.printDivider();
        }
    }

    /**
     * Removes the task associated with taskNum.
     * Condition: taskNum >= 1.
     *
     * @param input task description.
     */
    public static void deleteTask(String input) {
        try {
            input = input.replace("delete", "");
            int taskNum = Integer.parseInt(input.trim());
            Printer.printDeleteMessage(taskNum);
            Save.saveToTaskList(Duke.tasks, Duke.fileName);
        } catch (NullPointerException | IndexOutOfBoundsException n1) {
            Printer.printInvalidNumberMessage();
        } catch (NumberFormatException n2) {
            System.out.println("\tyou need to tell Toto the task number! @~@");
            Printer.printDivider();
        }
    }
}
