package java_reactive_demo.flux;

import java.util.List;
import java.util.stream.Stream;

import java_reactive_demo.util.Util;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;

public class Flux5FromRang {

	private static List<Integer> of;

	public static void main(String[] args) {
		
//		Flux<Integer> flux = Flux.range(1, 10);		
//		flux.subscribe(x -> System.out.println(x));
		
		Flux.range(1, 10)
			.map(x -> Util.faker().country().name())
			.subscribe(x -> System.out.println(x));
		
	}

}
