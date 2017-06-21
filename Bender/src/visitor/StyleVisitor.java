package visitor;

import java.util.ArrayList;
import java.util.Collections;

import cascade.RuleComparator;
import node.ElementNode;
import node.TextNode;
import node.Node;
import cascade.MatchedRule;
import style.Rule;
import style.StyleSheet;

public class StyleVisitor extends NodeVisitor {
	
	private StyleSheet style;
	
	public StyleVisitor(StyleSheet s) {
		this.style = s;
	}

	public ArrayList<MatchedRule> visit(Node n) {
		return null;
	}

	public ArrayList<MatchedRule> visit(TextNode n) {
		return this.visit(n.getParent());// MAY WANT TO FIX THIS
	}

	public ArrayList<MatchedRule> visit(ElementNode n) {
		ArrayList<MatchedRule> matchingRules = new ArrayList<MatchedRule>();
		MatchedRule temp;
		
		for(Rule r : this.style.getRules()) {
			temp = r.match(n);
			if(temp != null) {
				matchingRules.add(temp);
			}
		}

		RuleComparator compare = new RuleComparator();

		Collections.sort(matchingRules, compare);

		return matchingRules;
	}
}
