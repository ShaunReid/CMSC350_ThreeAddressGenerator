import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*CMSC350 
 9 Feb 2020
 Shaun Reid
 
 Operator Node inherits from Node and creates Operator Nodes
 */
public class OperatorNode extends Node {
	
	private Node left, right;
	private Operator operator;
	//private int regCount = 0;
	private String register;
	
	//empty constructor
	public OperatorNode() {
		
	}
	
	//creates the operator node
	public OperatorNode(Operator operator, Node left, Node right, int reg) {
		this.operator = operator;
		this.left = left;
		this.right = right;
		register = "R" + reg;
		
		
	}
	
	public String getRegister() {
		return register;
	}
	
	//Evaluates the operaotor node
	public String evaluate() {
		String leftValue = left.evaluate();
		String rightValue = right.evaluate();
		return operator.evaluate(leftValue, rightValue);
	}
	
	public boolean isOperatorNode() {
		return true;
	}
	
	//executes the post order walk
	public String postOrderWalk() {
		String leftOperand = left.postOrderWalk();
		//System.out.println(left.getClass());
		String rightOperand = right.postOrderWalk();
		//System.out.println(right.getClass());
		String leftNodeReg = left.getRegister();
		//System.out.println("A left node is " + leftNodeReg);
		String rightNodeReg = right.getRegister();
		//System.out.println("A right node is " + rightNodeReg);
		String result = new String();
		if(left.isOperatorNode() && right.isOperatorNode()) {
			result = operator.opType() + " " + register + " " + leftNodeReg + " " + rightNodeReg;
			//System.out.println("Left node is an Operator node");
		} else if (right.isOperatorNode()) {
			result = operator.opType() + " " + register + " " + leftOperand + " " + rightNodeReg;
		} else if (left.isOperatorNode()) {
			result = operator.opType() + " " + register + " " + leftNodeReg + " " + rightOperand;	
		} else {
			result = operator.opType() + " " + register + " " + leftOperand + " " + rightOperand;
		}
		
		System.out.println(result);
		
		try {
			FileWriter fWriter = new FileWriter("./destination/Output.txt", true);
			BufferedWriter buffWrite = new BufferedWriter(fWriter);
			buffWrite.write(result + "\n");
			buffWrite.close();
			
			//File file = new File("Desktop/Output.txt");
			//PrintWriter writer = new PrintWriter(file);
			
			//writer.println(result);
			//writer.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		
		return result;
	}
	
	
	
	
	
}
