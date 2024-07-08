package java_reactive_demo.sinks.assingment;

import java.util.function.Consumer;

import lombok.Data;

@Data
public class SlackMember {
	
	private String name;
	private Consumer<String> messageConsumer;
	
	void receives(String msg) {
		System.out.println(msg);
	}

	public String getName() {
		return name;
	}
	
	public void says(String msg) {
		messageConsumer.accept(msg);
	}

	void setMessageConsumer(Consumer<String> messageConsumer) {
		this.messageConsumer = messageConsumer;
	}

	public SlackMember(String name) {
		this.name = name;
	}
	

}
