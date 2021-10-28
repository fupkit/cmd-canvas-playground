package com.tony.cmdcanvas.command;

import com.tony.cmdcanvas.exception.InvalidInputException;
import org.springframework.stereotype.Component;

import static com.tony.cmdcanvas.Constants.*;

@Component
public class CommandFactory {
    public Command buildCommand(String input) throws InvalidInputException {
        if(input == null) {
            throwInvalidInput(null);
        }
        if(input.startsWith("C ")) {
            return new CanvasCommand(input);
        } else if(input.startsWith("L")) {
            return new LineCommand(input);
        } else if(input.startsWith("R ")) {
            return new RectangleCommand(input);
        } else if(input.startsWith("B ")) {
            return new BucketFillCommand(input);
        } else {
            throwInvalidInput(input);
        }
        return null;
    }

    private void throwInvalidInput(String input) throws InvalidInputException {
        throw new InvalidInputException(String.format(INVALID_INPUT_MSG, input, ELIGIBLE_INPUT_DESC));
    }
}
