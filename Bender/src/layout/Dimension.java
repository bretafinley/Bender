package layout;

public class Dimension {
    private Rect content;
    private EdgeSizes padding;
    private EdgeSizes border;
    private EdgeSizes margin;

    public Dimension() {
        this.content = new Rect();
        this.padding = new EdgeSizes();
        this.border = new EdgeSizes();
        this.margin = new EdgeSizes();
    }

    public Rect getContent() {
        return this.content;
    }

    public EdgeSizes getPadding() {
        return this.padding;
    }

    public EdgeSizes getBorder() {
        return this.border;
    }

    public EdgeSizes getMargin() {
        return this.margin;
    }

    public Rect paddingBox() {
        return this.content.expand(this.padding);
    }

    public Rect borderBox() {
        return this.paddingBox().expand(this.border);
    }

    public Rect marginBox() {
        return this.borderBox().expand(this.margin);
    }
}
