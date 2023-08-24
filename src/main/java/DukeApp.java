import java.util.HashMap;
import java.util.Objects;

/**
 * The Application object responsible for storing and executing commands.
 */
public class DukeApp {
    /**
     * Default to EchoCommand if input is unknown.
     */
    private final Command defaultCommand;

    /**
     * All commands stored in a map.
     */
    private final HashMap<String, Command> commandMap = new HashMap<>();

    public DukeApp() {
        DukeState state = new DukeState();
        this.addCommand("bye", new ExitCommand());

        this.addCommand("list", new ListCommand(state));
        this.addCommand("mark", new MarkCommand(state));
        this.addCommand("unmark", new UnmarkCommand(state));

        this.addCommand("deadline", new InsertCommand(state));
        this.addCommand("event", new InsertCommand(state));
        this.addCommand("todo", new InsertCommand(state));

        this.defaultCommand = new InsertCommand(state);
    }

    /**
     * Adds a command to the application's command map.
     *
     * @param name    The name of the command.
     * @param command The associated command.
     */
    public void addCommand(String name, Command command) {
        this.commandMap.put(name, command);
    }

    /**
     * Executes a command given an input.
     *
     * @param input The input of the user.
     */
    public void executeCommand(String input) {
        System.out.println("\t" + DukeConstants.HORIZONTAL_LINE);

        // Separate the command name and the command input
        String[] args = input.split(" ");
        String commandName = args[0];

        Command command = commandMap.get(commandName);
        Objects.requireNonNullElse(command, this.defaultCommand).run(input);
    }
}