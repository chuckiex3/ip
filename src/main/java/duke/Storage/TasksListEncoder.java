package duke.Storage;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

public class TasksListEncoder {
    /**
     * Formats the task to be printed in text file.
     *
     * @param task task to be formatted.
     * @return the string in the format for the .txt file.
     */
    static String formatTaskForFile(Task task) {
        String stringToPrint;
        String doneSymbol = (task.isDone() ? "o" : "x");

        if (task instanceof Deadline) {
            stringToPrint = "D-" + doneSymbol + "-"
                    + ((Deadline) task).getTaskDescription() + "-"
                    + ((Deadline) task).getDueDate();
        } else if (task instanceof Event) {
            stringToPrint = "E-" + doneSymbol + "-"
                    + ((Event) task).getTaskDescription() + "-"
                    + ((Event) task).getTime();
        } else { //(task instanceof To-Do)
            stringToPrint = "T-" + doneSymbol + "-"
                    + ((ToDo) task).getTaskDescription();
        }
        return stringToPrint;
    }
}
