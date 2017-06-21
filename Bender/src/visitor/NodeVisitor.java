package visitor;

import cascade.MatchedRule;
import node.ElementNode;
import node.Node;
import node.TextNode;

import java.util.ArrayList;

public abstract class NodeVisitor {
	public abstract ArrayList<MatchedRule> visit(Node n);
	public abstract ArrayList<MatchedRule> visit(TextNode n);
	public abstract ArrayList<MatchedRule> visit(ElementNode n);
}
