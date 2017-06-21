package window;

import layout.LayoutBox;
import windowimp.WindowFactory;
import windowimp.WindowImplementation;

public abstract class Window {

    protected WindowImplementation windowingSystem;
    protected LayoutBox contents;

    public Window(String title, String type)
    {
        this.windowingSystem = WindowFactory.getFactory(type).getWindow(title, this);
        this.contents = null;
    }

    public void drawCharacter(char c, int x, int y, styleunit.FontOption options)
    {
        this.windowingSystem.drawCharacter(c, x, y, options);
    }

    public void drawString(String str, int x, int y, styleunit.FontOption options)
    {
        this.windowingSystem.drawString(str, x, y, options);
    }

    public void drawRectangle(int x, int y, int width, int height, styleunit.Color color)
    {
        this.windowingSystem.drawRectangle(x, y, width, height, color);
    }

    public int charWidth(char c)
    {
        return windowingSystem.charWidth(c);
    }

    public int charHeight(char c)
    {
        return windowingSystem.charHeight(c);
    }

    public void setContents(LayoutBox b)
    {
        this.contents = b;
        this.windowingSystem.setContents();
    }

    public void draw()
    {
        this.contents.draw(this);
    }

    public void addBorder(int x1, int y1, int x2, int y2, int width, styleunit.Color color)
    {
        this.windowingSystem.addBorder(x1, y1, x2, y2, width, color);
    }

    public void addScrollBar(int x, int y, int width, int height)
    {
        this.windowingSystem.addScrollBar(x, y, width, height);
    }

    public void drawButton(int x, int y, int width, int height, String color)
    {
        this.windowingSystem.drawButton(x, y, width, height, color);
    }

    public void drawLabel(int x, int y, int width, int height, String color)
    {
        this.windowingSystem.drawLabel(x, y, width, height, color);
    }

    public int getFontSize()
    {
        return this.windowingSystem.getFontSize();
    }

    public void setFontSize(int size)
    {
        this.windowingSystem.setFontSize(size);
    }

    public void repaint()
    {
        this.windowingSystem.repaint();
    }
}
