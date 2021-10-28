package com.tony.cmdcanvas.command;

import com.tony.cmdcanvas.exception.InvalidInputException;

import static com.tony.cmdcanvas.Constants.*;

public abstract class AbstractCommand implements Command {
    protected String input;

    public AbstractCommand(String input) throws InvalidInputException {
        this.input = input;
        if (input != null && input.matches(getPattern())) {
            parseCommand(input);
        } else {
            throw new InvalidInputException(String.format(INVALID_INPUT_MSG, this.input, ELIGIBLE_INPUT_DESC));
        }
    }

    abstract String getPattern();

    abstract void parseCommand(String input);

    protected String[] splitBySpace(String input) {
        if (input == null) {
            return new String[0];
        }
        return input.split("\\s+");
    }
}
