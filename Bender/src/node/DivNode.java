package node;

import glyph.Glyph;
import glyph.RectangleGlyph;
import window.Window;

public class DivNode extends ElementNode{
	
	public DivNode() {
		super();
		this.tagName = "div";
	}
	
	public DivNode(String text) {
		super(text);
		this.tagName = "div";
	}
	
	public DivNode(Node child) {
		super(child);
		this.tagName = "div";
	}

	public Glyph render() {
		return new RectangleGlyph();
	}
}
