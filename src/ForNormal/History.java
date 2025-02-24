package ForNormal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import ForPlay.Playing;

public class History extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private JButton button_BackToMenu;

	History() {
		setBackground(Color.WHITE);
		Icon Back = new ImageIcon(getClass().getResource("Back.png"));
		button_BackToMenu = new JButton(Back);
		Icon BackClick = new ImageIcon(getClass().getResource("ClickBack.png"));
		button_BackToMenu.setRolloverIcon(BackClick);
		button_BackToMenu.addActionListener(this);
		if (MyFrame.number_Play > 5) {
			MyFrame.number_Play = 1;
		}

	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setFont(new Font("Serif", Font.BOLD, 100));
		g.drawString("History", 800, 100);
		g.setColor(new Color(81, 117, 194));
		g.fillRoundRect(25, 150, 1870, 130, 40, 40);
		g.setColor(new Color(245, 154, 35));
		g.fillRoundRect(25, 300, 1870, 130, 40, 40);
		g.setColor(new Color(32, 57, 110));
		g.fillRoundRect(25, 450, 1870, 130, 40, 40);
		g.setColor(new Color(245, 154, 35));
		g.fillRoundRect(25, 600, 1870, 130, 40, 40);
		g.setColor(new Color(107, 120, 146));
		g.fillRoundRect(25, 750, 1870, 130, 40, 40);

		if (!MyFrame.exist_History[4]) {
			if (!MyFrame.exist_History[3]) {
				if (!MyFrame.exist_History[2]) {
					if (!MyFrame.exist_History[1]) {
						if (!MyFrame.exist_History[0]) {

						} else {
							drawAtLine(g, 0, 1);
						}
					} else {
						drawAtLine(g, 1, 1);
						drawAtLine(g, 0, 2);
					}
				} else {
					drawAtLine(g, 2, 1);
					drawAtLine(g, 1, 2);
					drawAtLine(g, 0, 3);
				}
			} else {
				drawAtLine(g, 3, 1);
				drawAtLine(g, 2, 2);
				drawAtLine(g, 1, 3);
				drawAtLine(g, 0, 4);
			}
		} else {
			drawAtLine(g, 4, 1);
			drawAtLine(g, 3, 2);
			drawAtLine(g, 2, 3);
			drawAtLine(g, 1, 4);
			drawAtLine(g, 0, 5);

		}
		button_BackToMenu.setBounds(550, 920, 795, 100);
		add(button_BackToMenu);
	}

	public static void updateHistory() {
		if (MyFrame.exist_History[4]) {
			MyFrame.date_History[0] = MyFrame.date_History[1];
			MyFrame.date_History[1] = MyFrame.date_History[2];
			MyFrame.date_History[2] = MyFrame.date_History[3];
			MyFrame.date_History[3] = MyFrame.date_History[4];
			MyFrame.date_History[4] = Playing.date;

			MyFrame.score_History[0] = MyFrame.score_History[1];
			MyFrame.score_History[1] = MyFrame.score_History[2];
			MyFrame.score_History[2] = MyFrame.score_History[3];
			MyFrame.score_History[3] = MyFrame.score_History[4];
			MyFrame.score_History[4] = (int)(Playing.score_Current);

			MyFrame.accuracy_History[0] = MyFrame.accuracy_History[1];
			MyFrame.accuracy_History[1] = MyFrame.accuracy_History[2];
			MyFrame.accuracy_History[2] = MyFrame.accuracy_History[3];
			MyFrame.accuracy_History[3] = MyFrame.accuracy_History[4];
			MyFrame.accuracy_History[4] = Playing.accuracy_Current;

		} else {
			MyFrame.date_History[MyFrame.number_Play - 1] = Playing.date;
			MyFrame.score_History[MyFrame.number_Play - 1] = (int)(Playing.score_Current);
			MyFrame.accuracy_History[MyFrame.number_Play - 1] = Playing.accuracy_Current;
			MyFrame.exist_History[MyFrame.number_Play - 1] = true;
		}
	}

	private void drawAtLine(Graphics g, int n, int l) {	
		g.setColor(Color.WHITE);
		g.setFont(new Font("Serif", Font.ITALIC, 60));
		g.drawString("Score: " + MyFrame.score_History[n], 30, 250 + ((l - 1) * 150));
		g.drawString("Accuracy: " + String.format("%.2f", MyFrame.accuracy_History[n]) + " %", 600,
				250 + ((l - 1) * 150));
		g.drawString("" + MyFrame.date_History[n], 1280, 250 + ((l - 1) * 150));
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button_BackToMenu) {
			setVisible(false);
			MyFrame.addPanel(new MainMenu());
		}
	}
}
