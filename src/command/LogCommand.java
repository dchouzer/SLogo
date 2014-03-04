package command;

import java.util.List;

import controller.Controller;

public class LogCommand extends OneParamCommand {

	public LogCommand(Command c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double execute() {
		myAmount = myInput.execute();
		return Math.log(myAmount);
	}

}
