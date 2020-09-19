package duke;

import duke.commands.Deadline;
import duke.commands.Event;
import duke.commands.Task;
import duke.commands.ToDo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Handles saving function
 * Saves the ArrayList<Task> into a .txt file which can be
 * read when the program is loaded again.
 * Previously saved entries will be loaded into ArrayList<Task>
 * on execution.
 */
public class Save {
    /**
     * saves the task list to a .txt file when user does the following:
     * addDeadline, addEvent, addToDo
     *
     * @param tasks is the array list containing task inputs
     */
    public static void saveToTaskList(ArrayList<Task> tasks, File fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            for(Task t : tasks) {
                String textToAdd = formatTaskForFile(t);
                writer.append(textToAdd + System.lineSeparator());
            }
            writer.close();
            System.out.println("o0.0o Toto's done saving");
        } catch (IndexOutOfBoundsException i) {
            System.out.println("\tnothing in the list yet! o__o");
        } catch (IOException e) {
            System.out.println("\terror encountered");
        }
    }

    /**
     * formats the task to be printed in text file
     *
     * @param task task to be formatted
     * @return the string in the format for the .txt file
     */
    private static String formatTaskForFile(Task task) {
        String stringToPrint;
        String doneSymbol = (task.isDone() ? "o" : "x");

        if (task instanceof Deadline) {
            stringToPrint = "D-" + doneSymbol + "-"
                    + ((Deadline) task).getTaskDescription() + "-"
                    + ((Deadline) task).getDueDate();
        } else if (task instanceof Event) {
            stringToPrint = "E-" + doneSymbol + "-"
                    + ((Event) task).getTaskDescription() + "-"
                    + ((Event) task).getTime();
        } else { //(task instanceof To-Do)
            stringToPrint = "T-" + doneSymbol + "-"
                    + ((ToDo) task).getTaskDescription();
        }
        return stringToPrint;
    }

    /**
     * converts the data in the .txt file to Task type
     *
     * @param input is a line in the .txt file
     * @return task in the list so that it can be added into ArrayList<Task>
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
        } catch (Exception exception) {
            System.out.println("\tinvalid entry");
        }
        return null;
    }
}
