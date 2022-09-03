package com.db.canvas.command;

import com.db.canvas.exception.PrintException;

public interface Command {
    void execute() throws PrintException;
}
