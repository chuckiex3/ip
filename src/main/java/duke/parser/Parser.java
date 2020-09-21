package duke.parser;

import duke.Duke;
import duke.Ui.Ui;
import duke.commands.AddDeadlineCommand;
import duke.commands.AddToDoCommand;
import duke.commands.AddEventCommand;
import duke.commands.DeleteCommand;
import duke.commands.DoneCommand;
import duke.commands.ListCommand;
import duke.exceptions.DukeException;
import duke.exceptions.SaveFileException;
import duke.exceptions.TimeException;
import duke.task.TaskList;

public class Parser {
    /**
     * Gets command(s) from the user and executes it(them) appropriately.
     * Available commands: list, done, deadline, event, todo.
     *
     * @throws DukeException     when task description is missing from [input].
     * @throws TimeException     when [time] is missing from [input].
     * @throws SaveFileException when there are exceptions thrown when opening/saving file.
     */
    public static void getUserCommand() throws Exception {
        String input = Duke.in.nextLine();
        try {
            if (input.equals("bye")) {
                Ui.printBye();
                Duke.notQuit = false;
            } else if (input.equals("list")) {
                ListCommand.listTasks(TaskList.tasks);
            } else if (input.contains("done")) {
                DoneCommand.markAsDone(input);
                if (TaskList.numberOfTasks == 0) {
                    throw new SaveFileException();
                }
            } else if (input.contains("delete")) {
                DeleteCommand.deleteTask(input);
            } else if (input.contains("deadline")) {
                AddDeadlineCommand.addDeadline(input);
            } else if (input.contains("event")) {
                AddEventCommand.addEvent(input);
            } else if (input.contains("todo")) {
                AddToDoCommand.addToDo(input);
            } else {
                Ui.printErrorMessage();
            }
        } catch (DukeException d) {
            System.out.println("\tno task description! :o");
            Ui.printDivider();
        } catch (TimeException t) {
            System.out.println("\tno time given! you don't have forever though...owo");
            Ui.printDivider();
        } catch (SaveFileException s) {
            System.out.println("\tencountered problems when saving!");
            Ui.printDivider();
        }
    }
}
