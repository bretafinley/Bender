
package windowimp;

import window.Window;

public abstract class WindowFactory
{
    public static WindowFactory getFactory(String windowType)
    {
        if(windowType == null)
            windowType = "swing";

        if(windowType.equalsIgnoreCase("swing"))
        {
            return SwingFactory.instance();
        }

        else if(windowType.equals("fx"))
        {
            return FXFactory.instance();
        }

        else
        {
            return AwtFactory.instance();
        }
    }

    protected static WindowFactory instance() throws UnsupportedOperationException
    {
        throw new UnsupportedOperationException("Cannot get instance of Abstract Factory.");
    }

    public WindowImplementation getWindow(String title, Window w)
    {
        return createWindow(title, w);
    }

    protected abstract WindowImplementation createWindow(String title, Window w);
}
