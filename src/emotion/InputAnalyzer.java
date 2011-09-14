//package emotion;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Scanner;
//
//import emotion.Emotions.Emotion;
//import graphics.EmotionSpiderPlot;
//
///*
// * Crappy analyzer for strings of multiple words.  Type exit to quit and show the tallies.  The pretty plot gets written to the usual file.
// */
//public class InputAnalyzer {
//    public static void main(String[] args) throws IOException {
//	EmotionData emotionData = new EmotionData();
//	HashMap<String, Emotion> map;
//	HashMapSerializer hms = new HashMapSerializer();
//	map = hms.retrieve();
//	
//	System.out.print("Enter sentence: ");
//
//	Scanner sc = new Scanner(System.in);
//	
//	while(sc.hasNextLine()) {
//	    String line = sc.nextLine();	   
//	    line = line.toLowerCase();
//	    
//	    if (line.equals("exit")) {
//		break;
//	    }
//	    
//	    line = line.replace(',', ' ');
//	    line = line.replace('.', ' ');
//
//	    String[] words = line.split(" ");
//	    
//	    for (String word : words) {
//		if (map.containsKey(word)) {
//		    emotionData.incrementValue(map.get(word).ordinal());
//		}
//	    }
//	}
//	
//	System.out.println(emotionData);
//	
//	EmotionSpiderPlot plot = new EmotionSpiderPlot(emotionData);
//	plot.draw();
//    }    
//}
