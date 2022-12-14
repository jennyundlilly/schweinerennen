package view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Spur extends JPanel{
	public Spur(int pos, int zahl) {
		if(zahl%2 == 0) {
			this.setBackground(new Color(0x119c18));
		} else {
			this.setBackground(new Color(0x117016));
		}
		
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		ImageIcon img = new ImageIcon("src/img/schwein_klein.png");
		JLabel schwein = new JLabel(img);
		this.setBorder(new EmptyBorder(0, pos*10, 0, 0));
		this.add(schwein);
	}
}
