package java_reactive_demo.flux;

import java.time.Duration;
import java.util.List;

import java_reactive_demo.util.ColorGenerator;
import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class Flux9IntervalUpdate {

	public static void main(String[] args) {
		
		Flux.interval(Duration.ofSeconds(1))
			.subscribe(x -> System.out.println(x));
		
		Util.sleep(5);
		
	}

}
