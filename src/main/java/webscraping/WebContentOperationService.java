package webscraping;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WebContentOperationService implements WebContentOperationServiceInterface{

	/* To get Word List with Word Frequency from Website content*/
	@Override
	public Map<String,Integer> getWordMap(String inputString) {
		// TODO Auto-generated method stub
		 int count = 0;
		 Pattern p = Pattern.compile("[a-zA-Z]+");
		 Matcher matcher = p.matcher(inputString);
		 Map<String, Integer> wordMap = new HashMap<>();
	
		 String currentWord;
		 
		 while (matcher.find()) { 
			 	currentWord = matcher.group();
				try {
					count++;						
					if(wordMap.containsKey(currentWord))
					{
						wordMap.put(currentWord, wordMap.get(currentWord).intValue() + 1);
					}
					else
					{
						wordMap.put(currentWord,1);
					}
				}
				 catch(Exception e) {
					 System.out.println("Pattern not matched");
				 }
			} 
		 
		 System.out.println("Total words parsed: "+ count +"\n");
		 return wordMap;
	}
	
	/* Get Sorted Map from Unsorted Map */
	@Override
	public Map<String, Integer> getSortedMap(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		Map<String, Integer> result = new LinkedHashMap<>();
		
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEachOrdered(x -> result.put(x.getKey(), x.getValue()));
        return result;
	}

	/* Get top N words from input Map*/
	@Override
	public Map<String,Integer> getTopNWords(Map<String, Integer> sortedMap, Integer number) {
		// TODO Auto-generated method stub
		Map<String,Integer> topNWordMap = new LinkedHashMap<String,Integer>();
		
		for(Map.Entry<String,Integer> entry: sortedMap.entrySet()) {
			topNWordMap.put(entry.getKey(), entry.getValue());
		}
		return topNWordMap;
	}
	
	
	/* To get Word List from Website content using Regex parser*/
	public String[] getWordListUsingRegex(String inputString) {
		// TODO Auto-generated method stub
		
		return  inputString.trim().split("[^a-zA-Z]+|\\s+");
	}

	/* To get Word Frequency count from List of String(Words) using stream*/
	@Override
	//TODO review
	public Map<String, Integer> getWordFrequencyCount(List<String> list) {
		// TODO Auto-generated method stub
		Map<String, Integer> wordMap = list.parallelStream().
	            collect(Collectors.toConcurrentMap(
	                w -> w, w -> 1, Integer::sum));
	
	
	  		//System.out.println(wordMap);
	        //System.out.println(wordMap.size());
	        
	    return wordMap;
	}

	/* To get Word Frequency count from List of String(Words) using TreeMap*/
	@Override
	
	public Map<String, Integer> getWordFrequencyCountUsingMap(List<String> list) {
		// TODO Auto-generated method stub
		Map<String, Integer> wordMap = new TreeMap<>();
		int totalwords=0;
		
		for(String s: list) {
			Integer count = wordMap.get(s);
			if(count == null)
				count=0;
			totalwords++;
			wordMap.put(s,count + 1);
			
		}
		
		System.out.println("total words:"+totalwords);   		        
		return wordMap;
	}

	
}
