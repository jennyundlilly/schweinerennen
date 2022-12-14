package view;

import javax.swing.JButton;

import listener.StartListener;
import model.Rennen;

public class StartButton extends JButton{
	private Rennen r;
	
	public Rennen getR() {
		return r;
	}

	public void setR(Rennen r) {
		this.r = r;
	}
	
	public StartButton(String aufschrift, Rennen r) {
		super(aufschrift);
		this.addActionListener(new StartListener());
		this.setR(r);
	}

	
}
