package java_reactive_demo.flux;

import java.time.Duration;
import java.util.List;

import java_reactive_demo.util.ColorGenerator;
import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Flux11FluxtoMono {

	public static void main(String[] args) {
		
		
		Flux<Integer> flux = Flux.just(2,4,5,6);
		
		flux
			.filter(x->x>1)
			.next() // where we conver from flux to mono
			.subscribe(x ->System.out.println(x));
			

	}


}
