
package windowimp;

import window.Window;

public class SwingFactory extends WindowFactory
{
    private static SwingFactory instance = null;

    protected SwingFactory()
    {

    }

    protected static WindowFactory instance()
    {
        if(instance == null)
            instance = new SwingFactory();

        return instance;
    }

    protected WindowImplementation createWindow(String title, Window w)
    {
        return new SwingWindow(title, w, 500, 500);
    }
}
