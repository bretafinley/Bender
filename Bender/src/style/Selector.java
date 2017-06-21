package style;

import node.ElementNode;

public abstract class Selector {
	
	protected int specificity = 100;
	
	public abstract boolean match(ElementNode elem);
	
	public int getSpecificity() {
		return this.specificity;
	}
}
