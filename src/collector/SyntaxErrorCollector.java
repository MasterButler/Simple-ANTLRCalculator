package collector;

import java.util.ArrayList;

public class SyntaxErrorCollector {
	private static SyntaxErrorCollector instance = null;
	
	private String error;
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
		error = "";
	}
	
	public void recordError(String error) {
		System.out.println("RECORDED");
		this.error = error;
		hasErrors = true;
	}
	
	public boolean inputHasErrors() {
		return hasErrors;
	}
	
	public String inputShowErrors() {
		return error;
	}
}
