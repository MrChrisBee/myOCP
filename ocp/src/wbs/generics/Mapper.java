package wbs.generics;

// O: typ des objekts (abgeordneter, wahlberechtigter, schueler)
// P: typ der eigenschaft (fraktion, wahlkreis, klasse)

public interface Mapper<O, P> {
	public P map(O o);
}
