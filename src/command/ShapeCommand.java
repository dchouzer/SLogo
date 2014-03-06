package command;

import controller.Controller;

public class ShapeCommand extends ZeroParamCommand {

	public ShapeCommand() {
	}

	@Override
	public double execute() {
		return Controller.getShape();
	}

}
