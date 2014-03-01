package commandcontrol;

import controller.Controller;

public class ShowTurtleCommand extends ZeroParamCommands {
	
	@Override
	public double execute() {
		return Controller.changeTurtleVisibility(1);
	}

}
