package style;

import node.ElementNode;

public class TagSelector extends Selector {
	private String tagName;
	
	public TagSelector(String name) {
		this.specificity = 5;
		this.tagName = name;
	}
	
	public boolean match(ElementNode elem) {
		return elem.getTagName().equals(this.tagName);
	}
	
	public String toString() {
		return this.tagName;
	}
}
