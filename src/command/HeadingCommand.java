package command;

import controller.Controller;

public class HeadingCommand extends ZeroParamCommand {
	
	@Override
	public double execute() {
		return Controller.getHeading();
	}

}
