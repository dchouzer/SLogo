package command;

import controller.Controller;

public class YCorCommand extends ZeroParamCommand {

	@Override
	public double execute() {
		return Controller.ycor();
	}

}
