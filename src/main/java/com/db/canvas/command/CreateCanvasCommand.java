package com.db.canvas.command;

import com.db.canvas.CanvasSheet;
import com.db.canvas.exception.MalformedCommandException;
import com.db.canvas.utils.CommandValidatorUtils;

/*
C w h
 */
public class CreateCanvasCommand implements Command {

    private int width;

    private int height;

    private CanvasSheet canvasSheet;


    public CreateCanvasCommand(String[] commandArray, CanvasSheet canvasSheet) throws MalformedCommandException {
        CommandValidatorUtils.validateCreateCanvasCommand(commandArray);

        this.width = Integer.parseInt(commandArray[1]);
        this.height = Integer.parseInt(commandArray[2]);
        this.canvasSheet = canvasSheet;
    }

    public void execute() {
        this.canvasSheet.initialize(this.width, this.height);
    }
}
