package com.cs.consoledrawing.command;

import com.cs.consoledrawing.exception.InvalidInputException;
import com.cs.consoledrawing.model.Canvas;

import java.util.Stack;

/**
 * Not used for now, planning to use it for undo/redo
 */
public class DrawingProcessor {
    private Canvas canvas;
    private Stack<Canvas> doneStack;
    private Stack<Canvas> undoneStack;

    public DrawingProcessor() {
        canvas = new Canvas();
        doneStack = new Stack<>();
        undoneStack = new Stack<>();
    }

    public Canvas getCanvas() {
        return doneStack.peek();
    }

    public void executeCommand(Command command) throws InvalidInputException {

        if (canvas.getWidth() == 0 && !(command instanceof CreateCanvasCommand))
            throw new InvalidInputException("Please create a canvas first");

        // make a clone of the canvas
        Canvas newCanvas = new Canvas(canvas);
        command.execute(newCanvas);
        doneStack.add(newCanvas);
        this.canvas = newCanvas;

        // Executing a command triggers the clearing of the redo stack. After executing a command,
        // it may no longer make sense to redo a command that was previously undone.
        // This mirrors how a user expects redo behavior to work and avoids otherwise confusing behavior.
        undoneStack.clear();

    }

    public void undoLastCmd() {
        if (doneStack.isEmpty()) return;
        Canvas previousImage = doneStack.pop();
        undoneStack.push(previousImage);
        this.canvas = previousImage;
    }

    public void redoLastUndone() {
        if (undoneStack.isEmpty()) return;
        Canvas previousImage = undoneStack.pop();
        doneStack.push(previousImage);
        this.canvas = previousImage;
    }

}
