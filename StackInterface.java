/*CMSC350 
 9 Feb 2020
 Shaun Reid
 
 Interface used for TreeStack
 */
public interface StackInterface <E>{
	public boolean isFull();
	public boolean isEmpty();
	public Node peek();
	public void push(Node item);
	public Node pop();
}
