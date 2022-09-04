package com.db.canvas.printer;

import com.db.canvas.CanvasSheet;
import com.db.canvas.exception.PrintException;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RectanglePrinterTest {

    private Printer printer;

    private Pair<Integer, Integer> p1;
    private Pair<Integer, Integer> p2;

    private String canvasAfterRectangleCommand = "----------------------\n" +
                                                "|                    |\n" +
                                                "|              xxxxxx|\n" +
                                                "|              x    x|\n" +
                                                "|              x    x|\n" +
                                                "|              xxxxxx|\n" +
                                                "----------------------";

    @Before
    public void setUp() {
        p1 = new ImmutablePair<>(15, 2);
        p2 = new ImmutablePair<>(20, 5);
        printer = new RectanglePrinter(p1, p2);
    }

    @Test(expected = PrintException.class)
    public void testPrint_WhenCanvasIsNull() throws PrintException {
        printer.print(null);
    }

    @Test(expected = PrintException.class)
    public void testPrint_WhenCanvasNotInitialized() throws PrintException {
        printer.print(new CanvasSheet());
    }

    @Test
    public void testPrint() throws PrintException {
        CanvasSheet sheet = new CanvasSheet();
        sheet.initialize(20, 5);
        printer.print(sheet);

        assertEquals(canvasAfterRectangleCommand, sheet.display());
    }
}