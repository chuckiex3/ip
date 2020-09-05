import java.util.Scanner;
import java.lang.String;

public class Duke {
    static final int MAX_NO = 100;
    private static int numberOfTasks = 0; // stores the number of tasks in the array
    private static Task[] tasks = new Task[MAX_NO]; // initialise array of Task objects

    public static void main(String[] args) throws Exception {
        printGreeting();
        getMessage();
    }

    /**
     * gets command(s) from the user and executes it(them) appropriately
     * available commands: list, done, deadline, event, bye, todo
     */
    private static void getMessage() throws Exception {
        Scanner in = new Scanner(System.in);
        String input;

        while (true) {
            input = in.nextLine();
            if (input.equals("bye")) {
                printBye();
                break;
            } else if (input.equals("list")) {
                listTasks(tasks);
            } else if (input.contains("done")) {
                try {
                    markAsDone(input);
                } catch (NullPointerException n) {
                    printNullPointerErrorMessage();
                }
            } else if (input.contains("deadline")){
                addDeadline(input);
            } else if (input.contains("event")) {
                addEvent(input);
            } else if (input.contains("todo")) {
                addToDo(input);
            } else {
                try {
                    throw new TaskException();
                } catch (TaskException t) {
                    printErrorMessage();
                }
            }
        }
    }

    /**
     * prints out greeting from Toto upon execution
     */
    public static void printGreeting() {
        String logo = "      /-\\    /-\\ \n" //6 spaces
                + "     /  |_9_/  |\n" //5 spaces
                + "    /,,o  3  o,,\\ \n"; //4 spaces
        printDivider();
        System.out.println("\tHullo I'm Toto!\n" + logo);
        System.out.println("\tHow can Toto help today?");
        printDivider();
    }

    /**
     * prints the divider between user input and output
     */
    public static void printDivider(){
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
    }

    /**
     * prints bye message when user inputs "bye"
     */
    public static void printBye(){
        String logo = "      /-\\    /-\\ \n"
                + "     /  |_9_/  |\n"
                + "    / TT  w  TT \\ \n";
        printDivider();
        System.out.println("\tToto will be lonely... :<\n" + logo);
        printDivider();
    }

    /**
     * prints out everything in the array of tasks
     *
     * @param tasks array of tasks
     */
    public static void listTasks (Task[] tasks) {
        printDivider();
        if (numberOfTasks == 0) {
            System.out.println("\tyour task list is empty");
            printDivider();
        } else {
            for (int j = 0; j < numberOfTasks; j++) {
                System.out.println((j+1) + ": " + tasks[j]);
            }
        }
        printDivider();
    }

    /**
     * add deadline to tasks list
     * e.g. deadline [input] /by time
     *
     * @param input task description
     */
    public static void addDeadline(String input) {
        numberOfTasks++;
        input = input.replace("deadline", " ").trim();
        int dividerPosition = input.indexOf("/by");
        String by = input.substring(dividerPosition+3).trim();
        String taskDescription = input.substring(0, dividerPosition).trim();
        tasks[numberOfTasks-1] = new Deadline(taskDescription, by);
        printDivider();
        System.out.println("\tToto added: " + taskDescription);
        System.out.println(numberOfTasks + ":" + tasks[numberOfTasks-1]);
        System.out.println("\tnow you have " + numberOfTasks + " task(s)");
        printDivider();
    }

    /**
     * adds an event to tasks list
     * e.g. event [input] /at time
     *
     * @param input task description
     */
    private static void addEvent(String input) {
        numberOfTasks++;
        input = input.replace("event", " ");
        int dividerPosition = input.indexOf("/at");
        String time = input.substring(dividerPosition+3).trim();
        String taskDescription = input.substring(0, dividerPosition).trim();
        tasks[numberOfTasks-1] = new Event(taskDescription, time);
        printDivider();
        System.out.println("\tToto added: " + taskDescription);
        System.out.println(numberOfTasks + ":" + tasks[numberOfTasks-1]);
        System.out.println("\tnow you have " + numberOfTasks + " task(s)");
        printDivider();
    }

    /**
     * adds to-do to the tasks
     * e.g. todo [input]
     *
     * @param input task description
     */
    private static void addToDo(String input) {
        numberOfTasks++;
        String taskDescription = input.replace("todo", " ");
        tasks[numberOfTasks-1] = new ToDo(taskDescription.trim());
        printDivider();
        System.out.println("\tToto added: " + taskDescription.trim());
        System.out.println(numberOfTasks + ":" + tasks[numberOfTasks-1]);
        System.out.println("\tnow you have " + numberOfTasks + " task(s)");
        printDivider();
    }

    /**
     * marks the task associated with taskNum as done
     *
     * @param input task description
     */
    public static void markAsDone(String input) {
        input = input.replace("done", "");
        int taskNum = Integer.parseInt(input.trim());
        tasks[taskNum-1].setDone();
        printDoneMessage(taskNum);
    }

    /**
     * prints done message for the task marked as done
     * condition: taskNum >= 1
     *
     * @param taskNum index of task according to the list
     * @throws NullPointerException if task to be marked done doesn't exist
     */
    public static void printDoneMessage(int taskNum) {
        printDivider();
        System.out.println("\tToto is proud of you! =w=");
        System.out.println(taskNum + ": " + tasks[taskNum-1]);
        printDivider();
    }

    /**
     * message printed out when there are errors while executing user commands
     * for NullPointerException
     */
    public static void printNullPointerErrorMessage(){
        printDivider();
        System.out.println("\tnot in Toto's database! oAo");
        printDivider();
    }

    /**
     * message printed out when user input is not a valid command
     * for TaskException
     */
    private static void printErrorMessage() {
        String logo = "      /-\\    /-\\ \n"
                + "     /  |_7_/  |\n"
                + "    / =@  ~  @= \\ \n";
        printDivider();
        System.out.print("\tsorry, Toto did not get that...\n" + logo);
        printDivider();
    }
}
