import java.util.Scanner;
import java.lang.String;
import TaskClass.Task;

public class Duke {
    static final int MAX_NO = 100;

    public static void main(String[] args) {
        printGreeting();
        getMessage();
        //printBye();
    }

    public static void printGreeting() {
        String logo = "      /-\\    /-\\ \n" //4 spaces
            + "     /  |_9_/  |\n" //4 spaces
            + "    /,,o  3  o,,\\ \n"; //4 spaces
        printDivider();
        System.out.println("    Hullo I'm Toto!\n" + logo); //4 spaces
        System.out.println("    How can Toto help today?"); //4 spaces
        printDivider();
    }

    public static void printDivider(){
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
    }

    public static void printBye(){
        String logo = "      /-\\    /-\\ \n"
            + "     /  |_9_/  |\n"
            + "    / TT  A  TT \\ \n";
        printDivider();
        System.out.println("    Toto will be lonely... :<\n" + logo);
        printDivider();
    }

    private static void echoMessage(String message){
        printDivider();
        System.out.println("added: " + message);
        printDivider();
    }

    private static void getMessage(){
        Scanner in = new Scanner(System.in);
        String[] input = new String[MAX_NO];
        Task[] tasks = new Task[MAX_NO]; // initialise array of Task objects
        int i = 0;
        int j = 0;

        while (true) {
            input[i] = in.nextLine();
            if (input[i].equals("bye") || input[i].equals("Bye")) {
                printBye();
                break;
            } else if (input[i].equals("list") || input[i].equals("List")) {
                listTasks(tasks, j);
            } else if (input[i].contains("done")) {
                input[i] = input[i].trim();
                int taskNum = Integer.parseInt(input[i]);
                tasks[taskNum-1].isDone = true;
            } else {
                tasks[j] = new Task(input[i]);
                echoMessage(input[i]);
                tasks[j].numOfTasks++;
                i++;
                j++;
            }
        }
    }

    public static void listTasks (Task[] tasks, int j) {
        printDivider();
        for (j = 0; j < Task.numOfTasks; j++) {
            System.out.println((j+1) + ": " + "["
                    + tasks[j].getStatusIcon() + "]" + tasks[j]);
        }
        printDivider();
    }
}
