public class LList <E>implements ListInterface<E> 
{
	private Node front, rear, current;
	private int length; // the size of the list
	public LList() // default constructor
	{
		rear = front = current = null;
		length = 0;
	}
	public void add(E x)   //adds x to the end of the list
	{
		Node p = new Node(x);  // instantiate a new node referenced by p
		if (rear == null)      // if list is initially empty
			front = rear = p;  // the list has just one node
		else
		{
			rear.setNext(p);   // places the node referenced by p at the end
			rear = p;
		}
		length++;
	}
	public void add(int index, E x)  //adds x to list at position index
	{
		if (index > length || index < 0 )  // index out of range
		{
			System.out.printf("Out of range in add(int index, E x)\n");
			System.exit(0);
		}
		Node p = new Node(x);  // instantiate a new node referenced by p
		
		// add to the front of the list
		if (index == 0)
		{
			p.setNext(front); // place the address of the first node into the new node
			front = p; // front references the new node
			if (rear == null)  // if list was initially empty
				rear = front;  // front and rear reference the single node of the list
			length++;
			return;
		}
		// add to the end of the list
		if (index == length)
		{
			add(x);
			return;
		}
		
		// addition is neither at front nor rear
		Node q = front;
		for (int i = 0; i < index - 1; i++)
			q = q.getNext();
		Node r = q.getNext();
		q.setNext(p);
		p.setNext(r);
		length++;
	}
	
	public void clear() //makes the list empty
	{
		front = rear = null;
		length = 0; 
	}
	public boolean contains (E x) // returns true if x is a member of the list
	{
		Node p = front;
		for (int i = 0; i < length; i++) 
		{
			if (x.equals(p.getData())) return true;
			p = p.getNext(); 
		}
		return false; // search unsuccessful
	}
	
	public E get (int index) // returns data at position index
	{
		if (index >= length || index < 0) // if index is out of bounds
		{
			System.out.printf("Error in get (int index)\n");
			System.exit(0); 
		}
		Node p = front;
		for (int i = 0 ; i < index; i++)
			p = p.getNext(); // move through the list, node by node
		return (E)p.getData();
	}
	
	
	 // 
	public boolean isEmpty() // returns true if list is empty
	{
		return length == 0; 
	}
	
	public boolean remove(E x) // removes first occurrence of x a nd returns true if successful
	{
		Node p = front;
		Node q = null;
		while (!(p == null) && !x.equals(p.getData())) // look for x
		{
			q = p;
			p = p.getNext(); 
		}
		if (p == null) // not found
			return false; 
		if (!(q == null)) // if x is in the first node q is null
			q.setNext(p.getNext());
		if (p == front)
			front = front.getNext(); 
		if (p == rear)
			rear = q; 
		length--;
		return true; 
	}
	
	public E remove(int index) // removes and returns data at position index
	{
		if (index >= length || index < 0) // index out of bounds
		{
			System.out.printf("Error in remove (int index)\n");
			System.exit(0); 
		}
		Node p = front;
		Node q = null;
		for (int i = 0; i < index; i++) // q follows p down the list
		{
			q = p;
			p = p.getNext(); 
		}
		if (current == p) // if removing the current node, move current to the next node
			current = p.getNext(); 
		if (!(q == null))  //  if not removibg first node	
			q.setNext(p.getNext()); //q follows p, so q is null when p is the first node.
		if (p == front)
			front = front.getNext(); 
		if (p == rear)
			rear = q; 
		length--;
		return (E)p.getData(); 
	}

	public E set (int index, E x) // sets data at position index to x
	{
		if (index >= length || index < 0) // index out of bounds
		{
			System.out.printf("Error in get (int index)\n");
			System.exit(0); 
		}
		Node p = front;
		for (int i = 0; i < index; i++)
			p = p.getNext();
		E temp = (E)p.getData(); 
		p.setData(x); 
		return temp;
	}

	public int size() // returns the number of data on the list
	{
		return length; 
	}

	public void reset() // makes the first node the current node
	{
		current = front; 
	}
	public boolean hasNext() // returns true if a call to next() will be successful
	{
		if (current == null) 
			return false;
		return true; 
	}
	
	public E next() // returns data of current node and moves current to the next node
	{
		if (current == null) 
		{
			System.out.printf("Error in hasNext()\n");
			System.exit(0); 
		}
		E temp = (E)current.getData(); 
		current = current.getNext(); 
		return temp;
	} 
}