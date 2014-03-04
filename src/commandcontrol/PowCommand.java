package commandcontrol;

import java.util.List;

import controller.Controller;

public class PowCommand extends MoreThanOneParamCommands {

	public PowCommand(List<Command> l) {
		super(l);
	}

	@Override
	public double execute() {
		return Math.pow(mySubCommands.get(0).execute(), mySubCommands.get(1).execute());
	}

}
