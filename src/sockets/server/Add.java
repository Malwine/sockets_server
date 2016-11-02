package sockets.server;

public class Add implements Command {

	@Override
	public String process(String[] args) {
		
		Double sum = 0.0;
		
		for(int i = 0; i < args.length; i++) {
			sum += Double.valueOf(args[i]);
		}
		return sum.toString();
	}

}
