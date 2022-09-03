package com.db.canvas.printer;

import com.db.canvas.CanvasSheet;
import com.db.canvas.exception.PrintException;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;

@AllArgsConstructor
public class LinePrinter implements Printer {

    private Pair<Integer, Integer> p1;

    private Pair<Integer, Integer> p2;

    @Override
    public void print(CanvasSheet canvasSheet) throws PrintException {
        if(canvasSheet == null)
            throw new PrintException("Canvas not initialized");

        int xLength = p2.getLeft() - p1.getLeft();
        int yLength = p2.getRight() - p1.getRight();

        if (xLength != 0) {
            if(xLength>0) {
                for (int i = this.p1.getLeft(); i <= this.p2.getLeft(); i++) {
                    canvasSheet.setContent(i, this.p1.getRight());
                }
            } else {
                for (int i = this.p1.getLeft(); i >= this.p2.getLeft(); i--) {
                    canvasSheet.setContent(i, this.p1.getRight());
                }
            }
        } else {
            if(yLength>0) {
                for (int i = this.p1.getRight(); i <= this.p2.getRight(); i++) {
                    canvasSheet.setContent(this.p1.getLeft(), i);
                }
            } else {
                for (int i = this.p1.getRight(); i >= this.p2.getRight(); i--) {
                    canvasSheet.setContent(this.p1.getLeft(), i);
                }
            }
        }

    }
}
