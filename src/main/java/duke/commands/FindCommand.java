package duke.commands;

import duke.Ui.Ui;
import duke.task.Task;

import java.util.ArrayList;

import static duke.task.TaskList.tasks;

/**
 * Finds tasks containing a given set of keyword(s) specified by the user.
 */
public class FindCommand extends Command {
    public static final String COMMAND_WORD = "find";
    static int numberOfMatches;

    /**
     * Finds task(s) containing the user's given keyword(s).
     *
     * @param keyword Specified by user to find tasks associated with it.
     */
    public static void findMatch (String keyword){
        listMatches(getTaskMatches(keyword), keyword);
    }

    /**
     * Prints out the tasks that match what the user is looking for with the given keyword.
     *
     * @param matchedListOfTasks ArrayList<Task> that contains the task which match the keyword
     * @param keyword Used to find tasks. It is something the user is looking for in a task.
     */
    public static void listMatches (ArrayList<Task> matchedListOfTasks, String keyword) {
        Ui.printDivider();
        if (numberOfMatches == 0) {
            System.out.println("\txpx Toto could not find tasks with "
                    + "'" + keyword + "'");
            Ui.printDivider();
        } else {
            System.out.println("\tToto has found " + numberOfMatches + " match(es)!");
            for (int i = 0; i < numberOfMatches; i++) {
                System.out.println(i+1 + ":" + matchedListOfTasks.get(i));
            }
            Ui.printDivider();
        }
    }

    /**
     * Gets the task(s) which has/have the user's given keyword(s).
     *
     * @param input is the keyword given by the user.
     * @return an ArrayList<Task> containing all the task(s) that contain(s) the keyword.
     */
    private static ArrayList<Task> getTaskMatches(String input) {
        ArrayList<Task> matchedTaskList = new ArrayList<>();
        numberOfMatches = 0; //reset the number of matches every time
        for (Task t : tasks) {
            if (t.getTaskDescription().contains(input)) {
                matchedTaskList.add(t);
                numberOfMatches++;
            }
        }
        return matchedTaskList;
    }
}
