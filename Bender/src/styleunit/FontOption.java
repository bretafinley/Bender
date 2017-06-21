package styleunit;

import java.awt.*;

public class FontOption {
    protected String family;
    protected int size;
    protected Color color;
    protected int style;

    public FontOption() {
        this.family = "Arial";
        this.size = 12;
        this.color = Color.BLACK;
        this.style = Font.PLAIN;
    }

    public FontOption(String family) {
        this();
        this.family = family;
    }

    public FontOption(String family, int size) {
        this(family);
        this.size = size;
    }

    public FontOption(String family, int size, Color color) {
        this(family, size);
        this.color = color;
    }

    public FontOption(String family, int size, Color color, int style) {
        this(family, size, color);
        this.style = style;
    }

    public String getFamily() {
        return this.family;
    }

    public int getSize() {
        return this.size;
    }

    public Color getColor() {
        return this.color;
    }

    public int getStyle() {
        return this.style;
    }

    public void setFamily(String fam) {
        this.family = fam;
    }

    public void setSize(int s) {
        this.size = s;
    }

    public void setColr(Color color) {
        this.color = color;
    }

    public void setStyle(int s) {
        this.style = s;
    }
}
