package duke.task;

public class Event extends Task {
    protected String time;

    public Event(String description, String time) {
        super(description);
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public String getTaskDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + time + ")";

    }
}
