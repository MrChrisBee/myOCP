package wbs.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Ser4Base {
	String base;
	Ser4Base(String base) {
		System.out.println("nana");
		this.base = base;
	}
}

class Ser4 extends Ser4Base implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String s1;
	transient String s2;
	
	public Ser4() {
		super("super");
		System.out.println("aha!");
	}

	@Override
	public String toString() {
		return "Ser4 [s1=" + s1 + ", s2=" + s2 + ", base=" + base + "]";
	}
}

public class SerialisierungDemo4 {

	public static void main(String[] args) throws IOException {
		String path = "resources/io/stream/ser4.ser";
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
			Ser4 ser4 = new Ser4();
			ser4.s1 = "s1";
			ser4.s2 = "s2";
			oos.writeObject(ser4);
		}
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
			System.out.println(ois.readObject());
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
