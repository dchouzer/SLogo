package commandcontrol;

public class NotCommand extends OneParamCommands {

	public NotCommand(Command c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double execute() {
		myAmount = myInput.execute();
		return (myAmount == 0)? 1 : 0;
	}

}
