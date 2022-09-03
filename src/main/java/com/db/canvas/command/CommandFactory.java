package com.db.canvas.command;

import com.db.canvas.CanvasSheet;
import com.db.canvas.constants.CanvasConstants;
import com.db.canvas.exception.MalformedCommandException;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;

public class CommandFactory {

    public static Command getCommand(String strCommand, CanvasSheet canvasSheet) throws MalformedCommandException {
        if(StringUtils.isBlank(strCommand))
            throw new MalformedCommandException("Command cannot be empty or null");

        String[] commandArray = strCommand.trim().split(CanvasConstants.DELIMITER);

        CommandEnum command = EnumUtils.getEnumIgnoreCase(CommandEnum.class, commandArray[0]);

        if(command == null)
            throw new MalformedCommandException("Malformed Command, Not a valid command : "+commandArray[0]);

        Command canvasCommand;
        switch(command) {
            case C:
                canvasCommand = new CreateCanvasCommand(commandArray, canvasSheet);
                break;
            case L:
                canvasCommand = new DrawLineCommand(commandArray, canvasSheet);
                break;
            case R:
                canvasCommand = new DrawRectangleCommand(commandArray, canvasSheet);
                break;
            case Q:
                canvasCommand = new QuitCommand(commandArray);
                break;
            default:
                throw new MalformedCommandException("Malformed Command");
        }
        return canvasCommand;

    }
}
