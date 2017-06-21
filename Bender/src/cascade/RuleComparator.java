package cascade;

import cascade.MatchedRule;

import java.util.Comparator;

/**
 * Created by Bret on 5/26/2017.
 */
public class RuleComparator implements Comparator<MatchedRule>{

    public int compare(MatchedRule o1, MatchedRule o2) {
        return o1.getSpecificity() - o2.getSpecificity();
    }
}
