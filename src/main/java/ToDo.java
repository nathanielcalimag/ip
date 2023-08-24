/**
 * Deadline is a task with a description.
 */
public class ToDo extends Task {
    protected ToDo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
