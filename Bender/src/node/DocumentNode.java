package node;

import glyph.Glyph;
import glyph.RectangleGlyph;

public class DocumentNode extends ElementNode{
	
	public DocumentNode() {
		super();
		this.tagName = "html";
	}
	
	public DocumentNode(String text) {
		super(text);
		this.tagName = "html";
	}
	
	public DocumentNode(Node child) {
		super(child);
		this.tagName = "html";
	}

	public Glyph render() {
		return new RectangleGlyph();
	}
}
