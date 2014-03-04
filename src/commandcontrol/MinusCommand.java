package commandcontrol;

import controller.Controller;

public class MinusCommand extends OneParamCommands {

	public MinusCommand(Command c) {
		super(c);
	}

	@Override
	public double execute() {
		myAmount = myInput.execute();
		return -(myAmount);
	}

}
