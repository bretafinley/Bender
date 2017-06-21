package node;

import java.util.NoSuchElementException;

public class NodeFactory {
	
	public static ElementNode createNode(String type) {
		switch(type) {
			case "div":
				return new DivNode();

			case "em":
				return new EmphasisNode();

			case "html":
				return new DocumentNode();

			default:
				throw new NoSuchElementException("Invalid element: " + type);
		}
	}
}
