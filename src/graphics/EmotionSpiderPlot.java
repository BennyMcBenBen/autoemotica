package graphics;
import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PlotState;
import org.jfree.chart.plot.SpiderWebPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import emotion.Emotions;
import emotion.Emotions.Emotion;
import emotion.EmotionData;

import graphics.RoundGradientPaint;
/**
 * @author jeremy
 * The EmotionSpiderChart class represents a spider chart (aka radar chart or star chart) of all of the supported emotions.
 * 
 */

public class EmotionSpiderPlot {    
    private DefaultCategoryDataset data = new DefaultCategoryDataset();
    private SpiderWebPlot plot = new SpiderWebPlot(data);
    private EmotionData emotionData = new EmotionData();

    public EmotionSpiderPlot(EmotionData emotionData) {
	this.emotionData = emotionData;
	
	plot.setWebFilled(true);
	plot.setOutlineVisible(false);
	plot.setSeriesPaint(new RoundGradientPaint(375f, 375f, Color.BLACK, new Point2D.Double(150, 150), Color.RED));
	
	Integer row = new Integer(0);

	for (int i = 0; i < emotionData.size(); i ++) {	    
	    if (emotionData.getValue(i) != 0) {
		data.addValue(emotionData.getValue(i), row, Emotion.values()[i]);
	    }
	}
    }

    //returns the Emotion with highest index
    //if all are equal, return null
    public Emotion getStrongestEmotion() {
	//default to NEUTRAL
	Emotion strongest = null;

	int last = emotionData.getValue(0); 
	boolean allEqual = true;	
	for (int i : emotionData) {
	    if (emotionData.getValue(i) != last) {
		allEqual = false;
		if (emotionData.getValue(i) > last) {		    
		    strongest = Emotion.values()[i];
		    last = emotionData.getValue(i);
		}
	    }
	}

	if (allEqual) {
	    return null;
	} else {
	    return strongest;
	}
    }

    public void draw() throws IOException {
	BufferedImage img = new BufferedImage(750, 750, BufferedImage.TYPE_INT_RGB);
	plot.draw(img.createGraphics(), new Rectangle2D.Double(0, 0, 750, 750), null, new PlotState(), new PlotRenderingInfo(new ChartRenderingInfo()));

	File file = new File("newimage.png");
	ImageIO.write(img, "png", file);
    }

    @Override
    public String toString() {
	String out = "";

	for (Emotions.Emotion e: Emotions.Emotion.values()) {
	    out += e + ": " + emotionData.getValue(e.ordinal()) + "\n";
	}

	return out;
    }
}
