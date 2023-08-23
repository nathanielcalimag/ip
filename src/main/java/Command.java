/**
 * The generic command interface with a run method defining the behaviour
 * of the command
 */
public interface Command {
    /**
     * Executes the command given a user input.
     *
     * @param input
     */
    public void run(String input);
}
