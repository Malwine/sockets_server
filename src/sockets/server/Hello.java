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
	
	//simple tests
/*	public static void main(String[] args) {
		Hello h = new Hello();
		System.out.println(h.process(new String[]{}));
		System.out.println(h.process(new String[]{"3", "2"}));
		System.out.println(h.process(new String[]{"10", "6", "5"}));
	}*/

}
