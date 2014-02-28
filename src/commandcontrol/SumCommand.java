package commandcontrol;

import java.util.List;

import controller.TurtleController;

public class SumCommand extends MoreThanOneParamCommand {

	public SumCommand(List<Command> l) {
		super(l);
	}

	@Override
	public double execute() {
		return TurtleController.sum(mySubCommands.get(0).execute(), mySubCommands.get(1).execute());
	}

}
