package glyph;

import window.Window;
import layout.Rect;

public class RectangleGlyph extends Glyph {

    public void draw(Window window) {
        Rect content = this.dim.borderBox();
        int x1 = content.getX();
        int y1 = content.getY();
        int width = content.getWidth();
        int height = content.getHeight();

        window.drawRectangle(x1, y1, width, height, this.backgroundColor);
        this.drawBorder(window);
    }
}
