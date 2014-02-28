package commandcontrol;

import java.util.List;

import controller.TurtleController;

public class PowCommand extends MoreThanOneParamCommand {

	public PowCommand(List<Command> l) {
		super(null);
	}

	@Override
	public double execute() {
		return TurtleController.pow(mySubCommands.get(0).execute(), mySubCommands.get(1).execute());
	}

}
