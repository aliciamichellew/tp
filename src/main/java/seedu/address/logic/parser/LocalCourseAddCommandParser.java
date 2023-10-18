package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_LOCALCODE;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_LOCALNAME;
import static seedu.address.logic.parser.ParserUtil.areValuesEnclosedAndNonEmpty;

import java.util.stream.Stream;

import seedu.address.logic.commands.LocalCourseAddCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.localcourse.LocalCode;
import seedu.address.model.localcourse.LocalCourse;
import seedu.address.model.localcourse.LocalName;

/**
 * Parses input arguments and creates a new LocalCourse object.
 */
public class LocalCourseAddCommandParser implements Parser<LocalCourseAddCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the LocalCourseAddCommand
     * and returns an LocalCourseAddCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public LocalCourseAddCommand parse(String args) throws ParseException {
        if (!areValuesEnclosedAndNonEmpty(args)) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                            LocalCourseAddCommand.LOCAL_COURSE_ADD_MESSAGE_USAGE));
        }

        SeplendidArgumentMap parameterToArgMap =
                SeplendidArgumentTokenizer.tokenize(args, PARAMETER_LOCALCODE, PARAMETER_LOCALNAME);

        if (!areArgumentsPresent(parameterToArgMap, PARAMETER_LOCALCODE, PARAMETER_LOCALNAME)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    LocalCourseAddCommand.LOCAL_COURSE_ADD_MESSAGE_USAGE));
        }

        // All arguments should be a non-empty {@code Optional}
        LocalCode localCode = ParserUtil.parseLocalCode(parameterToArgMap.getValue(PARAMETER_LOCALCODE).get());
        LocalName localName = ParserUtil.parseLocalName(parameterToArgMap.getValue(PARAMETER_LOCALNAME).get());

        LocalCourse localCourse = new LocalCourse(localCode, localName);

        return new LocalCourseAddCommand(localCourse);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code SeplendidArgumentMap}.
     */
    private static boolean areArgumentsPresent(SeplendidArgumentMap argumentMap, SeplendidParameter... parameters) {
        return Stream.of(parameters).allMatch(parameter -> argumentMap.getValue(parameter).isPresent());
    }

}