package wbs.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class Ser2 {
	
	String s1;
	transient String s2;
	
	public Ser2() {
		System.out.println("aha!");
	}

	@Override
	public String toString() {
		return "Ser2 [s1=" + s1 + ", s2=" + s2 + "]";
	}
}

public class SerialisierungDemo2 {

	public static void main(String[] args) throws IOException {
		String path = "resources/io/stream/ser2.ser";
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
			Ser2 ser2 = new Ser2();
			ser2.s1 = "s1";
			ser2.s2 = "s2";
			oos.writeObject(ser2);
		}
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
			System.out.println(ois.readObject());
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
