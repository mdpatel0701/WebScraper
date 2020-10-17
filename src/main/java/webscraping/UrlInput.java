package webscraping;

import java.util.Scanner;
import org.apache.commons.validator.routines.UrlValidator;

public class UrlInput {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		boolean isValidUrl = false;
		do {
					System.out.println("Enter URL:");
					String userinput = sc.nextLine();
					
					if(!(userinput.toLowerCase().startsWith("http://") || userinput.toLowerCase().startsWith("https://"))){
						userinput = ("http://" + userinput).toLowerCase();
					}
					
					if(urlValidator(userinput)) {
						isValidUrl = true;
						System.out.println("url validator passed::"+ userinput);
					}
					else {
						System.out.println("Enter correct url");
					}
				}while(isValidUrl == false);
		
		}
	
	public static boolean urlValidator(String url) {
		UrlValidator validator = new UrlValidator();
		return validator.isValid(url);
	}
		
}
