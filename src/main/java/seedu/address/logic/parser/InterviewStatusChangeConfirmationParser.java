package seedu.address.logic.parser;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.StatusChangeCommand;
import seedu.address.logic.parser.exceptions.InterviewStatusChangeConfirmationParseException;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.status.Status;

/** Parses user input to confirm change of status from adding interview.
 * Adapted from ClearCommandConfirmationParser.
 */
public class InterviewStatusChangeConfirmationParser extends InternshipDiaryParser {
    public static final String CONFIRMATION_COMMAND_WORD = "yes";
    public static final String CHANGE_REFUSAL = "Status of Internship Application will not be changed.";

    // The index of the internship application to change status.
    private Index index;

    public InterviewStatusChangeConfirmationParser(Index index) {
        this.index = index;
    }

    @Override
    public Command parseCommand(String userInput) throws ParseException {
        if (userInput.trim().toLowerCase().equals(CONFIRMATION_COMMAND_WORD)) {
            return StatusChangeCommand.createStatusChange(index, Status.INTERVIEW);
        } else {
            throw new InterviewStatusChangeConfirmationParseException(CHANGE_REFUSAL);
        }
    }
}
