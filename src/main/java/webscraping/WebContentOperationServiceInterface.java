package webscraping;

import java.util.Map;

public interface WebContentOperationServiceInterface {

	public String[] getWordList(String inputString);

	public Map<String, Integer> getWordMap(String inputString); // using Pattern|Matcher

	public Map<String, Integer> getSortedMap(Map<String, Integer> map);

	public Map<String, Integer> getTopNWords(Map<String, Integer> map, Integer number);

}
