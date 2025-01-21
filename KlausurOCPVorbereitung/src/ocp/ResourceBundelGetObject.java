package ocp;

import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundelGetObject extends ListResourceBundle{
	@Override
	protected Object[][] getContents() {

		return new Object[][] {{"123",456}};
	}
}

