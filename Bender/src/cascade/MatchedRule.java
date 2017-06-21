package cascade;

import style.Rule;

public class MatchedRule {
	private int specificity;
	private Rule rule;
	
	public MatchedRule(int spec, Rule r) {
		this.specificity = spec;
		this.rule = r;
	}
	
	public int getSpecificity() {
		return this.specificity;
	}
	
	public Rule getRule() {
		return this.rule;
	}
}
