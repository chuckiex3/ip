package duke.commands;

import duke.Duke;
import duke.Ui.Ui;
import duke.Storage.Storage;
import duke.exceptions.DukeException;
import duke.task.ToDo;

public class AddToDoCommand extends Command {
    /**
     * Adds to-do to the ArrayList of tasks
     * e.g. todo [input]
     *
     * @param input task description
     * @throws DukeException when task description is empty
     */
    public static void addToDo(String input) throws Exception {
        String taskDescription = input.replace("todo", " ");
        taskDescription = taskDescription.trim();

        //checks if there is a task description in [input]
        if (taskDescription.isBlank()) { //if there is no task description
            throw new DukeException();
        } else { //if no problem with the input
            Duke.numberOfTasks++;
            Duke.tasks.add(new ToDo(taskDescription));
            Ui.printDivider();
            System.out.println("\tToto added: " + taskDescription.trim());
            System.out.println(Duke.numberOfTasks + ":" + Duke.tasks.get(Duke.numberOfTasks - 1));
            System.out.println("\tnow you have " + Duke.numberOfTasks + " task(s)");
            Ui.printDivider();
            Storage.saveToTaskList(Duke.tasks, Duke.filePath);
        }
    }
}
