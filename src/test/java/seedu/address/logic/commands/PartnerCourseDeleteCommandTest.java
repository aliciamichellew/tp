package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalObjects.COMP1000;
import static seedu.address.testutil.TypicalObjects.COMP2000;
import static seedu.address.testutil.TypicalObjects.TYPICAL_PARTNER_COURSE_CODE;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.PartnerCourseCatalogue;
import seedu.address.model.ReadOnlyLocalCourseCatalogue;
import seedu.address.model.ReadOnlyNoteCatalogue;
import seedu.address.model.ReadOnlyPartnerCourseCatalogue;
import seedu.address.model.ReadOnlyUniversityCatalogue;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.SeplendidModel;
import seedu.address.model.localcourse.LocalCode;
import seedu.address.model.localcourse.LocalCourse;
import seedu.address.model.notes.Note;
import seedu.address.model.partnercourse.PartnerCode;
import seedu.address.model.partnercourse.PartnerCourse;
import seedu.address.model.university.University;
import seedu.address.testutil.PartnerCourseBuilder;

/**
 * Unit testing of PartnerCourseDeleteCommand, with stubs / dependency injection.
 */
public class PartnerCourseDeleteCommandTest {

    @Test
    public void constructor_nullPartnerCode_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new PartnerCourseDeleteCommand(null));
    }

    @Test
    public void execute_partnerCourseAcceptedByModel_deleteSuccessful() throws Exception {
        ModelStubAcceptingPartnerCourseDeleted modelStub = new ModelStubAcceptingPartnerCourseDeleted();

        CommandResult commandResult = new PartnerCourseDeleteCommand(COMP1000.getPartnerCode()).execute(modelStub);

        assertEquals(String.format(PartnerCourseDeleteCommand.MESSAGE_SUCCESS, Messages.format(COMP1000)),
                commandResult.getFeedbackToUser());
        assertEquals(Arrays.asList(COMP2000), modelStub.partnerCoursesAdded);
    }

    @Test
    public void execute_partnerCourseDoesNotExist_throwsCommandException() {
        PartnerCourse validPartnerCourse = new PartnerCourseBuilder().build();
        PartnerCourseDeleteCommand partnerCourseDeleteCommand = new PartnerCourseDeleteCommand(
                new PartnerCode(TYPICAL_PARTNER_COURSE_CODE));
        SeplendidModelStub modelStub = new SeplendidModelStubWithPartnerCourse(validPartnerCourse);

        assertThrows(CommandException.class, PartnerCourseDeleteCommand.MESSAGE_NONEXISTENT_PARTNER_COURSE, () ->
                partnerCourseDeleteCommand.execute(modelStub));
    }

    @Test
    public void equals() {
        PartnerCode comp1000 = new PartnerCode("COMP1000");
        PartnerCode comp2000 = new PartnerCode("COMP2000");
        PartnerCourseDeleteCommand deleteComp1000Command = new PartnerCourseDeleteCommand(comp1000);
        PartnerCourseDeleteCommand deleteComp2000Command = new PartnerCourseDeleteCommand(comp2000);

        // same object -> returns true
        assertTrue(deleteComp1000Command.equals(deleteComp1000Command));

        // same values -> returns true
        PartnerCourseDeleteCommand deleteComp1000CommandCopy = new PartnerCourseDeleteCommand(comp1000);
        assertTrue(deleteComp1000Command.equals(deleteComp1000CommandCopy));

        // different types -> returns false
        assertFalse(deleteComp1000Command.equals(1));

        // null -> returns false
        assertFalse(deleteComp1000Command.equals(null));

        // different local course -> returns false
        assertFalse(deleteComp1000Command.equals(deleteComp2000Command));
    }

    /**
     * A default model stub that have all methods failing.
     */
    private class SeplendidModelStub implements SeplendidModel {
        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public GuiSettings getGuiSettings() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            throw new AssertionError("This method should not be called.");
        }

        // LocalCourse
        @Override
        public Path getLocalCourseCatalogueFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setLocalCourseCatalogueFilePath(Path localCourseCatalogueFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addLocalCourse(LocalCourse localCourse) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setLocalCourseCatalogue(ReadOnlyLocalCourseCatalogue localCourseCatalogue) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyLocalCourseCatalogue getLocalCourseCatalogue() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasLocalCourse(LocalCourse localCourse) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Optional<LocalCourse> getLocalCourseIfExists(LocalCode localCode) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteLocalCourse(LocalCourse localCourse) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setLocalCourse(LocalCourse localCourse, LocalCourse editedLocalCourse) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<LocalCourse> getFilteredLocalCourseList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredLocalCourseList(Predicate<LocalCourse> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        // PartnerCourse
        @Override
        public Path getPartnerCourseCatalogueFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setPartnerCourseCatalogueFilePath(Path partnerCourseCatalogueFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addPartnerCourse(PartnerCourse partnerCourse) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deletePartnerCourse(PartnerCourse partnerCourse) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyPartnerCourseCatalogue getPartnerCourseCatalogue() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasPartnerCourse(PartnerCourse partnerCourse) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Optional<PartnerCourse> getPartnerCourseIfExists(PartnerCode partnerCode) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<PartnerCourse> getFilteredPartnerCourseList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredPartnerCourseList(Predicate<PartnerCourse> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        // University
        @Override
        public Path getUniversityCatalogueFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyUniversityCatalogue getUniversityCatalogue() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setNoteCatalogue(ReadOnlyNoteCatalogue noteCatalogue) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyNoteCatalogue getNoteCatalogue() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasNote(Note note) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteNote(Note note) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setUniversityCatalogueFilePath(Path universityCatalogueFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<University> getFilteredUniversityList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasUniversity(University university) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addUniversity(University university) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setUniversity(University target, University editedUniversity) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredUniversityList(Predicate<University> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setUniversityCatalogue(ReadOnlyUniversityCatalogue universityCatalogue) {
            throw new AssertionError("This method should not be called.");
        }

        // Note
        @Override
        public void addNote(Note note) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setNote(Note note, Note editedNote) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Note> getFilteredNoteList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredNoteList(Predicate<Note> predicate) {
            throw new AssertionError("This method should not be called.");
        }

    }

    /**
     * A Model stub that contains a single partnerCourse.
     */
    private class SeplendidModelStubWithPartnerCourse extends PartnerCourseDeleteCommandTest.SeplendidModelStub {
        private final PartnerCourse partnerCourse;

        SeplendidModelStubWithPartnerCourse(PartnerCourse pc) {
            requireNonNull(pc);
            partnerCourse = pc;
        }

        @Override
        public boolean hasPartnerCourse(PartnerCourse pc) {
            requireNonNull(pc);
            return partnerCourse.isSamePartnerCourse(pc);
        }

        @Override
        public void deletePartnerCourse(PartnerCourse partnerCourse) {
            requireNonNull(partnerCourse);
        }

        @Override
        public Optional<PartnerCourse> getPartnerCourseIfExists(PartnerCode partnerCode) {
            if (!partnerCourse.getPartnerCode().equals(partnerCode)) {
                return Optional.empty();
            }
            return Optional.of(partnerCourse);
        }
    }

    /**
     * A Model stub that always accept the partner course being added.
     */
    private class ModelStubAcceptingPartnerCourseDeleted extends PartnerCourseDeleteCommandTest.SeplendidModelStub {
        final ArrayList<PartnerCourse> partnerCoursesAdded = new ArrayList<>(List.of(COMP1000, COMP2000));

        @Override
        public boolean hasPartnerCourse(PartnerCourse partnerCourse) {
            requireNonNull(partnerCourse);
            return partnerCoursesAdded.stream().anyMatch(partnerCourse::isSamePartnerCourse);
        }

        @Override
        public void deletePartnerCourse(PartnerCourse partnerCourse) {
            requireNonNull(partnerCourse);
            partnerCoursesAdded.remove(partnerCourse);
        }

        @Override
        public Optional<PartnerCourse> getPartnerCourseIfExists(PartnerCode partnerCode) {
            return partnerCoursesAdded.stream().filter(pc -> pc.getPartnerCode().equals(partnerCode)).findFirst();
        }

        @Override
        public ReadOnlyPartnerCourseCatalogue getPartnerCourseCatalogue() {
            return new PartnerCourseCatalogue();
        }
    }
}