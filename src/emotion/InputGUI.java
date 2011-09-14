package emotion;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;

import emotion.Emotions.Emotion;

public class InputGUI extends JFrame implements WindowListener {
	private static final long serialVersionUID = -4944861279254776990L;
	
	JTextField wordTextField;
	JLabel[] emotionLabels;
	JSlider[] emotionSliders;

	int defaultEmotion = 0;
	int minEmotion = 0;
	int maxEmotion = 2;
	int size = Emotion.values().length;
	Emotion[] emotions = Emotion.values();
	JButton addButton;

	HashMap<String, EmotionData> map;
	HashMapSerializer hms = new HashMapSerializer();

	public InputGUI(String name) {
		super(name);
		setResizable(false);

		wordTextField = new JTextField();

		emotionLabels = new JLabel[size];
		emotionSliders = new JSlider[size];

		for (int i = 0; i < size; i++) {
			emotionLabels[i] = new JLabel(emotions[i].toString().toLowerCase());
			emotionSliders[i] = new JSlider(JSlider.HORIZONTAL, minEmotion,
					maxEmotion, defaultEmotion);
			emotionSliders[i].setMajorTickSpacing(1);
			emotionSliders[i].setMinorTickSpacing(1);
			emotionSliders[i].setPaintTicks(true);
			emotionSliders[i].setPaintLabels(true);
			emotionSliders[i].setSnapToTicks(true);
		}

		addButton = new JButton("Add");

		map = hms.retrieve();
	}

	public void addComponentsToPane(final Container pane) {
		pane.setLayout(new GridLayout(12, 2, 0, 30));

		pane.add(new JLabel("Word:"));
		pane.add(wordTextField);

		pane.add(new JLabel("Emotion:"));
		pane.add(new JLabel());

		for (int i = 0; i < size; i++) {
			pane.add(new JLabel(emotions[i].toString().toLowerCase()));
			pane.add(emotionSliders[i]);
		}

		pane.add(new JLabel());
		pane.add(addButton);
		addButton.addActionListener(new EmotionCreator());
		
		addWindowListener(this);
	}

	private static void createAndShowGUI() {
		/* Create and set up the window */
		InputGUI frame = new InputGUI("Add Word to Emotion Dictionary");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.addComponentsToPane(frame.getContentPane());

		/* display the window */
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	class EmotionCreator implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String word = wordTextField.getText();
			EmotionData emotionData = new EmotionData();
			for (int i = 0; i < size; i++) {
				emotionData.setValue(i, emotionSliders[i].getValue());

			}
			System.out.println(word + " : " + emotionData);
		
			map.put(word, emotionData);
		}
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("window closed");
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("window closing");
		try {
		hms.update(map);
		System.out.println(map.toString());
		} catch (Exception e) {
			System.out.println("caught exception");
		}
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
