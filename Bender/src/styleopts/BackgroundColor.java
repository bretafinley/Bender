package styleopts;

import glyph.Glyph;

public class BackgroundColor extends ColorOption {

    public void apply(Glyph g) {
        g.setBackgroundColor(this.color);
    }
}
