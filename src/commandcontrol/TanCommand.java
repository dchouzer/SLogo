package commandcontrol;

import java.util.List;

import controller.TurtleController;

public class TanCommand extends OneParamCommands {

	public TanCommand(Command c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double execute() {
		myAmount = myInput.execute();
		return TurtleController.tan(myAmount);
	}

}
