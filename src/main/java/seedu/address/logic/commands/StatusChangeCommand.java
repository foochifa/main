package seedu.address.logic.commands;

import seedu.address.commons.core.index.Index;
import seedu.address.model.status.Status;

/** Utility command to change a status of a specific Internship Application provided.
 * It is a type of EditCommand but is only parsed from a confirmation parser.
 */
public class StatusChangeCommand extends EditCommand {

    private StatusChangeCommand(Index index, EditInternshipDescriptor editInternshipDescriptor) {
        super(index, editInternshipDescriptor);
    }

    /**
     * Static constructor for StatusChangeCommand. Will return a StatusChangeCommand.
     */
    public static StatusChangeCommand CreateStatusChange(Index index, Status statusToChangeTo) {
        EditCommand.EditInternshipDescriptor editInternshipDescriptor = new EditCommand.EditInternshipDescriptor();
        editInternshipDescriptor.setStatus(statusToChangeTo);
        return new StatusChangeCommand(index, editInternshipDescriptor);
    }
}
