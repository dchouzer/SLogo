package commandcontrol;

public class PenDownCommand extends ZeroParamCommands {
	
	public PenDownCommand(){
	}
	
	@Override
	public int execute() {
		//change pen status to down
		return 0;
	}

}
