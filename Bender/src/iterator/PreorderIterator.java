
package iterator;

import iterator.Iterable;
import java.util.*;

public class PreorderIterator<T extends Iterable<T>> extends Iterator<T>
{
	private Iterable<T> root;
	private Iterator<T> rootIterator;
	private Stack<Iterator<T>> stack = new Stack<Iterator<T>>();

	public PreorderIterator(T root)
	{
		this.root = root;
	}
	
	@Override
	public void first()
	{
		this.rootIterator = this.root.createIterator();
		this.rootIterator.first();
		this.stack.push(this.rootIterator);
	}

	@Override
	public boolean isDone()
	{
		return this.stack.empty();
	}

	@Override
	public void next()
	{
		Iterator<T> iter = this.stack.peek().getCurrent().createIterator();
		iter.first();
		this.stack.push(iter);
		while(!this.stack.empty() && this.stack.peek().isDone())
		{
			this.stack.pop();
			if(!this.stack.empty() && !this.stack.peek().isDone())
			{
				this.stack.peek().next();
			}
		}
	}

	@Override
	public T getCurrent()
	{
		return stack.peek().getCurrent();
	}
}
