package com.db.canvas.command;

import com.db.canvas.exception.MalformedCommandException;
import com.db.canvas.exception.QuitException;
import com.db.canvas.utils.CommandValidatorUtils;

public class QuitCommand implements Command {

    public QuitCommand(String[] commandArray) throws MalformedCommandException {
        CommandValidatorUtils.validateQuitCommand(commandArray);
    }

    public void execute() {
        throw new QuitException("quit");
    }
}
