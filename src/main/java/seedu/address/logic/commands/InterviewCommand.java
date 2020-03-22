package seedu.address.logic.commands;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.internship.InternshipApplication;

import java.util.List;

import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_IS_ONLINE;

public abstract class InterviewCommand extends Command {

    public static final String COMMAND_WORD = "interview";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Modifies Interviews in an Internship Application by using an index to specify application followed"
            + "by a command word to specify action to be taken.\n"
            + "Parameters: INDEX (must be a positive integer) COMMAND_CODE (must be either add, edit or delete)"
            + "[" + PREFIX_IS_ONLINE + "is it an online interview (true/false)] "
            + "[" + PREFIX_DATE + "DATE] "
            + "[" + PREFIX_ADDRESS + "ADDRESS (optional if online interview] "
            + "Example: " + COMMAND_WORD + " 1 add "
            + PREFIX_IS_ONLINE + "false"
            + PREFIX_ADDRESS + "123 road"
            + PREFIX_DATE + "01 02 2020";

    protected InternshipApplication getInternshipApplication(Model model, Index index) throws CommandException {
        List<InternshipApplication> lastShownList = model.getFilteredInternshipApplicationList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_INTERNSHIP_DISPLAYED_INDEX);
        }

        return lastShownList.get(index.getZeroBased());
    }


}
