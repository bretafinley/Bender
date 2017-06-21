package interp;

public class SyntaxException extends Exception {

    private int pos;
    private String expected;
    private String found;

    public SyntaxException(int pos, String expected, String found) {
		this.pos=pos;
		this.expected=expected;
		this.found=found;
    }

    public String toString() {
	return "syntax error"
	    +", pos="+pos
	    +", expected="+"\""+expected+"\""
	    +", found="+"\""+found+"\"";
    }
}
