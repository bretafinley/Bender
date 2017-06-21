package cascade;

import layout.BlockBox;
import layout.LayoutBox;
import node.ElementNode;
import style.Declaration;
import styleopts.StyleOption;

import java.util.ArrayList;
import java.util.HashMap;

public class StyleElement extends StyleNode {
    private ArrayList<StyleNode> children;

    public StyleElement(ElementNode me, ArrayList<MatchedRule> rules, ArrayList<StyleNode> children) {
        this.me = me;
        this.children = children;
        this.specifiedValues = new HashMap<String, StyleOption>();
        ArrayList<Declaration> tempDeclarations;
        for(MatchedRule rule : rules) {
            tempDeclarations = rule.getRule().getDeclarations();
            for(Declaration decl : tempDeclarations) {
                this.specifiedValues.put(decl.getName(), decl.getValue());
            }
        }
    }

    private void cascade() {

    }

    public ArrayList<StyleNode> getChildren() {
        return this.children;
    }

    public LayoutBox layOut() {
        return new BlockBox(this);
    }
}
