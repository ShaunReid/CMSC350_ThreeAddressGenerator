/*
CMSC350 
 9 Feb 2020
 Shaun Reid
 
 The Main class creates the GUI and receives all data from the GUI*/
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.*;

public class Main extends JFrame implements ActionListener{

	static String expressionTxt = "";
	
	//Create two labels
	static JLabel postfixExpLbl = new JLabel("Enter Postfix Expression", JLabel.CENTER);
	static JLabel infixExpLbl = new JLabel("Infix Expression", JLabel.CENTER);
	
	//Create two textfields
	static JTextField postfixTxt = new JTextField(20);
	static JTextField infixTxt = new JTextField(20);
	
	//Create evaluate button
	static JButton constructTreeBtn = new JButton("Construct Tree");
	
	
	
	public static void main(String[] args) {
		
		buildGUI();

	}
	
	//Builds the GUI
	public static void buildGUI() {
		
		//Create postfix expression panel
		JPanel postExpPanel = new JPanel(new FlowLayout());
		postExpPanel.add(postfixExpLbl);
		postExpPanel.add(postfixTxt);
		
		//Create button panel
		JPanel conTreeBtnPanel = new JPanel(new FlowLayout());
		conTreeBtnPanel.add(constructTreeBtn);
		
		//Create infix expression panel
		JPanel infixExpPanel = new JPanel(new FlowLayout());
		infixExpPanel.add(infixExpLbl);
		infixExpPanel.add(infixTxt);
		
		//Create frame
		final int WIDTH = 450;
		final int HEIGHT = 130;
		
		JFrame genFrame = new JFrame();
		genFrame.setTitle("Three Address Generator");
		genFrame.setSize(WIDTH, HEIGHT);
		genFrame.setLocationRelativeTo(null);
		genFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		genFrame.setVisible(true);
		genFrame.setForeground(Color.lightGray);
		
		genFrame.setLayout(new BorderLayout());
		genFrame.add(postExpPanel, BorderLayout.NORTH);
		genFrame.add(conTreeBtnPanel, BorderLayout.CENTER);
		genFrame.add(infixExpPanel, BorderLayout.SOUTH);
		
		constructTreeBtn.setSize(30, 10);
		
		constructTreeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Construct Tree Button Pressed");
				getExpTxt();
				System.out.println(expressionTxt);
				Parser parseStr = new Parser();
				System.out.println(parseStr.replaceOper(expressionTxt));
				
				parseStr.createTokens(expressionTxt);
				try {
				parseStr.createExpressionTree();
				} catch (RuntimeException msg) {
					JOptionPane invalidToken = new JOptionPane("Invalid Token " + msg.getMessage(), JOptionPane.ERROR_MESSAGE);
					JDialog dialog = invalidToken.createDialog("Message");
					dialog.setAlwaysOnTop(true);
					dialog.setVisible(true);
				}
				infixTxt.setText(parseStr.result);
			}
		});
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public static String getExpTxt() {
		return expressionTxt = postfixTxt.getText();
	}

}
