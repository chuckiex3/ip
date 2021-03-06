package duke;

import duke.Storage.Storage;
import duke.Ui.Ui;
import duke.parser.Parser;

import java.io.File;
import java.util.Scanner;
import java.lang.String;

/**
 * Entry point of the application.
 * Initialises the application and starts the interaction with the user.
 */
public class Duke {
    public static Scanner in = new Scanner(System.in);
    public static boolean notQuit = true;
    public static File filePath =  new File ("./data/taskList.txt");
    public static String fileDirectory = ("./data");
    private static Ui ui;
    private static Storage storage;

    public static void main(String[] args) throws Exception {
        ui = new Ui();
        run();
    }

    /** Runs the program until termination. */
    public static void run() throws Exception {
        ui.printGreeting();
        storage = new Storage(filePath, fileDirectory);
        storage.findSavedFile();

        while(notQuit) {
            Parser.parser();
        }
    }
}
