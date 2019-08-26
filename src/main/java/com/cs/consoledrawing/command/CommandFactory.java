package com.cs.consoledrawing.command;

import com.cs.consoledrawing.exception.InvalidInputException;

public class CommandFactory {

    public static Command createCommand(String commandKey, String[] args) throws InvalidInputException {
        Command command = null;

        switch(commandKey){
            case "C":
                command = new CreateCanvasCommand(args);
                break;

            case "L":
                command = new DrawLineCommand(args);
                break;

            case "R":
                command = new DrawRectangleCommand(args);
                break;

            case "B":
                command = new BucketFillCommand(args);
                break;

            default:
                break;
        }

        return command;
    }
}
