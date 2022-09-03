package duke;

import java.util.Scanner;

/**
 * A representation for the UI the user will see.
 */
public class Ui {
    private static final String byeMessage = ("      Bye. This doesn't have to be the end!\n");
    private static final String line = "____________________________________________________________\n";
    private static final String indentedLine = "     " + line;
    private static final String INITIAL_MESSAGE = indentedLine + indentedMessage(" Hello! I'm Duke\n      What can I do"
            + " for you?\n" + indentedLine);

    private final Scanner userScanner;

    /**
     * Constructs a {@code UI} class
     */
    public Ui() {
        this.userScanner = new Scanner(System.in);
    }

    //this is only public for now, need to refactor Parser into Command classes and call this from Command instead
    /**
     * Returns an indented message.
     * @param message The message to indent
     * @return A {@code String} representing the indented message
     */
    public static String indentedMessage(String message) {
        return "     " + message;
    }

    /**
     * Prints the welcome message
     */
    public void showWelcome() {
        System.out.print(INITIAL_MESSAGE);
    }

    public String getNextCommand() {
        return userScanner.nextLine();
    }

    public void showLine() {
        System.out.print(indentedLine);
    }

    public void showError(String errorMessage) {
        System.out.print(indentedMessage(errorMessage));
    }

    public void showExitMessage() {
        System.out.print(byeMessage);
    }
}
