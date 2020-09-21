package duke.commands;

import duke.Duke;
import duke.Ui.Ui;
import duke.Storage.Storage;
import duke.exceptions.DukeException;
import duke.exceptions.TimeException;
import duke.task.Event;

public class AddEventCommand extends Command {
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
                Ui.printDivider();
                System.out.println("\tToto added: " + taskDescription);
                System.out.println(Duke.numberOfTasks + ":" + Duke.tasks.get(Duke.numberOfTasks - 1));
                System.out.println("\tnow you have " + Duke.numberOfTasks + " task(s)");
                Ui.printDivider();
                Storage.saveToTaskList(Duke.tasks, Duke.filePath);
            }
        } else { // when [time] parameter is missing
            throw new TimeException();
        }
    }
}
