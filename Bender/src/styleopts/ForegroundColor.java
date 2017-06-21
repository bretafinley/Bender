package styleopts;

import glyph.Glyph;

public class ForegroundColor extends ColorOption {

    public void apply(Glyph g) {
        g.setForegroundColor(this.color);
    }
}
