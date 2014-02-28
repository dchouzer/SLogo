package commandcontrol;

import java.util.List;

import controller.TurtleController;

public class QuotientCommand extends MoreThanOneParamCommand {

	public QuotientCommand(List<Command> l) {
		super(l);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double execute() {
		return TurtleController.multiply(mySubCommands.get(0).execute(), 1.0/mySubCommands.get(1).execute());
	}

}
