package windowimp;

public interface WindowImplementation {

    void drawCharacter(char c, int x, int y, styleunit.FontOption options);
    void drawString(String str, int x, int y, styleunit.FontOption options);
    void drawRectangle(int x, int y, int width, int height, styleunit.Color color);

    int charWidth(char c);
    int charHeight(char c);

    void setContents();

    void addBorder(int x1, int y1, int x2, int y2, int width, styleunit.Color color);
    void addScrollBar(int x, int y, int width, int height);

    void drawButton(int x, int y, int width, int height, String color);
    void drawLabel(int x, int y, int width, int height, String color);

    int getFontSize();
    void setFontSize(int size);

    void repaint();

}
