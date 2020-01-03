public class Node <E>
{
	private E data; 
	private Node next;
	public Node() 
	{
		
	}
	public Node(E x) 
	{
		data = x;
		next = null;
	}
	public void setNext (Node next)
	{
		this.next = next;
	}
	public Node getNext()
	{
		return next;
	}
	public void setData(E data)
	{
		this.data = data;
	}
	public E getData()
	{
		return data;
	}
}