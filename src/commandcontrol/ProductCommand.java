package commandcontrol;

import java.util.List;

import controller.TurtleController;

public class ProductCommand extends MoreThanOneParamCommand {

	public ProductCommand(List<Command> l) {
		super(l);
	}

	@Override
	public double execute() {
		return TurtleController.multiply(mySubCommands.get(0).execute(), mySubCommands.get(1).execute());
	}

}
