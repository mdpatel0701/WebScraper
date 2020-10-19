package webscraping;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MyWebScraper {
	public static void main(String[] args) {
		
		System.out.println("#############################################"); 
		System.out.println("\t Welcome to My WebScraper!!"); 
		System.out.print("\t Enter URL: ");
	
		boolean isValidUserInput = false;
		
		
		while(!isValidUserInput) {
			try {
				Scanner sc = new Scanner(System.in); 
				String userinput = sc.nextLine();
				System.out.println("#############################################"); 
				
				
				/***** Enter URL *****/
				MyHTMLParser obj = new MyHTMLParser(userinput);
				String webContent = obj.getWebContent();
				System.out.println("Content:" +"\n"+ webContent );
				isValidUserInput=true;
				sc.close();
				
				
				WebContentOperationService webObj = new WebContentOperationService();
				
				/***** Get List of words from the given string content *****/
				Map<String,Integer> wordList = webObj.getWordList(webContent);
				System.out.println("WordList:"+"\n"+ wordList);
				System.out.println("WordList size: "+ wordList.size()+"\n");
			
				
				
				 /***** Get Word Frequency Map*****/
//				Map<String,Integer> wordCountMap = webObj.getWordFrequencyCount(wordList);
//				System.out.println("WordCount Map: "+ wordCountMap+"\n");
				//System.out.println("Map size:"+ wordCountMap.size()+"\n");
				 
				
				/***** Get Sorted Word Frequency Map*****/
				Map<String,Integer> sortedWordCountMap = webObj.getSortedMap(wordList);
				System.out.println("Sorted WordCount Map:"+ sortedWordCountMap+"\n");
				
				
				/***** Get Top n Words *****/
				System.out.println("Top 25 words:");
				Map<String,Integer> topWordsList = webObj.getTopNWords(sortedWordCountMap, 25);
				System.out.println(topWordsList);
				
				
			} catch (MalformedURLException e) {
				
				System.out.println("Please Enter valid URL!! URL cannot be empty or null , URL Format should be sometext.hostname");
				e.printStackTrace();
			}
		}
			

	}
}
