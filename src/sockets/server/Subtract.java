package sockets.server;

public class Subtract implements Command {

	@Override
	public String process(String[] args) {
		// for now we test the length of args, but we would like to have a fallback if the array is empty in class Protocol
		if (args.length == 0) {
			return "Error: No parameters given";
		}
		else {
			Double result = Double.parseDouble(args[0]);
		
		for (int i=1; i<args.length; i++) {
			result -= Double.parseDouble(args[1]);
			}
		return result.toString();
		}
		
	}
	
	//simple tests
/*	public static void main(String[] args) {
		Subtract s = new Subtract();
		System.out.println(s.process(new String[]{}));
		System.out.println(s.process(new String[]{"3", "2"}));
		System.out.println(s.process(new String[]{"10", "6", "5"}));
	}
*/
}
