package seedu.address.logic.parser.exceptions;

/** Represents a refusal by the user to change Interview Status. */
public class InterviewStatusChangeConfirmationParseException extends ParseException {
    public InterviewStatusChangeConfirmationParseException(String message) {
        super(message);
    }
}
