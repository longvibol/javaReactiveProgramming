package java_reactive_demo;

import reactor.core.publisher.Mono;

public class Demo2Error {

	public static void main(String[] args) {

		
//		Mono<Integer> mono = Mono.just(1);
//		Mono<Integer> mono = Mono.just(1).map(x->x/0);
		
//		Mono<Integer> mono = Mono.just("Vibol").map(x ->x.length());
		Mono<Integer> mono = Mono
				.just("Vibol")
				.map(x ->x.length())
				.map(x ->x/0);
		
		mono.subscribe(
				x -> System.out.println("onNext + " + x), 
				e -> System.out.println("onError: " + e.getMessage()), 
				() -> System.out.println("onComplete"));
		
	}
}
