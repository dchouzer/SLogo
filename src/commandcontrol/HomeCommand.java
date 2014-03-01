package commandcontrol;

import controller.Controller;

public class HomeCommand extends ZeroParamCommands {

	@Override
	public double execute() {
		return Controller.setXY(0, 0);
	}

}
