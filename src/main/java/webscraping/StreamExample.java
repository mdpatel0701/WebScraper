package webscraping;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamExample {
		public static void main(String[] args) {
			List<String> strings = Arrays.asList("INDia","USA","Australia","India","USA","India","Australia","India");
			String pageContent = "I live in USA. India is my native country.Native language in USA is English.";
			//List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList()); //removes empty string from list
//			for(String str : filtered) {
//				log(str);
//			}
			
			
			//Map<String,Long> filtered = strings.stream().collect(groupingBy(Function.identity(), counting()));
			
			/**** Counts total word count ****/
			long count = strings.parallelStream().filter(string -> string.length()>0).count();
			System.out.println("string count is"+count);
			/**** Counts total word count ****/
			
			
			/****** Word frequency count *****/
			  Map<String, Integer> counts = strings.parallelStream().
			            collect(Collectors.toConcurrentMap(
			                w -> w, w -> 1, Integer::sum));
			        System.out.println(counts);
			
			/****** Word frequency count *****/
			
		}

		 private static void log(String msg, String... vals) {
		        System.out.println(String.format(msg, vals));
		    }
}
