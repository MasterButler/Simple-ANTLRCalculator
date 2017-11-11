import java.awt.EventQueue;

import gui.CalculatorGUI;

public class AntlrUpdate {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println("INITIALIZE");
			    	String[] arg0 = { "-visitor", "/Users/Winfred Villaluna/Documents/SE Workspace/CMPILER Calculatr/src/model/Calc.g4", "-package", "model" };
			        org.antlr.v4.Tool.main(arg0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
