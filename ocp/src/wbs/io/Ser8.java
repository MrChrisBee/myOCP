package wbs.io;

import java.io.Serializable;

public class Ser8 implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	int feld1 = 3;
	int feld2 = 4;
	int feld3;
	
	
	@Override
	public String toString() {
		return "Ser8 [feld1=" + feld1 + ", feld2=" + feld2 + "]";
	}
	
	
	
}
