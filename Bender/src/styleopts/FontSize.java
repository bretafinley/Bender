package styleopts;

import glyph.Glyph;

public class FontSize extends StyleOption {

    private int size;

    public boolean shouldCascade() {
        return true;
    }

    public void parse(String size) {
        int s = Integer.parseInt(size);

        if(s < 0) {
            this.size = 12;
        } else {
            this.size = s;
        }
    }

    public void apply(Glyph g) {
        g.setFontSize(this.size);
    }

    public String toString() {
        return "" + this.size;
    }
}
