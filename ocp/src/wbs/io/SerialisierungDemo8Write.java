package wbs.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

// nach dem aufruf von SerialisierungDemo8Write wird die klasse Ser8 geändert
// dann wird SerialisierungDemo8Read aufgerufen

// jeweils mit / ohne serialVersionUID

public class SerialisierungDemo8Write {

	public static void main(String[] args) throws IOException {
		String path = "resources/io/stream/ser8.ser";
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
			Ser8 ser8 = new Ser8();
			oos.writeObject(ser8);
		}
	}
}
