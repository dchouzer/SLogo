package commandcontrol;

import java.util.List;

public class SetXYCommand extends MoreThanOneParamCommands{

	public SetXYCommand(List<Command> l) {
		super(l);
	}

	@Override
	public double execute() {
		return 0.0;
	}

}
