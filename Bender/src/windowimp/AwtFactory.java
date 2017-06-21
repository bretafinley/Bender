// Abstract Factory (87) : Concrete Factory
// Factory Method (107) : Concrete Creator
// Singleton (127) : Singleton

package windowimp;

import window.Window;

public class AwtFactory extends WindowFactory
{
    private static AwtFactory instance = null;

    protected AwtFactory()
    {

    }

    protected static WindowFactory instance()
    {
        if(instance == null)
            instance = new AwtFactory();

        return instance;
    }

    protected WindowImplementation createWindow(String title, Window w)
    {
        return new AwtWindow(title, w, 500, 500);
    }
}
