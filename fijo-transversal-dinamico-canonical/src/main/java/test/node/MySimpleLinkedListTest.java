package test.node;

public class MySimpleLinkedListTest {

	  public static void main(String args[]) {
	    // just instantiate one object and call the methods.
	    // I'm sure you can do it better than this code
	    MySimpleLinkedList sll = new MySimpleLinkedList();

	    sll.insert(new Integer(1));
	    sll.insert(new Integer(2));
	    sll.insert(new Integer(3));
	    sll.insert(new Integer(4));
	    sll.insert(new Integer(5));

	    sll.print();
	    sll.print(0);
	    sll.print(1);
	    sll.print(2);
	    sll.print(3);
	    sll.print(4);

	    System.out.println(sll.extract());
	    System.out.println(sll.extract());
	    System.out.println(sll.extract());
	    System.out.println(sll.extract());
	    System.out.println(sll.extract());

	    sll.print();
	  }
	}