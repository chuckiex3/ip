package duke.commands;

import duke.Duke;
import duke.Storage.Storage;
import duke.Ui.Ui;

public class DoneCommand extends Command {
    /**
     * Marks the task associated with taskNum as done.
     * Condition: taskNum >= 1
     *
     * @param input task description.
     */
    public static void markAsDone(String input) {
        try {
            input = input.replace("done", "");
            int taskNum = Integer.parseInt(input.trim());
            Duke.tasks.get(taskNum - 1).setAsDone();
            Ui.printDoneMessage(taskNum);
            Storage.saveToTaskList(Duke.tasks, Duke.filePath);
        }
        catch (NullPointerException | IndexOutOfBoundsException n1) {
            Ui.printInvalidNumberMessage();
        }
        catch (NumberFormatException n2) {
            System.out.println("\tyou need to tell Toto the task number! @~@");
            Ui.printDivider();
        }
    }
}
