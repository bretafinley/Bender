package styleopts;

import glyph.Glyph;

public class FontFamily extends StyleOption {

    private String family;

    public boolean shouldCascade() {
        return true;
    }

    public void parse(String family) {
        this.family = family;
    }

    public void apply(Glyph g) {
        g.setFontFamily(this.family);
    }

    public String toString() {
        return this.family;
    }
}
