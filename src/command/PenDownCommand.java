package command;

import controller.Controller;

public class PenDownCommand extends ZeroParamCommand {

	@Override
	public double execute() {
		return Controller.changePenVisibility(1);
	}

}
