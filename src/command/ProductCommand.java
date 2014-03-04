package command;

import java.util.List;

import controller.Controller;

public class ProductCommand extends MoreThanOneParamCommand {

	public ProductCommand(List<Command> l) {
		super(l);
	}

	@Override
	public double execute() {
		return Controller.multiply(mySubCommands.get(0).execute(), mySubCommands.get(1).execute());
	}

}
