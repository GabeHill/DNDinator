package files;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GSONifier {

	/**
	 *
	 * @param o
	 * @return String in JSON object format
	 *
	 *         Takes in an Object and turns it into a JSON string.
	 */
	public static String GSONify(Object o) {
		Gson g = new Gson();
		String s = g.toJson(o);
		return s; // returns a string containing the json and just use a file writer to save it to
					// disk
		// this also makes the json look ugly (all on one line) to enable the multiline
		// readability you will need to use a few extra lines...
		// GsonBuilder gb = new GsonBuilder()
		// gb.setPrettyPrinting(); // or something of the sort...
		// Gson g = gb.create(); // or similar idk its been a while since i set it all
		// up

	}

	/**
	 *
	 * @param s
	 * @param className
	 * @return Object of type className
	 *
	 *         Takes in a String and a Class type and builds an object out of it.
	 */
	public static Object unGSONify(String s, Class<?> className) {
		GsonBuilder gb = new GsonBuilder();
		Gson g = gb.create();
		return g.fromJson(s, className); // string in this case can be substitiuted for a file input stream
	}

}
