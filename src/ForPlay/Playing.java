package ForPlay;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.MemoryImageSource;

import javax.swing.*;

import ForNormal.*;

import java.util.Random;
import java.util.Date;

public class Playing extends JPanel implements ActionListener, MouseListener, MouseMotionListener {
	/**
	 * 
	 */

	public static double score_Current = 0;
	public static double accuracy_Current = 0;
	public static Date date;

	private int x_Circle1, y_Circle1, x_Circle2, y_Circle2, x_Circle3, y_Circle3;
	private int r_Circle = 75;
	private int x_Current = 0;
	private int y_Current = 0;
	private int x_potential = 0;
	private int y_potential = 0;
	private int hit_Counter = 0;
	private int missed_Counter = 0;
	private int score_Streak = 0;
	private int sec_Timer = 0, milliSec_Timer = 0, sec_CountdownTimer = 59, sec_PrepareTimer = 3;
	private int x_Mouse, y_Mouse;

	private Timer time_GameStart = new Timer(1000, this);
	private Timer time_Playing = new Timer(1, this);

	protected boolean gamestart = false;

	private JButton button_BackToMenu;
	private JButton button_Restart;

	private Random random = new Random();

	private boolean hit_Circle1 = true, hit_Circle2 = true, hit_Circle3 = true;
	private boolean redraw_Circle1 = false, redraw_Circle2 = false, redraw_Circle3 = false;
	private boolean new_highscore = false;

