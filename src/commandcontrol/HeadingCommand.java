package commandcontrol;

import controller.Controller;

public class HeadingCommand extends ZeroParamCommands {
	
	@Override
	public double execute() {
		return Controller.getHeading();
	}

}
