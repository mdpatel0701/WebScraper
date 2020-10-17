package webscraping;

import java.util.ArrayList;
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
//	
//	

	@Override
	public List<String> getWordList(String inputString) {
		// TODO Auto-generated method stub
		List<String> pageContent = new ArrayList<String>();
		 int count=0;
		 
		 Pattern p = Pattern.compile("[a-zA-Z]+");
		 Matcher m1 = p.matcher(inputString);
		// System.out.println("Words from strings : "); 
			
		 
		 while (m1.find()) { 
				try {
					count++;
					pageContent.add(m1.group());
				//	System.out.println(m1.group());
				}
				 catch(Exception e) {
					 
				 }
			} 
		 return pageContent;
	}

	@Override
	public String[] getWordListUsingRegex(String inputString) {
		// TODO Auto-generated method stub
		
		return  inputString.trim().split("[^a-zA-Z]+|\\s+");
	}

	@Override
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
	public Map<String, Integer> getWordFrequencyCount2(List<String> list) {
		// TODO Auto-generated method stub
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
	public List<String> getTopNWords(Map<String, Integer> sortedMap, Integer number) {
		// TODO Auto-generated method stub
		int counter=0;
		for(Iterator<Entry<String, Integer>> it= sortedMap.entrySet().iterator() ; it.hasNext() && counter < number;){
			System.out.println(it.next());
			counter++;
		}
		return null;
	}
}
