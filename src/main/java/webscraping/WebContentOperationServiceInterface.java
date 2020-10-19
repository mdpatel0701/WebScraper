package webscraping;

import java.util.List;
import java.util.Map;

public interface WebContentOperationServiceInterface {

	public Map<String,Integer> getWordList(String inputString); //using pattern
	public String[] getWordListUsingRegex(String inputString);
	
	public  Map<String,Integer> getWordFrequencyCount(List<String> list); //using Stream
	public  Map<String,Integer> getWordFrequencyCount2(List<String> list); //using TreeMap
	
	public  Map<String,Integer> getSortedMap(Map<String,Integer> map);
	public Map<String,Integer> getTopNWords(Map<String,Integer> map, Integer number);
	
}
