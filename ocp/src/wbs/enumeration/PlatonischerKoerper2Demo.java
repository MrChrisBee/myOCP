package wbs.enumeration;

// wie PlatonischerKoerper1, aber die enum-konstanten
// bekommen hier keinen eigenen class-body
enum PlatonischerKoerper2 {
	TETRAEDER(4, 4, 6), HEXAEDER(6, 8, 12), OKTAEDER(8, 6, 12), DODEKAEDER(12,
			20, 30), IKOSAEDER(20, 12, 30);

	private int flaechen;
	private int ecken;
	private int kanten;

	private PlatonischerKoerper2(int flaechen, int ecken, int kanten) {
		this.flaechen = flaechen;
		this.ecken = ecken;
		this.kanten = kanten;
	}

	public int getFlaechen() {
		return flaechen;
	}

	public int getEcken() {
		return ecken;
	}

	public int getKanten() {
		return kanten;
	}

	@Override
	public String toString() {
		return name()  + "(" + flaechen + "," + ecken + ","
				+ kanten + ")";
	}

}

public class PlatonischerKoerper2Demo {

	public static void main(String[] args) {
		for (PlatonischerKoerper2 pk2 : PlatonischerKoerper2.values()) {
			System.out.println(pk2);
		}

	}

}
