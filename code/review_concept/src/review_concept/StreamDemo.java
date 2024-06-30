package review_concept;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) {
		
		List<Student> students = List.of(
				new Student("Dara", "M", 23, List.of("Java Basic","Spring Boot")),
				new Student("Thida", "F", 21, List.of("Java Basic")),
				new Student("Socheata", "F", 22, List.of("Java Advance","Spring Boot")),		
				new Student("Veasna", "M", 23, List.of("Microservice","Spring Boot","Java Reactive"))						
				);
		
		
		// We want to cound the number on eacher name 
		
		/*
		students.stream()
			.map(x -> x.getName())
			.map(x ->x.length())
			.forEach(System.out::println);
			
		*/
		
		// Find All subjuect 
		
//		students.stream()
//			.flatMap(x ->x.getSubjects().stream())
//			.distinct()
//			.forEach(System.out::println);
		
		
		
		Map<Object, Object> map = students.stream()
		.flatMap(x ->x.getSubjects().stream())
		.distinct()
//		.collect(Collectors.toMap(x -> x, x -> x.length(), (x1, x2) -> x1));	
		.collect(Collectors.toMap(x -> x.length(),Function.identity(),  (x1, x2) -> x1));	
		System.out.println(map);
		
			
			
			

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	

	}

}
