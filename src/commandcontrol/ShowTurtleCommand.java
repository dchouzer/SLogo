package commandcontrol;

import controller.TurtleController;

public class ShowTurtleCommand extends ZeroParamCommands {
	
	@Override
	public double execute() {
		return TurtleController.changeTurtleVisibility(1);
	}

}
