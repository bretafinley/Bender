package windowimp;

import window.Window;

public class FXFactory extends WindowFactory {

    private static FXFactory instance = null;

    protected FXFactory() {

    }

    protected static WindowFactory instance() {
        if(instance == null) {
            instance = new FXFactory();
        }

        return instance;
    }

    protected WindowImplementation createWindow(String title, Window w) {
        return null;
    }
}
