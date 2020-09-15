package duke.commands;

public class ToDo extends Task {
    public ToDo(String description) {
        super(description);
    }

    public String getTaskDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
