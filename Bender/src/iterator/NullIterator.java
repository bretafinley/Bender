
package iterator;

public class NullIterator<T> extends Iterator<T>
{
	public NullIterator()
	{
		
	}
	
	@Override
	public void first()
	{
		
	}

	@Override
	public boolean isDone()
	{
		return true;
	}

	@Override
	public void next()
	{
		
	}

	@Override
	public T getCurrent()
	{
		return null;
	}
}
