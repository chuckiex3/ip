package duke.commands;

import duke.Duke;
import duke.Ui.Ui;
import duke.Storage.Storage;
import duke.exceptions.DukeException;
import duke.task.TaskList;
import duke.task.ToDo;

/**
 * Adds todo to task list.
 */
public class AddToDoCommand extends Command {
    public static final String COMMAND_WORD = "todo";

    /**
     * Adds to-do to the ArrayList of tasks
     * e.g. todo [input]
     *
     * @param input task description
     * @throws DukeException when task description is empty
     */
    public static void addToDo(String input) throws Exception {
        String taskDescription = input.trim();

        //checks if there is a task description in [input]
        if (taskDescription.isBlank()) { //if there is no task description
            throw new DukeException();
        } else { //if no problem with the input
            TaskList.numberOfTasks++;
            TaskList.tasks.add(new ToDo(taskDescription));
            Ui.printDivider();
            System.out.println("\tToto added: " + taskDescription.trim());
            System.out.println(TaskList.numberOfTasks + ":" + TaskList.tasks.get(TaskList.numberOfTasks - 1));
            System.out.println("\tnow you have " + TaskList.numberOfTasks + " task(s)");
            Ui.printDivider();
            Storage.saveToTaskList(TaskList.tasks, Duke.filePath);
        }
    }
}
