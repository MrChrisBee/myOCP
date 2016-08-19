package wbs.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Ser5Base implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String base;
	Ser5Base(String base) {
		System.out.println("nana");
		this.base = base;
	}
}

class Ser5 extends Ser5Base implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String s1;
	transient String s2;
	
	public Ser5() {
		super("super");
		System.out.println("aha!");
	}

	@Override
	public String toString() {
		return "Ser5 [s1=" + s1 + ", s2=" + s2 + ", base=" + base + "]";
	}

	
}

public class SerialisierungDemo5 {

	public static void main(String[] args) throws IOException {
		String path = "resources/io/stream/ser5.ser";
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
			Ser5 ser5 = new Ser5();
			ser5.s1 = "s1";
			ser5.s2 = "s2";
			oos.writeObject(ser5);
		}
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
			System.out.println(ois.readObject());
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
