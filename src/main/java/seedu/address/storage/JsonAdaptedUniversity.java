package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.localcourse.LocalCourse;
import seedu.address.model.localcourse.LocalName;
import seedu.address.model.university.University;
import seedu.address.model.university.UniversityName;

/**
 * Jackson-friendly version of {@link LocalCourse}.
 */
class JsonAdaptedUniversity {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "University's %s field is missing!";

    private final String universityName;


    /**
     * Constructs a {@code JsonAdaptedUniversity} with the given localCourse details.
     */
    @JsonCreator
    public JsonAdaptedUniversity(@JsonProperty("university") String universityName) {
        this.universityName = universityName;
    }

    /**
     * Converts a given {@code University} into this class for Jackson use.
     */
    public JsonAdaptedUniversity(University source) {
        universityName = source.getUniversityName().value;
    }

    /**
     * Converts this Jackson-friendly adapted university object into the model's {@code University} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted university.
     */
    public University toModelType() throws IllegalValueException {

        if (universityName == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    UniversityName.class.getSimpleName()));
        }
        if (!UniversityName.isValidUniversityName(universityName)) {
            throw new IllegalValueException(LocalName.MESSAGE_CONSTRAINTS);
        }
        final UniversityName modelUniversityName = new UniversityName(universityName);

        return new University(modelUniversityName);
    }

}