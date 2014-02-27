package commandcontrol;

import controller.Controller;

public class ClearScreenCommand extends ZeroParamCommands {

	@Override
	public double execute() {
		Controller.clearScreen();
		return Controller.setXY(0, 0);
	}

}
