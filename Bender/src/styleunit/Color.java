package styleunit;

public class Color {
    public static final Color RED = new Color(255, 0, 0);
    public static final Color GREEN = new Color(0, 255, 0);
    public static final Color BLUE = new Color(0, 0, 255);
    public static final Color BLACK = new Color(0, 0, 0);
    public static final Color WHITE = new Color(255, 255, 255);
    public static final Color GRAY = new Color(128, 128, 128);
    public static final Color YELLOW = new Color(255, 255, 0);
    public static final Color ORANGE = new Color(255, 128, 0);
    public static final Color MAGENTA = new Color(255, 0, 255);
    public static final Color CYAN = new Color(0, 255, 255);

    private int r;
    private int g;
    private int b;
    private int a;

    public Color(int red, int green, int blue) {
        this.r = red;
        this.g = green;
        this.b = blue;
        this.a = 1;
    }

    public Color(int red, int green, int blue, int alpha) {
        this.r = red;
        this.g = green;
        this.b = blue;
        this.a = alpha;
    }

    public Color(String hexValue) {
        if(hexValue.length() == 6) {
            String rString = hexValue.substring(0, 2);
            String gString = hexValue.substring(2, 4);
            String bString = hexValue.substring(4, 6);

            int r = Integer.parseInt(rString, 16);
            int g = Integer.parseInt(gString, 16);
            int b = Integer.parseInt(bString, 16);

            if(r > 255 || g > 255 || b > 255) {
                // error
            } else {
                this.r = r;
                this.g = g;
                this.b = b;
                this.a = 1;
            }
        } else if(hexValue.length() == 3) {

        } else {
            // error
        }

    }

    public static Color fromString(String colorName) {
        colorName = colorName.toUpperCase();
        Color retval;
        switch(colorName) {
            case "RED" : retval = RED;
                break;
            case "GREEN" : retval = GREEN;
                break;
            case "BLUE" : retval = BLUE;
                break;
            case "BLACK" : retval = BLACK;
                break;
            case "WHITE" : retval = WHITE;
                break;
            case "GRAY" : retval = GRAY;
                break;
            case "YELLOW" : retval = YELLOW;
                break;
            case "ORANGE" : retval = ORANGE;
                break;
            case "MAGENTA" : retval = MAGENTA;
                break;
            case "CYAN" : retval = CYAN;
                break;
            default : retval = null;
        }

        return retval;
    }

    public int getR() {
        return this.r;
    }

    public int getG() {
        return this.g;
    }

    public int getB() {
        return this.b;
    }

    public String toString() {
        return this.r + " " + this.g + " " + this.b;
    }
}
