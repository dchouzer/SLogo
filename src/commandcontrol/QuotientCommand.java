package commandcontrol;

import java.util.List;

import controller.Controller;

public class QuotientCommand extends MoreThanOneParamCommands {

	public QuotientCommand(List<Command> l) {
		super(l);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double execute() {
		return mySubCommands.get(0).execute()/mySubCommands.get(1).execute();
	}

}
