import java.util.Scanner;
import java.lang.String;
import java.util.Arrays;

public class Duke {
    static final int MAX_NO = 100;

    public class Task {
        protected String description;
        protected boolean isDone;
        int numOfTasks = 0;

        public Task(String description) {
            this.description = description;
            this.isDone = false;
        }

        public String getStatusIcon() {
            return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
        }

        //...
    }
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
        //String[] task = new String[MAX_NO];
        Task[] task;
        int i = 0;
        //int j = 0;

        while (true) {
            input[i] = in.nextLine();
            if (input[i].equals("bye") || input[i].equals("Bye")) {
                printBye();
                break;
            } else if (input[i].equals("list") || input[i].equals("List")) {
                //listTasks(task, j);
                listTasks();
            } else if (input[i].equals("done")) { //to be edited
                break; //to be edited
            } else {
                //task[j] = input[i];
                //echoMessage(input[i]);
                task= new Task(input[i]);
                task.numOfTasks++;
                i++;
                //j++;

            }
        }
    }

    public static void listTasks () {
        printDivider();
        for (int i = 0; i < Task.numOfTasks; i++) {
            System.out.println((i+1) + ": " + Task(task));
        }
        printDivider();
    }
}

