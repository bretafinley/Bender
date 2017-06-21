package interp;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public abstract class BScanner {
	
	protected int pos;
	protected String document;
	protected Set<String> whitespace;
	protected Set<String> digits;
	protected Set<String> letters;
	
	public BScanner(String doc) {
		this.document = doc;
		this.pos = 0;
		initWhitespace();
		initDigits();
		initLetters();
	}
	
	public void next() {
		this.pos++;
	}
	
	public void match(char c) throws SyntaxException {
		if(this.document.charAt(this.pos) != c) {
			throw new SyntaxException(this.pos, c+"", this.document.charAt(this.pos)+"");
		}
	}
	
	protected void past(char c) throws SyntaxException {
		while(!done() && c != this.document.charAt(this.pos)) {
			pos++;
		}
		
		if(!done() && c == this.document.charAt(this.pos)) {
			pos++;
		} else {
			throw new SyntaxException(this.pos, c+"", this.document.charAt(this.pos)+"");
		}
	}
	
	private void initWhitespace() {
		this.whitespace = new HashSet<String>();
		this.whitespace.add(" ");
		this.whitespace.add("\t");
		this.whitespace.add("\n");
	}
	
	private void initDigits() {
		this.digits = new HashSet<String>();
		this.fill(this.digits, '0', '9');
	}
	
	private void initLetters() {
		this.letters = new HashSet<String>();
		this.fill(this.letters, 'A', 'Z');
		this.fill(this.letters, 'a', 'z');
	}
	
	
	private void fill(Set<String> s, char lo, char hi) {
		for(char c = lo; c <= hi; c++) {
			s.add(c+"");
		}
	}
	
	protected boolean done() {
		return this.pos >= this.document.length();
	}
	
	protected int consumeWhitespace() {
		return many(this.whitespace);
	}
		
	protected int many(Set<String> s) {
		int oldPos = this.pos;
		while(!done() && s.contains(this.document.charAt(this.pos)+"")) {
			this.pos++;
		}

		return this.pos - oldPos;
	}
}
