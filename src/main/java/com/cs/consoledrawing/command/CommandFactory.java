package com.cs.consoledrawing.command;

import com.cs.consoledrawing.exception.InvalidInputException;

public class CommandFactory {

    //there is no strict right or wrong... but i wouldn't create one command object per input. 
    // i would simply create four command objects for the entire application lifecycle.
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
