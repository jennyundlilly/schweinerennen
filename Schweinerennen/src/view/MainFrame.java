package view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainFrame extends JFrame{
	public MainFrame(MainPanel mp) {
		this.setSize(1140, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("Schweinerennen");
		ImageIcon img = new ImageIcon("src/img/schwein.png");
		this.setIconImage(img.getImage());
		this.add(mp);
		this.setVisible(true);
	}
}
