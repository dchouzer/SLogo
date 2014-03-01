package commandcontrol;

import java.util.List;

import controller.TurtleController;

public class DifferenceCommand extends MoreThanOneParamCommand {

	public DifferenceCommand(List<Command> l) {
		super(l);
	}

	@Override
	public double execute() {
		return TurtleController.sum(mySubCommands.get(0).execute(), -(mySubCommands.get(1).execute()));
	}

}
