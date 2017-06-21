import java.io.FileNotFoundException;

import interp.HTMLParser;
import interp.StyleParser;
import interp.SyntaxException;
import node.ElementNode;
import cascade.StyleNode;
import style.StyleSheet;
import layout.LayoutBox;
import window.Window;
import window.ApplicationWindow;


public class Bender {

	public static void main(String[] args) throws FileNotFoundException, SyntaxException {
		
		ElementNode documentRoot = HTMLParser.parseDocument("test.html");
		StyleSheet sheet = StyleParser.parseDocument("test.css");

		StyleNode styleRoot = documentRoot.style(sheet);
		LayoutBox layoutRoot = styleRoot.layOut();

		layoutRoot.calculateDimensions();

		Window win = new ApplicationWindow("Bender", "swing");
		win.setContents(layoutRoot);
	}
}