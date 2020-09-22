package duke.commands;

import duke.Duke;
import duke.Ui.Ui;
import duke.Storage.Storage;
import duke.exceptions.DukeException;
import duke.exceptions.TimeException;
import duke.exceptions.TimeFormatException;
import duke.task.Event;
import duke.task.TaskList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Adds event to task list.
 */
public class AddEventCommand extends Command {
    public static final String COMMAND_WORD = "event";

    /**
     * Adds an event to the ArrayList of tasks
     * e.g. event [input] /at [time]
     *
     * @param input task description.
     * @throws DukeException when there is no task description in the [input].
     * @throws TimeException when [time] is missing from [input].
     */
    public static void addEvent(String input) throws Exception {
        if (input.contains("/at")) {
            // splits the string into two parts, using "/at" as the divider
            int dividerPosition = input.indexOf("/at");
            String time = input.substring(dividerPosition + 3).trim();
            String taskDescription = input.substring(0, dividerPosition).trim();
            //LocalDate atDateTime = LocalDate.parse(time);

            // checks if there is any missing information - time, taskDescription
            if (taskDescription.isBlank()) { //if there is no task description
                throw new DukeException();
            } else if (time.isBlank()) { //if there is no [time] given
                throw new TimeException();
            } else if (!correctTimeFormat(time)) { // if the [time] format is wrong
                throw new TimeFormatException();
            } else { //if no problem with input
                TaskList.numberOfTasks++;
                TaskList.tasks.add(new Event(taskDescription, time));
                Ui.printDivider();
                System.out.println("\tToto added: " + taskDescription);
                System.out.println(TaskList.numberOfTasks + ":" + TaskList.tasks.get(TaskList.numberOfTasks - 1));
                System.out.println("\tnow you have " + TaskList.numberOfTasks + " task(s)");
                Ui.printDivider();
                Storage.saveToTaskList(TaskList.tasks, Duke.filePath);
            }
        } else { // when [time] parameter is missing
            throw new TimeException();
        }
    }

    /**
     * Checks if [time] input by the user is in the correct format.
     *
     * @param time is the string containing the event's time period.
     * @return true when the input is in the correct format, otherwise false.
     * @throws DateTimeParseException thrown when the user's input is in the wrong format.
     */
    private static boolean correctTimeFormat(String time) {
        DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");
        LocalDate date = null;
        try {
            date = LocalDate.parse(time, dateTime);
            return true;
        } catch (DateTimeParseException d) {
            return false;
        }
    }
}
