package ForNormal;

import ForPlay.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainMenu extends JPanel implements ActionListener {
	/**
	 * 
	 */
	
	private JPanel panel_Sub = new JPanel(new GridLayout(4, 1));
	private JButton button_Play = new JButton("PLAY");
	private JButton button_Setting = new JButton("SETTING");
	private JButton button_History = new JButton("HISTORY");
	private JButton button_Quit = new JButton("QUIT");
	
	public MainMenu() {
		setLayout(new GridLayout(3, 3));

		for (int i = 1; i < 10; i++) {
			if (i == 5) {
				add(panel_Sub);
			} else {
				add(new Panel());
			}

		}
		setBackground(Color.WHITE);
		
		Icon Play =	new ImageIcon(getClass().getResource("Play.png"));
		Icon PlayClick =new ImageIcon(getClass().getResource("ClickPlay.png"));
		Icon Setting =	new ImageIcon(getClass().getResource("Setting.png"));
		Icon SettingClick =new ImageIcon(getClass().getResource("ClickSetting.png"));
		Icon History = new ImageIcon(getClass().getResource("History.png"));
		Icon HistoryClick = new ImageIcon(getClass().getResource("ClickHistory.png"));
		Icon Quit = new ImageIcon(getClass().getResource("Quit.png"));
		Icon QuitClick = new ImageIcon(getClass().getResource("ClickQuit.png"));
		
		button_Play = new JButton("PLAY",Play);
		button_Play.setRolloverIcon(PlayClick);
		button_Setting = new JButton("SETTING",Setting);
		button_Setting.setRolloverIcon(SettingClick);
		button_History = new JButton("HISTORY",History);
		button_History.setRolloverIcon(HistoryClick);
		button_Quit = new JButton("QUIT",Quit);
		button_Quit.setRolloverIcon(QuitClick);
		
		panel_Sub.add(button_Play);
		panel_Sub.add(button_Setting);
		panel_Sub.add(button_History);
		panel_Sub.add(button_Quit);
		
		button_Play.addActionListener(this);
		button_Setting.addActionListener(this);
		button_History.addActionListener(this);
		button_Quit.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button_Play) {
			setVisible(false);
			MyFrame.addPanel(new Playing());
		} else if (e.getSource() == button_Setting) {
			setVisible(false);
			MyFrame.addPanel(new Setting());
		} else if (e.getSource() == button_History) {
			setVisible(false);
			MyFrame.addPanel(new History());
		} else if (e.getSource() == button_Quit) {
			System.exit(0);
		}
	}
	

	
	
}
