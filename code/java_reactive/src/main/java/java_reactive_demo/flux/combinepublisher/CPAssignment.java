package java_reactive_demo.flux.combinepublisher;

import java.time.Duration;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class CPAssignment {

	public static void main(String[] args) {
		
		int carPrice = 10000;
		
		Flux.combineLatest(monthStream(), demandStream(), (month,demand)->{
			
			return (carPrice - month*100) * demand;			
		})
		
		.subscribe(Util.subcriber());
		
		//demandStream().subscribe(Util.subcriber());
		Util.sleep(10);
	}
	
	private static Flux<Long> monthStream(){
		
		return Flux.interval(Duration.ZERO,Duration.ofSeconds(1))
				.doOnNext(x ->System.out.println("Month: " +x));
		

	}
	
	private static Flux<Double> demandStream(){
		return Flux.interval(Duration.ofSeconds(3))
				.map(x -> Util.faker().random().nextInt(8, 10)/10.0)
				.startWith(1d)
				.doOnNext(x ->System.out.println("Demand: " + x))
				;// need to start with number 1
	}
	
	
}
