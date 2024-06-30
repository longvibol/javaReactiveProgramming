package review_concept;

import java.util.List;

public class GenericsReview {
	
	static Printer printer = new Printer();

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<String> names = List.of("Dara","Thida","Veasna");
		
		/* First Style
		names.stream()
			.forEach( x -> System.out.println(x));	
			
		*/
		
		/* Second Style 
		names.stream()
		.forEach(x -> {
			int length = x.length();
			System.out.println(x + " : has" + length + " letters");
		});
		*/
		
		/*
		1st style : Method Reference 
		names.stream()
			.forEach(System.out::println);
		*/
		
		/*
//		2nd style : Method Reference 
		names.stream()
		.forEach(printText());		
		*/		
		
//		Printer printer = new Printer(); it call variable call 		
//		names.stream()
//			.forEach(printer::printer);
		
		
		/*
		// Method print call from static and reference to the calss method name 		
		names.stream()
			.forEach(Printer::printAndCount);
		
		*/
		
		//Lambda expression 
		names.stream()
			.map(t -> t.toUpperCase())
//			.forEach(t -> Printer.printAndCount(t));
			.forEach(System.out::println); // call from object 
		
		
				
		
	}
	
	
	
	
	
	
	
	
	
	/* 2 nd Function Style 
	private static Consumer<String> printText() {
		return t ->System.out.println(t);
	}
	*/	
	
	
	/* 3 nd 
	private static Consumer<String> printText() {
		return t ->{
			int length = t.length();
			System.out.println(t + " : has" + length + " letters");
			
		};
	}
	*/

}



































