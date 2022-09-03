package com.db.canvas.printer;

import com.db.canvas.CanvasSheet;
import com.db.canvas.exception.PrintException;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

@AllArgsConstructor
public class RectanglePrinter implements Printer {

    private Pair<Integer, Integer> p1;

    private Pair<Integer, Integer> p3;

    @Override
    public void print(CanvasSheet canvasSheet) throws PrintException {
        if(canvasSheet == null)
            throw new PrintException("Canvas not initialized");

        Pair<Integer, Integer> p2 = new ImmutablePair<>(p1.getLeft(), p3.getRight());
        Pair<Integer, Integer> p4 = new ImmutablePair<>(p3.getLeft(), p1.getRight());

        Printer l1 = new LinePrinter(p1, p2);
        Printer l2 = new LinePrinter(p2, p3);
        Printer l3 = new LinePrinter(p3, p4);
        Printer l4 = new LinePrinter(p4, p1);

        l1.print(canvasSheet);
        l2.print(canvasSheet);
        l3.print(canvasSheet);
        l4.print(canvasSheet);

    }
}
