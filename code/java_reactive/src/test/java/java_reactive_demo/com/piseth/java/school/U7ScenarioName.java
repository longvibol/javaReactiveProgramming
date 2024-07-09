package java_reactive_demo.com.piseth.java.school;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class U7ScenarioName {
	
	private Flux<Integer> getItems(){
		return Flux.range(1, 5)
				.delayElements(Duration.ofSeconds(10));
	}
	
	@Test
	public void testFlux() { // test real time with i/o from Database 
		//StepVerifier.withVirtualTime(()-> getItems())
		StepVerifier.withVirtualTime(this::getItems)
			.thenAwait(Duration.ofSeconds(50))
			.expectNext(1,2,3,4,5)
			.expectComplete()
			.verify();
	}
	
	@Test
	public void testFlux1() { // test no event before tiem we set   
		StepVerifier.withVirtualTime(this::getItems)
			.expectSubscription() // before 9 secone it automatic have subscription : Explecet Do it manualy 
			.expectNoEvent(Duration.ofSeconds(9))
			.thenAwait(Duration.ofSeconds(51))
			.expectNext(1,2,3,4,5)
			.expectComplete()
			.verify();
	}
	
	@Test
	public void testFlux2() { // test no event before tiem we set   
		StepVerifier.withVirtualTime(this::getItems)
			.expectSubscription() 
			.expectNoEvent(Duration.ofSeconds(9))
			.thenAwait(Duration.ofSeconds(20))
			.expectNext(1,2)
			.thenAwait(Duration.ofSeconds(30))
			.expectNext(3,4,5)
			.expectComplete()
			.verify();
	}
	
	
	
	
	
	
	
	
	
	
	
}














