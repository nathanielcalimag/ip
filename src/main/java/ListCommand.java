/**
 * List items from application state
 */
public class ListCommand implements Command {
    private final DukeState state;

    public ListCommand(DukeState state) {
        this.state = state;
    }

    /**
     * List all the items in the application state.
     *
     * @param input The user input.
     */
    @Override
    public void run(String input) {
        this.state.listItems();
    }
}

