package duke.commands;

import duke.Duke;
import duke.task.Task;
import duke.Ui.Ui;

import java.util.ArrayList;

public class ListCommand extends Command {
    /**
     * Prints out everything in the ArrayList of tasks.
     *
     * @param tasks ArrayList of tasks.
     */
    public static void listTasks(ArrayList<Task> tasks) {
        Ui.printDivider();
        if (Duke.numberOfTasks == 0) {
            System.out.println("\tyour task list is empty");
        } else {
            for (int j = 0; j < Duke.numberOfTasks; j++) {
                System.out.println((j + 1) + ": " + tasks.get(j));
            }
        }
        Ui.printDivider();
    }
}
