package style;

import styleopts.StyleOption;

public class Declaration {
	private String name;
	private StyleOption value;
	
	public Declaration(String name, StyleOption value) {
		this.name = name;
		this.value = value;
	}

	public boolean shouldCascade() {
		return value.shouldCascade();
	}

	public String getName() {
		return this.name;
	}

	public StyleOption getValue() {
		return this.value;
	}
	
	public String toString() {
		return this.name + " : " + this.value;
	}
}
