

package com.db.canvas;

import com.db.canvas.exception.PrintException;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;

import static com.db.canvas.constants.CanvasConstants.*;

@NoArgsConstructor
public class CanvasSheet {

    private char[][] content;

    @Getter
    private int width = 0;

    @Getter
    private int height = 0;

    @Getter
    private boolean isInitialized;

    public void initialize(int width, int height){
        this.width = width;
        this.height = height;

        content = new char[height][width];

        for(int i = 0; i < height; i++)
            Arrays.fill(content[i], DELIMITER_CHAR);

        isInitialized = true;
    }

    public void setContent(int x, int y) throws PrintException {
        if(content == null)
            throw new PrintException("Canvas not initialized");


        if (x>width || y>height || x<1 || y<1) {
            throw new PrintException("The point lies beyond the Canvas");
        }

        this.content[y-1][x-1] = PRINT_CHAR;
    }

    public String display() throws PrintException {

        if(content == null)
            throw new PrintException("Canvas not initialized");

        StringBuilder builder = new StringBuilder();

        for (int i=0; i<(this.width+2); i++) {
            builder.append(HORIZONTAL_LINE_CHAR);
        }

        builder.append("\n");

        for (int i=0; i<content.length; i++) {
            builder.append(VERTICAL_LINE_CHAR);
            builder.append(String.valueOf(content[i]));
            builder.append(VERTICAL_LINE_CHAR);
            builder.append("\n");
        }

        for (int i=0; i<(this.width+2); i++) {
            builder.append(HORIZONTAL_LINE_CHAR);
        }

        return builder.toString();
    }
}
