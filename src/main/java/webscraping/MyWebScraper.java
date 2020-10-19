package webscraping;

import java.net.MalformedURLException;
import java.util.Map;
import java.util.Scanner;

public class MyWebScraper {
	public static void main(String[] args) {
		
		System.out.println("########################################################"); 
		System.out.println("\t !!Welcome to Mansi's WebScraper!!"); 
		System.out.println("Extract Top Keywords from the website of your choice!!\n");
		System.out.print("[Note: Valid URL formats:] http://www.example.com\n \t\t\t   https://www.example.com\n "
				+ "\t\t\t   www.example.com\n \t\t\t   example.com \n");
		System.out.print("\t Enter URL: ");
	
		boolean isValidUserInput = false;
		
		
		while(!isValidUserInput) {
			try {
				Scanner sc = new Scanner(System.in); 
				String userinput = sc.nextLine();
				System.out.println("########################################################"); 
				
				
				/***** Enter URL *****/
				MyHTMLParser obj = new MyHTMLParser(userinput);
				String webContent = obj.getWebContent();
				System.out.println("\nYour Website Content is: \n"+ webContent +"\n");
				isValidUserInput=true;
				sc.close();
				
				
				WebContentOperationService webObj = new WebContentOperationService();
				
				/***** Get List of words from the given string content *****/
				Map<String,Integer> wordMap = webObj.getWordMap(webContent);
				System.out.println("*********************"); 
				System.out.println("WordList with word frequency: \n"+ wordMap+"\n");
				System.out.println("Word Map size: "+ wordMap.size()+"\n");
			
				
				/***** Get Sorted Word Frequency Map*****/
				Map<String,Integer> sortedWordMap = webObj.getSortedMap(wordMap);
				System.out.println("*********************"); 
				System.out.println("Sorted WordCount Map: \n"+ sortedWordMap+"\n");
				
				
				/***** Get Top n Words *****/
				System.out.println("*********************"); 
				System.out.println("Top 25 words:");
				Map<String,Integer> topWordsList = webObj.getTopNWords(sortedWordMap, 25);
				System.out.println(topWordsList);
				
				
			} catch (MalformedURLException e) {
				
				System.out.println("Please Enter valid URL!! URL cannot be empty or null. \n"
						+ "URL Format should be 'sometext.hostname'");
				e.printStackTrace();
			}
		}
			

	}
}
