package collector;

import java.util.ArrayList;

public class SyntaxErrorCollector {
	private static SyntaxErrorCollector instance = null;
	
	private boolean hasErrors;
	
	public static SyntaxErrorCollector getInstance() {
		if(instance == null) {
			instance = new SyntaxErrorCollector();
		}
		return instance;
	}
	
	private SyntaxErrorCollector() {
		reset();
	}
	
	public void reset() {
		hasErrors = false;
	}
	
	public void recordError() {
		System.out.println("RECORDED");
		hasErrors = true;
	}
	
	public boolean inputHasErrors() {
		return hasErrors;
	}
}
