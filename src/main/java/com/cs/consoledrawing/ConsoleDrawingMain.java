package com.cs.consoledrawing;

import com.cs.consoledrawing.command.*;
import com.cs.consoledrawing.exception.InvalidInputException;
import com.cs.consoledrawing.model.CanvasRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Scanner;

public class ConsoleDrawingMain {
    private static final Logger Log = LoggerFactory.getLogger(ConsoleDrawingMain.class);

    public static void main(String[] args) {
        DrawingProcessor drawingProcessor = new DrawingProcessor();

        boolean exited = false;
        printMenu();
        Scanner console = new Scanner(System.in);

        while(!exited){
            System.out.print("Enter command: ");
            //break down this method... easiest way would be to move codes insisde this while loop out
            String userInput = console.nextLine().trim();

            if(!userInput.equals("")){
                String[] input = userInput.split(" ");
                String commandKey = input[0].toUpperCase();
                String[] inputArgs = Arrays.copyOfRange( input, 1, input.length );

                try {

                    switch(commandKey){
                        // control flow command
                        case "U":
                            drawingProcessor.undoLastCmd();
                            break;

                        case "RE":
                            drawingProcessor.redoLastUndone();
                            break;

                        case "Q":
                            System.out.println("Bye !");
                            exited = true;
                            continue;

                        default:
                            // drawing commmand
                            Command command = CommandFactory.createCommand(commandKey, inputArgs);
                            drawingProcessor.executeCommand(command);
                    }

                    CanvasRenderer.render(drawingProcessor.getCanvas());//better not static method

                } catch (InvalidInputException e) {
                    //do you have to show something to user?
                    log.error(e.getMessage());
                }
            }
        }
    }

    private static void printMenu() {
        System.out.println("*********************************************");
        System.out.println("*                                           *");
        System.out.println("*   0) C w h          to create a convas    *");
        System.out.println("*   1) L x1 y1 x2 y2  to create a line      *");
        System.out.println("*   2) R x1 y1 x2 y2  to create a rectangle *");
        System.out.println("*   3) B x1 y1 color  to refill             *");
        System.out.println("*   4) U              to undo               *");
        System.out.println("*   5) RE             to redo               *");
        System.out.println("*   4) Q              to Exit               *");
        System.out.println("*                                           *");
        System.out.println("******************************************");
    }

}
