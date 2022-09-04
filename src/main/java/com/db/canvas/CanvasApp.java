package com.db.canvas;

import com.db.canvas.exception.QuitException;
import com.db.canvas.manager.CanvasManager;
import com.db.canvas.manager.CanvasManagerImpl;

import java.util.Scanner;

public class CanvasApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean keepRunning = true;
        CanvasManager manager = new CanvasManagerImpl(new CanvasSheet());

        String input;

        while (keepRunning) {
            try {
                System.out.println("Enter command: ");
                input = scanner.nextLine();

                manager.manage(input);
            } catch (QuitException qe) {
                keepRunning = false;
            }
        }
    }
}
