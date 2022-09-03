package com.db.canvas.printer;

import com.db.canvas.CanvasSheet;
import com.db.canvas.exception.PrintException;

public interface Printer {

    void print(CanvasSheet canvasSheet) throws PrintException;
}
