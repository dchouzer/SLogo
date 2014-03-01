package commandcontrol;

import java.util.List;

import controller.TurtleController;

public class ATanCommand extends OneParamCommands {

	public ATanCommand(Command c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double execute() {
		myAmount = myInput.execute();
		return TurtleController.atan(myAmount);
	}

}
