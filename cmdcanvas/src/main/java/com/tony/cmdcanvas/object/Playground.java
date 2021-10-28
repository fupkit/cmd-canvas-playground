package com.tony.cmdcanvas.object;

import com.tony.cmdcanvas.command.*;
import com.tony.cmdcanvas.exception.InvalidInputException;
import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.tony.cmdcanvas.Constants.ERROR_MSG_CANVAS_NOT_EXIST;

@Data
@Component
@Getter
public class Playground {
    private CommandFactory commandFactory;
    private Canvas canvas;
    private boolean isPlaying = true;

    @Autowired
    public Playground(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    public void readInput(String input) {
        try {
            if("Q".equals(input)) {
                this.isPlaying = false;
                return;
            }
            executeCommand(input);
        } catch (InvalidInputException e) {
            print(e.getMessage());
        }
    }

    private void executeCommand(String input) throws InvalidInputException {
        Command command = this.commandFactory.buildCommand(input);
        if (command instanceof CanvasCommand) {
            this.canvas = ((CanvasCommand) command).execute();
        } else if (this.canvas == null) {
            throw new InvalidInputException(ERROR_MSG_CANVAS_NOT_EXIST);
        } else if(command instanceof LineCommand) {
            ((LineCommand) command).draw(this.canvas);
        } else if(command instanceof RectangleCommand) {
            ((RectangleCommand) command).draw(this.canvas);
        } else if(command instanceof BucketFillCommand) {
            ((BucketFillCommand) command).draw(this.canvas);
        }
        print(this.canvas.drawContent());
    }

    private void print(String str) {
        System.out.println(str);
    }
}
