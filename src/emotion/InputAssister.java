//package emotion;
//
//import java.util.HashMap;
//import java.util.Scanner;
//import emotion.HashMapSerializer;
//import emotion.Emotions.Emotion;
//
//public class InputAssister {
//    public static void main(String args[]) throws Exception {
//	HashMap<String, Emotion> map;
//	HashMapSerializer hms = new HashMapSerializer();
//	map = hms.retrieve();
//
//	System.out.print("Enter word: ");
//
//	Scanner sc = new Scanner(System.in);
//	while (sc.hasNext()) {
//	    String word = sc.next();
//	    word = word.toLowerCase();
//	    
//	    if (word.equals("exit")) {
//		break;
//	    }
//	    
//	    if (map.containsKey(word)) {
//		System.out.print("Already exists: " + map.get(word));
//	    } else {
//		System.out.print("Enter emotion: ");
//		String emotion = sc.next();
//		map.put(word, Emotions.Emotion.valueOf(emotion.toUpperCase()));
//	    }
//	    System.out.println("Enter word: ");
//	}
//	
//	hms.update(map);
//	System.out.println(map.toString());
//    }
//}
