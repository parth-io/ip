import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    // original access modifier was protected
    private final LocalDateTime dateTime;

    public Event(String description, Command taskCommand, LocalDateTime dateTime) {
        super(description, taskCommand);
        this.dateTime = dateTime;
    }

    @Override
    public String getFileStorageString(int index) {
        return taskCommand.getString() + " " + description + " /at " + start + "\n" + getTaskDoneString(index);
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + dateTime.format(DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm"))
                + ")";
    }
}
