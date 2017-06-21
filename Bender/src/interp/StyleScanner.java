package interp;

import java.util.HashSet;
import java.util.Set;

public class StyleScanner extends BScanner {
	
	private Set<String> specificityLegits;
	private Set<String> selectorLegits;
	private Set<String> declareNameLegits;
	private Set<String> declareValueLegits;
	private Set<String> unitLegits;
	
	public StyleScanner(String doc) {
		super(doc);
		initSpecificityLegits();
		initSelectorLegits();
		initDeclareNameLegits();
		initDeclareValueLegits();
	}
	
	public String nextSpecificity() {
		this.consumeWhitespace();
		int oldPos = this.pos;
		this.many(this.specificityLegits);
		return this.document.substring(oldPos, this.pos);
	}
	
	public boolean hasMoreSelectors() throws SyntaxException {
		this.consumeWhitespace();
		
		if(this.document.charAt(this.pos) == ',') {
			this.next();
			return true;
		} else if(this.document.charAt(this.pos) == '{') {
			return false;
		} else {
			throw new SyntaxException(this.pos, "Valid CSS separator", this.document.charAt(this.pos)+"");
		}
	}
	
	public String nextSelector() throws SyntaxException {
		this.consumeWhitespace();
		int oldPos = this.pos;
		this.many(this.selectorLegits);
		String selector = this.document.substring(oldPos, this.pos);
		
		if(selector.length() == 0) {
			throw new SyntaxException(this.pos, "Valid CSS separator", this.document.charAt(this.pos)+"");
		}
		
		return selector;
	}
	
	public boolean hasMoreDeclarations() {
		this.consumeWhitespace();
		return this.declareNameLegits.contains(this.document.charAt(this.pos)+"");
	}
	
	public String nextDeclarationName() throws SyntaxException {
		this.consumeWhitespace();
		
		int oldPos = this.pos;
		this.many(this.declareNameLegits);
		String name = this.document.substring(oldPos, this.pos);
		
		if(name.length() == 0) {
			throw new SyntaxException(this.pos, "Valid CSS separator", this.document.charAt(this.pos)+"");
		}
		
		return name;
	}
	
	public String nextDeclarationValue() throws SyntaxException {
		this.consumeWhitespace();
		this.match(':');
		this.next();
		this.consumeWhitespace();
		int oldPos = this.pos;
		while(this.many(this.declareValueLegits) > 0 || this.consumeWhitespace() > 0) {
			// do nothing
		}
		this.match(';');
		
		String value = this.document.substring(oldPos, this.pos);
		this.next();
		
		if(value.length() == 0) {
			throw new SyntaxException(this.pos, "Valid CSS separator", this.document.charAt(this.pos)+"");
		}
		
		return value;
	}
	
	private void initSpecificityLegits() {
		this.specificityLegits = new HashSet<String>();
		this.specificityLegits.add("#");
		this.specificityLegits.add(".");
		this.specificityLegits.add("*");
	}
	
	private void initSelectorLegits() {
		this.selectorLegits = new HashSet<String>();
		this.selectorLegits.addAll(this.letters);
		this.selectorLegits.add("-");
	}
	
	private void initDeclareNameLegits() {
		this.declareNameLegits = new HashSet<String>();
		this.declareNameLegits.addAll(this.letters);
		this.declareNameLegits.add("-");
	}
	
	private void initDeclareValueLegits() {
		this.declareValueLegits = new HashSet<String>();
		this.declareValueLegits.addAll(this.letters);
		this.declareValueLegits.addAll(this.digits);
		this.declareValueLegits.add("#");
		this.declareValueLegits.add("(");
		this.declareValueLegits.add(")");
		this.declareValueLegits.add(",");
		this.declareValueLegits.add("0");
	}
}
