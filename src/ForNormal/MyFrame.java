package ForNormal;

import java.awt.*;
import java.util.Date;

import javax.swing.*;

public class MyFrame{

	public static JFrame MAIN = new JFrame("Click Me If You Can");
	
	public static int score_Highest = 0;
	public static int score_New = 0;
	public static double accuracy_New = 0;
	
	public static int color_CrosshairR = 0;
	public static int color_CrosshairG = 0;
	public static int color_CrosshairB = 0;
	public static int color_CircleR = 62;
	public static int color_CircleG = 234;
	public static int color_CircleB = 32;
	
	public static Color color_Crosshair;
	public static Color color_Circle;
	public static Color color_PlayingBackground = Color.WHITE;
	
	public static int size_Dot = 0;
	public static int thickness_Cross = 3;
	public static int length_Cross = 6;
	public static int gap_Cross = 0;
	public static boolean choose_Cross = true;
	public static boolean choose_Circle = false;
	public static boolean custom_Circle = false;
	public static boolean custom_Crosshair = false;
	
	public static int number_Play = 0;
	
	public static Date [] date_History;
	public static int [] score_History;
	public static double [] accuracy_History;
	public static boolean []exist_History;
 
	public static void addPanel(JPanel panel) {
		MAIN.add(panel, BorderLayout.CENTER);
	}
}
