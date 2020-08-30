import java.util.Scanner;
import java.lang.String;
import pack.Task;

public class Duke {
    static final int MAX_NO = 100;
    private static int numOfTasks = 0;
    private static Task[] tasks = new Task[MAX_NO]; // initialise array of Task objects

    public static void main(String[] args) {
        printGreeting();
        getMessage();
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

    private static void getMessage() {
        Scanner in = new Scanner(System.in);
        String[] input = new String[MAX_NO];
        int i = 0;

        while (true) {
            input[i] = in.nextLine();
            if (input[i].equals("bye") || input[i].equals("Bye")) {
                printBye();
                break;
            } else if (input[i].equals("list") || input[i].equals("List")) {
                listTasks(tasks);
            } else if (input[i].contains("done")) {
                markAsDone(input[i]);
                i++;
            } else if (input[i].contains("deadline")){
                numOfTasks++;
                addDeadline(input[i]);
                i++;
            } else if (input[i].contains("event")) {
                numOfTasks++;
                addEvent(input[i]);
                i++;
            } else if (input[i].contains("todo")) {
                numOfTasks++;
                addToDo(input[i]);
                i++;
            } else {
                tasks[numOfTasks] = new Task(input[i]);
                numOfTasks++;
                echoMessage(input[i]);
                i++;
            }
        }
    }

    public static void listTasks (Task[] tasks) {
        printDivider();
        if (numOfTasks == 0) {
            System.out.println("\tyour task list is empty");
            printDivider();
        } else {
            for (int j = 0; j < numOfTasks; j++) {
            System.out.println((j+1) + ": " + tasks[j]);
            }
        }
        printDivider();
    }

    public static void addDeadline(String input) {
        input = input.replace("deadline", " ").trim();
        int dividerPosition = input.indexOf("/by");
        String by = input.substring(dividerPosition+3).trim();
        String taskDescription = input.substring(0, dividerPosition).trim();
        tasks[numOfTasks-1] = new Deadline(taskDescription, by);
        printDivider();
        System.out.println("\tadded: " + taskDescription);
        System.out.println(numOfTasks + ":" + tasks[numOfTasks-1]);
        System.out.println("\tnow you have " + numOfTasks + " task(s)");
        printDivider();
    }

    private static void addEvent(String input) {
        input = input.replace("event", " ");
        int dividerPosition = input.indexOf("/at");
        String time = input.substring(dividerPosition+3).trim();
        String taskDescription = input.substring(0, dividerPosition).trim();
        tasks[numOfTasks-1] = new Event(taskDescription, time);
        printDivider();
        System.out.println("\tadded: " + taskDescription);
        System.out.println(numOfTasks + ":" + tasks[numOfTasks-1]);
        System.out.println("\tnow you have " + numOfTasks + " task(s)");
        printDivider();
    }

    private static void addToDo(String input) {
        String taskDescription = input.replace("todo", " ");
        tasks[numOfTasks-1] = new ToDo(taskDescription.trim());
        printDivider();
        System.out.println("\tadded: " + taskDescription.trim());
        System.out.println(numOfTasks + ":" + tasks[numOfTasks-1]);
        System.out.println("\tnow you have " + numOfTasks + " task(s)");
        printDivider();
    }

    private static void echoMessage(String message){
        printDivider();
        System.out.println("\tadded: " + message);
        System.out.println(numOfTasks + ": " + tasks[numOfTasks-1]);
        System.out.println("\tnow you have " + numOfTasks + " task(s)");
        printDivider();
    }

    public static void markAsDone(String input) {
        input = input.replace("done", "");
        input = input.trim();
        int taskNum = Integer.parseInt(input);
        if (taskNum == 0 || taskNum > numOfTasks) {
            System.out.println("\tnot in Toto's database! oAo");
        } else {
            tasks[taskNum-1].setDone();
            printDoneMessage(taskNum);
        }
    }

    public static void printDoneMessage(int taskNum){
        printDivider();
        System.out.println("\tToto is proud of you! =w=");
        System.out.println(taskNum + ": " + tasks[taskNum -1]);
        printDivider();
    }
}
