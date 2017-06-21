package styleopts;

import glyph.Glyph;

public class BorderWidth extends EdgeOption {

    public void apply(Glyph g) {
        g.setBorderSize(this.size);
    }
}
