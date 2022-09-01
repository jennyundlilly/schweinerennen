package view;

import java.awt.Color;

import javax.swing.JPanel;

import model.Rennen;

public class ButtonPanel extends JPanel{
	public ButtonPanel(Rennen r)  {
		StartButton b = new StartButton("Start", r);
		this.setBackground(new Color(0x119c18));
		this.add(b);
	}
}
