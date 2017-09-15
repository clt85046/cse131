package scraping;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cse131.ArgsProcessor;

public class Weather {
	
	public static void main(String[] args) throws IOException {
		ArgsProcessor ap = new ArgsProcessor(args);
			
		String zip = ap.nextString("What zip code?");
		
		Document doc = Jsoup.connect("http://www.wunderground.com/cgi-bin/findweather/getForecast?query="+zip).get();
		String wholeThing = doc.toString();
		//
		// Get rid of the print of the whole thing
		//
		System.out.println(wholeThing);
		//
		// and instead do string searching and trimming 
		// to isolate the temperature reading
		// report that as your output
		//
		System.out.println("Temperature is "); // FIXME
		//
		// And find one more statistic of interest and report that:
		//
		System.out.println("And xxxx is ");  // FIXME

	}

}
