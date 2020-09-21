package duke.commands;

import duke.Duke;
import duke.Ui.Ui;
import duke.Storage.Storage;

public class DeleteCommand extends Command {
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
            Ui.printDeleteMessage(taskNum);
            Storage.saveToTaskList(Duke.tasks, Duke.filePath);
        } catch (NullPointerException | IndexOutOfBoundsException n1) {
            Ui.printInvalidNumberMessage();
        } catch (NumberFormatException n2) {
            System.out.println("\tyou need to tell Toto the task number! @~@");
            Ui.printDivider();
        }
    }
}
