package wbs.jdbc.dao;

import wbs.jdbc.annotation.Column;
import wbs.jdbc.annotation.PrimaryKey;

public class Nutzer {
	@Column(length = "")
	@PrimaryKey(index = 1)
	private int kdNnummer;
	@Column(length = "20")
	private String vorname;
	@Column(length = "50")
	private String nachname;
	@Column(length = "80")
	private String strasse;
	@Column(length = "80")
	private String ort;

	public int getKdNnummer() {
		return kdNnummer;
	}

	public String getVorname() {
		return vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public String getStrasse() {
		return strasse;
	}

	public String getOrt() {
		return ort;
	}

	public void setKdNnummer(int kdNnummer) {
		this.kdNnummer = kdNnummer;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public Nutzer(int kdNnummer, String vorname, String nachname,
			String strasse, String ort) {
		super();
		this.kdNnummer = kdNnummer;
		this.vorname = vorname;
		this.nachname = nachname;
		this.strasse = strasse;
		this.ort = ort;
	}

	@Override
	public String toString() {
		return "Kunde " + vorname + " " + nachname + " wohnt in " + strasse
				+ " " + ort + "und hat die Kundennummer " + kdNnummer;

	}

}
