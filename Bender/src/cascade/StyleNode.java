package cascade;

import java.util.HashMap;
import java.util.ArrayList;

import layout.LayoutBox;
import styleopts.StyleOption;
import node.Node;
import glyph.Glyph;

public abstract class StyleNode {
	protected Node me;
	protected HashMap<String, StyleOption> specifiedValues;

	public StyleOption getValue(String key) {
		return this.specifiedValues.get(key);
	}

	public ArrayList<StyleNode> getChildren() {
		return null;
	}

	public LayoutBox layOut() {
		return null;
	}

	public Glyph render() {
		Glyph myGlyph = this.me.render();

		for(String key : this.specifiedValues.keySet()) {
			this.specifiedValues.get(key).apply(myGlyph);
		}

		return myGlyph;
	}
}
