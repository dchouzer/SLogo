package commandcontrol;

import controller.Controller;

public class XCorCommand extends ZeroParamCommands {

	@Override
	public double execute() {
		return Controller.xcor();
	}

}
