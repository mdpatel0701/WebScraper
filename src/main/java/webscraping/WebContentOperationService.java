package webscraping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WebContentOperationService implements WebContentOperationServiceInterface{

//	private String pageContent = null;
//
//	public WebContentOperationService(String pageContent) {
//		super();
//		this.pageContent = pageContent;
//	}
	

	@Override
	public Map<String,Integer> getWordList(String inputString) {
		// TODO Auto-generated method stub
		//List<String> pageContent = new ArrayList<String>();
		 int count=0;
		 
		 Pattern p = Pattern.compile("[a-zA-Z]+");
		 Matcher matcher = p.matcher(inputString);
		 Map<String, Integer> wordMap = new HashMap<>();
		// System.out.println("Words from strings : "); 
		 String currentWord;
		 
		 while (matcher.find()) { 
			 	currentWord = matcher.group();
				try {
					count++;
					//pageContent.add(m1.group());
					
					if(wordMap.containsKey(currentWord))
					{
						wordMap.put(currentWord, wordMap.get(currentWord).intValue()+1);
					}
					else
					{
						wordMap.put(currentWord,1);
					}
				//	System.out.println(m1.group());
				}
				 catch(Exception e) {
					 //TODO
				 }
			} 
		 return wordMap;
	}

	@Override
	public String[] getWordListUsingRegex(String inputString) {
		// TODO Auto-generated method stub
		
		return  inputString.trim().split("[^a-zA-Z]+|\\s+");
	}

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

	@Override
	//TODO delete
	public Map<String, Integer> getWordFrequencyCount2(List<String> list) {
		// TODO Auto-generated method stub
		Map<String, Integer> wordMap = new HashMap<>();
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

	@Override
	public Map<String, Integer> getSortedMap(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		Map<String, Integer> result2 = new LinkedHashMap<>();
		
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));
        return result2;
	}

	@Override
	public Map<String,Integer> getTopNWords(Map<String, Integer> sortedMap, Integer number) {
		// TODO Auto-generated method stub
		int counter=0;
//		Entry<String, Integer> next;
		
		Map<String,Integer> topNWordMap = new LinkedHashMap<String,Integer>();
//		for(Iterator<Entry<String, Integer>> it= sortedMap.entrySet().iterator() ; it.hasNext() && counter < number;){
//			next = it.next();
//			topNWordMap.put(next.getKey(), next.getValue());
//			//System.out.println(it.next());
//			counter++;
//		}
		
		for(Map.Entry<String,Integer> entry: sortedMap.entrySet()) {
//			System.out.println();
			topNWordMap.put(entry.getKey(), entry.getValue());
		}
		return topNWordMap;
	}
}
