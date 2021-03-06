package seedu.address.logic.comparator;

import java.util.Comparator;

import seedu.address.logic.commands.SortCommand;
import seedu.address.model.internship.InternshipApplication;

/**
 * Identical to Comparator.reversed(). However, the string is overwritten.
 */
class ReversedComparator implements Comparator<InternshipApplication> {
    private Comparator<InternshipApplication> internalComparator;

    protected ReversedComparator(Comparator<InternshipApplication> comparator) {
        this.internalComparator = comparator;
    }

    @Override
    public int compare(InternshipApplication internship1, InternshipApplication internship2) {
        return -internalComparator.compare(internship1, internship2);
    }

    @Override
    public String toString() {
        return SortCommand.REVERSE_KEYWORD + " " + internalComparator.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof ReversedComparator
                && internalComparator.equals(((ReversedComparator) other).internalComparator);
    }
}
