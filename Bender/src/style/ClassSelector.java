package style;

import node.ElementNode;

public class ClassSelector extends Selector {
	private String className;
	
	public ClassSelector(String name) {
		this.specificity = 8;
		this.className = name;
	}
	
	public boolean match(ElementNode elem) {
		return elem.getClasses().contains(this.className);
	}
	
	public String toString() {
		return "." + this.className;
	}
}
