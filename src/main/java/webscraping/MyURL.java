package webscraping;

import org.apache.commons.validator.routines.UrlValidator;
import java.net.URL;
public class MyURL{
	
	public String inputUrl;

	public MyURL(String inputUrl) {
		super();
		this.inputUrl = inputUrl;
	}

	public String getInputUrl() {
		
		return this.inputUrl;
	}

	public static boolean urlValidator(String url) {
		UrlValidator validator = new UrlValidator();
		return validator.isValid(url);
	}
	
//	public void setInputUrl(String inputUrl) {
//		this.inputUrl = inputUrl;
//	} 
	
	
}
