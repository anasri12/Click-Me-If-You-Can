package ForNormal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Date;
import javax.swing.JFrame;

public class RUN extends MyFrame{
	RUN(){
		super();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		color_Crosshair = new Color(color_CrosshairR,color_CrosshairG,color_CrosshairB);
		color_Circle = new Color(color_CircleR,color_CircleG,color_CircleB);
		
		date_History = new Date[5];
		
		exist_History = new boolean[5];
		exist_History[0] = false;
		exist_History[1] = false;
		exist_History[2] = false;
		exist_History[3] = false;
		exist_History[4] = false;
		
		score_History = new int[5];
		score_History[0] = 0;
		score_History[1] = 0;
		score_History[2] = 0;
		score_History[3] = 0;
		score_History[4] = 0;
		
		accuracy_History = new double[5];
		accuracy_History[0] = 0;
		accuracy_History[1] = 0;
		accuracy_History[2] = 0;
		accuracy_History[3] = 0;
		accuracy_History[4] = 0;
		
		MAIN.setLayout(new BorderLayout());
		MAIN.setExtendedState(JFrame.MAXIMIZED_BOTH);
		MAIN.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MAIN.setResizable(false);
		MAIN.setLocationRelativeTo(null);
		addPanel(new MainMenu());
		MAIN.setVisible(true);
		
	}

}
