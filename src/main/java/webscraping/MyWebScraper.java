package webscraping;

import java.net.MalformedURLException;
import java.util.List;
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
				System.out.println("WordList:"+ wordList);
				System.out.println("WordList size:"+ wordList.size());
				/***** Get List of words from the given string content *****/
				
				
				
				webObj.getWordListUsingRegex(webContent);
				
			} catch (MalformedURLException e) {
				
				System.out.println("Please Enter valid URL!! URL cannot be empty or null , URL Format should be sometext.hostname");
				e.printStackTrace();
			}
		}
			

	}
}
