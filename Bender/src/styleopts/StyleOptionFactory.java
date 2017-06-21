package styleopts;

public class StyleOptionFactory {

    public static StyleOption getOption(String option) {
        option = option.toLowerCase();
        StyleOption retval;
        switch(option) {
            case "background-color" : retval = new BackgroundColor();
                break;
            case "foreground-color" : retval = new ForegroundColor();
                break;
            case "font-size" : retval = new FontSize();
                break;
            case "font-family" : retval = new FontFamily();
                break;
            case "height" : retval = new Height();
                break;
            case "width" : retval = new Width();
                break;
            case "border-width" : retval = new BorderWidth();
                break;
            case "border-color" : retval = new BorderColor();
                break;
            case "margin-top" : retval = new MarginTop();
                break;
            case "margin-right" : retval = new MarginRight();
                break;
            case "margin-bottom" : retval = new MarginBottom();
                break;
            case "margin-left" : retval = new MarginLeft();
                break;
            case "padding-top" : retval = new PaddingTop();
                break;
            case "padding-right" : retval = new PaddingRight();
                break;
            case "padding-bottom" : retval = new PaddingBottom();
                break;
            case "padding-left" : retval = new PaddingLeft();
                break;
            default: retval = null;
                break;
        }

        return retval;
    }
}
