package layout;

import cascade.StyleNode;
import cascade.StyleElement;

public class BlockBox extends LayoutBox {

    public BlockBox(StyleNode node) {
        super(node);
    }

    public BlockBox(StyleElement node) {
        super(node);

        LayoutBox temp;

        for(StyleNode n : node.getChildren()) {
            temp = n.layOut();
            temp.setParent(this);
            if(temp != null) {
                this.children.add(temp);
            }
        }
    }

    public void calculateDimensions() {
        calculateWidth();
        calculatePosition();
        layOutChildren();
        calculateHeight();
    }

    private void calculateWidth() {
        int marginLeft = this.convertAttr(this.lookup("margin-left"));
        int marginRight = this.convertAttr(this.lookup("margin-right"));
        int paddingLeft = this.convertAttr(this.lookup("padding-left"));
        int paddingRight = this.convertAttr(this.lookup("padding-right"));
        int borderWidth = this.convertAttr(this.lookup("border-width"));

        EdgeSizes margin = this.dim.getMargin();
        margin.setLeft(marginLeft);
        margin.setRight(marginRight);

        EdgeSizes padding = this.dim.getPadding();
        padding.setLeft(paddingLeft);
        padding.setRight(paddingRight);

        EdgeSizes border = this.dim.getBorder();
        border.setLeft(borderWidth);
        border.setRight(borderWidth);

        int width = this.convertAttr(this.lookup("width"));
        if(width > 0) {
            this.dim.getContent().setWidth(width);
        }
    }

    private int convertAttr(String attr) {
        try {
            int retval = Integer.parseInt(attr);
            if(retval < 0) {
                return 0;
            }

            return retval;
        } catch(NumberFormatException e) {
            return 0;
        }
    }

    private void calculatePosition() {
        int marginTop = this.convertAttr(this.lookup("margin-top"));
        int marginBottom = this.convertAttr(this.lookup("margin-bottom"));
        int paddingTop = this.convertAttr(this.lookup("padding-top"));
        int paddingBottom = this.convertAttr(this.lookup("padding-bottom"));
        int borderWidth = this.convertAttr(this.lookup("border-width"));

        EdgeSizes margin = this.dim.getMargin();
        margin.setTop(marginTop);
        margin.setBottom(marginBottom);

        EdgeSizes padding = this.dim.getPadding();
        padding.setTop(paddingTop);
        padding.setBottom(paddingBottom);

        EdgeSizes border = this.dim.getBorder();
        border.setTop(borderWidth);
        border.setBottom(borderWidth);

        // DO I NEED PARENT HEIGHT ANYMORE?

        int parentX;
        int parentY;
        int parentHeight;

        if(parent == null) {
            parentX = 0;
            parentY = 0;
            parentHeight = 0;
        } else {
            parentX = this.parent.getDim().getContent().getX();
            parentY = this.parent.getDim().getContent().getY();
            parentHeight = this.parent.getDim().getContent().getHeight();
        }

        int newX =  parentX + this.dim.getMargin().getLeft() + this.dim.getBorder().getLeft() + this.dim.getPadding().getLeft();
        int newY =  parentY + parentHeight + this.dim.getMargin().getTop() + this.dim.getBorder().getTop() + this.dim.getPadding().getTop();

        this.dim.getContent().setX(newX);
        this.dim.getContent().setY(newY);
    }

    private void layOutChildren() {
        for(LayoutBox child : this.children) {
            child.calculateDimensions();
            int newHeight = this.dim.getContent().getHeight() + child.dim.marginBox().getHeight();
            this.dim.getContent().setHeight(newHeight);
        }

    }

    private void calculateHeight() {
        int height = this.convertAttr(this.lookup("height"));
        if(height > this.dim.getContent().getHeight()) {
            this.dim.getContent().setHeight(height);
        }
    }
}
