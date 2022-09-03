package com.db.canvas.utils;

import com.db.canvas.CanvasSheet;
import com.db.canvas.exception.MalformedCommandException;

public class CommandValidatorUtils {
    public static void validateCreateCanvasCommand(String[] commandArray) throws MalformedCommandException {
        if(commandArray.length != 3)
            throw new MalformedCommandException("Improper Command as number of elements are not 3. It should be of format 'C w h'");

        try {
            int w = Integer.parseInt(commandArray[1]);
            int h = Integer.parseInt(commandArray[2]);

            if(w < 1 || h < 1)
                throw new MalformedCommandException("Improper Command as w or h should be greater than 0");

        } catch (IllegalArgumentException iae) {
            throw new MalformedCommandException("Improper Command as w or h are not numeric");
        }
    }

    public static void validateQuitCommand(String[] commandArray) throws MalformedCommandException {
        if(commandArray.length != 1)
            throw new MalformedCommandException("Improper Command as number of elements are not 1. It should be of format 'Q'");
    }

    public static void validateDrawLineCommand(String[] commandArray, CanvasSheet canvasSheet) throws MalformedCommandException {
        if(commandArray.length != 5)
            throw new MalformedCommandException("Improper Command as number of elements are not 5. It should be of format 'L x1 y1 x2 y2'");

        checkIfCanvasIsInitialized(canvasSheet);


        try {
            int x1 = Integer.parseInt(commandArray[1]);
            int y1 = Integer.parseInt(commandArray[2]);

            int x2 = Integer.parseInt(commandArray[3]);
            int y2 = Integer.parseInt(commandArray[4]);

            checkIfCommandIsWithinTheCanvas(canvasSheet, x1, y1, x2, y2);

            if (!(y1==y2 || x1==x2))
                throw new MalformedCommandException("Improper Command, x1,y1,x2,y2 doesnt make a horizontal or vertical line");

        } catch (IllegalArgumentException iae) {
            throw new MalformedCommandException("Improper Command, either of x1/y1/x2/y2 are not integers");
        }
    }

    public static void validateDrawRectangleCommand(String[] commandArray, CanvasSheet canvasSheet) throws MalformedCommandException {
        if(commandArray.length != 5)
            throw new MalformedCommandException("Improper Command as number of elements are not 5. It should be of format 'R x1 y1 x2 y2'");

        checkIfCanvasIsInitialized(canvasSheet);

        try {
            int x1 = Integer.parseInt(commandArray[1]);
            int y1 = Integer.parseInt(commandArray[2]);

            int x2 = Integer.parseInt(commandArray[3]);
            int y2 = Integer.parseInt(commandArray[4]);

            checkIfCommandIsWithinTheCanvas(canvasSheet, x1, y1, x2, y2);

        } catch (IllegalArgumentException iae) {
            throw new MalformedCommandException("Improper Command, either of x1/y1/x2/y2 are not integers");
        }
    }


    private static void checkIfCanvasIsInitialized(CanvasSheet canvasSheet) throws MalformedCommandException {
        if(!canvasSheet.isInitialized())
            throw new MalformedCommandException("Improper Command as the Canvas is not yet created. Please create the Canvas");
    }


    private static void checkIfCommandIsWithinTheCanvas(CanvasSheet canvasSheet, int x1, int y1, int x2, int y2) throws MalformedCommandException {
        if(x1 < 1 || y1 < 1 || x2 < 1 || y2 < 1)
            throw new MalformedCommandException("Improper Command, x1,y1,x2,y2 should be greater than 0");
        else if (x1 > canvasSheet.getWidth() || x2 > canvasSheet.getWidth() || y1 > canvasSheet.getHeight() || y2 > canvasSheet.getHeight())
            throw new MalformedCommandException("Improper Command, x1,y1,x2,y2 should lie within the Canvas");
    }
}
