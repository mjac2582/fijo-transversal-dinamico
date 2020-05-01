package test.node;

public class MyAdvancedLinkedList2 extends MySimpleLinkedList {

	  // this code is the same than writting nothing.
	  // That is, there is no need to write it
	  public MyAdvancedLinkedList2() {
	    super();
	  }

	  // the method is not required, but simplifies the code of the two
	  // following methods
	  private int size() {
	    int out = 0;

	    if (!isEmpty()) {
	      Node iterator = first;
	      do {
	        out++;
	        iterator = iterator.getNext();
	      } while (iterator != null);
	    }
	    return out;
	  }

	  // insert one object at the end of the list
	  public void insertAtTheEnd(Object o) {
	    // it is just like inserting in the last position (size() - 1)
	    insert(o, this.size() - 1);
	  }

	  // extract one object from the end of the list
	  public Object extractFromTheEnd() {
	    // it is just like extracting from the last position (size() - 1)
	    return extract(this.size() - 1);
	  }

	  // overwrite the method of the extended class
	  // much simpler code
	  public void print() {
	    System.out.println(this.toString());
	  }

	  // overwrite the method of the extended class
	  // much simpler code
	  public void print(int n) {
	    System.out.println(this.toString(n));
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

	      // now we know were. We just have to create the node and
	      // insert it
	      Node tmp = new Node(o, iterator.getNext());
	      iterator.setNext(tmp);
	    }
	  }

	  // extract the object in a specific position
	  public Object extract(int n) {
	    Object out = null;
	    if (isEmpty() || n <= 0) {
	      // in some cases, we can use the already implemented method
	      // note that this is the same than super.extract()
	      out = extract();
	    } else {
	      Node iterator = first;

	      for (int i = 1; i < n; i++) {
	        if (iterator.getNext().getNext() == null)
	          break; // we stop is we reach the end of the list

	        iterator = iterator.getNext();
	      }

	      // now we know were. We just have to get the info and
	      // reallocate the nodes
	      out = iterator.getNext().getInfo();
	      iterator.setNext(iterator.getNext().getNext());
	    }
	    return out;
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