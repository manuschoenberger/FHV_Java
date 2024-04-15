package at.fhv.msc.java;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AboutBox extends Dialog {
	private static final long serialVersionUID = 1L;
	
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 150;

	public AboutBox(Frame frame, String title, String text) {
		super(frame, title, true);
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(frame);
		setLayout(new BorderLayout());
		
		Label textLabel = new Label(text, Label.CENTER);
		Button returnButton = new Button("Return");
		returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				dispose();
			}
		});
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent ev) {
				dispose();
			}
		});
		
		add(textLabel, BorderLayout.CENTER);
		add(returnButton, BorderLayout.SOUTH);
	}
}
