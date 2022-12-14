package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Schwein {
	// Attribute
	private String name;
	private int aktGeschw;
	private int maxGeschw;
	private int pos;

	// Getter-Setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAktGeschw() {
		return aktGeschw;
	}

	public void setAktGeschw(int aktGeschw) {
		if (aktGeschw > this.getMaxGeschw()) {
			this.aktGeschw = this.getMaxGeschw();
		} else if (aktGeschw < 0) {
			this.aktGeschw = 0;
		} else {
			this.aktGeschw = aktGeschw;
		}
	}

	public int getMaxGeschw() {
		return maxGeschw;
	}

	public void setMaxGeschw(int maxGeschw) {
		if (maxGeschw > 10) {
			this.maxGeschw = 10;
		} else {
			this.maxGeschw = maxGeschw;
		}
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos, int laenge) {
		if (pos >= laenge) {
			this.pos = laenge;
		} else {
			this.pos = pos;
		}
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	// Konstruktoren
	public Schwein(String name, int aktGeschw, int maxGeschw, int pos) {
		this.setName(name);
		this.setAktGeschw(aktGeschw);
		this.setMaxGeschw(maxGeschw);
		this.setPos(pos);
	}

	public Schwein() {
		this.setName("Standardschwein");
		this.setAktGeschw(0);
		this.setMaxGeschw(7);
		this.setPos(0);
	}

	public Schwein(String name) {
		this.setName(name);
		this.setAktGeschw(0);
		this.setPos(0);
		Random r = new Random();
		// r.nextInt(6) = 0-5
		int randomMaxGeschw = r.nextInt(6) + 5;
		this.setMaxGeschw(randomMaxGeschw);
	}

	// Standardmethoden
	@Override
	public String toString() {
		return "Schwein [name=" + name + ", aktGeschw=" + aktGeschw + ", maxGeschw=" + maxGeschw + ", pos=" + pos + "]";
	}

	// Methoden
	public void beschleunigen() {
		Random r = new Random();
		int beschleunigung = r.nextInt(11);
		int unfall = r.nextInt(3);
		if (unfall == 0) {
			beschleunigung = beschleunigung * (-1);
		}
		this.setAktGeschw(this.getAktGeschw() + beschleunigung);
	}

	public void bewegen(int laenge) {
		this.setPos(this.getPos() + this.getAktGeschw(), laenge);
	}

	public static void check() {
		List<Schwein> l1 = new ArrayList<>();
		List<Schwein> l2 = new ArrayList<>();

		l1.add(new Schwein());

		l2.add(l1.get(0));

		System.err.println(l1.get(0).hashCode());
		System.err.println(l2.get(0).hashCode());

		if (l1.get(0).equals(l2.get(0))) {
			System.out.println("ok");
		}
	}

}
