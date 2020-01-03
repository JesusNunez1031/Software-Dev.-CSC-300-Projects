public class DLList<E> {
    private Node start;
    private Node end;
    //private Node current;
    private int size; // the size of the list

    public DLList() // default constructor
    {
        start = end = null;
        size = 0;
    }

    // Check if the list is empty
    public boolean isEmpty() // returns true if list is empty
    {
        return start == null;
    }

    public int size() // returns the number of data on the list
    {
        return size;
    }

    // Add an element to the start of the list
    public void addAtStart(E val) {
        Node<E> nptr = new Node<>(val, null, null);
        if (start == null) {
            start = nptr;
            end = start;
        } else {
            start.setPrevious(nptr);
            nptr.setNext(start);
            start = nptr;
        }
        size++;
    }

    // Adds an element to the end of the list
    public void add(E val) {
        Node<E> nptr = new Node<>(val, null, null);
        if (start == null) {
            start = nptr;
            end = start;
        } else {
            nptr.setPrevious(end);
            end.setNext(nptr);
            end = nptr;
        }
        size++;
    }

    // Add an element at a given position
    public void add(int index, E val)  //adds x to list at position index
    {
        if (index > size || index < 0)  // index out of range
        {
            System.out.printf("Out of range in add(int index, E x)\n");
            System.exit(0);
        }
        Node<E> nptr = new Node<>(val, null, null);  // instantiate a new node referenced by p

        // add to the front of the list
        if (index == 0) {
            addAtStart(val);
            if (end == null)  // if list was initially empty
                end = start;  // front and rear reference the single node of the list
            size++;
            return;
        }
        // add to the end of the list
        if (index == size) {
            add(val);
            return;
        }

        // addition is neither at front nor rear
        Node ptr = start;
        for (int i = 0; i <= size; i++) {
            if (i == index) {
                Node tmp = ptr.getNext();
                ptr.setNext(nptr);
                nptr.setPrevious(ptr);
                nptr.setNext(tmp);
                tmp.setPrevious(nptr);
            }
            ptr = ptr.getNext();
        }
        size++;
    }

    // Remove a node at a given position
    public E remove(int index) {
        if (index > size || index < 0) // index out of bounds
        {
            System.out.printf("Error in remove (int index)\n");
            System.exit(0);
        }
        Node ref;
        if (index == 1) {
            if (size == 1) {
                ref = start;
                start = null;
                end = null;
                size = 0;
                return (E) ref.getData();
            }
            ref = start;
            start = start.getNext();
            start.setPrevious(null);
            size--;
            return (E) ref.getData();
        }

        if(index == size) {
            ref = end;
            end = end.getPrevious();
            end.setNext(null);
            size--;
            return (E) ref.getData();
        }

        Node ptr = start.getNext();
        for (int i = 2; i <= size; i++) {
            if (i == index) {
                Node p = ptr.getPrevious();
                Node n = ptr.getNext();

                p.setNext(n);
                n.setPrevious(p);
                size--;
                return (E) ptr.getData();
            }
            ptr = ptr.getNext();
        }
        return null;
    }

    public E get(int index) // returns data at position index
    {
        if (index >= size || index < 0) // if index is out of bounds
        {
            System.out.print("Error in get (int index)\n");
            System.exit(0);
        }
        Node p = start;
        for (int i = 0; i < index; i++)
            p = p.getNext(); // move through the list, node by node
        return (E) p.getData();
    }

    public E set(int index, E x) // sets data at position index to x
    {
        if (index >= size || index < 0) // index out of bounds
        {
            System.out.printf("Error in get (int index)\n");
            System.exit(0);
        }
        Node p = start;
        for (int i = 0; i < index; i++)
            p = p.getNext();
        E temp = (E) p.getData();
        p.setData(x);
        return temp;
    }

    // display the status of the list
    public void display(){
        System.out.print("\nDoubly Linked List = ");
        if(size == 0) {
            System.out.print("empty\n");
            return;
        }
        if(start.getNext() == null) {
            System.out.println(start.getData());
            return;
        }
        Node ptr = start;
        System.out.print(start.getData() + " <-> ");
        ptr = start.getNext();
        while (ptr.getNext() != null){
            System.out.print(ptr.getData() + " <-> ");
            ptr = ptr.getNext();
        }
        System.out.print(ptr.getData() + "\n");
    }

    public void clear() //makes the list empty
    {
        start = end = null;
        size = 0;
    }

    public boolean contains(E val) // returns true if x is a member of the list
    {
        Node p = start;
        for (int i = 0; i < size; i++) {
            if (val.equals(p.getData())) return true;
            p = p.getNext();
        }
        return false; // search unsuccessful
    }

    //    public void reset() // makes the first node the current node
//    {
//        current = start;
//    }
//
//    public boolean hasNext() // returns true if a call to next() will be successful
//    {
//        return current != null;
//    }
//
//    public E next() // returns data of current node and moves current to the next node
//    {
//        if (current == null) {
//            System.out.print("Error in hasNext()\n");
//            System.exit(0);
//        }
//        E temp = (E) current.getData();
//        current = current.getNext();
//        return temp;
//    }
}
