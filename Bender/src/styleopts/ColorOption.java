package styleopts;

import styleunit.Color;

public abstract class ColorOption extends StyleOption {
    protected Color color;

    public boolean shouldCascade() {
        return true;
    }

    public void parse(String color) {
        String[] rgb;
        Color newColor;
        if(color.charAt(0) == '#') {
            this.color = new Color(color.substring(1));
        } else if((rgb = isRGB(color)) != null) {
            if(rgb.length != 3) {
                this.color = Color.BLACK;
            }
            else {
                int r = Integer.parseInt(rgb[0].trim());
                int g = Integer.parseInt(rgb[1].trim());
                int b = Integer.parseInt(rgb[2].trim());

                this.color = new Color(r, g, b);
            }
        } else if((newColor = Color.fromString(color)) != null) {
            this.color = newColor;
        } else {
            this.color = Color.BLACK;
        }
    }

    private String[] isRGB(String str) {
        if(str.indexOf("rgb(") == 0 && str.indexOf(")") == str.length() - 1) {
            int l = str.indexOf('(')+1;
            int r = str.indexOf(')');
            String vals = str.substring(l, r);
            System.err.println(vals);
            return vals.split(",");
        }

        return null;
    }

    public String toString() {
        if(this.color != null) {
            return this.color.toString();
        }

        return "";
    }
}
