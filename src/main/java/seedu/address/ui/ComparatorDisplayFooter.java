package seedu.address.ui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Comparator;
import java.util.Objects;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import seedu.address.model.internship.InternshipApplication;

/**
 * A graphical interface for the statistics that is displayed at the footer of the application.
 */
public class ComparatorDisplayFooter extends UiPart<Region> implements PropertyChangeListener {

    private static final String FXML = "ComparatorDisplayFooter.fxml";
    private Comparator<InternshipApplication> currentComparator;

    @FXML
    private Label comparatorLabel;

    public ComparatorDisplayFooter() {
        super(FXML);
        comparatorLabel.setText("Not Sorted.");
        updateComparatorDisplay(null);
    }

    /**
     * Receives the latest changes in Comparator from internship diary.
     * Updates the relevant display accordingly.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void propertyChange(PropertyChangeEvent e) {
        updateComparatorDisplay((Comparator<InternshipApplication>) e.getNewValue());
    }

    /**
     * Computes and updates the comparatorLabel.
     *
     * @param comparator comparator object that generates relevant display.
     */
    public void updateComparatorDisplay(Comparator<InternshipApplication> comparator) {
        if (Objects.equals(comparator, currentComparator)) {
            return;
        }
        if (comparator == null) {
            comparatorLabel.setText("Not Sorted.");
        } else {
            comparatorLabel.setText("Sorted by: " + comparator.toString());
        }
        currentComparator = comparator;
    }

}