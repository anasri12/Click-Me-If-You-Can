package ForNormal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Setting extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private JLabel label_Size = new JLabel("Size");
	private JLabel label_Thickness = new JLabel("Thickness");
	private JLabel label_Length = new JLabel("Length");
	private JLabel label_Gap = new JLabel("Gap");
	
	
	private JRadioButton radiobutton_Dot = new JRadioButton();
	private JButton button_DecreaseSize = new JButton("-");
	private JButton button_IncreaseSize = new JButton("+");

	private JRadioButton radiobutton_Cross = new JRadioButton();
	private JButton button_DecreaseThickness = new JButton("-");
	private JButton button_IncreaseThickness = new JButton("+");

	private JButton button_DecreaseLength = new JButton("-");
	private JButton button_IncreaseLength = new JButton("+");

	private JButton button_DecreaseGap = new JButton("-");
	private JButton button_IncreaseGap = new JButton("+");

	private JRadioButton radiobutton_CrosshairGreen = new JRadioButton("Green");
	private JRadioButton radiobutton_CrosshairRed = new JRadioButton("Red");
	private JRadioButton radiobutton_CrosshairViolet = new JRadioButton("Violet");
	private JRadioButton radiobutton_CrosshairCustom = new JRadioButton();

	private JRadioButton radiobutton_CrosshairBlue = new JRadioButton("Blue");
	private JRadioButton radiobutton_CrosshairOrange = new JRadioButton("Orange");
	private JRadioButton radiobutton_CrosshairCyan = new JRadioButton("Cyan");

	private JRadioButton radiobutton_CrosshairPurple = new JRadioButton("Purple");
	private JRadioButton radiobutton_CrosshairYellow = new JRadioButton("Yellow");
	private JRadioButton radiobutton_CrosshairBlack = new JRadioButton("Black");
	private ButtonGroup group_ColorCrosshair = new ButtonGroup();

	private JRadioButton radiobutton_CircleGreen = new JRadioButton("Green");
	private JRadioButton radiobutton_CircleRed = new JRadioButton("Red");
	private JRadioButton radiobutton_CircleViolet = new JRadioButton("Violet");

	private JRadioButton radiobutton_CircleBlue = new JRadioButton("Blue");
	private JRadioButton radiobutton_CircleOrange = new JRadioButton("Orange");
	private JRadioButton radiobutton_CircleCyan = new JRadioButton("Cyan");

	private JRadioButton radiobutton_CirclePurple = new JRadioButton("Purple");
	private JRadioButton radiobutton_CircleYellow = new JRadioButton("Yellow");
	private JRadioButton radiobutton_CircleCustom = new JRadioButton();
	private ButtonGroup group_ColorCircle = new ButtonGroup();

	private JRadioButton radiobutton_BackgroundBlack = new JRadioButton("Black");
	private JRadioButton radiobutton_BackgroundWhite = new JRadioButton("White");
	private ButtonGroup group_ColorBackground = new ButtonGroup();

	private JTextField textfield_CrosshairCustomR = new JTextField(3);
	private JTextField textfield_CrosshairCustomG = new JTextField(3);
	private JTextField textfield_CrosshairCustomB = new JTextField(3);

	private JTextField textfield_CircleCustomR = new JTextField(3);
	private JTextField textfield_CircleCustomG = new JTextField(3);
	private JTextField textfield_CircleCustomB = new JTextField(3);

	private JButton button_back;

	private JButton button_getCircleColor = new JButton("Get");
	private JButton button_getCrosshairColor = new JButton("Get");

	private int xcenter_ShowCrosshair = 1200, ycenter_ShowCrosshair = 215;

	Setting() {
		group_ColorBackground.add(radiobutton_BackgroundBlack);
		group_ColorBackground.add(radiobutton_BackgroundWhite);

		group_ColorCircle.add(radiobutton_CircleBlue);
		group_ColorCircle.add(radiobutton_CircleCustom);
		group_ColorCircle.add(radiobutton_CircleCyan);
		group_ColorCircle.add(radiobutton_CircleGreen);
		group_ColorCircle.add(radiobutton_CircleOrange);
		group_ColorCircle.add(radiobutton_CirclePurple);
		group_ColorCircle.add(radiobutton_CircleRed);
		group_ColorCircle.add(radiobutton_CircleViolet);
		group_ColorCircle.add(radiobutton_CircleYellow);

		group_ColorCrosshair.add(radiobutton_CrosshairBlack);
		group_ColorCrosshair.add(radiobutton_CrosshairBlue);
		group_ColorCrosshair.add(radiobutton_CrosshairCustom);
		group_ColorCrosshair.add(radiobutton_CrosshairCyan);
		group_ColorCrosshair.add(radiobutton_CrosshairGreen);
		group_ColorCrosshair.add(radiobutton_CrosshairOrange);
		group_ColorCrosshair.add(radiobutton_CrosshairPurple);
		group_ColorCrosshair.add(radiobutton_CrosshairRed);
		group_ColorCrosshair.add(radiobutton_CrosshairViolet);
		group_ColorCrosshair.add(radiobutton_CrosshairYellow);

		Icon Backtomenu = new ImageIcon(getClass().getResource("BTM.png"));
		Icon ClickBacktomenu = new ImageIcon(getClass().getResource("ClickBTM.png"));
		button_back = new JButton(Backtomenu);
		button_back.setRolloverIcon(ClickBacktomenu);

		button_back.addActionListener(this);
		button_DecreaseGap.addActionListener(this);
		button_DecreaseLength.addActionListener(this);
		button_DecreaseSize.addActionListener(this);
		button_DecreaseThickness.addActionListener(this);
		button_IncreaseGap.addActionListener(this);
		button_IncreaseLength.addActionListener(this);
		button_IncreaseSize.addActionListener(this);
		button_IncreaseThickness.addActionListener(this);

		button_getCircleColor.addActionListener(this);
		button_getCrosshairColor.addActionListener(this);

		radiobutton_BackgroundBlack.addActionListener(this);
		radiobutton_BackgroundWhite.addActionListener(this);
		radiobutton_CircleBlue.addActionListener(this);
		radiobutton_CircleCustom.addActionListener(this);
		radiobutton_CircleCyan.addActionListener(this);
		radiobutton_CircleGreen.addActionListener(this);
		radiobutton_CircleOrange.addActionListener(this);
		radiobutton_CirclePurple.addActionListener(this);
		radiobutton_CircleRed.addActionListener(this);
		radiobutton_CircleViolet.addActionListener(this);
		radiobutton_CircleYellow.addActionListener(this);
		radiobutton_Dot.addActionListener(this);
		radiobutton_Cross.addActionListener(this);
		radiobutton_CrosshairBlack.addActionListener(this);
		radiobutton_CrosshairBlue.addActionListener(this);
		radiobutton_CrosshairCustom.addActionListener(this);
		radiobutton_CrosshairCyan.addActionListener(this);
		radiobutton_CrosshairGreen.addActionListener(this);
		radiobutton_CrosshairOrange.addActionListener(this);
		radiobutton_CrosshairPurple.addActionListener(this);
		radiobutton_CrosshairRed.addActionListener(this);
		radiobutton_CrosshairViolet.addActionListener(this);
		radiobutton_CrosshairYellow.addActionListener(this);

		if (!MyFrame.custom_Circle) {
			textfield_CircleCustomR.setText("            " + "Red");
			textfield_CircleCustomG.setText("           " + "Green");
			textfield_CircleCustomB.setText("            " + "Blue");
		}

		if (!MyFrame.custom_Crosshair) {
			textfield_CrosshairCustomR.setText("            " + "Red");
			textfield_CrosshairCustomG.setText("           " + "Green");
			textfield_CrosshairCustomB.setText("            " + "Blue");
		}
		textfield_CircleCustomR.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char input = e.getKeyChar();
				if ((input < '0' || input > '9') && input != '\b') {
					e.consume();
				}
			}
		});

		textfield_CircleCustomG.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char input = e.getKeyChar();
				if ((input < '0' || input > '9') && input != '\b') {
					e.consume();
				}
			}
		});
		
		textfield_CircleCustomB.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char input = e.getKeyChar();
				if ((input < '0' || input > '9') && input != '\b') {
					e.consume();
				}
			}
		});

		textfield_CrosshairCustomR.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char input = e.getKeyChar();
				if ((input < '0' || input > '9') && input != '\b') {
					e.consume();
				}
			}
		});

		textfield_CrosshairCustomG.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char input = e.getKeyChar();
				if ((input < '0' || input > '9') && input != '\b') {
					e.consume();
				}
			}
		});

		textfield_CrosshairCustomB.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char input = e.getKeyChar();
				if ((input < '0' || input > '9') && input != '\b') {
					e.consume();
				}
			}
		});

	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		button_getCrosshairColor.setBounds(1440, 485, 100, 35);
		add(button_getCrosshairColor);
		button_getCircleColor.setBounds(1140, 795, 100, 35);
		add(button_getCircleColor);
		if (MyFrame.custom_Circle) {
			button_getCircleColor.setVisible(true);
		} else {
			button_getCircleColor.setVisible(false);
		}
		if (MyFrame.custom_Crosshair) {
			button_getCrosshairColor.setVisible(true);
		} else {
			button_getCrosshairColor.setVisible(false);
		}

		if ((MyFrame.color_CrosshairR >= 0 && MyFrame.color_CrosshairR <= 255)
				&& (MyFrame.color_CrosshairG >= 0 && MyFrame.color_CrosshairG <= 255)
				&& (MyFrame.color_CrosshairB >= 0 && MyFrame.color_CrosshairB <= 255)) {
			MyFrame.color_Crosshair = new Color(MyFrame.color_CrosshairR, MyFrame.color_CrosshairG,
					MyFrame.color_CrosshairB);
		}
		if ((MyFrame.color_CircleR >= 0 && MyFrame.color_CircleR <= 255)
				&& (MyFrame.color_CircleG >= 0 && MyFrame.color_CircleG <= 255)
				&& (MyFrame.color_CircleB >= 0 && MyFrame.color_CircleB <= 255)) {
			MyFrame.color_Circle = new Color(MyFrame.color_CircleR, MyFrame.color_CircleG, MyFrame.color_CircleB);
		}
		g.setFont(new Font("Serif", Font.ITALIC, 50));
		g.drawString("Crosshair Style", 30, 60);
		radiobutton_Dot.setBounds(30, 110, 20, 20);
		if (MyFrame.choose_Circle) {
			radiobutton_Dot.setSelected(true);
		}
		add(radiobutton_Dot);
		g.fillOval(75, 115, 10, 10);
		g.setFont(new Font("Serif", Font.ITALIC, 30));
		label_Size.setBounds(120,100,100,50);
		label_Size.setFont(new Font("Serif", Font.ITALIC, 20));
		add(label_Size);
		button_DecreaseSize.setBounds(270, 100, 45, 45);
		add(button_DecreaseSize);
		g.drawString("" + MyFrame.size_Dot, 325, 130);
		button_IncreaseSize.setBounds(360, 100, 45, 45);
		add(button_IncreaseSize);

		radiobutton_Cross.setBounds(30, 180, 20, 20);
		if (MyFrame.choose_Cross) {
			radiobutton_Cross.setSelected(true);
		}
		add(radiobutton_Cross);
		label_Thickness.setBounds(120,170,100,50);
		label_Thickness.setFont(new Font("Serif", Font.ITALIC, 20));
		add(label_Thickness);
		g.fillRect(80 - (3 * 6) - (2 * 0), 190 - 3, 2 * 6, 2 * 3);
		g.fillRect(80 - 3, 190 - (3 * 6) - (2 * 0), 2 * 3, 2 * 6);
		g.fillRect(80 + 6 + (2 * 0), 190 - (3), 2 * 6, 2 * 3);
		g.fillRect(80 - 3, 190 + 6 + (2 * 0), (2 * 3), (2 * 6));
		button_DecreaseThickness.setBounds(270, 170, 45, 45);
		add(button_DecreaseThickness);
		g.drawString("" + MyFrame.thickness_Cross, 325, 200);
		button_IncreaseThickness.setBounds(360, 170, 45, 45);
		add(button_IncreaseThickness);
		label_Length.setBounds(445,170,100,50);
		label_Length.setFont(new Font("Serif", Font.ITALIC, 20));
		add(label_Length);
		button_DecreaseLength.setBounds(555, 170, 45, 45);
		add(button_DecreaseLength);
		g.drawString("" + MyFrame.length_Cross, 605, 200);
		button_IncreaseLength.setBounds(640, 170, 45, 45);
		add(button_IncreaseLength);
		label_Gap.setBounds(720,170,100,50);
		label_Gap.setFont(new Font("Serif", Font.ITALIC, 20));
		add(label_Gap);
		button_DecreaseGap.setBounds(790, 170, 45, 45);
		add(button_DecreaseGap);
		g.drawString("" + MyFrame.gap_Cross, 840, 200);
		button_IncreaseGap.setBounds(875, 170, 45, 45);
		add(button_IncreaseGap);

		g.setFont(new Font("Serif", Font.ITALIC, 50));
		g.drawString("Crosshair Color", 30, 300);

		radiobutton_CrosshairGreen.setBounds(30, 350, 20, 20);
		if (MyFrame.color_CrosshairR == 62 && MyFrame.color_CrosshairG == 234 && MyFrame.color_CrosshairB == 32) {
			radiobutton_CrosshairGreen.setSelected(true);
		}
		add(radiobutton_CrosshairGreen);
		g.setColor(new Color(62, 234, 32));
		g.fillRoundRect(60, 340, 100, 35, 15, 15);
		radiobutton_CrosshairRed.setBounds(330, 350, 20, 20);
		if (MyFrame.color_CrosshairR == 234 && MyFrame.color_CrosshairG == 13 && MyFrame.color_CrosshairB == 2) {
			radiobutton_CrosshairRed.setSelected(true);
		}
		add(radiobutton_CrosshairRed);
		g.setColor(new Color(234, 13, 2));
		g.fillRoundRect(360, 340, 100, 35, 15, 15);
		radiobutton_CrosshairViolet.setBounds(630, 350, 20, 20);
		if (MyFrame.color_CrosshairR == 234 && MyFrame.color_CrosshairG == 2 && MyFrame.color_CrosshairB == 124) {
			radiobutton_CrosshairViolet.setSelected(true);
		}
		add(radiobutton_CrosshairViolet);
		g.setColor(new Color(234, 2, 124));
		g.fillRoundRect(660, 340, 100, 35, 15, 15);
		radiobutton_CrosshairCustom.setBounds(930, 490, 20, 20);
		if (MyFrame.custom_Crosshair) {
			radiobutton_CrosshairCustom.setSelected(true);
			textfield_CrosshairCustomR.setText(""+MyFrame.color_CrosshairR);
			textfield_CrosshairCustomG.setText(""+MyFrame.color_CrosshairG);
			textfield_CrosshairCustomB.setText(""+MyFrame.color_CrosshairB);
		}
		add(radiobutton_CrosshairCustom);
		g.setFont(new Font("Serif", Font.ITALIC, 30));
		g.setColor(Color.BLACK);
		g.drawString("Custom", 960, 510);
		textfield_CrosshairCustomR.setBounds(1080, 485, 100, 35);
		add(textfield_CrosshairCustomR);
		textfield_CrosshairCustomG.setBounds(1200, 485, 100, 35);
		add(textfield_CrosshairCustomG);
		textfield_CrosshairCustomB.setBounds(1320, 485, 100, 35);
		add(textfield_CrosshairCustomB);
		if (MyFrame.custom_Crosshair) {
			textfield_CrosshairCustomR.setEditable(true);
			textfield_CrosshairCustomG.setEditable(true);
			textfield_CrosshairCustomB.setEditable(true);
		} else {
			textfield_CrosshairCustomR.setEditable(false);
			textfield_CrosshairCustomG.setEditable(false);
			textfield_CrosshairCustomB.setEditable(false);
		}

		radiobutton_CrosshairBlue.setBounds(30, 420, 20, 20);
		if (MyFrame.color_CrosshairR == 4 && MyFrame.color_CrosshairG == 1 && MyFrame.color_CrosshairB == 230) {
			radiobutton_CrosshairBlue.setSelected(true);
		}
		add(radiobutton_CrosshairBlue);
		g.setColor(new Color(4, 1, 230));
		g.fillRoundRect(60, 410, 100, 35, 15, 15);
		radiobutton_CrosshairOrange.setBounds(330, 420, 20, 20);
		if (MyFrame.color_CrosshairR == 234 && MyFrame.color_CrosshairG == 88 && MyFrame.color_CrosshairB == 2) {
			radiobutton_CrosshairOrange.setSelected(true);
		}
		add(radiobutton_CrosshairOrange);
		g.setColor(new Color(234, 88, 2));
		g.fillRoundRect(360, 410, 100, 35, 15, 15);
		radiobutton_CrosshairCyan.setBounds(630, 420, 20, 20);
		if (MyFrame.color_CrosshairR == 2 && MyFrame.color_CrosshairG == 237 && MyFrame.color_CrosshairB == 234) {
			radiobutton_CrosshairCyan.setSelected(true);
		}
		add(radiobutton_CrosshairCyan);
		g.setColor(new Color(2, 237, 234));
		g.fillRoundRect(660, 410, 100, 35, 15, 15);

		radiobutton_CrosshairPurple.setBounds(30, 490, 20, 20);
		if (MyFrame.color_CrosshairR == 163 && MyFrame.color_CrosshairG == 1 && MyFrame.color_CrosshairB == 230) {
			radiobutton_CrosshairPurple.setSelected(true);
		}
		add(radiobutton_CrosshairPurple);
		g.setColor(new Color(163, 1, 230));
		g.fillRoundRect(60, 480, 100, 35, 15, 15);
		radiobutton_CrosshairYellow.setBounds(330, 490, 20, 20);
		if (MyFrame.color_CrosshairR == 234 && MyFrame.color_CrosshairG == 190 && MyFrame.color_CrosshairB == 2) {
			radiobutton_CrosshairYellow.setSelected(true);
		}
		add(radiobutton_CrosshairYellow);
		g.setColor(new Color(234, 190, 2));
		g.fillRoundRect(360, 480, 100, 35, 15, 15);
		radiobutton_CrosshairBlack.setBounds(630, 490, 20, 20);
		if (MyFrame.color_CrosshairR == 0 && MyFrame.color_CrosshairG == 0 && MyFrame.color_CrosshairB == 0) {
			radiobutton_CrosshairBlack.setSelected(true);
		}
		add(radiobutton_CrosshairBlack);
		g.setColor(new Color(0, 0, 0));
		g.fillRoundRect(660, 480, 100, 35, 15, 15);

		g.setFont(new Font("Serif", Font.ITALIC, 50));
		g.drawString("Circle Color", 30, 610);

		radiobutton_CircleGreen.setBounds(30, 660, 20, 20);
		if (MyFrame.color_CircleR == 62 && MyFrame.color_CircleG == 234 && MyFrame.color_CircleB == 32) {
			radiobutton_CircleGreen.setSelected(true);
		}
		add(radiobutton_CircleGreen);
		g.setColor(new Color(62, 234, 32));
		g.fillRoundRect(60, 650, 100, 35, 15, 15);
		radiobutton_CircleRed.setBounds(330, 660, 20, 20);
		if (MyFrame.color_CircleR == 234 && MyFrame.color_CircleG == 13 && MyFrame.color_CircleB == 2) {
			radiobutton_CircleRed.setSelected(true);
		}
		add(radiobutton_CircleRed);
		g.setColor(new Color(234, 13, 2));
		g.fillRoundRect(360, 650, 100, 35, 15, 15);
		radiobutton_CircleViolet.setBounds(630, 660, 20, 20);
		if (MyFrame.color_CircleR == 234 && MyFrame.color_CircleG == 2 && MyFrame.color_CircleB == 124) {
			radiobutton_CircleViolet.setSelected(true);
		}
		add(radiobutton_CircleViolet);
		g.setColor(new Color(234, 2, 124));
		g.fillRoundRect(660, 650, 100, 35, 15, 15);

		radiobutton_CircleBlue.setBounds(30, 730, 20, 20);
		if ((MyFrame.color_CircleR == 4 && MyFrame.color_CircleG == 1 && MyFrame.color_CircleB == 230)) {
			radiobutton_CircleBlue.setSelected(true);
		}
		add(radiobutton_CircleBlue);
		g.setColor(new Color(4, 1, 230));
		g.fillRoundRect(60, 720, 100, 35, 15, 15);
		radiobutton_CircleOrange.setBounds(330, 730, 20, 20);
		if (MyFrame.color_CircleR == 234 && MyFrame.color_CircleG == 88 && MyFrame.color_CircleB == 2) {
			radiobutton_CircleOrange.setSelected(true);
		}
		add(radiobutton_CircleOrange);
		g.setColor(new Color(234, 88, 2));
		g.fillRoundRect(360, 720, 100, 35, 15, 15);
		radiobutton_CircleCyan.setBounds(630, 730, 20, 20);
		if (MyFrame.color_CircleR == 2 && MyFrame.color_CircleG == 237 && MyFrame.color_CircleB == 234) {
			radiobutton_CircleCyan.setSelected(true);
		}
		add(radiobutton_CircleCyan);
		g.setColor(new Color(2, 237, 234));
		g.fillRoundRect(660, 720, 100, 35, 15, 15);

		radiobutton_CirclePurple.setBounds(30, 800, 20, 20);
		if (MyFrame.color_CircleR == 163 && MyFrame.color_CircleG == 1 && MyFrame.color_CircleB == 230) {
			radiobutton_CirclePurple.setSelected(true);
		}
		add(radiobutton_CirclePurple);
		g.setColor(new Color(163, 1, 230));
		g.fillRoundRect(60, 790, 100, 35, 15, 15);
		radiobutton_CircleYellow.setBounds(330, 800, 20, 20);
		if (MyFrame.color_CircleR == 234 && MyFrame.color_CircleG == 190 && MyFrame.color_CircleB == 2) {
			radiobutton_CircleYellow.setSelected(true);
		}
		add(radiobutton_CircleYellow);
		g.setColor(new Color(234, 190, 2));
		g.fillRoundRect(360, 790, 100, 35, 15, 15);
		radiobutton_CircleCustom.setBounds(630, 800, 20, 20);
		if (MyFrame.custom_Circle) {
			radiobutton_CircleCustom.setSelected(true);
			textfield_CircleCustomR.setText(""+MyFrame.color_CircleR);
			textfield_CircleCustomG.setText(""+MyFrame.color_CircleG);
			textfield_CircleCustomB.setText(""+MyFrame.color_CircleB);
		}
		add(radiobutton_CircleCustom);
		g.setFont(new Font("Serif", Font.ITALIC, 30));
		g.setColor(Color.BLACK);
		g.drawString("Custom", 660, 820);
		textfield_CircleCustomR.setBounds(780, 795, 100, 35);
		add(textfield_CircleCustomR);
		textfield_CircleCustomG.setBounds(900, 795, 100, 35);
		add(textfield_CircleCustomG);
		textfield_CircleCustomB.setBounds(1020, 795, 100, 35);
		add(textfield_CircleCustomB);
		if (MyFrame.custom_Circle) {
			textfield_CircleCustomR.setEditable(true);
			textfield_CircleCustomG.setEditable(true);
			textfield_CircleCustomB.setEditable(true);
		} else {
			textfield_CircleCustomR.setEditable(false);
			textfield_CircleCustomG.setEditable(false);
			textfield_CircleCustomB.setEditable(false);

		}

		g.setFont(new Font("Serif", Font.ITALIC, 50));
		g.drawString("Background Color", 30, 920);

		g.setFont(new Font("Serif", Font.ITALIC, 30));
		if (MyFrame.color_PlayingBackground == Color.BLACK) {
			radiobutton_BackgroundBlack.setSelected(true);
		}
		radiobutton_BackgroundBlack.setBounds(30, 970, 20, 20);
		g.drawString("Black", 65, 990);
		add(radiobutton_BackgroundBlack);

		if (MyFrame.color_PlayingBackground == Color.WHITE) {
			radiobutton_BackgroundWhite.setSelected(true);
		}
		radiobutton_BackgroundWhite.setBounds(330, 970, 20, 20);
		g.drawString("White", 365, 990);
		add(radiobutton_BackgroundWhite);

		button_back.setBounds(1400, 900, 300, 100);
		add(button_back);

		if (MyFrame.color_PlayingBackground == Color.BLACK) {
			g.setColor(MyFrame.color_Circle);
			g.fillRect(995, 25, 410, 410);
			g.setColor(Color.BLACK);
			g.fillRect(1000, 30, 400, 400);
		} else {
			g.setColor(MyFrame.color_Circle);
			g.fillRect(995, 25, 410, 410);
			g.setColor(Color.WHITE);
			g.fillRect(1000, 30, 400, 400);
		}
		g.setColor(MyFrame.color_Circle);
		g.fillOval(xcenter_ShowCrosshair - 75, ycenter_ShowCrosshair - 75, 150, 150);
		if (MyFrame.choose_Circle) {
			g.setColor(MyFrame.color_Crosshair);
			g.fillOval(xcenter_ShowCrosshair - (MyFrame.size_Dot), ycenter_ShowCrosshair - (MyFrame.size_Dot),
					(2 * MyFrame.size_Dot), (2 * MyFrame.size_Dot));
		}
		if (MyFrame.choose_Cross) {
			g.setColor(MyFrame.color_Crosshair);
			g.fillRect(xcenter_ShowCrosshair - (3 * MyFrame.length_Cross) - (2 * MyFrame.gap_Cross),
					ycenter_ShowCrosshair - MyFrame.thickness_Cross, 2 * MyFrame.length_Cross,
					2 * MyFrame.thickness_Cross);
			g.fillRect(xcenter_ShowCrosshair - MyFrame.thickness_Cross,
					ycenter_ShowCrosshair - (3 * MyFrame.length_Cross) - (2 * MyFrame.gap_Cross),
					2 * MyFrame.thickness_Cross, 2 * MyFrame.length_Cross);
			g.fillRect(xcenter_ShowCrosshair + MyFrame.length_Cross + (2 * MyFrame.gap_Cross),
					ycenter_ShowCrosshair - (MyFrame.thickness_Cross), 2 * MyFrame.length_Cross,
					2 * MyFrame.thickness_Cross);
			g.fillRect(xcenter_ShowCrosshair - MyFrame.thickness_Cross,
					ycenter_ShowCrosshair + MyFrame.length_Cross + (2 * MyFrame.gap_Cross),
					(2 * MyFrame.thickness_Cross), (2 * MyFrame.length_Cross));
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button_back) {
			setVisible(false);
			MyFrame.addPanel(new MainMenu());
		} else if (e.getSource() == radiobutton_BackgroundBlack) {
			MyFrame.color_PlayingBackground = Color.BLACK;
			repaint();
		} else if (e.getSource() == radiobutton_BackgroundWhite) {
			MyFrame.color_PlayingBackground = Color.WHITE;
			repaint();
		} else if (e.getSource() == radiobutton_CircleGreen) {
			MyFrame.color_CircleR = 62;
			MyFrame.color_CircleG = 234;
			MyFrame.color_CircleB = 32;
			MyFrame.custom_Circle = false;
			repaint();
		} else if (e.getSource() == radiobutton_CircleRed) {
			MyFrame.color_CircleR = 234;
			MyFrame.color_CircleG = 13;
			MyFrame.color_CircleB = 2;
			MyFrame.custom_Circle = false;
			repaint();
		} else if (e.getSource() == radiobutton_CircleViolet) {
			MyFrame.color_CircleR = 234;
			MyFrame.color_CircleG = 2;
			MyFrame.color_CircleB = 124;
			MyFrame.custom_Circle = false;
			repaint();
		} else if (e.getSource() == radiobutton_CircleBlue) {
			MyFrame.color_CircleR = 4;
			MyFrame.color_CircleG = 1;
			MyFrame.color_CircleB = 230;
			MyFrame.custom_Circle = false;
			repaint();
		} else if (e.getSource() == radiobutton_CircleOrange) {
			MyFrame.color_CircleR = 234;
			MyFrame.color_CircleG = 88;
			MyFrame.color_CircleB = 2;
			MyFrame.custom_Circle = false;
			repaint();
		} else if (e.getSource() == radiobutton_CircleCyan) {
			MyFrame.color_CircleR = 2;
			MyFrame.color_CircleG = 237;
			MyFrame.color_CircleB = 234;
			MyFrame.custom_Circle = false;
			repaint();
		} else if (e.getSource() == radiobutton_CirclePurple) {
			MyFrame.color_CircleR = 163;
			MyFrame.color_CircleG = 1;
			MyFrame.color_CircleB = 230;
			MyFrame.custom_Circle = false;
			repaint();
		} else if (e.getSource() == radiobutton_CircleYellow) {
			MyFrame.color_CircleR = 234;
			MyFrame.color_CircleG = 190;
			MyFrame.color_CircleB = 2;
			MyFrame.custom_Circle = false;
			repaint();
		} else if (e.getSource() == radiobutton_CircleGreen) {
			MyFrame.color_CircleR = 0;
			MyFrame.color_CircleG = 0;
			MyFrame.color_CircleB = 0;
			MyFrame.custom_Circle = false;
			repaint();
		} else if (e.getSource() == radiobutton_CircleCustom) {
			MyFrame.color_CircleR = 234;
			MyFrame.color_CircleG = 234;
			MyFrame.color_CircleB = 234;
			MyFrame.custom_Circle = true;
			textfield_CircleCustomR.setText("");
			textfield_CircleCustomG.setText("");
			textfield_CircleCustomB.setText("");
			repaint();

		} else if (e.getSource() == radiobutton_CrosshairGreen) {
			MyFrame.color_CrosshairR = 62;
			MyFrame.color_CrosshairG = 234;
			MyFrame.color_CrosshairB = 32;
			MyFrame.custom_Crosshair = false;
			repaint();
		} else if (e.getSource() == radiobutton_CrosshairRed) {
			MyFrame.color_CrosshairR = 234;
			MyFrame.color_CrosshairG = 13;
			MyFrame.color_CrosshairB = 2;
			MyFrame.custom_Crosshair = false;
			repaint();
		} else if (e.getSource() == radiobutton_CrosshairViolet) {
			MyFrame.color_CrosshairR = 234;
			MyFrame.color_CrosshairG = 2;
			MyFrame.color_CrosshairB = 124;
			MyFrame.custom_Crosshair = false;
			repaint();
		} else if (e.getSource() == radiobutton_CrosshairBlue) {
			MyFrame.color_CrosshairR = 4;
			MyFrame.color_CrosshairG = 1;
			MyFrame.color_CrosshairB = 230;
			MyFrame.custom_Crosshair = false;
			repaint();
		} else if (e.getSource() == radiobutton_CrosshairOrange) {
			MyFrame.color_CrosshairR = 234;
			MyFrame.color_CrosshairG = 88;
			MyFrame.color_CrosshairB = 2;
			MyFrame.custom_Crosshair = false;
			repaint();
		} else if (e.getSource() == radiobutton_CrosshairCyan) {
			MyFrame.color_CrosshairR = 2;
			MyFrame.color_CrosshairG = 237;
			MyFrame.color_CrosshairB = 234;
			MyFrame.custom_Crosshair = false;
			repaint();
		} else if (e.getSource() == radiobutton_CrosshairPurple) {
			MyFrame.color_CrosshairR = 163;
			MyFrame.color_CrosshairG = 1;
			MyFrame.color_CrosshairB = 230;
			MyFrame.custom_Crosshair = false;
			repaint();
		} else if (e.getSource() == radiobutton_CrosshairYellow) {
			MyFrame.color_CrosshairR = 234;
			MyFrame.color_CrosshairG = 190;
			MyFrame.color_CrosshairB = 2;
			MyFrame.custom_Crosshair = false;
			repaint();

		} else if (e.getSource() == radiobutton_CrosshairBlack) {
			MyFrame.color_CrosshairR = 0;
			MyFrame.color_CrosshairG = 0;
			MyFrame.color_CrosshairB = 0;
			MyFrame.custom_Crosshair = false;
			repaint();
		} else if (e.getSource() == radiobutton_CrosshairCustom) {
			MyFrame.color_CrosshairR = 234;
			MyFrame.color_CrosshairG = 234;
			MyFrame.color_CrosshairB = 234;
			MyFrame.custom_Crosshair = true;
			textfield_CrosshairCustomR.setText("");
			textfield_CrosshairCustomG.setText("");
			textfield_CrosshairCustomB.setText("");
			repaint();
		} else if (e.getSource() == radiobutton_Dot) {
			if (radiobutton_Dot.isSelected()) {
				MyFrame.choose_Circle = true;
			} else {
				MyFrame.choose_Circle = false;
			}
			repaint();
		} else if (e.getSource() == radiobutton_Cross) {
			if (radiobutton_Cross.isSelected()) {
				MyFrame.choose_Cross = true;
			} else {
				MyFrame.choose_Cross = false;
			}
			repaint();
		} else if (e.getSource() == button_DecreaseSize) {
			if (radiobutton_Dot.isSelected() && MyFrame.size_Dot > 0) {
				MyFrame.size_Dot -= 1;
				repaint();
			}
		} else if (e.getSource() == button_DecreaseThickness) {
			if (radiobutton_Cross.isSelected() && MyFrame.thickness_Cross > 0) {
				MyFrame.thickness_Cross -= 1;
				repaint();
			}
		} else if (e.getSource() == button_DecreaseLength) {
			if (radiobutton_Cross.isSelected() && MyFrame.length_Cross > 0) {
				MyFrame.length_Cross -= 1;
				repaint();
			}
		} else if (e.getSource() == button_DecreaseGap) {
			if (radiobutton_Cross.isSelected()) {
				MyFrame.gap_Cross -= 1;
				repaint();
			}
		} else if (e.getSource() == button_IncreaseSize) {
			if (radiobutton_Dot.isSelected()) {
				MyFrame.size_Dot += 1;
				repaint();
			}
		} else if (e.getSource() == button_IncreaseThickness) {
			if (radiobutton_Cross.isSelected()) {
				MyFrame.thickness_Cross += 1;
				repaint();
			}
		} else if (e.getSource() == button_IncreaseLength) {
			if (radiobutton_Cross.isSelected()) {
				MyFrame.length_Cross += 1;
				repaint();
			}
		} else if (e.getSource() == button_IncreaseGap) {
			if (radiobutton_Cross.isSelected()) {
				MyFrame.gap_Cross += 1;
				repaint();
			}
		} else if (e.getSource() == button_getCircleColor) {
			MyFrame.color_CircleR = Integer.parseInt(textfield_CircleCustomR.getText());
			MyFrame.color_CircleG = Integer.parseInt(textfield_CircleCustomG.getText());
			MyFrame.color_CircleB = Integer.parseInt(textfield_CircleCustomB.getText());
			repaint();
		} else if (e.getSource() == button_getCrosshairColor) {
			MyFrame.color_CrosshairR = Integer.parseInt(textfield_CrosshairCustomR.getText());
			MyFrame.color_CrosshairG = Integer.parseInt(textfield_CrosshairCustomG.getText());
			MyFrame.color_CrosshairB = Integer.parseInt(textfield_CrosshairCustomB.getText());
			repaint();
		}

	}

}
