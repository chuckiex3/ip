import java.util.*; //Scanner, Arrays
import java.lang.String;
import pack.Task;
//import java.lang.Integer;

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
            + "    / TT  w  TT \\ \n";
        printDivider();
        System.out.println("    Toto will be lonely... :<\n" + logo);
        printDivider();
    }

    public static void printDoneMessage(Task[] tasks, int taskNum){
        printDivider();
        System.out.println("    Toto is proud of you! =w=");
        System.out.println((taskNum) + ": " + "["
                + tasks[taskNum-1].getStatusIcon()
                + "]" + tasks[taskNum-1]);
        printDivider();
    }

    private static void echoMessage(String message){
        printDivider();
        System.out.println("    added: " + message);
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
                if (j == 0)
                    System.out.println("your task list is empty");
                else
                    listTasks(tasks, j);
            } else if (input[i].contains("done")) {
                input[i] = input[i].replace("done", "");
                input[i] = input[i].trim();
                int taskNum = Integer.parseInt(input[i]);
                if (taskNum == 0)
                    System.out.println("not in Toto's database! oAo");
                else {
                    tasks[taskNum-1].markAsDone();
                    printDoneMessage(tasks, taskNum);
                }
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
                    + tasks[j].getStatusIcon() + "] " + tasks[j]);
        }
        printDivider();
    }
}
