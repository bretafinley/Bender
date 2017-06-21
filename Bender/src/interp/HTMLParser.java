package interp;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import io.InFile;
import node.*;

public class HTMLParser {
	
	private static HTMLScanner scan;
	
	public static ElementNode parseDocument(String filename) throws SyntaxException, FileNotFoundException {
		scan = new HTMLScanner(InFile.readDocument(filename));
		scan.consumeWhitespace();
		
		return parseElement();
	}
	
	private static ArrayList<Node> parseNodes() throws SyntaxException {
		ArrayList<Node> nodes = new ArrayList<Node>();
		while(!scan.done() && !scan.noMoreChildren()) {
			scan.consumeWhitespace();
			nodes.add(parseNode());
		}
		
		return nodes;
	}
	
	private static Node parseNode() throws SyntaxException {
		if(scan.isElem()) {
			return parseElement();
		}
		
		return parseText();
	}
	
	private static ElementNode parseElement() throws SyntaxException {
		String tagName = scan.nextTag();
		ElementNode elem = NodeFactory.createNode(tagName);
		
		ArrayList<Attribute> attrs = scan.nextAttrs();
		for(Attribute a : attrs) {
			elem.addAttribute(a.key, a.value);
		}
		
		ArrayList<Node> children = parseNodes();
		for(int i = 0; i < children.size(); i++) {
			elem.insert(i, children.get(i));
		}
		
		String closeTag = scan.nextClose();
		
		if(!tagName.equals(closeTag)) {
			throw new SyntaxException(scan.pos, tagName, closeTag);
		}
		
		return elem;
	}
	
	private static TextNode parseText() throws SyntaxException {
		return new TextNode(scan.nextText());
	}
}
