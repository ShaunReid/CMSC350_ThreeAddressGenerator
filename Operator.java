/*CMSC350 
 9 Feb 2020
 Shaun Reid
 
 Operator class is a generic operator and the subsequent operator classes inherit from the Operator class 
 */
public abstract class Operator {
	abstract public String evaluate(String x, String y);
	abstract public String toString();
	abstract public String opType();
}

//Add operator
class AddOperator extends Operator {
	
	public String evaluate(String left, String right) {
		String addResult = new String("(" + left + "+" + right + ")");
		return addResult;
	}
	
	public String toString() {
		return "+";
	}
	
	public String opType() {
		return "Add";
	}
}

//Subtraction operator
class SubOperator extends Operator {
	
	public String evaluate(String left, String right) {
		String subResult = new String("(" + left + "-" + right + ")");
		return subResult;
	}
	
	public String toString() {
		return "-";
	}
	
	public String opType() {
		return "Sub";
	}
}

//Multiplication operator
class MulOperator extends Operator {
	
	public String evaluate(String left, String right) {
		String mulResult = new String("(" + left + "*" + right + ")");
		return mulResult;
	}
	
	public String toString() {
		return "*";
	}
	
	public String opType() {
		return "Mul";
	}
}

//Division operator
class DivOperator extends Operator {
	
	public String evaluate(String left, String right) {
		String divResult = new String("(" + left + "/" + right + ")");
		return divResult;
	}
	
	public String toString() {
		return "/";
	}
	
	public String opType() {
		return "Div";
	}
}