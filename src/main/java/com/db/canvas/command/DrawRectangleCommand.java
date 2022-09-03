package com.db.canvas.command;

import com.db.canvas.CanvasSheet;
import com.db.canvas.exception.MalformedCommandException;
import com.db.canvas.exception.PrintException;
import com.db.canvas.printer.Printer;
import com.db.canvas.printer.RectanglePrinter;
import com.db.canvas.utils.CommandValidatorUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

/*
R x1 y1 x2 y2
 */
public class DrawRectangleCommand implements Command {

    private Pair<Integer, Integer> p1;

    private Pair<Integer, Integer> p2;

    private CanvasSheet canvasSheet;

    public DrawRectangleCommand(String[] commandArray, CanvasSheet canvasSheet) throws MalformedCommandException {
        CommandValidatorUtils.validateDrawRectangleCommand(commandArray, canvasSheet);

        p1 = new ImmutablePair<>(Integer.parseInt(commandArray[1]), Integer.parseInt(commandArray[2]));
        p2 = new ImmutablePair<>(Integer.parseInt(commandArray[3]), Integer.parseInt(commandArray[4]));

        this.canvasSheet = canvasSheet;

    }
    public void execute() throws PrintException {
        Printer printer = new RectanglePrinter(p1, p2);
        printer.print(this.canvasSheet);
    }
}
