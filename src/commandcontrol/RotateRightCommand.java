package commandcontrol;

import java.util.List;

public class RotateRightCommand extends OneParamCommands{

	public RotateRightCommand(List<Command> l) {
		super(l);
	}

	@Override
	public int execute() {
		return 0;
	}
	
}