package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.StartButton;

public class StartListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		StartButton s = (StartButton)e.getSource();
		s.getR().start();
	}

}
