package duke;

import duke.Storage.Storage;
import duke.Ui.Ui;
import duke.task.Task;
import duke.parser.Parser;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.String;

public class Duke {
    public static int numberOfTasks = 0; // stores the number of tasks saved
    public static Scanner in = new Scanner(System.in);
    public static final ArrayList<Task> tasks = new ArrayList<>();
    public static boolean notQuit = true;
    public static File filePath =  new File ("./data/taskList.txt");
    public static String fileDirectory = ("./data");
    private static Ui ui;
    private static Storage storage;

    public static void main(String[] args) throws Exception {
        ui = new Ui();
        run();
    }

    public static void run() throws Exception {
        ui.printGreeting();
        storage = new Storage(filePath, fileDirectory);
        try {
            storage.findSavedFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        while(notQuit) {
            Parser.getUserCommand();
        }
    }
}
