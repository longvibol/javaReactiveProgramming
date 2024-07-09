package java_reactive_demo.com.piseth.java.school;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class U4FluxExpectCount {
	
	private Flux<Integer> getItems(){
		return Flux.range(1, 60);
	}
	
	@Test
	public void testFlux() {
		StepVerifier.create(getItems())
			.expectNext(1)
			.expectNextCount(59)
			.expectComplete()
			.verify();
	}
	
	@Test
	public void testFlux2() {
		StepVerifier.create(getItems())
			.expectNext(1,2,3)
			.expectNextCount(57)
			.expectComplete()
			.verify();
	}
	
	@Test
	public void testFlux3() {
		StepVerifier.create(getItems())
			.expectNext(1,2,3)
			.expectNextCount(21)
			.expectNext(25)
			.expectNextCount(35)
			.expectComplete()
			.verify();
	}
	

}














