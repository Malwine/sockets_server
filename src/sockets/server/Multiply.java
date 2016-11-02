package sockets.server;

public class Multiply implements Command {

	@Override
	public String process(String[] args) {
		Double product = 1.0;
		
		for (int i=0; i<args.length; i++) {
			product = product * Double.parseDouble(args[i]);
		}
		return product.toString();
	}

}
