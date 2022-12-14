package view;

import java.util.ArrayList;

import model.Rennen;
import model.Schwein;

public class ViewBuilder {
	public void loadStartView(MainPanel mp, Rennen r) {
		for(int i = 0; i < 5; i++) {
			mp.add(new Spur(r.getTeilnehmer().get(i).getPos(), i));
		}
		mp.add(new ButtonPanel(r));
		mp.revalidate();
	}
	public void loadNewView(MainPanel mp, Rennen r) {
		mp.removeAll();
		for(int i = 0; i < 5; i++) {
			mp.add(new Spur(r.getTeilnehmer().get(i).getPos(), i));
		}
		mp.add(new ButtonPanel(r));
		mp.revalidate();
	}
}
