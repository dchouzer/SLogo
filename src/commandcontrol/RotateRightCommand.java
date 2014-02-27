package commandcontrol;

import java.util.List;

public class RotateRightCommand extends OneParamCommands{

	public RotateRightCommand(List<Command> l) {
		super(l);
	}

	@Override
	public double execute() {
		return 0.0;
	}
	
}