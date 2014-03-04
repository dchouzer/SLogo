package command;

public class NotCommand extends OneParamCommand {

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
