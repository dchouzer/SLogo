package command;

import controller.Controller;

public class HomeCommand extends ZeroParamCommand {

	@Override
	public double execute() {
		return Controller.setXY(0, 0);
	}

}
