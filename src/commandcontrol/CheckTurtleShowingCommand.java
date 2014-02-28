package commandcontrol;

import controller.TurtleController;

public class CheckTurtleShowingCommand extends ZeroParamCommands {

	public CheckTurtleShowingCommand() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double execute() {
		return TurtleController.getTurtleVisibility();
	}

}
