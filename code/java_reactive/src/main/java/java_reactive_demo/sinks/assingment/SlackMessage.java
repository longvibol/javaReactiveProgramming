package java_reactive_demo.sinks.assingment;

import lombok.Data;

@Data
public class SlackMessage {
	
	private final String FORMART = "[%s -> %s] : %s";
	
	private String sender;
	private String receiver;
	private String message;
	
	@Override
	public String toString() {
		return String.format(FORMART, this.sender, this.receiver, this.message);
	}

}
