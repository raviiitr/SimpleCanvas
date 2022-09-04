package com.db.canvas.printer;

import com.db.canvas.CanvasSheet;
import com.db.canvas.exception.PrintException;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinePrinterTest {

    private Printer printer;

    private Pair<Integer, Integer> p1;
    private Pair<Integer, Integer> p2;

    private String canvasAfterLineCommand = "----------------------\n" +
                                            "|      x             |\n" +
                                            "|      x             |\n" +
                                            "|      x             |\n" +
                                            "|                    |\n" +
                                            "|                    |\n" +
                                            "----------------------";

    private String horizontalLine = "----------------------\n" +
                                    "|                    |\n" +
                                    "|xxxx                |\n" +
                                    "|                    |\n" +
                                    "|                    |\n" +
                                    "|                    |\n" +
                                    "----------------------";

    @Before
    public void setUp()  {
        p1 = new ImmutablePair<>(7, 1);
        p2 = new ImmutablePair<>(7, 3);
        printer = new LinePrinter(p1, p2);
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
    public void testPrintVerticalLine() throws PrintException {
        CanvasSheet sheet = new CanvasSheet();
        sheet.initialize(20, 5);
        printer.print(sheet);

        assertEquals(canvasAfterLineCommand, sheet.display());
    }

    @Test
    public void testPrintHorizontalLine() throws PrintException {
        CanvasSheet sheet = new CanvasSheet();
        sheet.initialize(20, 5);
        printer = new LinePrinter(new ImmutablePair<>(1,2 ), new ImmutablePair<>(4,2));
        printer.print(sheet);

        assertEquals(horizontalLine, sheet.display());
    }


}