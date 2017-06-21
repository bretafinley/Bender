package glyph;

import window.Window;

public class TextGlyph extends Glyph {

    private String text;

    public TextGlyph(String text) {
        this.text = text;
    }

    public void draw(Window window) {
        window.setFontSize(font.getSize());
        int x = this.dim.getContent().getX();
        int y = this.dim.getContent().getY();
        window.drawString(this.text, x, y, this.font);
        this.drawBorder(window);
    }
}
