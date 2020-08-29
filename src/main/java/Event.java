import pack.Task;

public class Event extends Task {
    protected String time;

    protected String by;

    public Event(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + by + ")";
    }
}