package java_reactive_demo.util;

import java.util.ArrayList;
import java.util.List;

import reactor.core.publisher.Flux;

public class ColorGenerator {
	
	public List<String> getColor(int number){
		List<String> colors = new ArrayList<String>();
		
		for(int i =0;i<=number;i++) {
			colors.add(getColor());
		}
		return colors;
	}
	
	public Flux<String> getColorV2(int number){
		return Flux.range(1, number)
			.map(x -> getColor());
	}
	
	
	private String getColor() {
		Util.sleep(1);
		return Util.faker().color().name();
	}

}
