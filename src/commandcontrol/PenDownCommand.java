package commandcontrol;

public class PenDownCommand extends ZeroParamCommands {
	
	public PenDownCommand(){
	}
	
	@Override
	public double execute() {
		//change pen status to down
		return 0.0;
	}

}
