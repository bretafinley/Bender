package styleopts;

import glyph.Glyph;

public class BorderColor extends ColorOption {

    public void apply(Glyph g) {
        g.setBorderColor(this.color);
    }
}
