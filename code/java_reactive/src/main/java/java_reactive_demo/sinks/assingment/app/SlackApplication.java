package java_reactive_demo.sinks.assingment.app;

import java_reactive_demo.sinks.assingment.SlackMember;
import java_reactive_demo.sinks.assingment.SlackRoom;

public class SlackApplication {
	
	public static void main(String[] args) {
		SlackRoom room = new SlackRoom("Java Reactive Class");
		
		
		// member in group 
		SlackMember dara = new SlackMember("Dara");
		SlackMember rith = new SlackMember("Rith");
		SlackMember thida = new SlackMember("Thida");
		
		
		// 
		room.joinRoom(dara);
		room.joinRoom(rith);
		
		dara.says("Hello Everyone!");		
		rith.says("Hi guys");
		
		
		room.joinRoom(thida);
		
		dara.says("YES");
		
		thida.says("Love you");
		
		
	}

}
