package commandcontrol;

import controller.TurtleController;

public class MinusCommand extends OneParamCommands {

	public MinusCommand(Command c) {
		super(c);
	}

	@Override
	public double execute() {
		myAmount = myInput.execute();
		return TurtleController.setNegativeNumbers(myAmount);
	}

}
