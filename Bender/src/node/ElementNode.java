package node;

import java.util.ArrayList;  
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import cascade.StyleNode;
import cascade.StyleElement;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import iterator.Iterator;
import iterator.VectorIterator;
import visitor.NodeVisitor;
import visitor.StyleVisitor;
import cascade.MatchedRule;
import style.StyleSheet;

public abstract class ElementNode extends Node {
	protected String tagName;
	protected HashMap<String, String> attributes;
	protected ArrayList<Node> children;
	
	public ElementNode() {
		this.children = new ArrayList<Node>();
		this.attributes = new HashMap<String, String>();
	}
	
	public ElementNode(String text) {
		this();
		this.children.add(new TextNode(text));
	}
	
	public ElementNode(Node child) {
		this();
		this.children.add(child);
	}
	
	public String getTagName() {
		return this.tagName;
	}

	public HashMap<String, String> getAttributes() {
		return this.attributes;
	}
	
	public void addAttribute(String key, String value) {
		this.attributes.put(key, value);
	}
	
	public String getID() {
		return this.attributes.get("id");
	}

	public StyleNode style(StyleSheet sheet) {
		if(sheet == null) {
			return null;
		}

		ArrayList<StyleNode> styledChildren = new ArrayList<StyleNode>();
		StyleVisitor vis = new StyleVisitor(sheet);
		ArrayList<MatchedRule> myRules = this.accept(vis);

		StyleNode child;
		for(Node c : this.children) {
			child = c.style(sheet);
			if(child != null) {
				styledChildren.add(child);
			}
		}

		return new StyleElement(this, myRules, styledChildren);
	}

	// trying to cascade...
	public StyleNode style(StyleSheet sheet, ArrayList<MatchedRule> cascadedRules) {
		if(sheet == null) {
			return null;
		}

		ArrayList<StyleNode> styledChildren = new ArrayList<StyleNode>();
		StyleVisitor vis = new StyleVisitor(sheet);
		ArrayList<MatchedRule> myRules = this.accept(vis);
		HashMap<Integer, MatchedRule> ruleMap = new HashMap<>();
		for(MatchedRule r : myRules) {
			ruleMap.put(r.getRule().hashCode(), r);
		}

		for(MatchedRule c : cascadedRules) {
			MatchedRule p = ruleMap.get(c.getRule().hashCode());//this wont work because the objects should be equals

		}

		StyleNode child;
		for(Node c : this.children) {
			child = c.style(sheet);
			if(child != null) {
				styledChildren.add(child);
			}
		}

		return null;
	}
	
	public Set<String> getClasses() {
		Set<String> classSet = new HashSet<String>();
		String classList = this.attributes.get("class");
		if(classList == null) {
			return classSet;
		}
		
		String classes[] = classList.split(" ");
		
		for(int i = 0; i < classes.length; i++) {
			classSet.add(classes[i]);
		}
		
		return classSet;
	}
	
	public void insert(int position, Node child) {
		child.setParent(this);
		this.children.add(position, child);
	}
	
	public void remove(Node child) {
		this.children.remove(child);
	}
	
	public Iterator<Node> createIterator() {
		return new VectorIterator<Node>(this.children);
	}
	
	public ArrayList<MatchedRule> accept(NodeVisitor visitor) {
    	return visitor.visit(this);
    }
	
	public String prettyPrint(int level) {
		String str = "";
		for(int i = 0; i < level; i++) {
			str += "  ";
		}
		
		str += this.tagName + " ";
		
		for(String attr : this.attributes.keySet()) {
			str += attr + "="  + this.attributes.get(attr) + " ";
		}
		
		str += "\n";
		
		level++;
		for(Node child : this.children) {
			str += child.prettyPrint(level);
		}
		
		str += "\n";
		
		return str;
	}
	
	public String toString() {
		String str = this.tagName + "( ";
		
		for(Node child : this.children) {
			str += child.toString();
		}
		
		str += " )";
		
		return str;
	}
}
