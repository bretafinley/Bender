package styleopts;

public class Height extends StyleOption {

    private int height;

    public void parse(String height) {
        int s = Integer.parseInt(height);

        if(s < 0) {
            this.height = 12;
        } else {
            this.height = s;
        }
    }

    public String toString() {
        return "" + this.height;
    }
}
