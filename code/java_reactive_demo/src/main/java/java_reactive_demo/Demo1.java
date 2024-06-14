package java_reactive_demo;

import reactor.core.publisher.Mono;

public class Demo1 {

	public static void main(String[] args) {

		//publiser have Lazy- it is not working if there are no subscriber 
		
		Mono<String> mono = Mono.just("Vibol");
//		mono.subscribe(x ->System.out.println(x));		
//		System.out.println(mono);
		
		mono.subscribe(
				x -> System.out.println("onNext + " + x), 
				e -> System.out.println("onError: " + e.getMessage()), 
				() -> System.out.println("onComplete"));
		
	}
	

}
