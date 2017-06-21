package styleopts;

public class Width extends StyleOption {

    private int width;

    public void parse(String width) {
        int s = Integer.parseInt(width);

        if(s < 0) {
            this.width = 12;
        } else {
            this.width = s;
        }
    }

    public void apply() {

    }

    public String toString() {
        return "" + this.width;
    }
}
