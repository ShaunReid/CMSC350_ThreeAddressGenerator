/*
 CMSC350 
 9 Feb 2020
 Shaun Reid
 
 Parser class parses all the input data from the GUI
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Parser {
	
	private String postFixStr = null;
	private String[] tokens = null;
	private TreeStack treeStack = new TreeStack();
	private Node root= null;
	String result = null;
	
	
	//Replaces operators with spaces and operators in the middle
	public String replaceOper(String str) {
		String spacedOpStr = new String(str);
		String addStr = new String(" " + "+" + " ");
		String subStr = new String(" " + "-" + " ");
		String mulStr = new String(" " + "*" + " ");
		String divStr = new String(" " + "/" + " ");
				
		spacedOpStr = spacedOpStr.replace("+", addStr);
		spacedOpStr = spacedOpStr.replace("-", subStr);		
		spacedOpStr = spacedOpStr.replace("*", mulStr);		
		spacedOpStr = spacedOpStr.replace("/", divStr);	
				
		System.out.println(spacedOpStr);
		return spacedOpStr;
	}
	
	//Creates the tokens 
	public String[] createTokens(String s) {
		tokens = s.split("|");
		for(int i = 0; i < tokens.length; i++) {
			System.out.println(tokens[i]);
		}
		return tokens;
	}
	
	//Creates the expression tree
	public void createExpressionTree() {
		
		int regCount = 0;
		
		for(int i = 0; i < tokens.length; i++) {
			if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
				Node rightNode = treeStack.pop();
				Node leftNode = treeStack.pop();
				
				if (tokens[i].equals("+")) {
					treeStack.push(new OperatorNode(new AddOperator(), leftNode, rightNode, regCount));
					regCount++;
				} else if (tokens[i].equals("-")) {
					treeStack.push(new OperatorNode(new SubOperator(), leftNode, rightNode, regCount));
					regCount++;
				} else if (tokens[i].equals("*")) {
					treeStack.push(new OperatorNode(new MulOperator(), leftNode, rightNode, regCount));
					regCount++;
				} else if (tokens[i].equals("/")) {
					treeStack.push(new OperatorNode(new DivOperator(), leftNode, rightNode, regCount));
					regCount++;
				}
			} else if (tokens[i].equals("1") || tokens[i].equals("2") || tokens[i].equals("3") || tokens[i].equals("4") || tokens[i].equals("5") || tokens[i].equals("6") || tokens[i].equals("7") || tokens[i].equals("8") || tokens[i].equals("9") || tokens[i].equals("0")) {
				OperandNode operand = new OperandNode(tokens[i]);
			
				treeStack.push(operand);
			} else {
				throw new RuntimeException(tokens[i]);
			}
		}
		root = treeStack.pop();
		result = root.evaluate();
		System.out.println(result);
		root.postOrderWalk();
		//System.out.println(root.postOrderWalk());
		//try {
			//FileWriter fWriter = new FileWriter("./destination/Output.txt", true);
			//BufferedWriter buffWrite = new BufferedWriter(fWriter);
			//buffWrite.write(root.postOrderWalk() + "\n");
			//buffWrite.close();
			
			//File file = new File("Desktop/Output.txt");
			//PrintWriter writer = new PrintWriter(file);
			
			//writer.println(result);
			//writer.close();
		//} catch (IOException e) {
			//System.out.println(e);
		//}
		
	}
	
	
	
}
