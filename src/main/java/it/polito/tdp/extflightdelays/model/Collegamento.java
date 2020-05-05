package it.polito.tdp.extflightdelays.model;

public class Collegamento {

	private int aer1;
	private int aer2;
	private double distanza;

	public Collegamento(int aer1, int aer2, double distanza) {
		super();
		this.aer1 = aer1;
		this.aer2 = aer2;
		this.distanza = distanza;

	}

	public int getAer1() {
		return aer1;
	}

	public void setAer1(int aer1) {
		this.aer1 = aer1;
	}

	public int getAer2() {
		return aer2;
	}

	public void setAer2(int aer2) {
		this.aer2 = aer2;
	}

	public double getDistanza() {
		return distanza;
	}

	public void setDistanza(double distanza) {
		this.distanza = distanza;
	}

	@Override
	public String toString() {
		return "{"+aer1 + ", " + aer2 +"}, distanza=" + distanza;
	}

	
}
