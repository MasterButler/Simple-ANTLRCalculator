package gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.builder.ButtonStackBuilder;

import model.CalculatorUtil;
import model.CalculatorVisitor;

import javax.swing.JScrollPane;

public class CalculatorGUI implements MouseListener{

	private final String[] characterList = {"(",")","%","*","7","8","9","/", "4","5","6","+","1","2","3","-","\u232B","0",".","="};
	private final boolean[] characterBold = {false, false, false, false, 
											true, true, true, false, 
											true, true, true, false, 
											true, true, true, false,
											false, true, false, false};
	
	private ArrayList<CButton> buttonList;
	private int openPar;
	
	private JFrame frame;
	private JPanel valuesPanel;
	
	private JLabel inputPanel;
	private JScrollPane scrollPane;
	private JScrollBar horScrBar;
	
	public void setVisible(boolean flag) {
		this.frame.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public CalculatorGUI() {
		buttonList = new ArrayList<>();
		openPar = 0;
		initialize();
	}

	public void addButton(String textToAdd, boolean textToBold) {
		CButton button = new CButton(textToAdd, textToBold);
		button.addMouseListener(this);
		buttonList.add(button);
		valuesPanel.add(button);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame.setDefaultLookAndFeelDecorated(false);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().setLayout(new BorderLayout());
		
		JPanel container = new JPanel();
		container.setBorder(new EmptyBorder(10, 10, 10, 10));
		container.setLayout(new BorderLayout(0, 10));
		container.setBackground(Color.DARK_GRAY);

		inputPanel = new JLabel("0");
		inputPanel.setHorizontalAlignment(SwingConstants.TRAILING);
		inputPanel.setBackground(Color.DARK_GRAY);
		inputPanel.setForeground(Color.WHITE);
		inputPanel.setFont(new Font("Consolas", Font.PLAIN, 46));
		inputPanel.setAlignmentY(Component.TOP_ALIGNMENT);
		inputPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		valuesPanel = new JPanel();
		valuesPanel.setBackground(Color.DARK_GRAY);
		valuesPanel.setLayout(new GridLayout(5, 4, 10, 10));
		
		scrollPane = new JScrollPane(inputPanel, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.getViewport().setBackground(Color.DARK_GRAY);
		scrollPane.setBackground(Color.DARK_GRAY);
		
		horScrBar = scrollPane.getHorizontalScrollBar();
		horScrBar.setValue(horScrBar.getMaximum());
		
		for(int i = 0; i < 20; i++) {
			addButton(characterList[i], characterBold[i]);
		}
		
		frame.getContentPane().add(container);
		container.add(scrollPane, BorderLayout.PAGE_START);
		container.add(valuesPanel, BorderLayout.CENTER);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		for(int i = 0; i < 20; i++) {
			if(e.getSource().equals(buttonList.get(i))) {
				if(characterList[i].equals("\u232B")) {
					if(inputPanel.getText().length() != 1) {
						inputPanel.setText(inputPanel.getText().substring(0, inputPanel.getText().length()-1));
					}else {	
						inputPanel.setText("0");
					}
					
				}else if(characterList[i].equals("(")) {
					char prevChar = inputPanel.getText().charAt(inputPanel.getText().length()-1);
					if((prevChar == '+' || prevChar == '-' || prevChar == '*' || prevChar == '/' || prevChar == '%' || prevChar == '(')) {
						inputPanel.setText(inputPanel.getText() + characterList[i]);
						openPar++;
					}else if(inputPanel.getText().length() == 1 && inputPanel.getText().charAt(0) == '0') {
						inputPanel.setText(characterList[i]);
						openPar++;
					}
					
				}else if(characterList[i].equals(")")) {
					char prevChar = inputPanel.getText().charAt(inputPanel.getText().length()-1);
					if(openPar > 0) {
						if(prevChar == '(' ) {
							System.out.println(inputPanel.getText() + "0" + characterList[i]);
							inputPanel.setText(inputPanel.getText() + "0" + characterList[i]);
							openPar--;
						}else if(!(prevChar == '+' || prevChar == '-' || prevChar == '*' || prevChar == '/' || prevChar == '%')) {
							inputPanel.setText(inputPanel.getText() + characterList[i]);
							openPar--;
						}
					}
					
				}else if(characterList[i].equals("+") || characterList[i].equals("-") || characterList[i].equals("*") || characterList[i].equals("/") || characterList[i].equals("%")){
					char prevChar = inputPanel.getText().charAt(inputPanel.getText().length()-1);
					if(prevChar == '+' || prevChar == '-' || prevChar == '*' || prevChar == '/' || prevChar == '%') {						
						inputPanel.setText(inputPanel.getText().substring(0, inputPanel.getText().length()-1) + characterList[i]);
					}else {
						inputPanel.setText(inputPanel.getText() + characterList[i]);
					}
					
				}else if(characterList[i].equals("=")) {
					String input = inputPanel.getText().trim();
					System.out.println("ENTERING THE TREE");
					System.out.println("MY INPUT WILL BE: \"" + input + "\"");
					inputPanel.setText(new CalculatorVisitor().solve(input).toString());
					
				}else if(characterList[i].equals(".")) {
					if(inputPanel.getText().lastIndexOf(".") == -1) {
						inputPanel.setText(inputPanel.getText() + characterList[i]);
					}else {
						boolean isPresent = false;
						String toCheck = inputPanel.getText().trim();
						for(int j = toCheck.length()-1; j > 0; j--) {
							System.out.print(inputPanel.getText().charAt(j));
							if(toCheck.charAt(j) == '+' 
							|| toCheck.charAt(j) == '-'
							|| toCheck.charAt(j) == '*'
							|| toCheck.charAt(j) == '/'
							|| toCheck.charAt(j) == '%') {
									break;
							}else if(toCheck.charAt(j) == '.') {
								isPresent = true;
							}
						}
						System.out.println();
						System.out.println("ISPRESENT STATUS: " + isPresent);;
						if(!isPresent) {
							if(inputPanel.getText().charAt(inputPanel.getText().length()-1) >= '0' && inputPanel.getText().charAt(inputPanel.getText().length()-2) <= '9') {
								inputPanel.setText(inputPanel.getText() + characterList[i]);
							}else {
								inputPanel.setText(inputPanel.getText() + "0" + characterList[i]);
							}
						}
					}
					
				}else {
					char prevprevChar = inputPanel.getText().length() > 1 ? inputPanel.getText().charAt(inputPanel.getText().length()-2) : ' '; 
					char prevChar = inputPanel.getText().charAt(inputPanel.getText().length()-1);
					String prev = prevprevChar + "" +  prevChar;
					
					if((prevprevChar == '+' || prevprevChar == '-' || prevprevChar == '*' || prevprevChar == '/' || prevprevChar == '%' || prevprevChar == ' ') && prevChar == '0') {
						inputPanel.setText(inputPanel.getText().substring(0, inputPanel.getText().length()-1) + characterList[i]);	
					}else {
						inputPanel.setText(inputPanel.getText() + characterList[i]);
					}
				}
			}
		}
		horScrBar.setAutoscrolls(true);
		scrollPane.validate();
		horScrBar.setValue(horScrBar.getMaximum());
	}

}
