package test.node;

public class MyAdvancedLinkedList extends MySimpleLinkedList {

	  // this code is the same than writting nothing.
	  // That is, there is no need to write it
	  public MyAdvancedLinkedList() {
	    super();
	  }

	  // insert one object in a specific position
	  public void insert(Object o, int n) {

	    if (isEmpty() || n <= 0) {
	      // in some cases, we can use the already implemented method
	      // note that this is the same than super.insert(o)
	      insert(o);
	    } else {
	      // we use "iterator" instead of "first", so we don't modify the
	      // "first" reference
	      Node iterator = first;

	      for (int i = 1; i < n; i++) {
	        if (iterator.getNext() == null)
	          break; // we stop is we reach the end of the list
	        iterator = iterator.getNext();
	      }

	      // now we know where. We just have to create the node and
	      // insert it
	      Node tmp = new Node(o, iterator.getNext());
	      iterator.setNext(tmp);
	    }
	  }

	  // extract the object in a specific position
	  public Object extract(int n) {
	    if (n <= 0 ||
	        isEmpty() ||
	        first.getNext() == null) { // only one element
	      return extract();
	    }

	    // find previous (n-1 element or next-to-last)
	    Node prev;
	    {
	      prev = first;
	      Node current = first.getNext();
	      int i = 1; // index of current
	      // search until last is found or current position is n
	      // meanwhile update prev, current and i
	      while (current.getNext() != null && i != n) {
	        prev = current;
	        current = current.getNext();
	        i++;
	      }
	    }

	    // actual extraction
	    Object info = prev.getNext().getInfo();
	    prev.setNext(prev.getNext().getNext());
	    return info;
	  }

	  public String toString(int n) {
	    String out = null;
	    // if the list is empty, return a null reference
	    if (!isEmpty()) {
	      Node tmp = first;
	      // iterates until i reaches n or the list is finished.
	      for (int i = 0; i < n; i++) {
	        tmp = tmp.getNext();
	        if (tmp == null)
	          return out; // the list is finished
	      }
	      out = tmp.getInfo().toString();
	    }
	    return out;
	  }

	  public String toString() {
	    String out = null;
	    // if the list is empty, return a null reference
	    if (!isEmpty()) {
	      out = ""; // null was only for empty lists
	      Node tmp = first;
	      // iterates until the list is finished
	      while (tmp != null) {
	        out = out + tmp.getInfo() + " ";
	        tmp = tmp.getNext();
	      }
	    }
	    // trim removes space characters at the end of the String
	    return out.trim();
	  }
	}