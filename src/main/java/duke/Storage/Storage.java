package duke.Storage;

import duke.Ui.Ui;
import duke.task.Task;
import duke.task.TaskList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents the file used to store task list data.
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
     */
    public static void findSavedFile() {
        try {
            int counter = 0;
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
                    counter++;
                    Task savedTask = TaskListDecoder.convertTextToTask(input);
                    TaskList.numberOfTasks++;
                    TaskList.tasks.add(savedTask);
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
     * addDeadline, addEvent, addToDo, markAsDone, delete.
     *
     * @param tasks the array list containing task inputs.
     */
    public static void saveToTaskList(ArrayList<Task> tasks, File fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            for(Task t : tasks) {
                String textToAdd = TaskListEncoder.formatTaskForFile(t);
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
}
