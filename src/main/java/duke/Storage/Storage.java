package duke.Storage;

import duke.Duke;
import duke.Ui.Ui;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles saving function.
 * Saves the ArrayList<Task> into a .txt file which can be read when the program
 * is loaded again.
 * Previously saved entries will be loaded into ArrayList<Task> from the .txt file.
 */
public class Storage {
    public static File filePath;
    public static String fileDirectory;

    public Storage(File filePath, String fileDirectory) {
        this.filePath = filePath;
        this.fileDirectory = fileDirectory;
    }

    /**
     * Creates a .txt file if no file can be found.
     * Otherwise, load content that has been saved previously into the ArrayList.
     *
     * @throws FileNotFoundException If file cannot be found.
     * @throws IOException If an error is encountered when creating the file.
     */
    public static void findSavedFile() throws IOException {
        try {
            File folder = new File(fileDirectory);
            if (folder.exists()) {
                System.out.println("folder has been found");
                System.out.println("@" + folder.getAbsolutePath());
            } else {
                folder.mkdir();
                System.out.println("\tweewoo Toto has made a folder~");
            }

            if (filePath.createNewFile()) {
                System.out.println("hehe Toto just made a new file for you! @ "
                        + filePath.getAbsolutePath() + " :o3");
                Ui.printDivider();
            } else {
                System.out.println("\tToto found your saved file..");
                Scanner s = new Scanner(filePath);
                while (s.hasNext()) {
                    String input = s.nextLine();
                    Duke.tasks.add(convertTextToTask(input));
                    Duke.numberOfTasks++;
                }
                Ui.printSaveMessage();
            }
        } catch (FileNotFoundException f) {
            System.out.print("file not found");
        } catch (IOException i) {
            System.out.println("error encountered when creating file...");
        }
    }

    /**
     * Saves the task list to a .txt file when user does the following:
     * addDeadline, addEvent, addToDo, markAsDone.
     *
     * @param tasks the array list containing task inputs.
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
            Ui.printDivider();
        } catch (IndexOutOfBoundsException i) {
            System.out.println("\tnothing in the list yet! o__o");
            Ui.printDivider();
        } catch (IOException e) {
            System.out.println("\terror encountered");
            Ui.printDivider();
        }
    }

    /**
     * Formats the task to be printed in text file.
     *
     * @param task task to be formatted.
     * @return the string in the format for the .txt file.
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
        } catch (Exception exception) {
            System.out.println("\tinvalid entry");
        }
        return null;
    }
}
