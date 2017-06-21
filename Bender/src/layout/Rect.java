package layout;

public class Rect {
    private int x;
    private int y;
    private int height;
    private int width;

    public Rect() {
        this.x = 0;
        this.y = 0;
        this.height = 0;
        this.width = 0;
    }

    public Rect(int x, int y, int height, int width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Rect expand(EdgeSizes edge) {
        int x = this.x - edge.getLeft();
        int y = this.y - edge.getTop();
        int width = this.width + edge.getLeft() + edge.getRight();
        int height = this.height + edge.getTop() + edge.getBottom();

        return new Rect(x, y, height, width);
    }
}
