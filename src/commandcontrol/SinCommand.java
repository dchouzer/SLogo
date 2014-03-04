package commandcontrol;

import java.util.List;

import controller.Controller;

public class SinCommand extends OneParamCommands {

	public SinCommand(Command c) {
		super(c);
	}

	@Override
	public double execute() {
		myAmount = myInput.execute();
		return Math.sin(myAmount);
	}

}
