package com.db.canvas.command;

import com.db.canvas.CanvasSheet;
import com.db.canvas.command.*;
import com.db.canvas.exception.MalformedCommandException;
import com.db.canvas.exception.PrintException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandFactoryTest {

    private String command1 = "C 20 5";

    private String command2 = "L 1 3 7 3";

    private String command4 = "R 15 2 20 5";

    private String improperCommand1 = "L a b 7 3";

    private String improperCommand2 = "L 10 15 40 15";

    private String improperCommand3 = "D 1 3 7 3";

    private String improperCommand4 = "R 40 40 60 60";

    private String improperCommand6 = "R a b 20 5";

    private String improperCommand8 = "L 15 2 20 5";


    private CanvasSheet canvasSheet;

    @Before
    public void setup() {
        canvasSheet = new CanvasSheet();
    }

    @Test
    public void testGetCommandForCreateCanvas() throws MalformedCommandException {
        Command command = CommandFactory.getCommand(command1, canvasSheet);
        assertEquals(CreateCanvasCommand.class, command.getClass());
    }

    @Test(expected = MalformedCommandException.class)
    public void testGetCommand_WithBlank() throws MalformedCommandException {
        CommandFactory.getCommand(" ", canvasSheet);
    }

    @Test(expected = MalformedCommandException.class)
    public void testGetCommandForCreateCanvas_WithInvalidData() throws MalformedCommandException {
        CommandFactory.getCommand("C a b", canvasSheet);
    }

    @Test(expected = MalformedCommandException.class)
    public void testGetCommandForCreateCanvas_WithLessParams() throws MalformedCommandException {
        CommandFactory.getCommand("C 2", canvasSheet);
    }

    @Test(expected = MalformedCommandException.class)
    public void testGetCommandForLine_WithLessParams() throws MalformedCommandException {
        CommandFactory.getCommand("L 2 3 4", canvasSheet);
    }

    @Test(expected = MalformedCommandException.class)
    public void testGetCommandForRectangle_WithLessParams() throws MalformedCommandException {
        CommandFactory.getCommand("R 2 3 4", canvasSheet);
    }

    @Test(expected = MalformedCommandException.class)
    public void testGetCommandForCreateCanvas_WithMoreParams() throws MalformedCommandException {
        CommandFactory.getCommand("C 2 3 4", canvasSheet);
    }

    @Test(expected = MalformedCommandException.class)
    public void testGetCommandForLine_WithMoreParams() throws MalformedCommandException {
        CommandFactory.getCommand("L 7 1 7 3 5", canvasSheet);
    }

    @Test(expected = MalformedCommandException.class)
    public void testGetCommandForRectangle_WithMoreParams() throws MalformedCommandException {
        CommandFactory.getCommand("R 15 2 20 5 6", canvasSheet);
    }

    @Test
    public void testGetCommandForDrawLine() throws MalformedCommandException, PrintException {
        CommandFactory.getCommand(command1, canvasSheet).execute();
        Command command = CommandFactory.getCommand(command2, canvasSheet);
        assertEquals(DrawLineCommand.class, command.getClass());
    }

    @Test(expected = MalformedCommandException.class)
    public void testGetCommandForDrawLine_CanvasNotInitialized() throws MalformedCommandException {
        CommandFactory.getCommand(command2, canvasSheet);
    }

    @Test(expected = MalformedCommandException.class)
    public void testGetCommandForDrawLine_OutOfCanvas() throws MalformedCommandException, PrintException {
        CommandFactory.getCommand(command1, canvasSheet).execute();
        CommandFactory.getCommand(improperCommand2, canvasSheet);
    }

    @Test(expected = MalformedCommandException.class)
    public void testGetCommandForDrawLine_InvalidData() throws MalformedCommandException {
        CommandFactory.getCommand(improperCommand1, canvasSheet);
    }

    @Test(expected = MalformedCommandException.class)
    public void testGetCommandForDrawLine_NotLine() throws MalformedCommandException, PrintException {
        CommandFactory.getCommand(command1, canvasSheet).execute();
        CommandFactory.getCommand(improperCommand8, canvasSheet);
    }

    @Test
    public void testGetCommandForDrawRectangle() throws MalformedCommandException, PrintException {
        CommandFactory.getCommand(command1, canvasSheet).execute();
        Command command = CommandFactory.getCommand(command4, canvasSheet);
        assertEquals(DrawRectangleCommand.class, command.getClass());
    }

    @Test(expected = MalformedCommandException.class)
    public void testGetCommandForDrawRectangle_CanvasNotInitialized() throws MalformedCommandException {
        CommandFactory.getCommand(command4, canvasSheet);
    }

    @Test(expected = MalformedCommandException.class)
    public void testGetCommandForDrawRectangle_OutOfCanvas() throws MalformedCommandException, PrintException {
        CommandFactory.getCommand(command1, canvasSheet).execute();
        CommandFactory.getCommand(improperCommand4, canvasSheet);
    }

    @Test(expected = MalformedCommandException.class)
    public void testGetCommandForDrawRectangle_InvalidData() throws MalformedCommandException {
        CommandFactory.getCommand(improperCommand6, canvasSheet);
    }

    @Test
    public void testGetCommandForQuit() throws MalformedCommandException {
        Command command = CommandFactory.getCommand("Q", canvasSheet);
        assertEquals(QuitCommand.class, command.getClass());
    }

    @Test(expected = MalformedCommandException.class)
    public void testGetCommandForInvalidCommand() throws MalformedCommandException {
        CommandFactory.getCommand(improperCommand3, canvasSheet);
    }
}