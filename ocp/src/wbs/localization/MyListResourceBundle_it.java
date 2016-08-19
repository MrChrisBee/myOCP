package wbs.localization;

import java.util.ListResourceBundle;

public class MyListResourceBundle_it extends ListResourceBundle {
	private Object[][] contents = { { "language", "italiano" }, { "currency", "euro" }, { "capital", "roma" } };

	@Override
	public Object[][] getContents() {
		return contents;
	}
}