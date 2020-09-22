package duke.task;

/**
 * Represents tasks that need to be done before a specific date/time.
 */
public class Deadline extends Task {
    protected String dueDate;

    public Deadline(String description, String by) {
        super(description);
        dueDate = by;
    }

    public String getDueDate() {
        return dueDate;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + dueDate + ")";
    }
}
