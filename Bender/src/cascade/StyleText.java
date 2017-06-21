package cascade;

import java.util.ArrayList;
import java.util.HashMap;

import layout.BlockBox;
import layout.LayoutBox;
import node.TextNode;
import style.Declaration;
import styleopts.StyleOption;

public class StyleText extends StyleNode {

    public StyleText(TextNode me, ArrayList<MatchedRule> rules) {
        this.me = me;
        this.specifiedValues = new HashMap<String, StyleOption>();
        ArrayList<Declaration> tempDeclarations;
        for(MatchedRule rule : rules) {
            tempDeclarations = rule.getRule().getDeclarations();
            for(Declaration decl : tempDeclarations) {
                if(decl.shouldCascade()) {//REMOVE THIS!
                    this.specifiedValues.put(decl.getName(), decl.getValue());
                }
            }
        }
    }

    public LayoutBox layOut() {
        return new BlockBox(this);
    }
}
