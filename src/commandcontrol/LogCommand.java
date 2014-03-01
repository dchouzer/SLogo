package commandcontrol;

import java.util.List;

import controller.TurtleController;

public class LogCommand extends OneParamCommands {

	public LogCommand(Command c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double execute() {
		myAmount = myInput.execute();
		return TurtleController.log(myAmount);
	}

}
