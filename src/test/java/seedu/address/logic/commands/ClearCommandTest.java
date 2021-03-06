package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalInternshipApplications.getTypicalInternshipDiary;

import org.junit.jupiter.api.Test;

import seedu.address.model.InternshipDiary;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

public class ClearCommandTest {

    @Test
    public void execute_emptyInternshipDiary_success() {
        Model model = new ModelManager();
        Model expectedModel = new ModelManager();

        assertCommandSuccess(new ClearCommand(), model, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_nonEmptyInternshipDiary_success() {
        Model model = new ModelManager(getTypicalInternshipDiary(), new UserPrefs());
        Model expectedModel = new ModelManager(getTypicalInternshipDiary(), new UserPrefs());
        expectedModel.setInternshipDiary(new InternshipDiary());

        assertCommandSuccess(new ClearCommand(), model, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

}
