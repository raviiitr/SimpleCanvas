package com.db.canvas.manager;

import com.db.canvas.CanvasSheet;
import com.db.canvas.exception.PrintException;
import com.db.canvas.exception.QuitException;
import com.db.canvas.manager.CanvasManagerImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CanvasManagerImplTest {

    private CanvasManagerImpl canvasManager;

    private CanvasSheet canvasSheet;

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

    private String canvasAfterCommand5 = "----------------------\n" +
                                         "|      x             |\n" +
                                         "|      x       xxxxxx|\n" +
                                         "|xxxxxxx       x    x|\n" +
                                         "|   x          x    x|\n" +
                                         "|              xxxxxx|\n" +
                                         "----------------------";

    private String canvasAfterCommand6 = "----------------------\n" +
                                         "|      x             |\n" +
                                         "| x    x       xxxxxx|\n" +
                                         "|xxxxxxx       x    x|\n" +
                                         "|   x          x    x|\n" +
                                         "|              xxxxxx|\n" +
                                         "----------------------";

    private String command1 = "C 20 5";

    private String command2 = "L 1 3 7 3";

    private String command3 = "L 7 1 7 3";

    private String command4 = "R 15 2 20 5";

    private String command5 = "L 4 4 4 4";

    private String command6= "R 2 2 2 2";

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
        canvasSheet = new CanvasSheet();
        canvasManager = new CanvasManagerImpl(canvasSheet);
    }

    @Test
    public void testManageWithProperCommands() throws PrintException {
        canvasManager.manage(command1);
        assertEquals(canvasAfterCommand1, canvasSheet.display());

        canvasManager.manage(command2);
        assertEquals(canvasAfterCommand2, canvasSheet.display());

        canvasManager.manage(command3);
        assertEquals(canvasAfterCommand3, canvasSheet.display());

        canvasManager.manage(command4);
        assertEquals(canvasAfterCommand4, canvasSheet.display());

        canvasManager.manage(command5);
        assertEquals(canvasAfterCommand5, canvasSheet.display());

        canvasManager.manage(command6);
        assertEquals(canvasAfterCommand6, canvasSheet.display());
    }


    @Test
    public void testManageWithImproperCommands() throws PrintException {
        canvasManager.manage(command1);
        assertEquals(canvasAfterCommand1, canvasSheet.display());

        canvasManager.manage(improperCommand1);
        assertEquals(canvasAfterCommand1, canvasSheet.display());

        canvasManager.manage(improperCommand2);
        assertEquals(canvasAfterCommand1, canvasSheet.display());

        canvasManager.manage(improperCommand3);
        assertEquals(canvasAfterCommand1, canvasSheet.display());

        canvasManager.manage(improperCommand4);
        assertEquals(canvasAfterCommand1, canvasSheet.display());

        canvasManager.manage(improperCommand5);
        assertEquals(canvasAfterCommand1, canvasSheet.display());

        canvasManager.manage(improperCommand6);
        assertEquals(canvasAfterCommand1, canvasSheet.display());

        canvasManager.manage(improperCommand7);
        assertEquals(canvasAfterCommand1, canvasSheet.display());

        canvasManager.manage(improperCommand8);
        assertEquals(canvasAfterCommand1, canvasSheet.display());
    }


    @Test(expected = QuitException.class)
    public void testManageWithQuit() {
        canvasManager.manage("Q");
    }
}