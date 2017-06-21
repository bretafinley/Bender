package layout;

import java.util.ArrayList;

import styleopts.StyleOption;
import window.Window;
import cascade.StyleNode;
import glyph.Glyph;

public abstract class LayoutBox {
    protected Dimension dim;
    protected StyleNode me;
    protected LayoutBox parent = null;
    protected ArrayList<LayoutBox> children = new ArrayList<LayoutBox>();

    public LayoutBox(StyleNode node) {
        this.me = node;
        this.dim = new Dimension();
    }

    public abstract void calculateDimensions();

    public LayoutBox getParent() {
        return this.parent;
    }

    public void setParent(LayoutBox parent) {
        this.parent = parent;
    }

    public Dimension getDim() {
        return this.dim;
    }

    protected String lookup(String key) {
        // CHECK FOR NULL!!!!
        StyleOption temp = me.getValue(key);
        if(temp != null)
            return temp.toString();
        return "0";
    }

    public void draw(Window win) {
        Glyph myGlyph = me.render();
        myGlyph.setDimensions(this.dim);
        myGlyph.draw(win);

        for(LayoutBox c : this.children) {
            c.draw(win);
        }
    }
}
