package sockets.server;

import java.util.Arrays;

public class Protocol {
	
	public String process(String message) {

		//All parts of the message get split by whitespace and saved in an array
		String[] messageParts = message.split(" ");
		
		//First element is the command
		String command = messageParts[0].toLowerCase();
		//All leftover elements are parameters to the command
		String[] parameters = Arrays.copyOfRange(messageParts, 1, messageParts.length);
		
		//Below I do a check for string "add". 
		// TODO Instead of the if we ideally want to use a list of commands and check for them.
		
		if (command.equals("add")) {
			Add addition = new Add();
			String result = addition.process(parameters);
			return "Result of Add is: " + result;
		}
		return "The given input starts with: " + messageParts[0];
	}
}
