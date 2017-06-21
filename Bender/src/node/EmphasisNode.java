package node;

import glyph.Glyph;
import glyph.RectangleGlyph;

import java.awt.*;

public class EmphasisNode extends ElementNode {

    public EmphasisNode() {
        super();
        this.tagName = "em";
    }

    public EmphasisNode(String text) {
        super(text);
        this.tagName = "em";
    }

    public EmphasisNode(Node child) {
        super(child);
        this.tagName = "em";
    }

    public Glyph render() {
        Glyph r = new RectangleGlyph();
        r.setFontStyle(Font.ITALIC);
        return r;
    }
}
