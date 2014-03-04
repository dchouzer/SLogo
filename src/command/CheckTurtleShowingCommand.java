package command;

import controller.Controller;

public class CheckTurtleShowingCommand extends ZeroParamCommand {

	public CheckTurtleShowingCommand() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double execute() {
		return Controller.getTurtleVisibility();
	}

}
