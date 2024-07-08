package java_reactive_demo.sinks.assingment;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class SlackRoom {
	
	/*
	 * 1. Slack Room : (joinRoom(), groupName, 
	 * 2. Sinks (we want to get : sender and receiver msg),  PARAMETER : SlackMessge (Sinks.Many = Many is inside Sink) 
	 * 3. Flux of message in group- to member can subsribe), PARAMETER : SLackMessage

	 */
	
	private String name; // refer to group name 
	private Sinks.Many<SlackMessage> sink; // for publish the message : emit the message 
	private Flux<SlackMessage> flux; // for subsriber 
	
	
	// Function : Create group and feature what they can do inside the group 
	public SlackRoom(String name) {
		this.name=name;
		this.sink = Sinks.many().replay().all(); // for the new subsriber can see the history (publisher)
		this.flux = sink.asFlux(); // // flux = register to group (subsriber) 
	}
	
	
	public void joinRoom(SlackMember slackMember) {
		System.out.println(slackMember.getName() + "------ Joined ------ " + name);
		subsribes(slackMember); // when someone join room they need to subcriber functin 
		
		/*
		slackMember.setMessageConsumer(msg ->{
			postMessage(msg, slackMember);
		});
		*/
		slackMember.setMessageConsumer(msg -> postMessage(msg, slackMember));// this mean Member they can say when they want 
		
	}
	
	// function to see who is post and what they post about something 	
	public void postMessage(String msg, SlackMember slackMember) {
		SlackMessage slackMessage = new SlackMessage();
		slackMessage.setSender(slackMember.getName()); // msg Sender = Meber in group 
		slackMessage.setMessage(msg); // msg " what they say" = member in group messae 		
		this.sink.tryEmitNext(slackMessage); // Inside the group will Publish to each member = emit when they post 
	}
	
	//Function: to create subscrib of the member 
	 private void subsribes(SlackMember slackMember) {
		
		 // this.flux mean (flux of SlackMessage)sm
		 
		 this.flux // flux where we create subscriber then to show in each device (create print) 
		 	.filter(sm -> !sm.getSender().equals(slackMember.getName())) // we should filter by ID 
		 	.doOnNext(sm ->sm.setReceiver(slackMember.getName())) // we set the recevier 
		 	//.map(sm -> sm.toString()) // we want to get the Fromate as we set " Sender -> receiver and msg " 
		 	.map(SlackMessage::toString)
		 	
		 	//.subscribe(sm -> slackMember.receives(sm.getMessage()));	 	
		 	.subscribe(slackMember::receives); //style method refere
	 }
	

}















