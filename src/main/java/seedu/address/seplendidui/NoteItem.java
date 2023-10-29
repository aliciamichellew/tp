package seedu.address.seplendidui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.notes.Note;

/**
 * An UI component that displays information of a {@code Note}.
 */
public class NoteItem extends UiPart<Region> {
    private static final String FXML = "NoteItemCard.fxml";

    public final Note note;

    @javafx.fxml.FXML
    private HBox noteItemPane;
    @FXML
    private Label id;
    @FXML
    private Label content;
    @FXML
    private Label tags;
    /**
     * Creates a {@code NoteItem} with the given {@code Note}
     */
    public NoteItem(Note note, int displayedIndex) {
        super(FXML);
        this.note = note;
        id.setText(displayedIndex + ".");
        content.setText(note.getContent().toString());
        tags.setText("Tags:" + note.getTags().toString());
    }
}
