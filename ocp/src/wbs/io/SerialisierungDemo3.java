package wbs.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Ser3Base {
	String base;
	Ser3Base() {
		System.out.println("nana");
		base = "lalla";
	}
}

class Ser3 extends Ser3Base implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String s1;
	transient String s2;
	
	public Ser3() {
		System.out.println("aha!");
	}

	@Override
	public String toString() {
		return "Ser3 [s1=" + s1 + ", s2=" + s2 + ", base=" + base + "]";
	}

	
}

public class SerialisierungDemo3 {

	public static void main(String[] args) throws IOException {
		String path = "resources/io/stream/ser3.ser";
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
			Ser3 ser3 = new Ser3();
			ser3.s1 = "s1";
			ser3.s2 = "s2";
			oos.writeObject(ser3);
		}
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
			System.out.println(ois.readObject());
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
