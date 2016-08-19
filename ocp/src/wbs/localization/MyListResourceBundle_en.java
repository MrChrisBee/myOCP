package wbs.localization;

import java.util.ListResourceBundle;

public class MyListResourceBundle_en extends ListResourceBundle {
	private Object[][] contents = { { "language", "english" }, { "currency", "euro" }, { "capital", "london" } };

	@Override
	public Object[][] getContents() {
		return contents;
	}
}