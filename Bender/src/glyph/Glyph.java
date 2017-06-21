package glyph;

import window.Window;
import styleunit.Color;
import styleunit.FontOption;
import layout.Dimension;
import layout.Rect;

public abstract class Glyph {

    protected Dimension dim;
    protected Color backgroundColor = Color.WHITE;
    protected Color borderColor = Color.BLACK;
    protected int borderSize = 0;
    protected FontOption font = new FontOption();

    public abstract void draw(Window window);

    protected void drawBorder(Window window) {
        Rect content = this.dim.borderBox();
        int x1 = content.getX();
        int y1 = content.getY();
        int x2 = x1 + content.getWidth();
        int y2 = y1 + content.getHeight();
        window.addBorder(x1, y1, x2, y2, this.borderSize, this.borderColor);
    }

    public void setDimensions(Dimension d) {
        this.dim = d;
    }

    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
    }

    public void setForegroundColor(Color color) {
        this.font.setColr(color);
    }

    public void setBorderColor(Color color) {
        this.borderColor = color;
    }

    public void setBorderSize(int s) {
        this.borderSize = s;
    }

    public void setFontFamily(String family) {
        this.font.setFamily(family);
    }

    public void setFontStyle(int style) {
        this.font.setStyle(style);
    }

    public void setFontSize(int s) {
        this.font.setSize(s);
    }
}
