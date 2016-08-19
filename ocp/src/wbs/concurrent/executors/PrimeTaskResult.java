package wbs.concurrent.executors;

import java.math.BigInteger;

public class PrimeTaskResult {

	private BigInteger untergrenze;
	private BigInteger obergrenze;
	private BigInteger anzahl;

	public PrimeTaskResult(BigInteger untergrenze, BigInteger obergrenze,
			BigInteger anzahl) {
		this.untergrenze = untergrenze;
		this.obergrenze = obergrenze;
		this.anzahl = anzahl;
	}

	public BigInteger getUntergrenze() {
		return untergrenze;
	}

	public void setUntergrenze(BigInteger untergrenze) {
		this.untergrenze = untergrenze;
	}

	public BigInteger getObergrenze() {
		return obergrenze;
	}

	public void setObergrenze(BigInteger obergrenze) {
		this.obergrenze = obergrenze;
	}

	public BigInteger getAnzahl() {
		return anzahl;
	}

	public void setAnzahl(BigInteger anzahl) {
		this.anzahl = anzahl;
	}
}
