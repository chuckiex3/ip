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
        String[] userInput = input.trim().split(" ", 2); // split input into command and arguments
        final String commandWord = userInput[0];
        final String argument = input.replace(commandWord, "").trim();

        try {
            switch (commandWord) {
            case "bye":
                Ui.printBye();
                Duke.notQuit = false;
                break;
            case ListCommand.COMMAND_WORD:
                ListCommand.listTasks(TaskList.tasks);
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
            default:
                Ui.printErrorMessage();
                break;
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
