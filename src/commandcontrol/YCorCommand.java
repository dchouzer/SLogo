package commandcontrol;

import controller.Controller;

public class YCorCommand extends ZeroParamCommands {

	@Override
	public double execute() {
		return Controller.ycor();
	}

}
