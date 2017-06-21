package interp;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import io.InFile;
import style.Rule;
import style.StyleSheet;
import style.Selector;
import style.SelectorFactory;
import style.Declaration;
import styleopts.StyleOptionFactory;
import styleopts.StyleOption;

public class StyleParser {
	
	private static StyleScanner scan;
	
	public static StyleSheet parseDocument(String filename) throws FileNotFoundException, SyntaxException {
		scan = new StyleScanner(InFile.readDocument(filename));
		scan.consumeWhitespace();
		
		StyleSheet sheet = new StyleSheet();
		ArrayList<Rule> rules = parseRules();
		for(Rule r : rules) {
			sheet.addRule(r);
		}
		
		return sheet;
	}
	
	private static ArrayList<Rule> parseRules() throws SyntaxException {
		ArrayList<Rule> rules = new ArrayList<Rule>();
		while(!scan.done()) {
			scan.consumeWhitespace();
			rules.add(parseRule());
		}
		
		return rules;
	}
	
	private static Rule parseRule() throws SyntaxException {
		scan.consumeWhitespace();
		return new Rule(parseSelectors(), parseDeclarations());
	}
	
	private static ArrayList<Selector> parseSelectors() throws SyntaxException {
		ArrayList<Selector> selects = new ArrayList<Selector>();
		selects.add(parseSelector());
		while(scan.hasMoreSelectors()) {
			selects.add(parseSelector());
		}
		
		return selects;
	}
	
	private static Selector parseSelector() throws SyntaxException {
		scan.consumeWhitespace();
		String specificity = scan.nextSpecificity();
		if(specificity.equals("*")) {
			return SelectorFactory.createSelector(specificity, "");
		} else {
			return SelectorFactory.createSelector(specificity, scan.nextSelector());
		}
	}
	
	private static ArrayList<Declaration> parseDeclarations() throws SyntaxException {
		ArrayList<Declaration> declarations = new ArrayList<Declaration>();
		scan.consumeWhitespace();
		scan.match('{');
		scan.next();
		Declaration temp;
		while(scan.hasMoreDeclarations()) {
			temp = parseDeclaration();
			if(temp != null) {
				declarations.add(temp);
			}
		}
		
		scan.match('}');
		scan.next();
		
		return declarations;
	}
	
	private static Declaration parseDeclaration() throws SyntaxException {
		scan.consumeWhitespace();
		// check for valid declaration, ignore invalid declaration
		String name = scan.nextDeclarationName();
		StyleOption opt = StyleOptionFactory.getOption(name);

		if(opt == null) {
			return null;
		}

		opt.parse(scan.nextDeclarationValue());
		return new Declaration(name, opt);
	}
}
