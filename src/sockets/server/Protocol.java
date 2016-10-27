package sockets.server;

import java.util.Arrays;
import java.util.HashMap;

public class Protocol {
	
	public String process(String message) {
		
		// TODO Look up how the conventions are around Constants in Java, maybe use an Enum?
		final HashMap<String, Command> COMMANDS_MAP = new HashMap<String, Command>();
		COMMANDS_MAP.put("add", new Add());
		COMMANDS_MAP.put("hello", new Hello());
		COMMANDS_MAP.put("subtract", new Subtract());
		COMMANDS_MAP.put("multiply", new Multiply());

		//All parts of the message get split by whitespace and saved in an array
		String[] messageParts = message.split(" ");
		
		//First element is the command
		String command = messageParts[0].toLowerCase();
		//All leftover elements are parameters to the command
		String[] parameters = Arrays.copyOfRange(messageParts, 1, messageParts.length);
		
		//Here we look up the command in the list of commands
		// TODO Create a fallback if the command is not in the list and/or there are no parameters
		Command specificCommand = COMMANDS_MAP.get(command);
		String result = specificCommand.process(parameters);
		return "Result of " + command + " is: " + result;
	}
}
