package duke;

import java.io.IOException;
import java.time.format.DateTimeParseException;

import duke.exceptions.StorageCreationException;
import duke.exceptions.UnknownCommandException;

/**
 * Serves as the entry point to run the application.
 */
public class Duke {
    private final TaskList taskList = new TaskList();
    private final Parser parser = new Parser();

    /**
     * Creates a new {@code Duke} instance.
     */
    public Duke() {
        try {
            Storage storage = new DukeStorage();
            this.taskList.setStorage(storage);
            this.taskList.loadTasks();
        } catch (DateTimeParseException e) {
            try {
                this.taskList.saveTasks();
            } catch (IOException ioException) {
                System.out.printf(Messages.ERROR_PREFIX + "%n", ioException.getMessage());
            }
        } catch (IOException | IllegalArgumentException | StorageCreationException e) {
            System.out.printf(Messages.ERROR_PREFIX + "%n", e.getMessage());
        }
    }

    /**
     * Gets the output of a command execution, given an input.
     *
     * @param input The input command string.
     * @return The output string.
     */
    public String getResponse(String input) {
        try {
            return parser.executeCommand(input, taskList);
        } catch (UnknownCommandException e) {
            return String.format(Messages.ERROR_PREFIX, e.getMessage());
        }
    }
}
