package node;

import cascade.MatchedRule;
import cascade.StyleNode;
import cascade.StyleText;
import glyph.Glyph;
import glyph.TextGlyph;
import style.StyleSheet;
import visitor.NodeVisitor;
import visitor.StyleVisitor;

import java.util.ArrayList;

public class TextNode extends Node {
	private String text;
	
	public TextNode( String text) {
		this.text = text;
	}

	public StyleNode style(StyleSheet sheet) {
		if(sheet == null) {
			return null;
		}

		StyleVisitor vis = new StyleVisitor(sheet);
		ArrayList<MatchedRule> myRules = this.accept(vis); // CHECK ON THIS!

		return new StyleText(this, myRules);
	}

	public ArrayList<MatchedRule> accept(NodeVisitor visitor) {
		return visitor.visit(this);
	}

	public String toString() {
		return "\"" + text + "\"";
	}
	
	public String prettyPrint(int level) {
		String str = "";
		for(int i = 0; i < level; i++) {
			str += "  ";
		}
		
		str += this.text;
		
		return str;
	}

	public Glyph render() {
		return new TextGlyph(this.text);
	}
}
