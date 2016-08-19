package wbs.enumeration;

enum PlatonischerKoerper1 {
	TETRAEDER {
		public int flaechen() {
			return 4;
		}

		public int kanten() {
			return 6;
		}

		public int ecken() {
			return 4;
		}
	},
	OKTAEDER {
		public int flaechen() {
			return 8;
		}

		public int kanten() {
			return 12;
		}

		public int ecken() {
			return 6;
		}
	},
	HEXAEDER {
		public int flaechen() {
			return 6;
		}

		public int kanten() {
			return 12;
		}

		public int ecken() {
			return 8;
		}
	},
	IKOSAEDER {
		public int flaechen() {
			return 20;
		}

		public int kanten() {
			return 30;
		}

		public int ecken() {
			return 12;
		}
	},
	DODEKAEDER {
		public int flaechen() {
			return 12;
		}

		public int kanten() {
			return 30;
		}

		public int ecken() {
			return 20;
		}
	};
	// class-body
	public abstract int flaechen();

	public abstract int kanten();

	public abstract int ecken();
}

public class PlatonischerKoerper1Demo {

	public static void main(String[] args) {
		// gibt die charakteristischen werte für jede enum-konstante,
		// also jeden platonischen körper aus
		for (PlatonischerKoerper1 pk1 : PlatonischerKoerper1.values()) {
			System.out.println(pk1.name());
			System.out.println("ecken: " + pk1.ecken());
			System.out.println("kanten: " + pk1.kanten());
			System.out.println("flaechen: " + pk1.flaechen());
			// für jede enum-konstante generiert der compiler hier eine eigene 
			// (anonyme) klasse:
			// wbs.enumeration.PlatonischerKoerper1$1
			// wbs.enumeration.PlatonischerKoerper1$2
			// ...
			// ...
			System.out.println(pk1.getClass().getName() + " -> "
					+ pk1.getDeclaringClass().getName());
			System.out.println("--------------");
		}
	}

}
