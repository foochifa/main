package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Selects an internship application to display in the GUI.
 */
public class SelectCommand extends Command {
    public static final String COMMAND_WORD = "select";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": displays the details of the internship application selected based on "
            + "the index number in the displayed internship application list.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + "\nExample: " + COMMAND_WORD + " 1 ";

    public static final String MESSAGE_SELECT_SUCCESS = "Internship Application Displayed!";

    private Index index;

    public SelectCommand(Index index) {
        requireNonNull(index);
        this.index = index;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        return new CommandResult(MESSAGE_SELECT_SUCCESS, index);
    }
}
