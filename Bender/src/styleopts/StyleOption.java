package styleopts;

import glyph.Glyph;

public abstract class StyleOption {
    public abstract void parse(String args);
    public void apply(Glyph g) {
        return;
    }
    public boolean shouldCascade() {
        return false;
    }
}
