package webscraping;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.*;

public class JsoupExample2 {
	public static void main(String args[]){
		 String parsedString = null;
		// String parsedString = "I live in USA. India is my native country.Native language in USA is English.";
				
				
		try {
			Document doc = Jsoup.connect("ARCHIVESOCIAL.com/").get();
			parsedString = doc.text().toLowerCase();
			log(parsedString); //prints content of webpage
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch(NullPointerException e) {
			System.out.println("String cannot be null");
		}catch(Exception e) {
			System.out.println("String cannot be null");
		}
		
		 // long count= doc.text().Stream().filter(string -> string.length()>0).count();
		 int count=0;
		 		 String[] wordArray = parsedString.trim().split("[^a-zA-Z]+|\\s+"); ///////[^a-zA-Z]|\\s+
		 		 for(String word : wordArray) {
		 			 count++;
		 			 System.out.println("Word"+ count+" "+ word);
		 		 }
			 
		/***** Get List of words from the given string content *****/
			List<String> wordList = getWordList(parsedString);
			System.out.println("WordList:"+ wordList);
			System.out.println("WordList size:"+ wordList.size());
		/***** Get List of words from the given string content *****/
		
		 
		 /***** Get Word Frequency Map*****/
			Map<String,Integer> wordCountMap = getWordFrequencyCount2(wordList);
			System.out.println("WordCount Map:"+ wordCountMap);
			System.out.println("Map size:"+ wordCountMap.size());
		/***** Get Word Frequency Map*****/
		
		
		System.out.println("sorted stream"+ wordCountMap.entrySet()
														.stream()
														.sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
														.collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2) -> e1,LinkedHashMap :: new)));
		
		 /***** Sort Word Frequency Map by frequency*****/
			Map<String, Integer> sortedMap = new LinkedHashMap<>();
	        wordCountMap.entrySet().stream()
	                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
	                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
		 
		 	//System.out.println("Sorted WordCount Map:"+ sortedMap);
        /***** Sort Word Frequency Map by frequency*****/
				
		//sortedMap.forEach((k, v) -> System.out.println((k + ":" + v)));
	
		
		 /***** Get top 25 *****/
			System.out.println("Top 25 words:");
			int counter=0;
			for(Iterator<Entry<String, Integer>> it= sortedMap.entrySet().iterator() ; it.hasNext() && counter < 25;){
				System.out.println(it.next());
				count++;
			}
		 /***** Get top 25 *****/
		
	} // END OF MAIN
	
	
	public static List<String> getWordList(String parsedString){
		
		List<String> pageContent = new ArrayList<String>();
		 int count=0;
		 
		 Pattern p = Pattern.compile("[a-zA-Z]+");
		 Matcher m1 = p.matcher(parsedString);
		 System.out.println("Words from strings : "); 
			
		 
		 while (m1.find()) { 
				try {
					count++;
					pageContent.add(m1.group());
					System.out.println(m1.group());
				}
				 catch(Exception e) {
					 
				 }
			} 
		 return pageContent;
	}
	
	public static Map<String,Integer> getWordFrequencyCount(List<String> list) {
		 
		Map<String, Integer> wordMap = list.parallelStream().
		            collect(Collectors.toConcurrentMap(
		                w -> w, w -> 1, Integer::sum));
		
		
		  		//System.out.println(wordMap);
		        //System.out.println(wordMap.size());
		        
		        return wordMap;
		
	}
	
	public static Map<String,Integer> getSortedMap(Map<String,Integer> map){
//		Map<String, Integer> result = map.entrySet().stream()
//                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
//                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
//		return result;

		
		Map<String, Integer> result2 = new LinkedHashMap<>();
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));
        return result2;
//		
//		map.entrySet()
//		.stream()
//		.sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
//		.collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2) -> e1,LinkedHashMap :: new));
//		return map;
	}
		
	public static Map<String,Integer> getWordFrequencyCount2(List<String> list) {
		 
		Map<String, Integer> wordMap = new TreeMap<>();
		int totalwords=0;
		
		for(String s: list) {
			Integer count = wordMap.get(s);
			if(count == null)
				count=0;
			totalwords++;
			wordMap.put(s,count+1);
			
		}
		
		System.out.println("total words:"+totalwords);   		        
		return wordMap;
		
	}
	 private static void log(String msg, String... vals) {
	        System.out.println(String.format(msg, vals));
	    }
}
