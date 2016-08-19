package wbs.localization;

import java.util.ListResourceBundle;

public class MyListResourceBundle_fr extends ListResourceBundle {
	private Object[][] contents = { { "language", new StringBuffer("francais") },
			{ "currency", new StringBuffer("euro") }, { "capital", new StringBuffer("paris") } };

	@Override
	public Object[][] getContents() {
		return contents;
	}
}