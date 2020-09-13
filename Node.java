/*CMSC350 
 9 Feb 2020
 Shaun Reid
 Node class is an abstract class that creates a generic Node for the Expression Tree*/
public abstract class Node {
	abstract public String evaluate();

	abstract public String postOrderWalk();
	
	public abstract String getRegister();

	public abstract boolean isOperatorNode();
	
	
	
	//private String node = null;
	
	//public Node(String a) {
		//node = a;
	//}
	
	//public String evaluate() {
		 //return node;
	 //}
}
