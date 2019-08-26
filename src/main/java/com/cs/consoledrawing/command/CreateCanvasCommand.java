package com.cs.consoledrawing.command;

import com.cs.consoledrawing.exception.InvalidInputException;
import com.cs.consoledrawing.model.Canvas;

public class CreateCanvasCommand implements Command {

    private int width;
    private int height;

    public CreateCanvasCommand(String[] args) throws InvalidInputException {
        // request validation
        if (args.length != 2)
        {
            throw new InvalidInputException("Number of parameter not 2.");
        }

        this.width = Integer.parseInt(args[0]);
        this.height = Integer.parseInt(args[1]);

        validateInput(this.width, this.height);
    }

    private void validateInput(int width, int height) throws InvalidInputException {
        if (width < 1 || height < 1 )
            throw new InvalidInputException("Width and height must be greater than 0");
    }


    @Override
    public void execute(Canvas canvas) {
        canvas.setCanvas(new Canvas(this.width, this.height));
    }
}
