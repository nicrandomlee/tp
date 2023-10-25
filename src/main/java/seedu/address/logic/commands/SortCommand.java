package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.Comparator;

import seedu.address.model.Model;
import seedu.address.model.person.Person;
import seedu.address.model.person.comparer.SortComparator;

/**
 * Changes the remark of an existing person in the address book.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";
    public static final String SORTBY_KEYWORD = "/byname";
    public static final String REVERSE_KEYWORD = "/reverse";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts all persons in UniMate "
            + "by the alphabetical order of their name. \n"
            + "Example: " + COMMAND_WORD + " " + SORTBY_KEYWORD + " " + REVERSE_KEYWORD;

    public static final String MESSAGE_SUCCESS = "Sorted all persons by specified order";
    private Comparator<Person> personComparator;

    /**
     * Constructor for SortCommand, creates a comparator to sort by Person's full name.
     */
    public SortCommand(ArrayList<SortComparator> sortComparatorList) {
        SortComparator sortComparator = sortComparatorList.get(0);
        boolean isReverse = sortComparator.getIsReverse();
        this.personComparator = isReverse
                ? sortComparator.reversed()
                : sortComparator;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.sortPersonList(personComparator);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
