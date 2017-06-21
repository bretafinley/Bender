package style;

import java.util.ArrayList;

import cascade.MatchedRule;
import node.ElementNode;

public class Rule {
	private ArrayList<Selector> selectors;
	private ArrayList<Declaration> declarations;
	
	public Rule(ArrayList<Selector> selectors, ArrayList<Declaration> declarations) {
		this.selectors = selectors;
		this.declarations = declarations;
	}

	public ArrayList<Selector> getSelectors() {
		return this.selectors;
	}

	public ArrayList<Declaration> getDeclarations() {
		return this.declarations;
	}
	
	public MatchedRule match(ElementNode elem) {
		Selector max = null;
		Selector curr;
		for(int i = 0; i < selectors.size(); i++) {
			curr = selectors.get(i);
			if(curr.match(elem)) {
				if(max == null) {
					max = curr;
				}
				
				if(curr.getSpecificity() > max.getSpecificity()) {
					max = curr;
				}
			}
		}
		
		if(max == null) {
			return null;
		} else {
			return new MatchedRule(max.getSpecificity(), this);
		}
	}
	
	public String toString() {
		String str = "";
		
		for(Selector s : this.selectors) {
			str += s.toString() + ", ";
		}
		
		str += "{\n";
		
		for(Declaration d : this.declarations) {
			str += d.toString() + "\n";
		}
		
		str += "}";
		
		return str;
	}
}
