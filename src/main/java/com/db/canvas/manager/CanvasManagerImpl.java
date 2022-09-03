package com.db.canvas.manager;

import com.db.canvas.CanvasSheet;
import com.db.canvas.command.Command;
import com.db.canvas.command.CommandFactory;
import com.db.canvas.exception.MalformedCommandException;
import com.db.canvas.exception.PrintException;

public class CanvasManagerImpl implements CanvasManager {

    private CanvasSheet canvasSheet;

    public CanvasManagerImpl() {
        canvasSheet = new CanvasSheet();
    }

    public void manage(String input) {
        try {
            Command command = CommandFactory.getCommand(input, canvasSheet);
            command.execute();
            System.out.println(canvasSheet.display());
        } catch (MalformedCommandException mce) {
            System.out.println("Error: " + mce.getMessage());
        } catch (PrintException pe) {
            System.out.println("Error: " + pe.getMessage());
        }
    }


    CanvasSheet getCanvasSheet(){
        return canvasSheet;
    }
}
