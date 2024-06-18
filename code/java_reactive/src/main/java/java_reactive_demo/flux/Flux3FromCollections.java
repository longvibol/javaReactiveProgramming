package java_reactive_demo.flux;

import java.util.List;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class Flux3FromCollections {

	public static void main(String[] args) {

		/*
		
		List<Integer> list = List.of(1,2,3,4);
		
		Flux<Integer> flux = Flux.fromIterable(list);
		flux.subscribe(x ->System.out.println(x));
		
		*/
		
		// Integer is the object type
		Integer[] numbers = {5,6,7,12};
		
		Flux<Integer> flux = Flux.fromArray(numbers);
		flux.subscribe(x ->System.out.println(x));
		
		
		
		
		
		
		
		
	}

}
