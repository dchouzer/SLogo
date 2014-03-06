package command;

import controller.Controller;

public class PenColorCommand extends ZeroParamCommand {

	public PenColorCommand() {
	}

	@Override
	public double execute() {
		return Controller.getPenColor();
	}

}
