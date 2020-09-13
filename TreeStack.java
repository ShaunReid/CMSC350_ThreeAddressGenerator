/*CMSC350 
 9 Feb 2020
 Shaun Reid
 
 TreeStack class is used to create the nodes for the expression tree
 */
public class TreeStack<E> implements StackInterface<E> {
	
	private static int DEFAULT_SIZE = 15;
	Node stackElements[];
	int numberOfElements = 0;
	
	@SuppressWarnings("unchecked")
	public TreeStack() {
		stackElements = (Node[])(new Node[DEFAULT_SIZE]);
	}
	
	@SuppressWarnings("unchecked")
	public TreeStack(int size) {
		stackElements = (Node[])(new Node[size]);
	}
	
	public boolean isFull() {
		if (numberOfElements == stackElements.length)
			return true;
		else
			return false;
	}
	
	public boolean isEmpty() {
		if (numberOfElements == 0)
			return true;
		else
			return false;
	}
	
	public Node peek()  {
		if (numberOfElements == 0)
			System.out.println("Stack is Empty");
		return stackElements[numberOfElements - 1];
	}
	
	public void push(Node item) {
		if (numberOfElements == stackElements.length)
			System.out.println("Stack is Full");
		stackElements[numberOfElements] = item;
		numberOfElements++;
		System.out.println(item + " pushed");
		
	}
	
	public Node pop() throws ArrayIndexOutOfBoundsException {
		
			if (numberOfElements == 0)
			System.out.println("Stack is Empty");
			Node elementToReturn = stackElements[numberOfElements - 1];
			numberOfElements--;
			System.out.println(elementToReturn + " popped");	
			return elementToReturn;
		
		
	}
	
	public void displayStackElements() {
		if (numberOfElements == 0)
			System.out.println("Stack is Empty");
		for(int i = 0; i < numberOfElements; i++) {
			System.out.println(stackElements[i]);
		}
	}
}
