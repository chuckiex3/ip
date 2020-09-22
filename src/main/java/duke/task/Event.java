package duke.task;

/**
 * Represents tasks that start at a specific time and ends at a specific time
 */
public class Event extends Task {
    protected String time;

    public Event(String description, String time) {
        super(description);
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + time + ")";

    }
}
