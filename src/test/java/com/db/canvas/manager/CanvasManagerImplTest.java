package com.db.canvas.manager;

import com.db.canvas.exception.PrintException;
import com.db.canvas.exception.QuitException;
import com.db.canvas.manager.CanvasManagerImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CanvasManagerImplTest {

    CanvasManagerImpl canvasManager;

    private String canvasAfterCommand1 = "----------------------\n" +
                                         "|                    |\n" +
                                         "|                    |\n" +
                                         "|                    |\n" +
                                         "|                    |\n" +
                                         "|                    |\n" +
                                         "----------------------";

    private String canvasAfterCommand2 = "----------------------\n" +
                                         "|                    |\n" +
                                         "|                    |\n" +
                                         "|xxxxxxx             |\n" +
                                         "|                    |\n" +
                                         "|                    |\n" +
                                         "----------------------";

    private String canvasAfterCommand3 = "----------------------\n" +
                                         "|      x             |\n" +
                                         "|      x             |\n" +
                                         "|xxxxxxx             |\n" +
                                         "|                    |\n" +
                                         "|                    |\n" +
                                         "----------------------";

    private String canvasAfterCommand4 = "----------------------\n" +
                                         "|      x             |\n" +
                                         "|      x       xxxxxx|\n" +
                                         "|xxxxxxx       x    x|\n" +
                                         "|              x    x|\n" +
                                         "|              xxxxxx|\n" +
                                         "----------------------";

    private String command1 = "C 20 5";

    private String command2 = "L 1 3 7 3";

    private String command3 = "L 7 1 7 3";

    private String command4 = "R 15 2 20 5";

    private String improperCommand1 = "L a b 7 3";

    private String improperCommand2 = "L 10 15 40 15";

    private String improperCommand3 = "D 1 3 7 3";

    private String improperCommand4 = "R 40 40 60 60";

    private String improperCommand5 = "N 40 40 60 60";

    private String improperCommand6 = "R a b 20 5";

    private String improperCommand7 = "L 7.1 1.2 7 3";

    private String improperCommand8 = "L 2 2 20 5";

    @Before
    public void setup() {
        canvasManager = new CanvasManagerImpl();
    }

    @Test
    public void testManageWithProperCommands() throws PrintException {
        canvasManager.manage(command1);
        assertEquals(canvasAfterCommand1, canvasManager.getCanvasSheet().display());

        canvasManager.manage(command2);
        assertEquals(canvasAfterCommand2, canvasManager.getCanvasSheet().display());

        canvasManager.manage(command3);
        assertEquals(canvasAfterCommand3, canvasManager.getCanvasSheet().display());

        canvasManager.manage(command4);
        assertEquals(canvasAfterCommand4, canvasManager.getCanvasSheet().display());
    }


    @Test
    public void testManageWithImproperCommands() throws PrintException {
        canvasManager.manage(command1);
        assertEquals(canvasAfterCommand1, canvasManager.getCanvasSheet().display());

        canvasManager.manage(improperCommand1);
        assertEquals(canvasAfterCommand1, canvasManager.getCanvasSheet().display());

        canvasManager.manage(improperCommand2);
        assertEquals(canvasAfterCommand1, canvasManager.getCanvasSheet().display());

        canvasManager.manage(improperCommand3);
        assertEquals(canvasAfterCommand1, canvasManager.getCanvasSheet().display());

        canvasManager.manage(improperCommand4);
        assertEquals(canvasAfterCommand1, canvasManager.getCanvasSheet().display());

        canvasManager.manage(improperCommand5);
        assertEquals(canvasAfterCommand1, canvasManager.getCanvasSheet().display());

        canvasManager.manage(improperCommand6);
        assertEquals(canvasAfterCommand1, canvasManager.getCanvasSheet().display());

        canvasManager.manage(improperCommand7);
        assertEquals(canvasAfterCommand1, canvasManager.getCanvasSheet().display());

        canvasManager.manage(improperCommand8);
        assertEquals(canvasAfterCommand1, canvasManager.getCanvasSheet().display());
    }


    @Test(expected = QuitException.class)
    public void testManageWithQuit() {
        canvasManager.manage("Q");
    }
}