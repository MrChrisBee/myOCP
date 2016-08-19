package wbs.jdbc.dao;

import java.util.Date;

import wbs.jdbc.annotation.Column;
import wbs.jdbc.annotation.PrimaryKey;

public class Ausleihe {
	@Column(length="20")
	@PrimaryKey(index=1)
	private String ISBN;
	@Column(length="")
	@PrimaryKey(index=2)
	private int nr;
	@Column(length="")
	@PrimaryKey(index=3)
	private int kdNummer;
	@Column(length="")
	private Date datumAusleihe;
	@Column(length="")
	private Date datumRueckgabe;
	@Column(length="")
	private Date datumMahnung;
	@Column(length="")
	private int mahnStufe;
	public String getISBN() {
		return ISBN;
	}
	public int getNr() {
		return nr;
	}
	public int getKdNummer() {
		return kdNummer;
	}
	public Date getDatumAusleihe() {
		return datumAusleihe;
	}
	public Date getDatumRueckgabe() {
		return datumRueckgabe;
	}
	public Date getDatumMahnung() {
		return datumMahnung;
	}
	public int getMahnStufe() {
		return mahnStufe;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public void setNr(int nr) {
		this.nr = nr;
	}
	public void setKdNummer(int kdNummer) {
		this.kdNummer = kdNummer;
	}
	public void setDatumAusleihe(Date datumAusleihe) {
		this.datumAusleihe = datumAusleihe;
	}
	public void setDatumRueckgabe(Date datumRueckgabe) {
		this.datumRueckgabe = datumRueckgabe;
	}
	public void setDatumMahnung(Date datumMahnung) {
		this.datumMahnung = datumMahnung;
	}
	public void setMahnStufe(int mahnStufe) {
		this.mahnStufe = mahnStufe;
	}
	public Ausleihe(String iSBN, int nr, int kdNummer, Date datumAusleihe,
			Date datumRueckgabe, Date datumMahnung, int mahnStufe) {
		super();
		ISBN = iSBN;
		this.nr = nr;
		this.kdNummer = kdNummer;
		this.datumAusleihe = datumAusleihe;
		this.datumRueckgabe = datumRueckgabe;
		this.datumMahnung = datumMahnung;
		this.mahnStufe = mahnStufe;
	}
	@Override
	public String toString() {
		return "Ausleihe [ISBN=" + ISBN + ", nr=" + nr + ", kdNummer="
				+ kdNummer + ", datumAusleihe=" + datumAusleihe
				+ ", datumRueckgabe=" + datumRueckgabe + ", datumMahnung="
				+ datumMahnung + ", mahnStufe=" + mahnStufe + "]";
	}

}
