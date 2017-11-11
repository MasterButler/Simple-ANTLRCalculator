package gui;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CButton extends JButton{

	public static Color bgColor = Color.BLACK;
	public static Color hoverColor = Color.LIGHT_GRAY;
	
	public CButton(String text, boolean isBold) {
		super(text);
		setFont(new Font("Segoe UI Symbol", isBold ? Font.BOLD : Font.PLAIN,20));
		setBackground(Color.BLACK);//import java.awt.Color;
		setForeground(Color.WHITE);
		setFocusPainted(false);
		setBorder(null);
		
        addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				if (getModel().isPressed()) {
                    setBackground(hoverColor);
                } else if (getModel().isRollover()) {
                    setBackground(hoverColor);
                } else {
                    setBackground(bgColor);
                }
			}
        });
	}	
}
