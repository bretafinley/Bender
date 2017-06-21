package style;

import java.util.NoSuchElementException;

import node.NodeFactory;

public class SelectorFactory {
	
	public static Selector createSelector(String type, String name) {
		
		if(type.equals("#")) {
			return new UniqueSelector(name);
		} else if(type.equals(".")) {
			return new ClassSelector(name);
		} else if(type.equals("*")) {
			return new WildSelector();
		} else if((NodeFactory.createNode(name)) != null) {
			return new TagSelector(name);
		} else {
			throw new NoSuchElementException("Invalid selector");
		}
	}
}
