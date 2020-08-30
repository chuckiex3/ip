import pack.Task;

public class Event extends Task {
    protected String time;

    //protected String by;

    public Event(String description, String time) {
        super(description);
        this.time = time;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + time + ")";

    }
}