package commandcontrol;

public class PenUpCommand extends ZeroParamCommands {

	public PenUpCommand() {

	}

	@Override
	public double execute() {
		//Change pen status to up
		return 1.0;
	}

}
