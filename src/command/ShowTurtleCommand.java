package command;

import controller.Controller;

public class ShowTurtleCommand extends ZeroParamCommand {
	
	@Override
	public double execute() {
		return Controller.changeTurtleVisibility(1);
	}

}
