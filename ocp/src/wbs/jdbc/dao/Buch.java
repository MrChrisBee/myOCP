package wbs.jdbc.dao;

import java.io.Serializable;

import wbs.jdbc.annotation.Column;
import wbs.jdbc.annotation.PrimaryKey;

public class Buch implements Serializable {

	private static final long serialVersionUID = 1L;

	public Buch(String isbn, String titel, String autor, double preis) {
		super();
		this.isbn = isbn;
		this.titel = titel;
		this.autor = autor;
		this.preis = preis;
	}

	public Buch() {
		super();
	}

	@Column(length="20")
	@PrimaryKey(index=1)
	private String isbn = "";
	@Column(length="40")
	private String titel = "";
	@Column(length="20")
	private String autor = "";
	@Column(length="8,2")
	private double preis = 0.0;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

	@Override
	public String toString() {
		return "Buch [isbn=" + isbn + ", titel=" + titel + ", autor=" + autor + ", preis=" + preis + "]";
	}

}
