package interp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class HTMLScanner extends BScanner {
	
	private Set<String> tagLegits;
	private Set<String> keyLegits;
	private Set<String> valLegits;
	private Set<String> textLegits;

	public HTMLScanner(String doc) {
		super(doc);
		initTagLegits();
		initKeyLegits();
		initValLegits();
		initTextLegits();
	}
	
	public boolean noMoreChildren() {
		this.consumeWhitespace();
		String end = this.document.substring(this.pos, this.pos+2);
		return end.equals("</");
	}
	
	public boolean isElem() {
		this.consumeWhitespace();
		return this.document.charAt(this.pos) == '<';
	}
	
	public String nextText() throws SyntaxException {
		this.consumeWhitespace();
		int oldPos = this.pos;
		this.many(this.textLegits);
		String text = this.document.substring(oldPos, this.pos);
		this.match('<');
		
		return text;
	}
	
	public String nextTag() throws SyntaxException {
		this.consumeWhitespace();
		this.match('<');
		this.next();
		int oldPos = this.pos;
		this.many(this.tagLegits);
		String tag = this.document.substring(oldPos, this.pos);
		
		if(oldPos == this.pos) {
			throw new SyntaxException(this.pos, "Valid tag", this.document.charAt(this.pos) + "");
		}
		
		return tag;
	}
	
	public String nextClose() throws SyntaxException {
		this.consumeWhitespace();
		this.match('<');
		this.next();
		this.match('/');
		this.next();
		int oldPos = this.pos;
		this.many(this.tagLegits);
		String tag = this.document.substring(oldPos, this.pos);
		
		if(oldPos == this.pos) {
			throw new SyntaxException(this.pos, "Valid tag", this.document.charAt(this.pos) + "");
		}
		
		this.match('>');
		this.next();
		
		return tag;
	}
	
	public ArrayList<Attribute> nextAttrs() throws SyntaxException {
		Attribute attr;
		ArrayList<Attribute> attrs = new ArrayList<Attribute>();
		while((attr = nextAttr()) != null) {
			attrs.add(attr);
		}
		
		this.consumeWhitespace();
		this.match('>');
		this.next();
		
		return attrs;
	}
	
	private Attribute nextAttr() throws SyntaxException {
		this.consumeWhitespace();
		String key = nextAttrKey();
		
		if(key != null) {
			String val = nextAttrVal();
			return new Attribute(key, val);
		} else {
			return null;
		}
	}
	
	private String nextAttrKey() {
		this.consumeWhitespace();
		int oldPos = this.pos;
		this.many(this.keyLegits);
		String key = this.document.substring(oldPos, this.pos);
		
		if(oldPos == this.pos) {
			return null;
		}
		
		return key;
	}
	
	private String nextAttrVal() throws SyntaxException {
		this.consumeWhitespace();
		this.match('=');
		this.next();
		this.consumeWhitespace();
		this.match('"');
		this.next();
		this.consumeWhitespace();
		int oldPos = this.pos;
		this.many(this.valLegits);
		String val = this.document.substring(oldPos, this.pos);
		this.match('"');
		this.next();
		
		return val;
	}
	
	private void initTagLegits() {
		this.tagLegits = new HashSet<String>();
		this.tagLegits.addAll(this.letters);
		this.tagLegits.addAll(this.digits);
		this.tagLegits.add("-");
	}
	
	private void initKeyLegits() {
		this.keyLegits = new HashSet<String>();
		this.keyLegits.addAll(this.letters);
		this.keyLegits.addAll(this.digits);
		this.keyLegits.add("-");
	}
	
	private void initValLegits() {
		this.valLegits = new HashSet<String>();
		this.valLegits.addAll(this.letters);
		this.valLegits.addAll(this.digits);
		this.valLegits.add("-");
	}
	
	private void initTextLegits() {
		this.textLegits = new HashSet<String>();
		this.textLegits.addAll(this.letters);
		this.textLegits.addAll(this.digits);
		this.textLegits.addAll(this.whitespace);
		this.textLegits.add("-");
	}
}
