package command;

import java.util.List;

import controller.Controller;

public class ATanCommand extends OneParamCommand {

	public ATanCommand(Command c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double execute() {
		myAmount = myInput.execute();
		return Math.atan(myAmount);
	}

}
