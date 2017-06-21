package node;

import cascade.StyleNode;
import iterator.Iterator;
import iterator.NullIterator;
import cascade.MatchedRule;
import visitor.NodeVisitor;
import style.StyleSheet;
import glyph.Glyph;

import java.util.ArrayList;

public abstract class Node implements iterator.Iterable<Node> {
	protected ElementNode parent;

	public abstract Glyph render();

	public ElementNode getParent() {
		return this.parent;
	}

	public void setParent(ElementNode parent) {
		this.parent = parent;
	}
	
	public abstract String prettyPrint(int level);

	public Iterator<Node> createIterator() {
    	return new NullIterator<Node>();
    }
	
	public ArrayList<MatchedRule> accept(NodeVisitor visitor) {
		return visitor.visit(this);
	}

	public StyleNode style(StyleSheet sheet) {
		return null;
	}

	public StyleNode style(StyleSheet sheet, ArrayList<MatchedRule> cascadedRules) {
		return null;
	}
}
