/**
 * The generic command interface with a run method defining the behaviour
 * of the command.
 */
public interface Command {
    /**
     * Executes the command given an input.
     *
     * @param input
     */
    void run(String input);
}
