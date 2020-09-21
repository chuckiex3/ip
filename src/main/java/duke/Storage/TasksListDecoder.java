package duke.Storage;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

public class TasksListDecoder {
    /**
     * Converts the data in the .txt file to Task type.
     *
     * @param input is a line in the .txt file.
     * @return task in the list so that it can be added into ArrayList<Task>.
     */
    public static Task convertTextToTask(String input) {
        try {
            String[] userInput = input.split("-");
            Task taskSaved;
            String taskDescription = userInput[2];

            switch (userInput[0]) {
            case "D":
                String time = userInput[3];
                taskSaved = new Deadline(taskDescription, time);
                break;
            case "E":
                time = userInput[3];
                taskSaved = new Event(taskDescription, time);
                break;
            case "T":
                taskSaved = new ToDo(taskDescription);
                break;
            default:
                throw new Exception();
            }

            if (userInput[1].equals("o")) {
                taskSaved.setAsDone();
            }
            return taskSaved;
        }
        catch (Exception exception) {
            System.out.println("\tinvalid entry");
        }
        return null;
    }
}
