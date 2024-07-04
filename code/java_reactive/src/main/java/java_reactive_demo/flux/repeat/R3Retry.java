package java_reactive_demo.flux.repeat;

import java.util.concurrent.atomic.AtomicInteger;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class R3Retry {
	
	private static AtomicInteger atomicInteger = new AtomicInteger();

	public static void main(String[] args) {

		flux()
			.retry(2)
			.subscribe(Util.subcriber());
		
	}
	
	public static Flux<Integer> flux(){
		return Flux.range(1, 3)
				.doOnSubscribe(x -> System.out.println("--->Subscrib"))
				.doOnComplete(() -> System.out.println("--->Complete"))
				.map(x -> atomicInteger.getAndIncrement())				
				.map(x -> x/(Util.faker().random().nextInt(1, 6) < 3 ? 0:1))
				.doOnError(err -> System.out.println("----> Error : "+err.getMessage()))
				;
				
	}

}
