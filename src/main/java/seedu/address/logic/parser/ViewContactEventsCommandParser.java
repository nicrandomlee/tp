package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.ViewContactEventsCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new ViewContactEventsCommand object.
 */
public class ViewContactEventsCommandParser implements Parser<ViewContactEventsCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the ViewContactEventsCommand
     * and returns a ViewContactEventsCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format.
     */
    public ViewContactEventsCommand parse(String args) throws ParseException {
        try {
            Index index = ParserUtil.parseIndex(args);
            return new ViewContactEventsCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewContactEventsCommand.MESSAGE_USAGE));
        }
    }
}