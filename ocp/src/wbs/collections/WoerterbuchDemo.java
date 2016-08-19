package wbs.collections;


public class WoerterbuchDemo {

	public static void main(String[] args) {
		/*
		 * wir bestücken ein wörterbuch mit einigen einträgen
		 * 
		 * dann invertieren wir das wörterbuch
		 * 
		 * dann geben wir das invertierte wörterbuch aus
		 */
		String[] entries = { "mieter:knauser",
				"miemer:sinnierer,phantast,traeumer,gruebler",
				"morskruper:arschkriecher,schmeichler",
				"pruellker:lump,knicker,geizhals", "proter:großmaul",
				"priemelpott:korinthenkacker",
				"priemelmors:korinthenkacker,pedant,genauigkeitskraemer",
				"puettjer:pedant", "quacke:faselhans,pfuscher",
				"quackel:faselhans,pfuscher", "quarker:noergler",
				"rattsnuut:quasselstrippe", "rif-raff:poebel,gesindel",
				"snacker:plaudertasche", "snoettfatt:rotzbengel,naseweis",
				"swiendriever:schweinetreiber", "trieselpiepe:plagegeist",
				"wroegel:staenkerer,zaenker" };
		String srcWord;
		String[] dstWords;
		int pos;
		Woerterbuch plattdeutsch_hochdeutsch = new Woerterbuch("plattdeutsch",
				"hochdeutsch");
		for (String entry : entries) {
			pos = entry.indexOf(':');
			srcWord = entry.substring(0, pos);
			dstWords = entry.substring(pos + 1).split(",");
			for (String dstWord : dstWords) {
				plattdeutsch_hochdeutsch.putWord(srcWord, dstWord);
			}
		}

		for (String s : plattdeutsch_hochdeutsch.srcWords()) {
			System.out.println(s + " -> "
					+ plattdeutsch_hochdeutsch.getWords(s));
		}

		System.out.println("-------");

		Woerterbuch hochdeutsch_plattdeutsch = plattdeutsch_hochdeutsch
				.invertDict();
		for (String word : hochdeutsch_plattdeutsch.srcWords()) {
			System.out.println(word + " -> "
					+ hochdeutsch_plattdeutsch.getWords(word));
		}

	}
}
