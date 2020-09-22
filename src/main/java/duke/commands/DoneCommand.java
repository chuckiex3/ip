package duke.commands;

import duke.Duke;
import duke.Storage.Storage;
import duke.Ui.Ui;
import duke.task.TaskList;

public class DoneCommand extends Command {
    public static final String COMMAND_WORD = "done";

    /**
     * Marks the task associated with taskNum as done.
     * Condition: taskNum >= 1
     *
     * @param input task description.
     */
    public static void markAsDone(String input) {
        try {
            int taskNum = Integer.parseInt(input.trim());
            TaskList.tasks.get(taskNum - 1).setAsDone();
            Ui.printDoneMessage(taskNum);
            Storage.saveToTaskList(TaskList.tasks, Duke.filePath);
        } catch (NullPointerException | IndexOutOfBoundsException n1) {
            Ui.printInvalidNumberMessage();
        } catch (NumberFormatException n2) {
            System.out.println("\tyou need to tell Toto the task number! @~@");
            Ui.printDivider();
        }
    }
}
