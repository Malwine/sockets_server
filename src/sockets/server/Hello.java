package sockets.server;

public class Hello implements Command {

	@Override
	public String process(String[] args) {
		if (args.length == 0) {
			return "Hello World!";
		}
		else {
			return "Hello " + args[0] + "!";
		}
	}
}
