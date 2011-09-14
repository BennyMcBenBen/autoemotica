package emotion;

import java.util.HashMap;

public class EmotionDictionaryPrinter {
	void print(HashMap<String, EmotionData> map) {
		System.out.println(map.toString());
	}
	
	 public static void main(String args[]) {
		 HashMapSerializer hms = new HashMapSerializer();
		 HashMap<String, EmotionData> map = hms.retrieve();
		 EmotionDictionaryPrinter printer = new EmotionDictionaryPrinter();
		 printer.print(map);
	 }
}


