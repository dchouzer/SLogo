package commandcontrol;

import java.util.List;

import controller.Controller;

public class CosCommand extends OneParamCommands {

	public CosCommand(Command c) {
		super(c);
	}

	@Override
	public double execute() {
		myAmount = myInput.execute();
		return Math.cos(myAmount);
	}

}
