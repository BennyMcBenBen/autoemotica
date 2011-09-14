package emotion;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

import emotion.Emotions.Emotion;

public class EmotionData implements Iterable<Integer>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2999688993553050741L;
	Integer current = new Integer(0);
	protected int[] values = new int[Emotion.values().length];

	public int[] getValues() {
		return values;
	}

	public void setValues(int[] values) {
		this.values = values;
	}

	public int size() {
		return values.length;
	}

	private class EmotionDataIterator implements Iterator<Integer> {
		private int current;

		public boolean hasNext() {
			return current < values.length;
		}

		public Integer next() {
			if (hasNext()) {
				Integer i = values[current];
				current++;
				return i;
			} else
				throw new NoSuchElementException();
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	public Integer getValue(int index) {
		return values[index];
	}

	public void setValue(int index, int value) {
		values[index] = value;
	}

	public void incrementValue(int index) {
		values[index]++;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new EmotionDataIterator();
	}

	@Override
	public String toString() {
		String out = "";

		for (Emotions.Emotion e : Emotions.Emotion.values()) {
			out += e + ": " + values[e.ordinal()] + "\n";
		}

		return out;
	}
}
