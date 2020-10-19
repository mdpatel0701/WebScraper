package webscraping;

import java.util.List;
import java.util.Map;

public interface WebContentOperationServiceInterface {

	public Map<String,Integer> getWordMap(String inputString); //using pattern	
	public  Map<String,Integer> getSortedMap(Map<String,Integer> map);
	public Map<String,Integer> getTopNWords(Map<String,Integer> map, Integer number);
	
	public  Map<String,Integer> getWordFrequencyCount(List<String> list); //using Stream
	public  Map<String,Integer> getWordFrequencyCountUsingMap(List<String> list); //using TreeMap
	
}
