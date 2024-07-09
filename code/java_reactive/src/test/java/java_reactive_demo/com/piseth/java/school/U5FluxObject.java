package java_reactive_demo.com.piseth.java.school;

import java.util.Objects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class U5FluxObject {
	
	private record Book(int id, String title, String author) {
		
	}
	
	private Flux<Book> getBooks(){
		return Flux.range(1, 3)
					.map(x -> new Book(x, Util.faker().book().title(), Util.faker().book().author()));
	}
	
	@Test
	public void testFlux() {
		StepVerifier.create(getBooks())
			.assertNext(x ->{
				Assertions.assertEquals(1, x.id());
			})
			.assertNext(x ->{
				Assertions.assertEquals(2, x.id());
			})
			.assertNext(x ->{
				Assertions.assertEquals(3, x.id());
			})
			.expectComplete()
			.verify();
	}
	
	@Test
	public void testFlux1() {
		StepVerifier.create(getBooks())
			.assertNext(x ->{
				Assertions.assertEquals(1, x.id());
			})
			.thenConsumeWhile(x -> Objects.nonNull(x.title))
			.expectComplete()
			.verify();
	}
	
	//return element 
	
	@Test
	public void testFlux2() { // we want to get only the element 
		StepVerifier.create(getBooks().collectList())
			.assertNext(x ->{
				Assertions.assertEquals(3, x.size());
			})
			.expectComplete()
			.verify();
	}
	
	
	

}
















