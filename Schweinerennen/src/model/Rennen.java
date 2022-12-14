package model;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import view.MainPanel;
import view.ViewBuilder;

public class Rennen extends TimerTask {
	// Attribute
	private String name;
	private int laenge;
	private ArrayList<Schwein> teilnehmer;
	private ArrayList<Schwein> platzierung;
	private Timer timer;
	private ViewBuilder vb;
	private MainPanel mp;

	// Getter-Setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLaenge() {
		return laenge;
	}

	public void setLaenge(int laenge) {
		this.laenge = laenge;
	}

	public ArrayList<Schwein> getTeilnehmer() {
		return teilnehmer;
	}

	public void setTeilnehmer(ArrayList<Schwein> teilnehmer) {
		this.teilnehmer = teilnehmer;
	}

	public ArrayList<Schwein> getPlatzierung() {
		return platzierung;
	}

	public void setPlatzierung(ArrayList<Schwein> platzierung) {
		this.platzierung = platzierung;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	// Konstruktoren
	public Rennen(String name, int laenge, ArrayList<Schwein> teilnehmer) {
		this.setName(name);
		this.setLaenge(laenge);
		this.setTeilnehmer(teilnehmer);
		this.setPlatzierung(new ArrayList<Schwein>());
		this.setTimer(new Timer());
	}

	public Rennen(String name, int laenge) {
		this.setName(name);
		this.setLaenge(laenge);
		ArrayList<Schwein> teilnehmer = new ArrayList<Schwein>();
		for (int i = 0; i < 5; i++) {
			String sName = "Schwein" + (i + 1);
			Schwein s = new Schwein(sName);
			teilnehmer.add(s);
		}
		this.setTeilnehmer(teilnehmer);
		this.setPlatzierung(new ArrayList<Schwein>());
		this.setTimer(new Timer());
	}

	public Rennen(String name, int laenge, String sName1, String sName2, String sName3, String sName4, String sName5,
			MainPanel mp, ViewBuilder vb) {
		this.setName(name);
		this.setLaenge(laenge);
		ArrayList<Schwein> teilnehmer = new ArrayList<Schwein>();
		Schwein s1 = new Schwein(sName1);
		Schwein s2 = new Schwein(sName2);
		Schwein s3 = new Schwein(sName3);
		Schwein s4 = new Schwein(sName4);
		Schwein s5 = new Schwein(sName5);

		teilnehmer.add(s1);
		teilnehmer.add(s2);
		teilnehmer.add(s3);
		teilnehmer.add(s4);
		teilnehmer.add(s5);
		this.setTeilnehmer(teilnehmer);
		this.setPlatzierung(new ArrayList<Schwein>());
		this.setTimer(new Timer());
		this.mp = mp;
		this.vb = vb;
	}

	// Standardmethoden
	@Override
	public String toString() {
		String s = "Rennen [name=" + name + ", laenge=" + laenge + "]\n";
		for (int i = 0; i < 5; i++) {
			s = s + this.getTeilnehmer().get(i).toString() + " \n";
		}
		return s;
	}

	// Methoden
	public void start() {

		this.getTimer().schedule(this, 1000, 250);
	}

	public boolean alleSchweineImZiel() {
		boolean aiz = true;
		for (int i = 0; i < 5; i++) {
			if (this.getTeilnehmer().get(i).getPos() < this.getLaenge()) {
				aiz = false;
			}
		}
		return aiz;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			this.getTeilnehmer().get(i).beschleunigen();
			this.getTeilnehmer().get(i).bewegen(this.getLaenge());
//			System.out.println(this.getTeilnehmer().get(i).toString());
			if (this.getTeilnehmer().get(i).getPos() >= getLaenge()) {
				this.getPlatzierung().add(this.getTeilnehmer().get(i));
			}
			this.vb.loadNewView(mp, this);
		}
		if (alleSchweineImZiel()) {
			this.getTimer().cancel();
			this.getTimer().purge();
			for (Schwein schwein : getPlatzierung()) {
				System.out.println(schwein.getName());
			}
		}
	}
}
