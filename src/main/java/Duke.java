import java.util.Scanner;
import java.lang.String;

public class Duke {
    static final int MAX_NO = 100;
    private static int numberOfTasks = 0; // stores the number of tasks in the array
    private static Task[] tasks = new Task[MAX_NO]; // initialise array of Task objects

    public static void main(String[] args) {
        printGreeting();
        getMessage();
    }

    /**
     * gets command(s) from the user and executes it(them) appropriately
     * available commands: list, done, deadline, event, todo, task, bye
     */
    private static void getMessage() {
        Scanner in = new Scanner(System.in);
        String[] input = new String[MAX_NO];
        int i = 0; //used as an index to iterate through the array

        while (true) {
            input[i] = in.nextLine();
            if (input[i].equals("bye")) {
                printBye();
                break;
            } else if (input[i].equals("list")) {
                listTasks(tasks);
            } else if (input[i].contains("done")) {
                markAsDone(input[i]);
            } else if (input[i].contains("deadline")){
                addDeadline(input[i]);
            } else if (input[i].contains("event")) {
                addEvent(input[i]);
            } else if (input[i].contains("todo")) {
                addToDo(input[i]);
            } else {
                echoMessage(input[i]);
            }
            i++;
        }
    }

    public static void printGreeting() {
        String logo = "      /-\\    /-\\ \n" //6 spaces
            + "     /  |_9_/  |\n" //5 spaces
            + "    /,,o  3  o,,\\ \n"; //4 spaces
        printDivider();
        System.out.println("\tHullo I'm Toto!\n" + logo); //4 spaces
        System.out.println("\tHow can Toto help today?"); //4 spaces
        printDivider();
    }

    public static void printDivider(){
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
    }

    public static void printBye(){
        String logo = "      /-\\    /-\\ \n"
            + "     /  |_9_/  |\n"
            + "    / TT  w  TT \\ \n";
        printDivider();
        System.out.println("\tToto will be lonely... :<\n" + logo);
        printDivider();
    }

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

    public static void addDeadline(String input) {
        numberOfTasks++;
        input = input.replace("deadline", " ").trim();
        int dividerPosition = input.indexOf("/by");
        String by = input.substring(dividerPosition+3).trim();
        String taskDescription = input.substring(0, dividerPosition).trim();
        tasks[numberOfTasks-1] = new Deadline(taskDescription, by);
        printDivider();
        System.out.println("\tadded: " + taskDescription);
        System.out.println(numberOfTasks + ":" + tasks[numberOfTasks-1]);
        System.out.println("\tnow you have " + numberOfTasks + " task(s)");
        printDivider();
    }

    private static void addEvent(String input) {
        numberOfTasks++;
        input = input.replace("event", " ");
        int dividerPosition = input.indexOf("/at");
        String time = input.substring(dividerPosition+3).trim();
        String taskDescription = input.substring(0, dividerPosition).trim();
        tasks[numberOfTasks-1] = new Event(taskDescription, time);
        printDivider();
        System.out.println("\tadded: " + taskDescription);
        System.out.println(numberOfTasks + ":" + tasks[numberOfTasks-1]);
        System.out.println("\tnow you have " + numberOfTasks + " task(s)");
        printDivider();
    }

    private static void addToDo(String input) {
        numberOfTasks++;
        String taskDescription = input.replace("todo", " ");
        tasks[numberOfTasks-1] = new ToDo(taskDescription.trim());
        printDivider();
        System.out.println("\tadded: " + taskDescription.trim());
        System.out.println(numberOfTasks + ":" + tasks[numberOfTasks-1]);
        System.out.println("\tnow you have " + numberOfTasks + " task(s)");
        printDivider();
    }

    private static void echoMessage(String message){
        numberOfTasks++;
        tasks[numberOfTasks-1] = new Task(message);
        printDivider();
        System.out.println("\tToto added: " + message);
        System.out.println(numberOfTasks + ": " + tasks[numberOfTasks-1]);
        System.out.println("\tnow you have " + numberOfTasks + " task(s)");
        printDivider();
    }

    public static void markAsDone(String input) {
        input = input.replace("done", "");
        int taskNum = Integer.parseInt(input.trim());
        if (taskNum == 0 || taskNum > numberOfTasks) {
            System.out.println("\tnot in Toto's database! oAo");
        } else {
            tasks[taskNum-1].setDone();
            printDoneMessage(taskNum);
        }
    }

    public static void printDoneMessage(int taskNum){
        printDivider();
        System.out.println("\tToto is proud of you! =w=");
        System.out.println(taskNum + ": " + tasks[taskNum-1]);
        printDivider();
    }
}
