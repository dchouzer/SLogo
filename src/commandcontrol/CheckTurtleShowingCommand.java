package commandcontrol;

import controller.Controller;

public class CheckTurtleShowingCommand extends ZeroParamCommands {

	public CheckTurtleShowingCommand() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double execute() {
		return Controller.getTurtleVisibility();
	}

}
