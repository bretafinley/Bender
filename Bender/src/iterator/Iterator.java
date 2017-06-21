package iterator;

public abstract class Iterator<T> {
	public abstract void first();
	public abstract boolean isDone();
	public abstract void next();
	public abstract T getCurrent();
}
