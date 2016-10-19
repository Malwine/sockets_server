package sockets.server;

public interface Command {
	
	// Override this method in all command classes that implement the interface 
	// by selecting in the menu "Source" -> "Override/Implement Methods"
	// TODO Create classes that implement "Command": Multiply, Subtract and Hello
	
	public default String process(String[] args) {
		return null;
	}
}
