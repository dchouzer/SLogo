package command;

import java.util.List;

import controller.Controller;

public class TanCommand extends OneParamCommand {

	public TanCommand(Command c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double execute() {
		myAmount = myInput.execute();
		return Math.tan(myAmount);
	}

}
