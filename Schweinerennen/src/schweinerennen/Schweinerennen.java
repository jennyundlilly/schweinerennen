package schweinerennen;

import model.Rennen;
import model.Schwein;
import view.MainFrame;
import view.MainPanel;
import view.ViewBuilder;

public class Schweinerennen {

	public static void main(String[] args) {
		ViewBuilder vb = new ViewBuilder();
		MainPanel mp = new MainPanel();
		Rennen r = new Rennen("LeMans", 100, "Piggy", "Schweini", "Peter", "Petra", "Gabi", mp, vb);
		MainFrame mf = new MainFrame(mp);
		vb.loadStartView(mp, r);

		Schwein.check();
	}

}
