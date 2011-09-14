package emotion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class HashMapSerializer {
	public void create() throws Exception {
		HashMap<String, EmotionData> map = new HashMap<String, EmotionData>();
		FileOutputStream fileStream = new FileOutputStream("map.ser");
		ObjectOutputStream os = new ObjectOutputStream(fileStream);
		os.writeObject(map);
		os.close();
	}

	@SuppressWarnings("unchecked")
	public HashMap<String, EmotionData> retrieve() {
		try {
			FileInputStream fileStream = new FileInputStream("map.ser");
			ObjectInputStream os = new ObjectInputStream(fileStream);
			HashMap<String, EmotionData> map = (HashMap<String, EmotionData>) os
					.readObject();
			os.close();
			return map;
		} catch (Exception e) {
			return null;
		}
	}

	public void update(HashMap<String, EmotionData> map) {
		FileOutputStream fileStream;
		ObjectOutputStream os;
		try {
			fileStream = new FileOutputStream("map.ser");
			os = new ObjectOutputStream(fileStream);
			os.writeObject(map);
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws Exception {
		HashMapSerializer cereal = new HashMapSerializer();
		cereal.create();

		HashMap<String, EmotionData> map = cereal.retrieve();
		map.clear();
		cereal.update(map);

		// map.put(":)", Emotion.HAPPY);
		// cereal.update(map);

		// System.out.println(map.get(":)"));
	}
}
