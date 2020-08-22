import java.util.Scanner;
import java.lang.String;

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
            + "    /  T  ^  T \\ \n";
        printDivider();
        System.out.println("    Byee\n    Toto will be lonely... :<\n" + logo);
        printDivider();
    }

    private static void echoMessage(String message){
        printDivider();
        System.out.println(message);
        printDivider();
    }

    private static void getMessage(){
        Scanner in = new Scanner(System.in);
        String[] input = new String[MAX_NO];
        int i = 0;
        while (true) {
            input[i] = in.nextLine();
            if (input[i].equals("bye") || input[i].equals("Bye")) {
                printBye();
                break;
            } else {
                echoMessage(input[i]);
                i++;
            }
        }
    }

    public static int check_command(String command) {
        if (command.equals("help") || command.equals("HELP")) {
            return 1;
        }
        return 0;
    }
}
