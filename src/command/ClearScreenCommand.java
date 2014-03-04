package command;

import controller.Controller;

public class ClearScreenCommand extends ZeroParamCommand {

	@Override
	public double execute() {
		Controller.clearScreen();
		return Controller.setXY(0, 0);
	}

}
