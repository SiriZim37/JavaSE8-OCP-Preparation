package loc.res;

import java.util.ListResourceBundle;

public class labels extends ListResourceBundle {


	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{ "search", "Search" },
			{ "edit", "Edit" },
			{ "cancel", "Cancel" },
		};
	}

}
