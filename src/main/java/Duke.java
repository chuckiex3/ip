public class Duke {
    public static void main(String[] args) {
        printGreeting();
        printBye();
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
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
    }

    public static void printBye(){
        String logo = "      /-\\    /-\\ \n"
            + "     /  |_9_/  |\n"
            + "    /  T  ^  T \\ \n";
        System.out.println("    Byee\n    Toto will be lonely... :<\n" + logo);
        printDivider();
    }
}
