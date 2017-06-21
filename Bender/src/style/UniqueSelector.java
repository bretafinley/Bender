package style;

import node.ElementNode;

public class UniqueSelector extends Selector {
	private String indentifier;
	
	public UniqueSelector(String id) {
		this.specificity = 10;
		this.indentifier = id;
	}
	
	public boolean match(ElementNode elem) {
		String id = elem.getID();
		
		if(id == null) {
			return false;
		}
		
		return elem.getID().equals(this.indentifier);
	}
	
	public String toString() {
		return "#" + this.indentifier;
	}
}
