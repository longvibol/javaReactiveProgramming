package java_reactive_demo.flux.thread;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class TS2SubscribeOn {

	public static void main(String[] args) {

		Flux<Object> flux = Flux.create(sink -> {
			printThreadName("create");
			sink.next(10);
		}).doOnNext(x -> printThreadName("onNext: " + x));
		
		/*
		flux
			.doFirst(() -> printThreadName("doFirst 2 : "))
			.subscribeOn(Schedulers.boundedElastic())
			.doFirst(() -> printThreadName("doFirst 1 : "))
			.subscribe(x -> printThreadName("sub: " + x));
		
		*/		
		
		Runnable runnable = () -> flux
				.doFirst(() -> printThreadName("doFirst 2 : "))
				.subscribeOn(Schedulers.boundedElastic()) // where we change the thread to : boundedElastic
				.doFirst(() -> printThreadName("doFirst 1 : "))
				.subscribe(x -> printThreadName("sub: " + x));

		for (int i = 0; i < 2; i++) {
			new Thread(runnable).start();
		}
		
		Util.sleep(60);

	}
	
	

	private static void printThreadName(String text) {
		System.out.println(text + " - Thread: " + Thread.currentThread().getName());
	}
}
