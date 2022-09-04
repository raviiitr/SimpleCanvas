package com.db.canvas;

import com.db.canvas.exception.PrintException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CanvasSheetTest {

    private String canvasAfterCommand1 = "----------------------\n" +
                                        "|                    |\n" +
                                        "|                    |\n" +
                                        "|                    |\n" +
                                        "|                    |\n" +
                                        "|                    |\n" +
                                        "----------------------";

    private String canvasAfterPointIsSet = "----------------------\n" +
                                            "|x                   |\n" +
                                            "|                    |\n" +
                                            "|                    |\n" +
                                            "|                    |\n" +
                                            "|                    |\n" +
                                            "----------------------";

    private CanvasSheet canvasSheet;
    @Before
    public void setUp() {
        canvasSheet = new CanvasSheet();
    }

    @Test
    public void testInitialize() throws PrintException {
        canvasSheet.initialize(20, 5);
        assertTrue(canvasSheet.isInitialized());
        assertEquals(20, canvasSheet.getWidth());
        assertEquals(5, canvasSheet.getHeight());
        assertEquals(canvasAfterCommand1, canvasSheet.display());
    }

    @Test(expected = PrintException.class)
    public void testSetContentFail_WhenCanvasNotInitialized() throws PrintException {
        canvasSheet.setContent(4, 4);
    }

    @Test(expected = PrintException.class)
    public void testSetContentFail_WhenPointOutsideCanvas() throws PrintException {
        canvasSheet.initialize(2, 2);
        canvasSheet.setContent(4, 4);
    }

    @Test
    public void testSetContent() throws PrintException {
        canvasSheet.initialize(20, 5);
        canvasSheet.setContent(1, 1);
        assertEquals(canvasAfterPointIsSet, canvasSheet.display());
    }

    @Test(expected = PrintException.class)
    public void testDisplay_WhenCanvasNotInitialized() throws PrintException {
        canvasSheet.display();
    }


}