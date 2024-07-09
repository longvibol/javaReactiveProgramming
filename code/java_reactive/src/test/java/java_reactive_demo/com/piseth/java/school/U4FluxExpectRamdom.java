package java_reactive_demo.com.piseth.java.school;

import org.junit.jupiter.api.Test;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class U4FluxExpectRamdom {
	
	private Flux<Integer> getRandomItems(){
		return Flux.range(1, 60)
				.map(x -> Util.faker().random().nextInt(1, 100));
	}
	
	@Test
	public void testFlux() { // matcher 
		StepVerifier.create(getRandomItems())
			.expectNextMatches(x -> x >0 && x < 101)
			.expectNextCount(59)
			.expectComplete()
			.verify();
	}	
	
	@Test
	public void testFlux1() { // while condition 
		StepVerifier.create(getRandomItems())
			.thenConsumeWhile(x -> x >0 && x < 101)
			.expectComplete()
			.verify();
	}	
}














