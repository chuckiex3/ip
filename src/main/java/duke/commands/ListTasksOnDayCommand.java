package duke.commands;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.Ui.Ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.lang.String;

public class ListTasksOnDayCommand extends Command {
    static DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static int counter; //counts the number of tasks with date specified

    /**
     * Finds tasks that match the date input by user.
     *
     * @param date the date input by the user.
     * @param tasks ArrayList of tasks input by the user.
     * @return extracted ArrayList of task(s) containing only tasks with the date specified by the user.
     */
    public static ArrayList<Task> getOnDate(String date, ArrayList<Task> tasks) {
        counter = 0; //always reset to 0
        ArrayList<Task> extractedList = new ArrayList<>();
        for (Task t: tasks) {
            if (t instanceof Event | t instanceof Deadline) {
                if (date.equals(t.getDay().trim())) {
                    extractedList.add(t);
                    counter++;
                }
            }
        }
        if (counter == 0) {
            return null;
        }
        return extractedList;
    }

    /**
     * Lists tasks on date specified by the user.
     *
     * @param input date input by the user.
     * @param tasks ArrayList of tasks input by the user.
     */
    public static void listOnDate(String input, ArrayList<Task> tasks) {
        String userInput = input.replace("on", "").trim();
        Ui.printDivider();
        try {
            ArrayList<Task> extractedList = getOnDate(userInput, tasks);
            if (tasks.size() == 0) {
                System.out.println("\tyour task list is empty");
            } else if (!correctDateFormat(userInput)) {
                System.out.println("\tplease input date as follows: dd/MM/yyyy");
            } else {
                for (int j = 0; j < extractedList.size(); j++) {
                    System.out.println((j + 1) + ": " + extractedList.get(j));
                }
            }
        } catch (NullPointerException n) {
            System.out.println("\tno tasks on " + userInput + "!");
        }
        Ui.printDivider();
    }

    /**
     * Checks if [time] input by the user is in the correct format.
     *
     * @param userInput is the string containing a date specified by the user.
     * @return true when the input is in the correct format, otherwise false.
     * @throws DateTimeParseException thrown when the user's input is in the wrong format.
     */
    private static boolean correctDateFormat(String userInput) {
        LocalDate day = null;
        try {
            day  = LocalDate.parse(userInput, date);
            return true;
        } catch (DateTimeParseException d) {
            return false;
        }
    }
}

