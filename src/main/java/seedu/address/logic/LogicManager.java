package seedu.address.logic;

import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Logger;

import javafx.collections.ObservableList;

import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.InternshipDiaryParser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.ListenerPropertyType;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyInternshipDiary;
import seedu.address.model.internship.InternshipApplication;
import seedu.address.model.statistics.Statistics;
import seedu.address.storage.Storage;

/**
 * The main LogicManager of the app.
 */
public class LogicManager implements Logic {
    public static final String FILE_OPS_ERROR_MESSAGE = "Could not save data to file: ";
    private final Logger logger = LogsCenter.getLogger(LogicManager.class);

    private final Model model;
    private final Storage storage;
    private final InternshipDiaryParser internshipDiaryParser;

    private InternshipDiaryParser nextParser;

    public LogicManager(Model model, Storage storage) {
        this.model = model;
        this.storage = storage;
        internshipDiaryParser = new InternshipDiaryParser();
    }

    @Override
    public CommandResult execute(String commandText) throws CommandException, ParseException {
        logger.info("----------------[USER COMMAND][" + commandText + "]");

        InternshipDiaryParser nextParser = this.nextParser;
        this.nextParser = null;

        Command command;
        if (nextParser == null) {
            command = internshipDiaryParser.parseCommand(commandText);
        } else {
            command = nextParser.parseCommand(commandText);
        }
        CommandResult commandResult = command.execute(model);
        this.nextParser = command.getNextInternshipDiaryParser();

        try {
            storage.saveInternshipDiary(model.getInternshipDiary());
        } catch (IOException ioe) {
            throw new CommandException(FILE_OPS_ERROR_MESSAGE + ioe, ioe);
        }

        return commandResult;
    }

    @Override
    public ReadOnlyInternshipDiary getInternshipDiary() {
        return model.getInternshipDiary();
    }

    @Override
    public ObservableList<InternshipApplication> getFilteredInternshipApplicationList() {
        return model.getFilteredInternshipApplicationList();
    }

    @Override
    public void addPropertyChangeListener(ListenerPropertyType propertyType, PropertyChangeListener l) {
        model.addPropertyChangeListener(propertyType, l);
    }

    @Override
    public Path getInternshipDiaryFilePath() {
        return model.getInternshipDiaryFilePath();
    }

    @Override
    public GuiSettings getGuiSettings() {
        return model.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        model.setGuiSettings(guiSettings);
    }

    @Override
    public Statistics getStatistics() {
        return model.getStatistics();
    }

}
