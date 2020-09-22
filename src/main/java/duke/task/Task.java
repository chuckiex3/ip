package duke.task;

/**
 * Represents a Task in the task list.
 */
public abstract class Task {
    protected String description;
    protected boolean isDone;
    protected String tick = "\u2713";
    protected String cross = "\u2718";

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String toString(){
        return "[" + this.getStatusIcon() + "] " + this.description;
    }

    public String getStatusIcon() {
        return (isDone ? tick : cross); //return tick or X symbols
    }

    public String getTaskDescription() {
        return description;
    }

    public boolean isDone(){
        return isDone;
    }

    public void setAsDone() {
        this.isDone = true;
    }
}
