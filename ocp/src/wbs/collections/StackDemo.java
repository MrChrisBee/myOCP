package wbs.collections;

public class StackDemo {
	// wir erzeugen ein Undoable- Objekt
	// wir führen einige zustandsänderungen herbei
	// wir machen sukzessive alle zustandsänderungen wieder rückgängig
	public static void main(String[] args) {
		Undoable undoable = new Undoable(1);
		undoable.setState(2);
		undoable.setState(3);
		undoable.setState(4);
		System.out.println(undoable);
		while (undoable.undo()) {
			System.out.println(undoable);
		}
	}
}