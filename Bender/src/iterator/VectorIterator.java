
package iterator;

import java.util.*;

public class VectorIterator<T> extends Iterator<T>
{
	private ArrayList<T> vector;
	private int position;
	
	public VectorIterator(ArrayList<T> list)
	{
		this.vector = list;
		this.position = -1;
	}
	
	public void first()
	{
		if(this.vector.size() < 1) return;
		
		this.position = 0;
	}
	
	@Override
	public boolean isDone()
	{
		return this.position == this.vector.size();
	}

	@Override
	public void next()
	{
		this.position++;
	}
	
	public T getCurrent()
	{
		if(this.position >= this.vector.size())
			return null;
		
		return this.vector.get(this.position);
	}
}
