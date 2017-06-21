package style;

import node.ElementNode;

public class WildSelector extends Selector {
	
	public WildSelector() {
		this.specificity = 1;
	}
	
	public boolean match(ElementNode elem) {
		return true;
	}
	
	public String toString() {
		return "*";
	}
}
