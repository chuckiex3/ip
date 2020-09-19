package duke;

/**
 * Contains all print messages required in Duke.java
 * prints out messages when called
 */
public class Printer {
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
     * prints save message after saving task list
     */
    static void printSaveMessage() {
        String logo = "      /-\\    /-\\ \n" //6 spaces
                + "     /  |_9_/  |\n" //5 spaces
                + "   p/,,=  w  =,,\\p "; //4 spaces
        printDivider();
        System.out.println("\twelcome back master! Toto has missed you~ <3");
        System.out.println("\tToto has loaded your saved task list~\n" + logo);
        printDivider();
    }

    /**
     * prints message for the deleted task
     * condition: 1 <= taskNum < numberOfTasks
     *
     * @param taskNum index of task according to the list
     */
    static void printDeleteMessage(int taskNum) {
        printDivider();
        System.out.println("\taaaah why though?");
        System.out.println(taskNum + ": " + Duke.tasks.get(taskNum-1));
        Duke.tasks.remove(taskNum-1);
        Duke.numberOfTasks--;
        System.out.println("\tnow you have " + Duke.numberOfTasks + " task(s)");
        printDivider();
    }

    /**
     * prints done message for the task marked as done
     * condition: 1 <= taskNum < numberOfTasks
     *
     * @param taskNum index of task according to the list
     */
    public static void printDoneMessage(int taskNum) {
        printDivider();
        System.out.println("\tToto is proud of you! =w=");
        System.out.println(taskNum + ": " + Duke.tasks.get(taskNum-1));
        printDivider();
    }

    /**
     * message printed out when there are errors while executing user commands
     * for the method markAsDone and deleteTask
     */
    public static void printInvalidNumberMessage() {
        printDivider();
        System.out.println("\tnot in Toto's database! oAo");
        System.out.println("\tplease give Toto a valid number... >__<");
        printDivider();
    }

    /**
     * message printed out when user input is not a valid command
     * for invalid user inputs
     */
    public static void printErrorMessage() {
        String logo = "      /-\\    /-\\ \n"
                + "     /  |_7_/  |\n"
                + "    / =@  ~  @= \\ \n";
        printDivider();
        System.out.print("\tsorry, Toto did not get that...\n" + logo);
        printDivider();
    }
}
