package command;

import controller.Controller;

public class XCorCommand extends ZeroParamCommand {

	@Override
	public double execute() {
		return Controller.xcor();
	}

}
