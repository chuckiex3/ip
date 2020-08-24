package TaskClass;

public class Task {
    protected String description;
    protected boolean isDone;
    protected static int numOfTasks = 0;
    static int MAX_NO = 100;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String toString(){
        return this.description;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    /*public String[] taskList(Task item) {
        Task[] tasks
        for (int i = 0; i < MAX_NO; i++) {
            Task tasks
        }
    }*/
}
