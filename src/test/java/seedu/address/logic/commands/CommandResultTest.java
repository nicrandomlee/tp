package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;

public class CommandResultTest {
    @Test
    public void equals() {
        CommandResult commandResult = new CommandResult("feedback");

        // same values -> returns true
        assertTrue(commandResult.equals(new CommandResult("feedback")));
        assertTrue(commandResult.equals(new CommandResult("feedback", false, false, false, false)));

        // same object -> returns true
        assertTrue(commandResult.equals(commandResult));

        // null -> returns false
        assertFalse(commandResult.equals(null));

        // different types -> returns false
        assertFalse(commandResult.equals(0.5f));

        // different feedbackToUser value -> returns false
        assertFalse(commandResult.equals(new CommandResult("different")));

        // different showHelp value -> returns false
        assertFalse(commandResult.equals(new CommandResult("feedback", true, false, false, false)));

        // different exit value -> returns false
        assertFalse(commandResult.equals(new CommandResult("feedback", false, true, false, false)));

        // different switchBottomList value -> returns false
        assertFalse(commandResult.equals(new CommandResult("feedback", false, false, false, true)));
    }

    @Test
    public void hashcode() {
        CommandResult commandResult = new CommandResult("feedback");

        // same values -> returns same hashcode
        assertEquals(commandResult.hashCode(), new CommandResult("feedback").hashCode());

        // different feedbackToUser value -> returns different hashcode
        assertNotEquals(commandResult.hashCode(), new CommandResult("different").hashCode());

        // different showHelp value -> returns different hashcode
        assertNotEquals(commandResult.hashCode(), new CommandResult("feedback", true, false, false, false).hashCode());

        // different exit value -> returns different hashcode
        assertNotEquals(commandResult.hashCode(), new CommandResult("feedback", false, true, false, false).hashCode());

        // different switchBottomList value -> returns different hashCode
        assertNotEquals(commandResult.hashCode(), new CommandResult("feedback", false, false, false, true).hashCode());
    }

    @Test
    public void indicatorViewEvents_validViewEventsIndicator_success() {
        CommandResult.ViewEventsIndicator viewEventsIndicator = new CommandResult.ViewEventsIndicator(1);
        assertTrue(viewEventsIndicator.isViewEvents());
    }

    @Test
    public void indicatorGetIndex_validViewEventsIndicator_success() {
        CommandResult.ViewEventsIndicator viewEventsIndicator = new CommandResult.ViewEventsIndicator(1);
        assertEquals(viewEventsIndicator.getIndex(), Index.fromOneBased(1));
    }

    @Test
    public void isViewEvents_validViewEventsIndicator_success() {
        CommandResult commandResult = new CommandResult("feedback", Index.fromOneBased(1));
        assertTrue(commandResult.isViewEvents());
    }

    @Test
    public void getIndex_validViewEventsIndicator_success() {
        CommandResult commandResult = new CommandResult("feedback", Index.fromOneBased(1));
        assertEquals(commandResult.getEventViewIndex(), Index.fromOneBased(1));
    }

    @Test
    public void toStringMethod() {
        CommandResult commandResult = new CommandResult("feedback");
        String expected = CommandResult.class.getCanonicalName() + "{feedbackToUser="
                + commandResult.getFeedbackToUser() + ", showHelp=" + commandResult.isShowHelp()
                + ", exit=" + commandResult.isExit()
                + ", switchBottomList=" + commandResult.isSwitchBottomList() + "}";
        assertEquals(expected, commandResult.toString());
    }
}