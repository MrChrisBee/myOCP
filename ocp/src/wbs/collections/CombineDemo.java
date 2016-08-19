package wbs.collections;

public class CombineDemo {

	public static void main(String[] args) {
		Woerterbuch wb1 = new Woerterbuch("a", "b");
		Woerterbuch wb2 = new Woerterbuch("b", "c");
		
		wb1.putWord("eins", "one");
		wb1.putWord("zwei", "two");
		wb1.putWord("drei", "three");
		wb1.putWord("vier", "four");
		
		wb2.putWord("one", "un");
		wb2.putWord("one", "une");
		wb2.putWord("two", "deux");
		wb2.putWord("three", "trois");
		
		Woerterbuch wb3 = Woerterbuch.combine(wb1, wb2);
		
		for(String srcWord : wb3.srcWords()) {
			System.out.println(srcWord + wb3.getWords(srcWord));
		}
	}
}
