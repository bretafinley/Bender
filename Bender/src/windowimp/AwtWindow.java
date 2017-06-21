package windowimp;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import window.Window;

class AwtWindow implements WindowImplementation {

    private final int width;
    private final int height;

    private Window _window;
    private Pane _pane;
    private Frame _frame;
    private Color _color;
    private Graphics _graphics;
    private Font _font=null;
    private FontMetrics _fm;

    private class Pane extends Panel {

        public void paint(Graphics graphics) {
            super.paint(graphics);
            _graphics=graphics;
            if (_font!=null) {
                _graphics.setFont(_font);
                _fm=_graphics.getFontMetrics();
            }
            _window.draw();
        }

    }

    public AwtWindow(String title, Window window, int width, int height) {
        this.width = width;
        this.height = height;
        _window=window;
        _frame=new Frame(title);
        _frame.setMenuBar(new MenuBar());
        _frame.setSize(width,height);
        _frame.setVisible(true);
        _fm=_frame.getGraphics().getFontMetrics();
        _color=_frame.getGraphics().getColor();
    }

    public int charWidth(char c) {
        return _fm.charWidth(c);
    }

    public int charHeight(char c) {
        return _fm.getHeight();
    }

    private int charBaseline(char c) {
        return _fm.getLeading()+_fm.getAscent();
    }

    public void drawCharacter(char c, int x, int y, styleunit.FontOption options) {
        _graphics.setFont(new Font(options.getFamily(), options.getStyle(), options.getSize()));
        _graphics.setColor(new Color(options.getColor().getR(), options.getColor().getG(), options.getColor().getB()));
        _graphics.drawString(c+"",x,y+charBaseline(c));
        _graphics.setColor(_color);
    }

    public void drawString(String str, int x, int y, styleunit.FontOption options) {
        _graphics.setFont(new Font(options.getFamily(), options.getStyle(), options.getSize()));
        _graphics.setColor(new Color(options.getColor().getR(), options.getColor().getG(), options.getColor().getB()));
        _graphics.drawString(str, x, y+options.getSize());
        _graphics.setColor(_color);
    }

    public void drawRectangle(int x, int y, int width, int height, styleunit.Color color) {
        _graphics.setColor(new Color(color.getR(), color.getG(), color.getB()));
        _graphics.fillRect(x,y,width,height);
        _graphics.setColor(_color);
        _graphics.drawRect(x,y,width,height);
    }

    public void setContents() {
        _pane=new Pane();
        _frame.removeAll();
        _frame.add(_pane);
        _pane.setFocusable(true);
        _pane.requestFocusInWindow();
        _frame.setVisible(true);
    }

    public void addBorder(int x1, int y1, int x2, int y2, int width, styleunit.Color color) {
        _graphics.setColor(new Color(color.getR(), color.getG(), color.getB()));
        _graphics.fillRect(x1,y1,x2-x1,width);             // top
        _graphics.fillRect(x1,y1,width,y2-y1-width);       // left
        _graphics.fillRect(x2-width,y1-width,width,y2-y1); // right
        _graphics.fillRect(x1,y2-width,x2-x1,width);       // bottom
        _graphics.setColor(_color);
    }

    public void addScrollBar(int x, int y, int width, int height) {
        _graphics.drawRect(x,y,width,height);        // bar
        _graphics.fillRect(x+2,y+2,width-3,width-3); // handle
    }

    public Color color(String c) {
        if (c.equalsIgnoreCase("red"))
            return Color.red;
        if (c.equalsIgnoreCase("green"))
            return Color.green;
        return _color;
    }

    public void drawButton(int x, int y, int width, int height, String color) {
        _graphics.setColor(color(color));
        _graphics.fillRect(x,y,width,height);
        _graphics.setColor(_color);
    }

    public void drawLabel(int x, int y, int width, int height, String color) {
        _graphics.setColor(color(color));
        _graphics.drawRect(x,y,width,height);
        _graphics.setColor(_color);
    }

    public int getFontSize() {
        Font font;
        if (_font!=null)
            font=_font;
        else
            font=_pane.getGraphics().getFont();
        return font.getSize();
    }

    public void setFontSize(int size) {
        if (size>0) {
            Font font;
            if (_font!=null)
                font=_font;
            else
                font=_pane.getGraphics().getFont();
            _font=new Font(font.getFamily(),font.getStyle(),size);
            _graphics.setFont(_font);
            _fm=_graphics.getFontMetrics();
        }
    }

    public void repaint() { _pane.repaint(); }

}
