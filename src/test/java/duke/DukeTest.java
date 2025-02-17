package duke;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test the {@code Duke} class
 */
public class DukeTest {
    /**
     * Deletes the file that was created.
     * @throws IOException if an exception occurs
     */
    @AfterEach
    void tearDown() throws IOException {
        ParserTest.deleteStorageFiles();
    }

    /**
     * Delete any generated files
     * @throws IOException if an exception occurs
     */
    @BeforeEach
    void clean() throws IOException {
        ParserTest.deleteStorageFiles();
    }

    /**
     * Test if Duke returns the correct response to a valid command
     */
    @Test
    public void getDukeResponse_addTodo_newEventAdded() {
        assertTrue(Duke.getDukeInstance().getResponse("todo borrow book")
                .contains("Got it. I've added this task:\n    [T][ ] borrow book\n"));
    }

    /**
     * Test if Duke returns an error for an invalid command
     */
    @Test
    public void getDukeResponse_addEmptyTodo_errorMessageGenerated() {
        assertEquals("OOPS!!! The todo must have valid arguments.\n",
                Duke.getDukeInstance().getResponse("todo"));
    }
}
