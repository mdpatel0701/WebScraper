package webscraping;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MyWebScraper {
	public static void main(String[] args) {
		
		
		System.out.println("Welcome to My WebScraper!!"); 
		System.out.println("Enter URL:");
	
		boolean isValidUserInput = false;
		
		
		while(!isValidUserInput) {
			try {
				Scanner sc = new Scanner(System.in); 
				String userinput = sc.nextLine();
				
				MyHTMLParser obj = new MyHTMLParser(userinput);
				String webContent = obj.getWebContent();
				System.out.println("Content:" +"\n"+ webContent );
				isValidUserInput=true;
				sc.close();
				
				
				WebContentOperationService webObj = new WebContentOperationService();
				
				/***** Get List of words from the given string content *****/
				List<String> wordList = webObj.getWordList(webContent);
				System.out.println("WordList:"+"\n"+ wordList);
				System.out.println("WordList size:"+ wordList.size());
				/***** Get List of words from the given string content *****/
				
				
				 /***** Get Word Frequency Map*****/
				Map<String,Integer> wordCountMap = webObj.getWordFrequencyCount2(wordList);
				System.out.println("WordCount Map:"+ wordCountMap);
				System.out.println("Map size:"+ wordCountMap.size());
				/***** Get Word Frequency Map*****/
				
				/***** Get Word Frequency Map*****/
				Map<String,Integer> sortedWordCountMap = webObj.getSortedMap(wordCountMap);
				System.out.println("Sorted WordCount Map:"+ sortedWordCountMap);
				/***** Get Word Frequency Map*****/
				
				/***** Get Top n Words *****/
				System.out.println("Top 25 words:");
				List<String> topWordsList = webObj.getTopNWords(sortedWordCountMap, 25);
				System.out.println(topWordsList);
				/***** Get Top n Words *****/
				
			} catch (MalformedURLException e) {
				
				System.out.println("Please Enter valid URL!! URL cannot be empty or null , URL Format should be sometext.hostname");
				e.printStackTrace();
			}
		}
			

	}
}
