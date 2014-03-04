package command;
import java.util.List;

public class SetXYCommand extends MoreThanOneParamCommand{

	public SetXYCommand(List<Command> l) {
		super(l);
	}

	@Override
	public double execute() {
		return 0.0;
	}

}
