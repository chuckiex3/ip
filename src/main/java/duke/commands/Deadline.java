package duke.commands;

public class Deadline extends Task {
    protected String dueDate;

    public Deadline(String description, String by) {
        super(description);
        dueDate = by;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getTaskDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + dueDate + ")";
    }
}
