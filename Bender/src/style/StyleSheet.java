package style;

import java.util.ArrayList;

public class StyleSheet {
	private ArrayList<Rule> rules;
	
	public StyleSheet() {
		this.rules = new ArrayList<Rule>();
	}
	
	public void addRule(Rule r) {
		this.rules.add(r);
	}
	
	public ArrayList<Rule> getRules() {
		return this.rules;
	}
	
	public String toString() {
		String str = "";
		
		for(Rule r : this.rules) {
			str += r.toString() + "\n";
		}
		
		return str;
	}
}
