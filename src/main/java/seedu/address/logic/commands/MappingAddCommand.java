package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.SeplendidModel;
import seedu.address.model.mapping.Mapping;
import seedu.address.seplendidui.UiUtil;

/**
 * Adds a mapping to the MappingCatalogue.
 */
public class MappingAddCommand extends MappingCommand {

    public static final String MAPPING_ADD_MESSAGE_USAGE = COMMAND_WORD
            + " add [localcode] [university] [partnercode] [information]: Adds a mapping to the mapping catalogue.";
    public static final String ACTION_WORD = "add";

    public static final String MESSAGE_SUCCESS = "New mapping added: %1$s";
    public static final String MESSAGE_DUPLICATE_MAPPING = "This mapping already exists in SEPlendid";
    public static final String MESSAGE_NONEXISTENT_LOCALCODE = "The local course does not exist in SEPlendid";
    public static final String MESSAGE_NONEXISTENT_UNIVERSITY = "The partner university does not exist in SEPlendid";
    public static final String MESSAGE_NONEXISTENT_PARTNERCODE = "The partner course does not exist in SEPlendid";

    private final Mapping mappingToAdd;

    /**
     * Creates a MappingAddCommand to add the specified {@code mapping}
     *
     * @param mapping The Mapping to be added into Storage.
     */
    public MappingAddCommand(Mapping mapping) {
        super();
        requireNonNull(mapping);
        mappingToAdd = mapping;
    }

    /**
     * TBD: This stub is to be removed after morphing is complete.
     *
     * @param model {@code Model} which the command should operate on.
     * @return Nothing.
     * @throws CommandException Always.
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        throw new CommandException("TBD: this is a stub and should be removed after morph.");
    }

    @Override
    public CommandResult execute(SeplendidModel seplendidModel) throws CommandException {
        requireNonNull(seplendidModel);

        if (seplendidModel.hasMapping(mappingToAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_MAPPING);
        }

        // Check if localcode, university and partnercode exists
        if (!seplendidModel.hasLocalCourse(mappingToAdd.getLocalCode())) {
            throw new CommandException(MESSAGE_NONEXISTENT_LOCALCODE);
        }

        if (!seplendidModel.hasPartnerCourse(mappingToAdd.getPartnerCode())) {
            throw new CommandException(MESSAGE_NONEXISTENT_PARTNERCODE);
        }

        if (!seplendidModel.hasUniversity(mappingToAdd.getUniversityName())) {
            throw new CommandException(MESSAGE_NONEXISTENT_UNIVERSITY);
        }

        // Check if
        seplendidModel.addMapping(mappingToAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(mappingToAdd)),
                UiUtil.ListViewModel.MAPPING_LIST);

    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof MappingAddCommand)) {
            return false;
        }

        MappingAddCommand otherMappingAddCommand = (MappingAddCommand) other;
        return mappingToAdd.equals(otherMappingAddCommand.mappingToAdd);
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("mappingToAdd", mappingToAdd)
                .toString();
    }

}
