package command;

import controller.Controller;

public class MinusCommand extends OneParamCommand {

	public MinusCommand(Command c) {
		super(c);
	}

	@Override
	public double execute() {
		myAmount = myInput.execute();
		return -(myAmount);
	}

}
