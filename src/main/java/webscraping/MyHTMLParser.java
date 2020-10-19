package webscraping;

import java.io.IOException;

import org.apache.commons.validator.routines.UrlValidator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.net.MalformedURLException;

public class MyHTMLParser{
	
	private String urlString;
	
	public MyHTMLParser(String urlString) throws MalformedURLException {
		if(urlString == null || urlString.isEmpty())
			throw new MalformedURLException("URL cannot be empty or null");

		this.urlString = urlString;	
	}

	public String getWebContent() throws MalformedURLException{
		String parsedContent = null;
		
		if(isValidUrl()) {
			try {	
				Document doc = Jsoup.connect(this.urlString).ignoreHttpErrors(true).get();
				parsedContent = doc.text().toLowerCase();
				return parsedContent;
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Error occured while connecting to url!");
				e.printStackTrace();
			}
			
		}
		throw new MalformedURLException();
	
	}
	
	public boolean isValidUrl() {
		// TODO Auto-generated method stub
		if(!(this.urlString .toLowerCase().startsWith("http://") || this.urlString.toLowerCase().startsWith("https://"))){
			this.urlString = ("http://" + this.urlString).toLowerCase();
		}
		
		UrlValidator validator = new UrlValidator();	
		return validator.isValid(this.urlString);
	}
}
