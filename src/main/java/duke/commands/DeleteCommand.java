package duke.commands;

import duke.Duke;
import duke.Ui.Ui;
import duke.Storage.Storage;
import duke.task.TaskList;

/**
 * Deletes task according to the index given by the user.
 */
public class DeleteCommand extends Command {
    public static final String COMMAND_WORD = "delete";
    /**
     * Removes the task associated with taskNum.
     * Condition: taskNum >= 1.
     *
     * @param input task description.
     */
    public static void deleteTask(String input) {
        try {
            int taskNum = Integer.parseInt(input.trim());
            if (taskNum > TaskList.numberOfTasks){
                Ui.printInvalidNumberMessage();
            } else {
                Ui.printDeleteMessage(taskNum);
                Storage.saveToTaskList(TaskList.tasks, Duke.filePath);
            }
        } catch (NullPointerException | IndexOutOfBoundsException n1) {
            Ui.printInvalidNumberMessage();
        } catch (NumberFormatException n2) {
            System.out.println("\tyou need to tell Toto the task number! @~@");
            Ui.printDivider();
        }
    }
}
