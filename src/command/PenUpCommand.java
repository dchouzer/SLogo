package command;

import controller.Controller;

public class PenUpCommand extends ZeroParamCommand {

	@Override
	public double execute() {
		return Controller.changePenVisibility(0);
	}

}
