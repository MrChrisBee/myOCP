package wbs.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SerialisierungDemo8Read {

	public static void main(String[] args) throws IOException {
		String path = "resources/io/stream/ser8.ser";
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
			System.out.println(ois.readObject());
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