	public Playing() {
		int[] pixels = new int[16 * 16];
		Image image = Toolkit.getDefaultToolkit().createImage(new MemoryImageSource(16, 16, pixels, 0, 16));
		Cursor transparentCursor = Toolkit.getDefaultToolkit().createCustomCursor(image, new Point(0, 0),
				"invisibleCursor");
		setCursor(transparentCursor);
		setBackground(Color.RED);
		score_Current = 0;
		accuracy_Current = 0;
		time_GameStart.start();

		Icon btm = new ImageIcon(getClass().getResource("BTM.png"));
		Icon btmClick = new ImageIcon(getClass().getResource("ClickBTM.png"));
		Icon restart = new ImageIcon(getClass().getResource("Restart.png"));
		Icon restartClick = new ImageIcon(getClass().getResource("ClickRestart.png"));

		button_BackToMenu = new JButton(btm);
		button_BackToMenu.setRolloverIcon(btmClick);
		button_Restart = new JButton(restart);
		button_Restart.setRolloverIcon(restartClick);

		button_BackToMenu.addActionListener(this);
		button_Restart.addActionListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (sec_PrepareTimer > 0) {
			if (sec_PrepareTimer == 2) {
				g.setColor(Color.BLACK);
			} else if (sec_PrepareTimer > 1) {
				g.setColor(Color.WHITE);
			} else {
				g.setColor(Color.BLUE);
			}
			g.setFont(new Font("Serif", Font.BOLD, 100));
			g.drawString("START IN " + sec_PrepareTimer, 720, 500);
			g.setFont(new Font("Serif", Font.ITALIC, 75));
			g.drawString("Right click to return.", 690, 800);
			g.drawString("If the game start ,right click will be your restart.", 270, 900);
		} else {
			time_GameStart.stop();
			time_Playing.start();
			gamestart = true;
			if (sec_CountdownTimer > 0) {
				setBackground(MyFrame.color_PlayingBackground);
				g.setFont(new Font("Serif", Font.BOLD, 70));
				if (MyFrame.color_PlayingBackground == Color.BLACK) {
					g.setColor(Color.WHITE);
				}
				g.drawString(sec_CountdownTimer + " S", 900, 100);
				g.setFont(new Font("Serif", Font.BOLD, 40));
				g.drawString("SCORE: " + (int)(score_Current), 30, 150);
				if (missed_Counter == 0 && score_Current > 0) {
					g.setColor(Color.BLUE);
				}
				g.drawString("ACCURACY: " + String.format("%.2f", accuracy_Current) + " %", 30, 100);
				if (MyFrame.color_PlayingBackground == Color.BLACK) {
					g.setColor(Color.WHITE);
				} else {
					g.setColor(Color.BLACK);
				}
				g.setFont(new Font("Serif", Font.BOLD, 40));
				if (new_highscore) {
					g.setColor(Color.RED);
					g.drawString("HIGHSCORE: " + MyFrame.score_Highest, 1500, 100);
				} else {
					g.drawString("HIGHSCORE: " + MyFrame.score_Highest, 1500, 100);
				}
				g.setColor(MyFrame.color_Circle);
				if (redraw_Circle1) {
					g.fillOval(x_Circle1 - r_Circle, y_Circle1 - r_Circle, 2 * r_Circle, 2 * r_Circle);
					redraw_Circle1 = false;
				} else if (!redraw_Circle1 && x_Circle1 != 0 && y_Circle1 != 0) {
					g.fillOval(x_Circle1 - r_Circle, y_Circle1 - r_Circle, 2 * r_Circle, 2 * r_Circle);
				}
				if (redraw_Circle2) {
					g.fillOval(x_Circle2 - r_Circle, y_Circle2 - r_Circle, 2 * r_Circle, 2 * r_Circle);
					redraw_Circle2 = false;
				} else if (!redraw_Circle2 && x_Circle2 != 0 && y_Circle2 != 0) {
					g.fillOval(x_Circle2 - r_Circle, y_Circle2 - r_Circle, 2 * r_Circle, 2 * r_Circle);
				}
				if (redraw_Circle3) {
					g.fillOval(x_Circle3 - r_Circle, y_Circle3 - r_Circle, 2 * r_Circle, 2 * r_Circle);
					redraw_Circle3 = false;
				} else if (!redraw_Circle3 && x_Circle3 != 0 && y_Circle3 != 0) {
					g.fillOval(x_Circle3 - r_Circle, y_Circle3 - r_Circle, 2 * r_Circle, 2 * r_Circle);
				}
				Crosshair(g);
			} else {
				if (getBackground() != Color.WHITE) {
					setBackground(Color.WHITE);
				} else {
					setCursor(Cursor.getDefaultCursor());
					time_Playing.stop();
					gamestart = false;
					date = new Date();
					button_BackToMenu.setBounds(400, 900, 300, 100);
					button_Restart.setBounds(1200, 900, 300, 100);
					add(button_BackToMenu);
					add(button_Restart);
					g.setFont(new Font("Serif", Font.BOLD, 80));
					g.drawString("RESULT", 800, 100);
					if (new_highscore) {
						g.setFont(new Font("Serif", Font.BOLD, 70));
						g.setColor(Color.RED);
						g.drawString("NEW HIGHSCORE!", 650, 240);
						new_highscore = false;
					}
					if (missed_Counter == 0 && score_Current > 0) {
						g.setFont(new Font("Serif", Font.BOLD, 60));
						g.setColor(Color.BLUE);
						g.drawString("PERFECT", 800, 880);
					}
					g.setFont(new Font("Serif", Font.ITALIC, 50));
					g.setColor(Color.BLACK);
					g.drawString("Your Score: " + (int)(score_Current), 730, 350);
					g.drawString("Your Accuracy: " + String.format("%.2f", accuracy_Current) + " %", 730, 450);
					g.drawString("Total Clicked: " + (hit_Counter + missed_Counter), 730, 550);
					g.drawString("Total Hit: " + hit_Counter, 730, 650);
					g.drawString("Total Missed: " + missed_Counter, 730, 750);
					MyFrame.number_Play += 1;
					History.updateHistory();
				}
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (gamestart) {
			milliSec_Timer += 1;
			if (MyFrame.score_Highest < score_Current) {
				MyFrame.score_Highest = (int)(score_Current);
				new_highscore = true;
			}
			if (Math.floor(milliSec_Timer / 75) > sec_Timer) {
				sec_Timer += 1;
				sec_CountdownTimer -= 1;
			}

			repaint();
		} else {
			sec_PrepareTimer -= 1;
			if (sec_PrepareTimer == 2) {
				setBackground(Color.YELLOW);
			} else if (sec_PrepareTimer == 1) {
				setBackground(Color.GREEN);
			}
			repaint();
		}
		if (e.getSource() == button_BackToMenu) {
			this.setVisible(false);
			MyFrame.addPanel(new MainMenu());
		} else if (e.getSource() == button_Restart) {
			this.setVisible(false);
			MyFrame.addPanel(new Playing());
		}

		if (score_Current < 0) {
			score_Current = 0;
			repaint();
		}
		if (hit_Circle1) {
			x_potential = 225 + random.nextInt(1450);
			y_potential = 275 + random.nextInt(600);
			if (calculateDistance(x_potential, y_potential, x_Circle1, y_Circle1) >= 4 * r_Circle
					&& calculateDistance(x_potential, y_potential, x_Circle2, y_Circle2) >= 4 * r_Circle
					&& calculateDistance(x_potential, y_potential, x_Circle3, y_Circle3) > 4 * r_Circle) {
				x_Circle1 = x_potential;
				y_Circle1 = y_potential;
				redraw_Circle1 = true;
				hit_Circle1 = false;
				repaint();
			}
		}
		if (hit_Circle2) {
			x_potential = 225 + random.nextInt(1450);
			y_potential = 275 + random.nextInt(600);
			if (calculateDistance(x_potential, y_potential, x_Circle1, y_Circle1) >= 4 * r_Circle
					&& calculateDistance(x_potential, y_potential, x_Circle2, y_Circle2) >= 4 * r_Circle
					&& calculateDistance(x_potential, y_potential, x_Circle3, y_Circle3) > 4 * r_Circle) {
				x_Circle2 = x_potential;
				y_Circle2 = y_potential;
				redraw_Circle2 = true;
				hit_Circle2 = false;
				repaint();
			}
		}
		if (hit_Circle3) {
			x_potential = 225 + random.nextInt(1450);
			y_potential = 275 + random.nextInt(600);
			if (calculateDistance(x_potential, y_potential, x_Circle1, y_Circle1) >= 4 * r_Circle
					&& calculateDistance(x_potential, y_potential, x_Circle2, y_Circle2) >= 4 * r_Circle
					&& calculateDistance(x_potential, y_potential, x_Circle3, y_Circle3) > 4 * r_Circle) {
				x_Circle3 = x_potential;
				y_Circle3 = y_potential;
				redraw_Circle3 = true;
				hit_Circle3 = false;
				repaint();
			}
		}

	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {
		if (gamestart) {
			if (e.getModifiersEx() == InputEvent.BUTTON1_DOWN_MASK) {
				x_Current = e.getX();
				y_Current = e.getY();
				if (calculateDistance(x_Current, y_Current, x_Circle1, y_Circle1) < r_Circle) {
					hit_Circle1 = true;
					hit_Counter += 1;
					score_Current += (r_Circle - calculateDistance(x_Current, y_Current, x_Circle1, y_Circle1)) * 20
							+ score_Streak * 10;
					score_Streak += 1;
					accuracy_Current = (hit_Counter * 100.0) / (double) (hit_Counter + missed_Counter);
					repaint();
				} else if (calculateDistance(x_Current, y_Current, x_Circle2, y_Circle2) < r_Circle) {
					hit_Circle2 = true;
					hit_Counter += 1;
					score_Current += (r_Circle - calculateDistance(x_Current, y_Current, x_Circle2, y_Circle2)) * 20
							+ score_Streak * 10;
					score_Streak += 1;
					accuracy_Current = (hit_Counter * 100.0) / (double) (hit_Counter + missed_Counter);
					repaint();
				} else if (calculateDistance(x_Current, y_Current, x_Circle3, y_Circle3) < r_Circle) {
					hit_Circle3 = true;
					hit_Counter += 1;
					score_Current += (r_Circle - calculateDistance(x_Current, y_Current, x_Circle3, y_Circle3)) * 20
							+ score_Streak * 10;
					score_Streak += 1;
					accuracy_Current = (hit_Counter * 100.0) / (double) (hit_Counter + missed_Counter);
				} else {
					if (score_Current >= 0 && gamestart) {
						missed_Counter += 1;
						if (MyFrame.score_Highest == score_Current) {
							score_Current -= 1000;
							MyFrame.score_Highest = (int)(score_Current);
						} else {
							score_Current -= 1000;
						}
						score_Streak = 0;

						accuracy_Current = (hit_Counter * 100.0) / (double) (hit_Counter + missed_Counter);
					}

				}
			} else if (e.getModifiersEx() == InputEvent.BUTTON3_DOWN_MASK) {
				if (MyFrame.score_Highest - score_Current == 0) {
					MyFrame.score_Highest = 0;
				}
				setVisible(false);
				MyFrame.addPanel(new Playing());
			}
		} else {
			if (e.getModifiersEx() == InputEvent.BUTTON3_DOWN_MASK) {
				setVisible(false);
				MyFrame.addPanel(new MainMenu());
			}
		}

	}

	public void mouseReleased(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public int calculateDistance(int x1, int y1, int x2, int y2) {
		return (int) Math.round(Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)));
	}

	public void mouseDragged(MouseEvent e) {
		if (gamestart) {
			x_Mouse = e.getX();
			y_Mouse = e.getY();
			repaint();
		}
	}

	public void mouseMoved(MouseEvent e) {
		if (gamestart) {
			x_Mouse = e.getX();
			y_Mouse = e.getY();
			repaint();
		}
	}

	public void Crosshair(Graphics g) {
		if (gamestart) {
			if (MyFrame.choose_Circle) {
				g.setColor(MyFrame.color_Crosshair);
				g.fillOval(x_Mouse - (MyFrame.size_Dot), y_Mouse - (MyFrame.size_Dot), (2 * MyFrame.size_Dot),
						(2 * MyFrame.size_Dot));
			}
			if (MyFrame.choose_Cross) {
				g.setColor(MyFrame.color_Crosshair);
				g.fillRect(x_Mouse - (3 * MyFrame.length_Cross) - (2 * MyFrame.gap_Cross),
						y_Mouse - MyFrame.thickness_Cross, 2 * MyFrame.length_Cross, 2 * MyFrame.thickness_Cross);
				g.fillRect(x_Mouse - MyFrame.thickness_Cross,
						y_Mouse - (3 * MyFrame.length_Cross) - (2 * MyFrame.gap_Cross), 2 * MyFrame.thickness_Cross,
						2 * MyFrame.length_Cross);
				g.fillRect(x_Mouse + MyFrame.length_Cross + (2 * MyFrame.gap_Cross),
						y_Mouse - (MyFrame.thickness_Cross), 2 * MyFrame.length_Cross, 2 * MyFrame.thickness_Cross);
				g.fillRect(x_Mouse - MyFrame.thickness_Cross, y_Mouse + MyFrame.length_Cross + (2 * MyFrame.gap_Cross),
						(2 * MyFrame.thickness_Cross), (2 * MyFrame.length_Cross));
			}
		}
	}

}
