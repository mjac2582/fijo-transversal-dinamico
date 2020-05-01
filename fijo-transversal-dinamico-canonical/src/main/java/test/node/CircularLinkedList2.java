package test.node;

public class CircularLinkedList2 {

	  // This time, the Node is defined INSIDE CircularLinkedList.
	  // Think about the implications.
	  public class Node {

	    private Object info;
	    private Node next;

	    public Node() {
	      info = null;
	      next = null;
	    }

	    public Node(Object o, Node n) {
	      setInfo(o);
	      setNext(n);
	    }

	    public void setInfo(Object o) {
	      info = o;
	    }

	    public void setNext(Node n) {
	      next = n;
	    }

	    public Object getInfo() {
	      return info;
	    }

	    public Node getNext() {
	      return next;
	    }
	  }

	  // an object of the class defined above
	  private Node position;

	  protected CircularLinkedList2() {
	    position = null;
	  }

	  public boolean isEmpty() {
	    if (position == null)
	      return true;
	    else
	      return false;
	  }

	  public void insert(Object o) {
	    if (isEmpty()) {
	      position = new Node(o, null);
	      position.setNext(position);
	    } else {
	      Node tmp = new Node(o, position.getNext());
	      position.setNext(tmp);
	    }
	  }

	  public Object extract() {
	    // look carefully which value is returned in each case
	    //
	    // 1 - if the list is empty, return null
	    // 2 - if the list has only one value,
	    // return the value and state that the list is empty
	    // 3 - if the list has more than one value,
	    // return the value that is next to 'position' and
	    // the Node that contained the returned Object.
	    //
	    // Look that in the third case, instead of returning the value of
	    // position, it is returned the next in the list. Why? Because it is
	    // easier to implement, no further reason.
	    Object out = null;
	    if (!isEmpty() && position.getNext() == position) {
	      out = position.getInfo();
	      position = null;
	    } else if (!isEmpty() && position.getNext() != position) {
	      out = position.getNext().getInfo();
	      position.setNext(position.getNext().getNext());
	    }
	    return out;
	  }

	  public static CircularLinkedList getExample() {
	    CircularLinkedList out = new CircularLinkedList();

	    int numberOfElements = (int) Math.round(Math.random() * 5) + 5;

	    for (int i = 0; i < numberOfElements; i++) {
	      int value = (int) Math.round(Math.random()) * 50 - 25;
	      out.insert(new Integer(value));
	    }
	    return out;
	  }

	  public String toString() {
	    String out = "";

	    /* code here */

	    return out.trim();
	  }

	  public int size() {
	    int out = 0;

	    /* code here */

	    return out;
	  }

	  public Object[] toArray() {
	    Object[] out = new Object[size()];

	    /* code here */

	    return out;
	  }

	  public MySimpleLinkedList toSimpleLinkedList() {
	    MySimpleLinkedList out = new MySimpleLinkedList();

	    /* code here */

	    return out;
	  }
	}