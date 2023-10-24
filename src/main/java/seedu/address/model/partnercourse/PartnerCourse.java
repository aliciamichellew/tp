package seedu.address.model.partnercourse;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.SeplendidDataType;
import seedu.address.model.university.University;

/**
 * Represents a Partner Course in SEPlendid.
 * Guarantees: details are present and not null, field values are validated and immutable.
 */
public class PartnerCourse implements SeplendidDataType {
    private final University partnerUniversity;
    private final PartnerCode partnerCode;
    private final PartnerName partnerName;
    private final PartnerUnit partnerUnit;

    /**
     * Every field must be present and not null
     */
    public PartnerCourse(
        University partnerUniversity,
        PartnerCode partnerCode,
        PartnerName partnerName,
        PartnerUnit partnerUnit) {
        requireAllNonNull(partnerUniversity, partnerCode, partnerName, partnerUnit);
        this.partnerUniversity = partnerUniversity;
        this.partnerCode = partnerCode;
        this.partnerName = partnerName;
        this.partnerUnit = partnerUnit;
    }
    public University getPartnerUniversity() {
        return partnerUniversity;
    }

    public PartnerCode getPartnerCode() {
        return partnerCode;
    }

    public PartnerName getPartnerName() {
        return partnerName;
    }

    public PartnerUnit getPartnerUnit() {
        return partnerUnit;
    }

    /**
     * Returns true if both PartnerCourses have the same partnerCode.
     * Assumption: partnerCode is the primary key i.e. there exists
     * no two distinct PartnerCourses with the same partnerCode.
     *
     * @param otherPartnerCourse This is the other partner course.
     */
    public boolean isSamePartnerCourse(PartnerCourse otherPartnerCourse) {
        if (otherPartnerCourse == this) {
            return true;
        }

        if (otherPartnerCourse == null) {
            return false;
        }

        return otherPartnerCourse.getPartnerCode().equals(getPartnerCode());
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof PartnerCourse)) {
            return false;
        }

        PartnerCourse otherPartnerCourse = (PartnerCourse) other;
        return partnerUniversity.equals(otherPartnerCourse.partnerUniversity)
                && partnerCode.equals(otherPartnerCourse.partnerCode)
                && partnerName.equals(otherPartnerCourse.partnerName)
                && partnerUnit.equals(otherPartnerCourse.partnerUnit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partnerUniversity, partnerCode, partnerName, partnerUnit);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("partnerUniversity", partnerUniversity)
                .add("partnerCode", partnerCode)
                .add("partnerName", partnerName)
                .add("partnerUnit", partnerUnit)
                .toString();
    }
}
