package wbs.localization;

import java.util.ListResourceBundle;

public class MyListResourceBundle_de extends ListResourceBundle {
	private Object[][] contents = { { "language", "deutsch" }, { "currency", "euro" }, { "capital", "berlin" } };

	@Override
	public Object[][] getContents() {
		return contents;
	}
}