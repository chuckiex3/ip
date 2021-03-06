package duke.parser;

import duke.Duke;
import duke.Ui.Ui;
import duke.commands.ListCommand;
import duke.commands.FindCommand;
import duke.commands.DoneCommand;
import duke.commands.DeleteCommand;
import duke.commands.AddEventCommand;
import duke.commands.AddDeadlineCommand;
import duke.commands.AddToDoCommand;
import duke.commands.ListTasksOnDayCommand;
import duke.exceptions.DukeException;
import duke.exceptions.SaveFileException;
import duke.exceptions.TimeException;
import duke.exceptions.TimeFormatException;
import duke.task.TaskList;

import static duke.task.TaskList.tasks;

/**
 * Parses user's input.
 */
public class Parser {
    private static void getUserCommand() throws Exception {
        String input = Duke.in.nextLine();
        String[] userInput = input.trim().split(" ", 2); // split input into command and arguments
        final String commandWord = userInput[0];
        final String argument = input.replace(commandWord, "").trim();

        switch (commandWord) {
        case "bye":
            Ui.printBye();
            Duke.notQuit = false;
            break;
        case ListCommand.COMMAND_WORD:
            ListCommand.listTasks(tasks);
            break;
        case DoneCommand.COMMAND_WORD:
            DoneCommand.markAsDone(argument);
            if (TaskList.numberOfTasks == 0) {
                throw new SaveFileException();
            }
            break;
        case DeleteCommand.COMMAND_WORD:
            DeleteCommand.deleteTask(argument);
            break;
        case AddDeadlineCommand.COMMAND_WORD:
            AddDeadlineCommand.addDeadline(argument);
            break;
        case AddEventCommand.COMMAND_WORD:
            AddEventCommand.addEvent(argument);
            break;
        case AddToDoCommand.COMMAND_WORD:
            AddToDoCommand.addToDo(argument);
            break;
        case FindCommand.COMMAND_WORD:
            FindCommand.listMatches(argument);
            break;
        case ListTasksOnDayCommand.COMMAND_WORD:
            ListTasksOnDayCommand.listOnDate(input, tasks);
            break;
        default:
            Ui.printErrorMessage();
            break;
        }
    }

    /**
     * Executes user commands.
     * Available commands: list, done, deadline, event, todo.
     *
     * @throws Exception when an error is encountered.
     */
    public static void parser() throws Exception {
        try {
            getUserCommand();
        } catch (DukeException d) {
            System.out.println("\tno task description! :o");
            Ui.printDivider();
        } catch (TimeException t) {
            System.out.println("\tno time given! you don't have forever though...owo");
            Ui.printDivider();
        } catch (SaveFileException s) {
            System.out.println("\tencountered problems when saving!");
            Ui.printDivider();
        } catch (TimeFormatException t) {
            System.out.println("\tplease give the [time] parameter in this format:");
            System.out.println("\tdd/MM/yyyy hhmm, where time is in 24h format!");
            Ui.printDivider();
        }
    }
}
