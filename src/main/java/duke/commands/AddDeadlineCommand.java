package duke.commands;

import duke.Duke;
import duke.Ui.Ui;
import duke.Storage.Storage;
import duke.exceptions.DukeException;
import duke.exceptions.TimeException;
import duke.task.Deadline;
import duke.task.TaskList;

public class AddDeadlineCommand extends Command {
    /**
     * Adds deadline to the ArrayList of tasks.
     * e.g. deadline [input] /by [time]
     *
     * @param input task description
     * @throws DukeException when there is no task description in the [input].
     * @throws TimeException when [time] is missing from [input].
     */
    public static void addDeadline(String input) throws Exception {
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
                TaskList.numberOfTasks++;
                TaskList.tasks.add(new Deadline(taskDescription, by));
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
}
