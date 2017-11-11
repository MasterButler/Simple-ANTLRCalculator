import java.awt.EventQueue;

import gui.CalculatorGUI;
import model.CalculatorVisitor;

public class Driver {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorGUI window = new CalculatorGUI();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
//		new CalculatorVisitor().solve("(4 + (3 - 6 * 5)) /3");
		
	}
}
