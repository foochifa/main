package seedu.address.logic;

import java.beans.PropertyChangeListener;
import java.nio.file.Path;

import javafx.collections.ObservableList;

import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.ListenerPropertyType;
import seedu.address.model.ReadOnlyInternshipDiary;
import seedu.address.model.internship.InternshipApplication;
import seedu.address.model.statistics.Statistics;

/**
 * API of the Logic component
 */
public interface Logic {
    /**
     * Executes the command and returns the result.
     * @param commandText The command as entered by the user.
     * @return the result of the command execution.
     * @throws CommandException If an error occurs during command execution.
     * @throws ParseException If an error occurs during parsing.
     */
    CommandResult execute(String commandText) throws CommandException, ParseException;

    /**
     * Returns the InternshipDiary.
     *
     * @see seedu.address.model.Model#getInternshipDiary()
     */
    ReadOnlyInternshipDiary getInternshipDiary();

    /** Returns an unmodifiable view of the filtered list of internship applications */
    ObservableList<InternshipApplication> getFilteredInternshipApplicationList();

    /**
     * Adds a property listener for any changes in {@code propertyType} used.
     */
    void addPropertyChangeListener(ListenerPropertyType propertyType, PropertyChangeListener l);

    /**
     * Returns the user prefs' internship diary file path.
     */
    Path getInternshipDiaryFilePath();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Set the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns a statistics object that can compute relevant internship application statistics.
     */
    Statistics getStatistics();

}
