import pack.Task;

public class Deadline extends Task {
    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + "["
                + this.getStatusIcon() + "] " + super.toString() + " (by: " + by + ")";
        //return String.format("[D]%s (by: %s)", super.toString(), by);
    }
}