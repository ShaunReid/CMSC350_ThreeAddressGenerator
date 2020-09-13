/*CMSC350 
 9 Feb 2020
 Shaun Reid
 
 Operand Node class inherits from Node and creates Operand Nodes
 */
public class OperandNode extends Node {
	private String operand = null;
	
	//Sets the operand
	public OperandNode(String number) {
		operand = number;
	}
	
	//returns the operand
	public String evaluate() {
		return operand;
	}
	
	//returns the operand for the postorderwalk
	public String postOrderWalk() {
		//System.out.println(operand);
		return operand;
	}
	
	public String getRegister() {
		return null;
	}
	
	public boolean isOperatorNode() {
		return false;
	}
}
