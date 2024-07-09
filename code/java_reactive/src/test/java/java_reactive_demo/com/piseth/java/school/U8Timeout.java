package java_reactive_demo.com.piseth.java.school;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.test.StepVerifierOptions;

public class U8Timeout {
	
	private Flux<Integer> getItems(){
		return Flux.range(1, 5).delayElements(Duration.ofMillis(200));
		// it have 5 item = 1000 millisecond 
	}
	
	// want to do report but can not longer then 1 second --> it it happend we need to change our qurey 
	
	@Test
	public void testFlux() { 		
		StepVerifier.create(getItems())
			.expectNext(1,2,3,4,5)
			.expectComplete()
			.verify(Duration.ofMillis(500)); // where we find the delay time not bigger than 500
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}














