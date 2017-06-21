package styleopts;

public abstract class EdgeOption extends StyleOption {
    protected int size;

    public void parse(String size) {
        int s;
        try {
            s = Integer.parseInt(size);
            if(s < 0) {
                this.size = 0;
            } else {
                this.size = s;
            }
        } catch(NumberFormatException e) {
            this.size = 0;
        }
    }

    public String toString() {
        return "" + size;
    }
}
